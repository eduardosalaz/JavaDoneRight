package controladores;
import modelos.ModeloPantallaUser;
import vistas.VistaPantallaUser;

public class ControladorPantallaUser {
	
	public ModeloPantallaUser modeloUser;
	public VistaPantallaUser vistaUser;
	
	public ControladorPantallaUser(VistaPantallaUser vista, ModeloPantallaUser modelo) {
		vistaUser = vista;
		modeloUser = modelo;
		
	}
	public void ejecutar() {
		
	}

}
