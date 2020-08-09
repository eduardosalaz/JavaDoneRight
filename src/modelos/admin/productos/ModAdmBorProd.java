package modelos.admin.productos;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModAdmBorProd {
    int id;
    public PreparedStatement pstm = null;
    ResultSet rs = null;
    Connection con ;
    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT * FROM articulo WHERE cve_art = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nom_art");
                String message = "¿Está seguro de querer eliminar a:\n" +
                        "Nombre: " + nombre + "\n" +
                        "ID: " + id;
                int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    query = "DELETE FROM articulo WHERE cve_art = ?";
                    pstm = con.prepareStatement(query);
                    pstm.setInt(1, id);
                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "Producto no eliminado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado al producto","Error", JOptionPane.ERROR_MESSAGE);
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
