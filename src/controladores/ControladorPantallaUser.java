package controladores;
import modelos.ModeloPantallaUser;
import vistas.VistaPantallaUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPantallaUser implements ActionListener {
	
	public ModeloPantallaUser modeloUser;
	public VistaPantallaUser vistaUser;
	
	public ControladorPantallaUser(VistaPantallaUser vista, ModeloPantallaUser modelo) {
		vistaUser = vista;
		modeloUser = modelo;
		ejecutar();
	}

	public void ejecutar() {
		vistaUser.lanzarVista();
		System.out.println("vista user finalizada");
		agregarListeners();

	}

	private void agregarListeners() {
		if(vistaUser.finished){
			vistaUser.btn_compra.addActionListener(this);
			vistaUser.btn_corte.addActionListener(this);
			vistaUser.btn_venta.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vistaUser.btn_compra){
			System.out.println("compra");
		}else if(e.getSource() == vistaUser.btn_corte){
			System.out.println("corte");
		}else if(e.getSource() == vistaUser.btn_venta){
			System.out.println("venta");
		}

	}
}
