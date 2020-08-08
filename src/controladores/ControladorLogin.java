package controladores;

import controladores.admin.ControladorPantallaAdmin;
import controladores.user.ControladorPantallaUser;
import vistas.VistaLogin;
import vistas.user.VistaPantallaUser;
import vistas.admin.VistaPantallaAdmin;
import java.awt.event.*;
import javax.swing.JOptionPane;
import modelos.ModeloLogin;
import modelos.admin.users.Usuario;

public class ControladorLogin implements ActionListener {
	VistaLogin vista;
	ModeloLogin modelo;
	private int intentos = 5;
	private boolean check, valido;
	private int usuario;
	private String password;

	public ControladorLogin(VistaLogin vista, ModeloLogin modelo) {
		this.vista = vista;
		this.modelo = modelo;
		ejecutar();
	}

	public void ejecutar() {
		vista.lanzarVista();
		while(!vista.finished){
			try{
				Thread.sleep(2);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("vista finalizada");
		agregarListeners();
	}

	public void agregarListeners(){
		vista.btn_login.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.btn_login) {
			try{
				usuario = Integer.parseInt(vista.txt_usuario.getText());
				password = new String(vista.pwd_password.getPassword());
				valido = true;
			}catch (Exception e1){
				JOptionPane.showMessageDialog(null, "Ese no es un input Válido");
				valido = false;
			}
			if (valido) {
				check = modelo.login(usuario, password);
			}
			if(intentos!=0) {
				if(check) {
					Usuario user = modelo.devolverUsuario();
					String nombre = user.getNombre();
					JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + nombre);
					if(user.isAdmin()) {
						VistaPantallaAdmin vistaAdmin = new VistaPantallaAdmin();
						ControladorPantallaAdmin controladorAdmin = new ControladorPantallaAdmin(vistaAdmin);

					}else {
						VistaPantallaUser vistaUser = new VistaPantallaUser();
						ControladorPantallaUser controladorUser = new ControladorPantallaUser(vistaUser);
					}
					vista.frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Te quedan " + intentos + " intentos para ingresar");
					intentos--;
				}
			}else {
				JOptionPane.showMessageDialog(null, "Has superado la cantidad de intentos permitidos, intenta después");
				vista.txt_usuario.setEnabled(false);
				vista.pwd_password.setEnabled(false);
				vista.btn_login.setEnabled(false);
				try {
					Thread.sleep(5000);
					vista.txt_usuario.setEnabled(true);
					vista.pwd_password.setEnabled(true);
					vista.btn_login.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Puedes volver a intentarlo");
					intentos = 5;
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
