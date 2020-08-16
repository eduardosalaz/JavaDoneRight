package modelos.user.venta;

import DBManager.Conexion;
import modelos.admin.Articulo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ModUsrVenta {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    public Connection con;
    public float prec_total;
    public ArrayList<Articulo> Articulos = new ArrayList<Articulo>();
    public ArrayList<Integer> Claves = new ArrayList<>();
    public ArrayList<Integer> Cantidades = new ArrayList<>();
    public ArrayList<Float> Montos = new ArrayList<>();
    public int idUser;
    public float total_venta;


    public void queryProductos(){
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM articulo";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Articulos.add(
                        new Articulo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void calcularPrecio(int id, int cantidad) {
        prec_total = 0;
        try{
            String query = "SELECT pre_art FROM articulo WHERE cve_art=?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                float prec_ind = rs.getFloat(1);
                prec_total = prec_ind * cantidad;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
    public void cerrarConexion() {
        try{
            rs.close();
            pstm.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void pagar(){
        int totalArticulos = Claves.size();
        try{
            String query = "INSERT INTO venta (iduser_venta,fecha_venta,total_venta) VALUES (?, NOW(), ?)";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, idUser);
            pstm.setFloat(2, total_venta);
            pstm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        for (int i=0;i<totalArticulos;i++){
            try{
                int clave_actual = Claves.get(i);
                int cant_actual = Cantidades.get(i);
                float monto_actual = Montos.get(i);

                String query = "UPDATE articulo SET inv_art = (inv_art - ?) WHERE cve_art = ?";
                pstm = con.prepareStatement(query);
                pstm.setInt(1, cant_actual);
                pstm.setInt(2, clave_actual);
                pstm.executeUpdate();

                query = "SELECT inv_art FROM articulo WHERE cve_art = ?";
                pstm = con.prepareStatement(query);
                pstm.setInt(1, clave_actual);
                rs = pstm.executeQuery();

                while (rs.next()){
                    int cantidad = rs.getInt(1);
                    if(cantidad<0){
                        JOptionPane.showMessageDialog(null, "Has intentado vender más artículos de los que hay en existencias", "Error", JOptionPane.ERROR_MESSAGE);
                        query = "UPDATE articulo SET inv_art = (inv_art + ?) WHERE cve_art = ?";
                        pstm = con.prepareStatement(query);
                        pstm.setInt(1, cant_actual);
                        pstm.setInt(2, clave_actual);
                        pstm.executeUpdate();

                        query = "DELETE FROM venta WHERE id_venta = LAST_INSERT_ID()";
                        pstm = con.prepareStatement(query);
                        pstm.executeUpdate();
                    }else{
                        query = "INSERT INTO detalle_venta (idventa_det,cveart_det,cant_det,cost_det) VALUES (LAST_INSERT_ID(), ?,?,?)";
                        pstm = con.prepareStatement(query);
                        pstm.setInt(1, clave_actual);
                        pstm.setInt(2, cant_actual);
                        pstm.setFloat(3, monto_actual);
                        pstm.executeUpdate();
                        }
                    }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }
}
