package modelos;

import DBManager.Conexion;
import modelos.admin.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModLogin {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    public Connection con;
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public boolean login(int user, String pass) {
        con = Conexion.Conectar();
        //Query para saber si existe el usuario
        try {
            String query = "SELECT * FROM usuario WHERE id_usr = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, user);
            rs = pstm.executeQuery();
            if (rs.next()) {
                //Estoy super segurisimo que estoy haciendo algo mal y no tendria que hacer 2 queries pero por mientras funciona TODO: Arreglar las 2 queries
                query = "SELECT * FROM usuario WHERE id_usr =? AND pass = AES_ENCRYPT(?, 'secret')";
                pstm = con.prepareStatement(query);
                pstm.setInt(1, user);
                pstm.setString(2, pass);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    //Query de la contraseña desencriptada
                    String query2 = "SELECT AES_DECRYPT(?, 'secret') as `contra` FROM usuario WHERE id_usr =?";
                    PreparedStatement pstm2 = con.prepareStatement(query2);
                    pstm2.setString(1, pass);
                    pstm2.setInt(2, user);
                    ResultSet rs2 = pstm2.executeQuery();
                    if (rs2.next()) {
                        String passW = rs2.getString("contra");
                        usuarios.add(new Usuario(rs.getInt("id_usr"), rs.getBoolean("admin"), passW, rs.getString("nom_usr"), rs.getString("tel_usr"),
                                rs.getDate("alta_usr"), rs.getDate("ultima_usr")));
                        //Query de actualizar el campo de Ultima Sesion
                        query = "UPDATE usuario SET ultima_usr = NOW() WHERE id_usr = ?";
                        pstm = con.prepareStatement(query);
                        pstm.setInt(1, user);
                        pstm.executeUpdate();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
                rs.close();
                pstm.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }

    public Usuario devolverUsuario() {
        return usuarios.get(0);
    }
}
