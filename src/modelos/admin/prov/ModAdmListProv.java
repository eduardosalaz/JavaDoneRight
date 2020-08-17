package modelos.admin.prov;

import DBManager.Conexion;
import modelos.admin.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmListProv {
    public boolean checked;
    private PreparedStatement pstm = null;
    private ResultSet rs;
    public ArrayList<Proveedor> Proveedores = new ArrayList<Proveedor>();

    public void buscar() {
        Connection con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM proveedor";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Proveedores.add(new Proveedor(rs.getInt("id_prov"), rs.getString("nom_prov"), rs.getDate("ultima_prov")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
