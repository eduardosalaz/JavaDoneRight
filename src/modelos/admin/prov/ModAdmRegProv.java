package modelos.admin.prov;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModAdmRegProv {
    private PreparedStatement pstm = null;
    private Connection con;
    public void ejecutar(int id, String nombre) {
        con = Conexion.Conectar();
        String query = "INSERT INTO proveedor (id_prov,nom_prov,ultima_prov) VALUES (?,?,NOW())";
        try{
            pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.setString(2,nombre);
            pstm.executeUpdate();
            String message = "Proveedor " + nombre + " creado con éxito";
            JOptionPane.showMessageDialog(null, message);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ya existe un proveedor con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
    public void cerrar() {
        try{
            con.close();
            pstm.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
