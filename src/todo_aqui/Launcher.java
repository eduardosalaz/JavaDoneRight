package todo_aqui;



public class Launcher{
    public static void main(String[] args) {
        VistaLogin vistaLogin = new VistaLogin();
        ModeloLogin modeloLogin = new ModeloLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, modeloLogin);
    }
}