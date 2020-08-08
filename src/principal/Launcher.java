package principal;
import controladores.*;
import modelos.*;
import vistas.*;

public class Launcher {
    public static void main(String[] args) {
        VisLogin visLogin = new VisLogin();
        ModLogin modLogin = new ModLogin();
        ConLogin conLogin = new ConLogin(visLogin, modLogin);
    }
}
