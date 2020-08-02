package principal;
import controladores.*;
import modelos.*;
import vistas.*;


public class Launcher {

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        VistaLogin vistaLogin = new VistaLogin();
        ModeloLogin modeloLogin = new ModeloLogin();
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, modeloLogin);
    }

}
