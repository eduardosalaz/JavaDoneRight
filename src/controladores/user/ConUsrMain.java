package controladores.user;
import vistas.user.VisUserMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConUsrMain implements ActionListener {

	public VisUserMain vistaUser;
	
	public ConUsrMain(VisUserMain vista) {
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
			System.out.println("compra");
		}else if(e.getSource() == vistaUser.btn_corte){
			System.out.println("corte");
		}else if(e.getSource() == vistaUser.btn_venta){
			System.out.println("venta");
		}

	}
}
