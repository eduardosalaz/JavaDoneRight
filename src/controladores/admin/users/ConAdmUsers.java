package controladores.admin.users;

import controladores.admin.ConAdmMain;
import modelos.admin.users.ModAdmAltaUser;
import modelos.admin.users.ModAdmBajaUser;
import modelos.admin.users.ModAdmListUser;
import modelos.admin.users.ModAdmModUser;
import vistas.admin.VisAdmMain;
import vistas.admin.users.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmUsers implements ActionListener {
    public VisAdmUsers vista;

    public ConAdmUsers(VisAdmUsers visAdmUsers) {
        vista = visAdmUsers;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if (vista.finished) {
            vista.btn_alta.addActionListener(this);
            vista.btn_baja.addActionListener(this);
            vista.btn_modificar.addActionListener(this);
            vista.btn_listar.addActionListener(this);
            vista.btn_home.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_alta) {
            alta();
        } else if (e.getSource() == vista.btn_baja) {
            baja();
        } else if (e.getSource() == vista.btn_modificar) {
            modificar();
        } else if (e.getSource() == vista.btn_listar) {
            listar();
        } else if (e.getSource() == vista.btn_home) {
            home();
        }
        vista.frame.dispose();
    }

    private void alta() {
        VisAdmAltaUser visAdmAltaUser = new VisAdmAltaUser();
        ModAdmAltaUser modAdmAltaUser = new ModAdmAltaUser();
        ConAdmAltaUser conAdmAltaUser = new ConAdmAltaUser(visAdmAltaUser, modAdmAltaUser);
    }

    private void baja() {
        VisAdmBajaUser visAdmBajaUser = new VisAdmBajaUser();
        ModAdmBajaUser modAdmBajaUser = new ModAdmBajaUser();
        ConAdmBajaUser conAdmBajaUser = new ConAdmBajaUser(visAdmBajaUser, modAdmBajaUser);
    }

    private void modificar() {
        VisAdmModUser visAdmModUser = new VisAdmModUser();
        ModAdmModUser modAdmModUser = new ModAdmModUser();
        ConAdmModUser conAdmModUser = new ConAdmModUser(visAdmModUser, modAdmModUser);
    }

    private void listar() {
        VisAdmListUser visAdmListUser = new VisAdmListUser();
        ModAdmListUser modAdmListUser = new ModAdmListUser();
        ConAdmListUser conAdmListUser = new ConAdmListUser(visAdmListUser, modAdmListUser);
    }

    private void home() {
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
    }
}
