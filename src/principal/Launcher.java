package principal;
import controladores.*;
import modelos.*;
import vistas.*;


public class Launcher {

    public static void main(String[] args) {
        VistaLogin vistaLogin = new VistaLogin();
        ModeloLogin modeloLogin = new ModeloLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, modeloLogin);
    }

}
