package controladores.admin;
import controladores.admin.reportes.ControladorAdminRep;
import controladores.admin.productos.ControladorAdminProd;
import controladores.admin.prov.ControladorAdminProv;
import controladores.admin.users.ControladorAdminUsers;
import vistas.admin.prov.VistaAdminProv;
import vistas.admin.VistaPantallaAdmin;
import vistas.admin.productos.VistaAdminProductos;
import vistas.admin.reportes.VistaAdminReportes;
import vistas.admin.users.VistaAdminUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPantallaAdmin implements ActionListener {
	VistaPantallaAdmin vistaAdmin;
	
	public ControladorPantallaAdmin(VistaPantallaAdmin vista) {
		vistaAdmin = vista;
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
			ControladorAdminProd controladorAdminProd = new ControladorAdminProd(vistaAdminProductos);
		}else if(e.getSource() == vistaAdmin.btn_prov){
			System.out.println("proveedores");
			VistaAdminProv vistaAdminProv = new VistaAdminProv();
			ControladorAdminProv controladorAdminProv = new ControladorAdminProv(vistaAdminProv);
		}else if(e.getSource() == vistaAdmin.btn_rep){
			System.out.println("reportes");
			VistaAdminReportes vistaAdminReportes = new VistaAdminReportes();
			ControladorAdminRep controladorAdminRep = new ControladorAdminRep(vistaAdminReportes);
		}else if(e.getSource() == vistaAdmin.btn_usuarios){
			System.out.println("usuarios");
			VistaAdminUsers vistaAdminUsers = new VistaAdminUsers();
			ControladorAdminUsers controladorAdminUsers = new ControladorAdminUsers(vistaAdminUsers);
		}
		vistaAdmin.frame.dispose();
	}
}
