package modelos.admin.categorias;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModAdmModCat {
    private int id;
    public PreparedStatement pstm = null;
    public boolean checked;
    private Connection con;
    private ResultSet rs = null;

    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        String nombre;
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM categoria where id_cat = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nom_cat");
                checked = nombre != null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            checked = false;
            try{
                con.close();
                rs.close();
                pstm.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    public void actualizar(String n_nombre, int n_id) {
        String query = "UPDATE categoria SET id_cat=?, nom_cat=? WHERE id_cat=?";
        try{
            pstm = con.prepareStatement(query);
            pstm.setInt(1,n_id);
            pstm.setString(2,n_nombre);
            pstm.setInt(3,id);
            pstm.executeUpdate();
            String message = "Categoría modificada con éxito";
            JOptionPane.showMessageDialog(null, message);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cerrar() {
        try{
            con.close();
            rs.close();
            pstm.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
