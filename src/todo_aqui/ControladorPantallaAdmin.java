package todo_aqui;


public class ControladorPantallaAdmin {
	public ModeloPantallaAdmin modeloAdmin;
	public VistaPantallaAdmin vistaAdmin;
	
	public ControladorPantallaAdmin(VistaPantallaAdmin vista, ModeloPantallaAdmin modelo) {
		vistaAdmin = vista;
		modeloAdmin = modelo;
	}
	public void ejecutar() {
		System.out.println("soy admin");
		
	}

}
