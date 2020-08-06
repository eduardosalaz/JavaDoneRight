package modelos;

import DBManager.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloAdmAltaUser {
    String nombre, pass, tel;
    int id;
    boolean admin;
    public static PreparedStatement pstm = null;
    ResultSet rs = null;
    Connection con;

    public ModeloAdmAltaUser(){
    }
    public void recibir(String nombre, String pass, String tel, int id, boolean admin){
        this.nombre = nombre;
        this.pass = pass;
        this.tel = tel;
        this.id = id;
        this.admin = admin;
    }

    public void ejecutar() {
        con = Conexion.Conectar();
        try{
            String query = "INSERT INTO usuario (id_usr, admin, pass, nom_usr, tel_usr, alta_usr) VALUES (?, ?, AES_ENCRYPT(?, 'secret'), ?, ?, NOW())";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.setBoolean(2, admin);
            pstm.setString(3, pass);
            pstm.setString(4, nombre);
            pstm.setString(5, tel);
            pstm.executeUpdate();
            String message = "Usuario " + nombre + " creado con éxito";
            JOptionPane.showMessageDialog(null, message);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
