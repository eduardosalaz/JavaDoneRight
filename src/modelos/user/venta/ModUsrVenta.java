package modelos.user.venta;

import DBManager.Conexion;
import modelos.admin.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModUsrVenta {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    public Connection con;
    public float prec_total;
    public ArrayList<Articulo> Articulos = new ArrayList<Articulo>();

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
}
