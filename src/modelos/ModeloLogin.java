package modelos;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBManager.*;

public class ModeloLogin {
	private Conexion conexion = new Conexion();
	public static PreparedStatement pstm = null;
	public PreparedStatement pstm2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	public Connection con;
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public boolean login(int user, String pass){
		
		con = Conexion.Conectar();
		try {
			String query = "SELECT * FROM usuario WHERE ID_Usuario = ?";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, user);
			rs = pstm.executeQuery();
			if(rs.next()) {
				query = "SELECT * FROM usuario WHERE ID_Usuario =? AND Pass = AES_DECRYPT(?, 'secret')";
				pstm = con.prepareStatement(query);
				pstm.setInt(1,  user);
				pstm.setString(2, pass);
				rs = pstm.executeQuery();
				if(rs.next()) {
					String query2 = "SELECT AES_DECRYPT(?, 'secret') AS `contra` FROM usuario WHERE ID_USUARIO =?";
					 pstm2 = con.prepareStatement(query2);
					 pstm2.setString(1, pass);
					 pstm2.setInt(2, user);
					 rs2 = pstm2.executeQuery();
					 String passW = rs2.getString("contra");//Intentar con la columna 1
					usuarios.add(new Usuario(rs.getInt("ID_Usuario"), rs.getBoolean("Admin"), passW, rs.getString("Nombre"), rs.getString("Telefono"), rs.getDate("Fecha_Alta"),
							rs.getDate("Ultima_Sesion")));
					return true;
					
				}else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Usuario devolverUsuario() {
		return usuarios.get(0);
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
