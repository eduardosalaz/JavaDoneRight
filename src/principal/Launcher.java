package principal;
import controladores.*;
import modelos.*;
import vistas.*;


public class Launcher {
    public static VistaLogin vistaLogin;
    public static ModeloLogin modeloLogin;
    ControladorLogin controladorLogin;
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.controladorLogin = new ControladorLogin(vistaLogin, modeloLogin);
    }

}
