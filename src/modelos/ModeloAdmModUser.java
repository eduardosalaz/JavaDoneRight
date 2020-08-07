package modelos;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloAdmModUser {
    int id;
    public static PreparedStatement pstm = null;
    public boolean checked;
    Connection con;
    ResultSet rs = null;

    public void recibir(int id) {
        this.id = id;
    }
    public void ejecutar(){
        String nombre;
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM usuario where id_usr = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nom_usr");
                if(nombre!=null){
                    System.out.println(nombre);
                    checked = true;
                }else{
                    checked = false;
                }
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

    public void actualizar(String nombre, String pass, boolean admin, String tel) {
        String query = "UPDATE usuario SET admin=?,pass=AES_ENCRYPT(?,'secret'),nom_usr=?,tel_usr=? WHERE id_usr=?";
        try{
            pstm = con.prepareStatement(query);
            pstm.setBoolean(1, admin);
            pstm.setString(2, pass);
            pstm.setString(3, nombre);
            pstm.setString(4,tel);
            pstm.setInt(5, id);
            pstm.executeUpdate();
            String message = "Usuario " + nombre + " modificado con éxito";
            JOptionPane.showMessageDialog(null, message);
        }catch(SQLException e){
            e.printStackTrace();
            try{
                pstm.close();
                con.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}
