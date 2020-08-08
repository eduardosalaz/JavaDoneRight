package modelos.admin.users;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloAdmBajaUser {
    String nombre;
    int id;
    public static PreparedStatement pstm = null;
    ResultSet rs = null;
    Connection con;

    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM usuario WHERE id_usr = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nom_usr");
                String message = "¿Está seguro de querer eliminar a:\n" +
                        "Nombre: " + nombre + "\n" +
                        "ID: " + id;
                int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    query = "DELETE FROM usuario WHERE id_usr = ?";
                    pstm = con.prepareStatement(query);
                    pstm.setInt(1, id);
                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado al usuario","Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
                rs.close();
                pstm.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }

        }
    }
}
