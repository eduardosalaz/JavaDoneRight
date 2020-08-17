package principal;

import controladores.ConLogin;
import modelos.ModLogin;
import vistas.VisLogin;

public class Launcher {
    public static void main(String[] args) {
        VisLogin visLogin = new VisLogin();
        ModLogin modLogin = new ModLogin();
        ConLogin conLogin = new ConLogin(visLogin, modLogin);
    }
}
