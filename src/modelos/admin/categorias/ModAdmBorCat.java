package modelos.admin.categorias;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModAdmBorCat {
    private int id;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con;

    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM categoria WHERE id_cat = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nom_cat");
                String message = "¿Está seguro de querer eliminar a:\n" +
                        "Nombre: " + nombre + "\n" +
                        "ID: " + id;
                int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    query = "DELETE FROM categoria WHERE id_cat = ?";
                    pstm = con.prepareStatement(query);
                    pstm.setInt(1, id);
                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Categoría eliminada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "Categoría no eliminada");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado al categoría","Error", JOptionPane.ERROR_MESSAGE);
            }
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
