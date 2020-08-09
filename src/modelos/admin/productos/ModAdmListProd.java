package modelos.admin.productos;

import DBManager.Conexion;
import modelos.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmListProd {
    public PreparedStatement pstm = null;
    Connection con;
    ResultSet rs;
    public ArrayList<Articulo> Articulos = new ArrayList<>();
    public void buscar() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT art.cve_art,art.nom_art,art.pre_art,art.inv_art,cat.nom_cat,prov.nom_prov FROM articulo as art,categoria as cat,proveedor as prov WHERE " +
                    "art.cat_art=cat.id_cat AND art.IDprov_art=prov.id_prov";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Articulos.add(new Articulo(rs.getInt("cve_art"), rs.getInt("inv_art"),rs.getString("nom_cat"),rs.getString("nom_prov"),rs.getFloat("pre_art"),
                        rs.getString("nom_art")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try
            {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
