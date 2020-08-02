package controladores;

import vistas.VistaLogin;
import vistas.VistaPantallaUser;
import vistas.VistaPantallaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelos.ModeloLogin;
import modelos.Usuario;
import modelos.ModeloPantallaUser;
import modelos.ModeloPantallaAdmin;

public class ControladorLogin implements ActionListener {

	VistaLogin vista;
	ModeloLogin modelo;
	public int intentos = 5;

	public ControladorLogin(VistaLogin vista, ModeloLogin modelo) {
		this.vista = vista;
		this.modelo = modelo;
		try{
			Thread.sleep(200);
		}catch (Exception e2){
			e2.printStackTrace();
		}
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
			int usuario = Integer.parseInt(vista.txt_usuario.getText());
			String password = new String(vista.pwd_password.getPassword());
			boolean check = modelo.login(usuario, password);
			if(intentos!=0) {
				if(check) {
					Usuario user = modelo.devolverUsuario();
					String nombre = user.getNombre();
					JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + nombre);
					if(user.isAdmin()) {
						VistaPantallaUser vistaUser = new VistaPantallaUser();
						ModeloPantallaUser modeloUser = new ModeloPantallaUser();
						ControladorPantallaUser controladorUser = new ControladorPantallaUser(vistaUser, modeloUser);
						controladorUser.ejecutar();
					}else {
						VistaPantallaAdmin vistaAdmin = new VistaPantallaAdmin();
						ModeloPantallaAdmin modeloAdmin = new ModeloPantallaAdmin();
						ControladorPantallaAdmin controladorAdmin = new ControladorPantallaAdmin(vistaAdmin, modeloAdmin);
						controladorAdmin.ejecutar();

					}
				}else {
					JOptionPane.showMessageDialog(null, "Te quedan " + intentos + " para ingresar");
					intentos--;

				}
			}else {
				JOptionPane.showMessageDialog(null, "Has superado la cantidad de intentos permitidos, intenta después");
				vista.txt_usuario.setEnabled(false);
				vista.pwd_password.setEnabled(false);
				vista.btn_login.setEnabled(false);
				try {
					Thread.sleep(99999);
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
