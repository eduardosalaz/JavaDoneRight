package modelos.admin.categorias;

import DBManager.Conexion;
import modelos.admin.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmListCat {
    public boolean checked;
    private PreparedStatement pstm = null;
    private ResultSet rs;
    public ArrayList<Categoria> Categorias = new ArrayList<Categoria>();

    public void buscar() {
        Connection con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM categoria";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Categorias.add(new Categoria(rs.getInt("id_cat"), rs.getString("nom_cat")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                if(con !=null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
