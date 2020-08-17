package modelos.admin.prov;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModAdmBorProv {
    private int id;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con;

    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM proveedor WHERE id_prov = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nom_prov");
                String message = "¿Está seguro de querer eliminar a:\n" +
                        "Nombre: " + nombre + "\n" +
                        "ID: " + id;
                int confirm = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    query = "DELETE FROM proveedor WHERE id_prov = ?";
                    pstm = con.prepareStatement(query);
                    pstm.setInt(1, id);
                    pstm.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor no eliminado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrar() {
        try {
            if (con != null) con.close();
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
