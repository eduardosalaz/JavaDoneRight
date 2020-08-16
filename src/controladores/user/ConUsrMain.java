package controladores.user;
import controladores.user.venta.ConUsrVenta;
import modelos.user.venta.ModUsrVenta;
import vistas.user.VisUsrMain;
import vistas.user.venta.VisUsrVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConUsrMain implements ActionListener {

	public VisUsrMain vistaUser;
	
	public ConUsrMain(VisUsrMain vista) {
		vistaUser = vista;
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

		}else if(e.getSource() == vistaUser.btn_corte){
			System.out.println("corte");
		}else if(e.getSource() == vistaUser.btn_venta){
			VisUsrVenta visUsrVenta = new VisUsrVenta();
			ModUsrVenta modUsrVenta = new ModUsrVenta();
			ConUsrVenta conUsrVenta = new ConUsrVenta(visUsrVenta, modUsrVenta);

		}
		vistaUser.frame.dispose();
	}

}
