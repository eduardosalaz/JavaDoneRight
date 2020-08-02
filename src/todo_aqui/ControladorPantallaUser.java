package todo_aqui;


public class ControladorPantallaUser {
	
	public ModeloPantallaUser modeloUser;
	public VistaPantallaUser vistaUser;
	
	public ControladorPantallaUser(VistaPantallaUser vista, ModeloPantallaUser modelo) {
		vistaUser = vista;
		modeloUser = modelo;
		
	}
	public void ejecutar() {
		System.out.println("soy user");
		
	}

}
