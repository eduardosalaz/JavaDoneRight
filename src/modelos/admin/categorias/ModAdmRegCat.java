package modelos.admin.categorias;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModAdmRegCat {
    private PreparedStatement pstm = null;
    private Connection con;

    public void ejecutar(int id, String nombre) {
        con = Conexion.Conectar();
        String query = "INSERT INTO categoria (id_cat,nom_cat) VALUES (?,?)";
        try {
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.setString(2, nombre);
            pstm.executeUpdate();
            String message = "Categoría " + nombre + " creada con éxito";
            JOptionPane.showMessageDialog(null, message);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe una categoría con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cerrar() {
        try {
            if (con != null) con.close();
            if (pstm != null) pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
