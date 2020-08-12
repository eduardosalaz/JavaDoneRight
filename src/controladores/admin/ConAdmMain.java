package controladores.admin;
import controladores.admin.categorias.ConAdmCat;
import controladores.admin.reportes.ConAdmRep;
import controladores.admin.productos.ConAdmProd;
import controladores.admin.prov.ConAdmProv;
import controladores.admin.users.ConAdmUsers;
import vistas.admin.categorias.VisAdmCat;
import vistas.admin.prov.VisAdmProv;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmProd;
import vistas.admin.reportes.VisAdmRep;
import vistas.admin.users.VisAdmUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmMain implements ActionListener {
	VisAdmMain vistaAdmin;
	
	public ConAdmMain(VisAdmMain vista) {
		vistaAdmin = vista;
		ejecutar();
	}

	public void ejecutar() {
		vistaAdmin.lanzarVista();
		agregarListeners();
	}
	private void agregarListeners(){
		if (vistaAdmin.finished) {
			vistaAdmin.btn_prod.addActionListener(this);
			vistaAdmin.btn_prov.addActionListener(this);
			vistaAdmin.btn_rep.addActionListener(this);
			vistaAdmin.btn_usuarios.addActionListener(this);
			vistaAdmin.btn_cat.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaAdmin.btn_prod){
			VisAdmProd visAdmProd = new VisAdmProd();
			ConAdmProd conAdmProd = new ConAdmProd(visAdmProd);
		}else if(e.getSource() == vistaAdmin.btn_prov){
			VisAdmProv visAdmProv = new VisAdmProv();
			ConAdmProv conAdmProv = new ConAdmProv(visAdmProv);
		}else if(e.getSource() == vistaAdmin.btn_rep){
			VisAdmRep visAdmRep = new VisAdmRep();
			ConAdmRep controladorAdminRep = new ConAdmRep(visAdmRep);
		}else if(e.getSource() == vistaAdmin.btn_usuarios){
			VisAdmUsers visAdmUsers = new VisAdmUsers();
			ConAdmUsers conAdmUsers = new ConAdmUsers(visAdmUsers);
		}else if(e.getSource() == vistaAdmin.btn_cat){
			VisAdmCat visAdmCat = new VisAdmCat();
			ConAdmCat conAdmCat = new ConAdmCat(visAdmCat);
		}
		vistaAdmin.frame.dispose();
	}
}
