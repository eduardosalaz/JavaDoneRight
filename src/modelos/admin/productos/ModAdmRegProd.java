package modelos.admin.productos;

import DBManager.Conexion;
import modelos.admin.Categoria;
import modelos.admin.Proveedor;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmRegProd {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    public Connection con;
    public ArrayList<Categoria> Categorias = new ArrayList<Categoria>();
    public ArrayList<Proveedor> Proveedores = new ArrayList<Proveedor>();
    private int cve, inv;
    private String nom,cat,prov;
    private float prec;

    public void queryCategorias() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM categoria";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while(rs.next()){
                Categorias.add(new Categoria(rs.getInt("id_cat"), rs.getString("nom_cat")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void queryProv() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM proveedor";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while(rs.next()){
                Proveedores.add(new Proveedor(rs.getInt("id_prov"), rs.getString("nom_prov")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void recibirDatos(int cve, String nom, float prec, int inv, String cat, String prov){
        this.cve = cve;
        this.nom = nom;
        this.prec = prec;
        this.inv = inv;
        this.cat = cat;
        this.prov = prov;
    }

    public void registrarProducto(){
        con = Conexion.Conectar();
        try{
            String query = "INSERT INTO articulo (cve_art,nom_art,pre_art,inv_art,cat_art,IDprov_art) VALUES (?,?,?,?,(SELECT id_cat FROM categoria WHERE nom_cat=?)," +
                    "(SELECT id_prov FROM proveedor WHERE nom_prov=?))";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, cve);
            pstm.setString(2, nom);
            pstm.setFloat(3, prec);
            pstm.setInt(4, inv);
            pstm.setString(5, cat);
            pstm.setString(6, prov);
            pstm.executeUpdate();
            String message = "Producto " + nom + " registrado con éxito";
            JOptionPane.showMessageDialog(null, message);
        }catch (SQLException e){
            e.printStackTrace();
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
