package controladores;
import modelos.ModeloAdmBajaUser;
import vistas.VistaAdmBajaUser;
import vistas.VistaAdminUsers;
import vistas.VistaPantallaAdmin;
import vistas.VistaAdmAltaUser;
import modelos.ModeloAdmAltaUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdminUsers implements ActionListener {
    VistaAdminUsers vista;

    public ControladorAdminUsers(VistaAdminUsers vistaAdminUsers){
        vista = vistaAdminUsers;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        System.out.println("vista admin users lista");
        agregarListeners();
    }

    private void agregarListeners() {
        if(vista.finished){
            vista.btn_alta.addActionListener(this);
            vista.btn_baja.addActionListener(this);
            vista.btn_modificar.addActionListener(this);
            vista.btn_listar.addActionListener(this);
            vista.btn_home.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_alta){
            VistaAdmAltaUser vistaAdmAltaUser = new VistaAdmAltaUser();
            ModeloAdmAltaUser modeloAdmAltaUser = new ModeloAdmAltaUser();
            ControladorAdmAltaUser controladorAdmAltaUser = new ControladorAdmAltaUser(vistaAdmAltaUser, modeloAdmAltaUser);
            System.out.println("alta");
        }else if(e.getSource() == vista.btn_baja){
            VistaAdmBajaUser vistaAdmBajaUser = new VistaAdmBajaUser();
            ModeloAdmBajaUser modeloAdmBajaUser = new ModeloAdmBajaUser();
            ControladorAdmBajaUser controladorAdmBajaUser = new ControladorAdmBajaUser(vistaAdmBajaUser, modeloAdmBajaUser);
            System.out.println("baja");
        }else if(e.getSource() == vista.btn_modificar){
            System.out.println("modificar");
        }else if(e.getSource() == vista.btn_listar){
            System.out.println("listar");
        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
            System.out.println("home");
        }
        vista.frame.dispose();

    }
}
