package modelos.admin.prov;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModAdmModProv {
    private int id;
    private PreparedStatement pstm = null;
    public boolean checked;
    private Connection con;
    private ResultSet rs = null;

    public void recibir(int id) {
        this.id = id;
    }

    public void ejecutar() {
        String nombre;
        con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM proveedor where id_prov = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nom_prov");
                checked = nombre != null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            checked = false;
            try {
                con.close();
                rs.close();
                pstm.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void actualizar(String n_nombre, int n_id) {
        String query = "UPDATE proveedor SET id_prov=?, nom_prov=? WHERE id_prov=?";
        try {
            pstm = con.prepareStatement(query);
            pstm.setInt(1, n_id);
            pstm.setString(2, n_nombre);
            pstm.setInt(3, id);
            pstm.executeUpdate();
            String message = "Proveedor modificado con éxito";
            JOptionPane.showMessageDialog(null, message);
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
