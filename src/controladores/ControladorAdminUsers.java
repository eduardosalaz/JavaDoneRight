package controladores;
import modelos.ModeloAdmBajaUser;
import modelos.ModeloAdmListUser;
import modelos.ModeloAdmModUser;
import vistas.*;
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
        }else if(e.getSource() == vista.btn_baja){
            VistaAdmBajaUser vistaAdmBajaUser = new VistaAdmBajaUser();
            ModeloAdmBajaUser modeloAdmBajaUser = new ModeloAdmBajaUser();
            ControladorAdmBajaUser controladorAdmBajaUser = new ControladorAdmBajaUser(vistaAdmBajaUser, modeloAdmBajaUser);
        }else if(e.getSource() == vista.btn_modificar){
            VistaAdmModUser vistaAdmModUser = new VistaAdmModUser();
            ModeloAdmModUser modeloAdmModUser = new ModeloAdmModUser();
            ControladorAdmModUser controladorAdmModUser = new ControladorAdmModUser(vistaAdmModUser, modeloAdmModUser);
        }else if(e.getSource() == vista.btn_listar){
            VistaAdmListUser vistaAdmListUser = new VistaAdmListUser();
            ModeloAdmListUser modeloAdmListUser = new ModeloAdmListUser();
            ControladorAdmListUser controladorAdmListUser = new ControladorAdmListUser(vistaAdmListUser, modeloAdmListUser);
        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
        }
        vista.frame.dispose();
    }
}
