package modelos.admin.users;

import DBManager.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModAdmListUser {
    public static PreparedStatement pstm = null;
    Connection con;
    ResultSet rs;
    public ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

    public void buscar() {
        con = Conexion.Conectar();
        try{
            String query = "SELECT id_usr,nom_usr,AES_DECRYPT(pass,'secret') as `contra`,admin,tel_usr,alta_usr,ultima_usr FROM usuario";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuarios.add(new Usuario(rs.getInt("id_usr"), rs.getBoolean("admin"), rs.getString("contra"), rs.getString("nom_usr"), rs.getString("tel_usr"),
                        rs.getDate("alta_usr"), rs.getDate("ultima_usr")));
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
