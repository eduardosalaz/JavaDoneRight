package modelos.admin.productos;

import DBManager.Conexion;
import modelos.admin.Categoria;
import modelos.admin.Proveedor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmModProd {
    public int id;
    private PreparedStatement pstm = null;
    public boolean checked;
    private Connection con;
    private ResultSet rs = null;
    public ArrayList<Categoria> Categorias = new ArrayList<Categoria>();
    public ArrayList<Proveedor> Proveedores = new ArrayList<Proveedor>();
    private int n_cve, inventario;
    private float precio;
    private String n_nombre, cat, prov;

    public void recibir(int id) {
        this.id = id;
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

    public void ejecutar() {
        String nombre;
        con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM articulo where cve_art = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nom_art");
                checked = nombre != null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            checked = false;
        }
    }

    public void queryCategorias() {
        con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM categoria";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Categorias.add(new Categoria(rs.getInt("id_cat"), rs.getString("nom_cat")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryProv() {
        con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM proveedor";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Proveedores.add(new Proveedor(rs.getInt("id_prov"), rs.getString("nom_prov")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recibirDatos(int n_cve, String n_nombre, float n_prec, int inventario, String cat, String prov) {
        this.n_cve = n_cve;
        this.n_nombre = n_nombre;
        this.precio = n_prec;
        this.inventario = inventario;
        this.cat = cat;
        this.prov = prov;
    }

    public void modProducto() {
        con = Conexion.Conectar();
        try {
            String query = "UPDATE articulo SET cve_art=?,nom_art=?,pre_art=?,inv_art=?,cat_art=(SELECT id_cat FROM categoria WHERE nom_cat=?),IDprov_art=(SELECT id_prov FROM proveedor WHERE nom_prov=?)" +
                    "WHERE cve_art=?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, n_cve);
            pstm.setString(2, n_nombre);
            pstm.setFloat(3, precio);
            pstm.setInt(4, inventario);
            pstm.setString(5, cat);
            pstm.setString(6, prov);
            pstm.setInt(7, id);
            pstm.executeUpdate();
            String message = "Producto " + n_nombre + " modificado con éxito";
            JOptionPane.showMessageDialog(null, message);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
