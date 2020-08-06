package controladores;
import modelos.ModeloPantallaAdmin;
import vistas.VistaAdminProv;
import vistas.VistaPantallaAdmin;
import vistas.VistaAdminProductos;
import vistas.VistaAdminReportes;
import vistas.VistaAdminUsers;

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
	private void agregarListeners(){
		if (vistaAdmin.finished) {
			vistaAdmin.btn_prod.addActionListener(this);
			vistaAdmin.btn_prov.addActionListener(this);
			vistaAdmin.btn_rep.addActionListener(this);
			vistaAdmin.btn_usuarios.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaAdmin.btn_prod){
			System.out.println("productos");
			VistaAdminProductos vistaAdminProductos = new VistaAdminProductos();
			vistaAdmin.frame.dispose();
			ControladorAdminProd controladorAdminProd = new ControladorAdminProd(vistaAdminProductos);
		}else if(e.getSource() == vistaAdmin.btn_prov){
			System.out.println("proveedores");
			VistaAdminProv vistaAdminProv = new VistaAdminProv();
			vistaAdmin.frame.dispose();
			ControladorAdminProv controladorAdminProv = new ControladorAdminProv(vistaAdminProv);
		}else if(e.getSource() == vistaAdmin.btn_rep){
			System.out.println("reportes");
			VistaAdminReportes vistaAdminReportes = new VistaAdminReportes();
			vistaAdmin.frame.dispose();
			ControladorAdminRep controladorAdminRep = new ControladorAdminRep(vistaAdminReportes);
		}else if(e.getSource() == vistaAdmin.btn_usuarios){
			System.out.println("usuarios");
			VistaAdminUsers vistaAdminUsers = new VistaAdminUsers();
			vistaAdmin.frame.dispose();
			ControladorAdminUsers controladorAdminUsers = new ControladorAdminUsers(vistaAdminUsers);
		}
	}
}
