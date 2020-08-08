package controladores;

import controladores.admin.ConAdmMain;
import controladores.user.ConUsrMain;
import vistas.VisLogin;
import vistas.user.VisUserMain;
import vistas.admin.VisAdmMain;
import java.awt.event.*;
import javax.swing.JOptionPane;
import modelos.ModLogin;
import modelos.admin.Usuario;

public class ConLogin implements ActionListener {
	VisLogin vista;
	ModLogin modelo;
	private int intentos = 5;
	private boolean check, valido;
	private int usuario;
	private String password;

	public ConLogin(VisLogin vista, ModLogin modelo) {
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
						VisAdmMain vistaAdmin = new VisAdmMain();
						ConAdmMain controladorAdmin = new ConAdmMain(vistaAdmin);

					}else {
						VisUserMain vistaUser = new VisUserMain();
						ConUsrMain controladorUser = new ConUsrMain(vistaUser);
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
