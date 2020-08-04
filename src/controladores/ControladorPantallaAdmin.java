package controladores;
import modelos.ModeloPantallaAdmin;
import vistas.VistaPantallaAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPantallaAdmin implements ActionListener {
	ModeloPantallaAdmin modeloAdmin;
	VistaPantallaAdmin vistaAdmin;
	
	public ControladorPantallaAdmin(VistaPantallaAdmin vista, ModeloPantallaAdmin modelo) {
		vistaAdmin = vista;
		modeloAdmin = modelo;
		ejecutar();
	}

	public void ejecutar() {
		vistaAdmin.lanzarVista();
		System.out.println("vista admin finalizada");
		agregarListeners();
	}
	public void agregarListeners(){
		if (vistaAdmin.finished) {
			vistaAdmin.btn_prod.addActionListener(this);
			vistaAdmin.btn_prov.addActionListener(this);
			vistaAdmin.btn_rep.addActionListener(this);
			vistaAdmin.btn_usuarios.addActionListener(this);
		}else{

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaAdmin.btn_prod){
			System.out.println("productos");

		}else if(e.getSource() == vistaAdmin.btn_prov){
			System.out.println("proveedores");

		}else if(e.getSource() == vistaAdmin.btn_rep){
			System.out.println("reportes");

		}else if(e.getSource() == vistaAdmin.btn_usuarios){
			System.out.println("usuarios");
		}
	}
}
