package controladores.admin.prov;
import controladores.admin.ControladorPantallaAdmin;
import vistas.admin.prov.VistaAdminProv;
import vistas.admin.VistaPantallaAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdminProv implements ActionListener {
    VistaAdminProv vista;

    public ControladorAdminProv(VistaAdminProv vistaAdminProv){
        vista = vistaAdminProv;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        System.out.println("vista admin prov lista");
        agregarListeners();
    }

    private void agregarListeners() {
        if(vista.finished){
            vista.btn_borrar.addActionListener(this);
            vista.btn_home.addActionListener(this);
            vista.btn_listar.addActionListener(this);
            vista.btn_modificar.addActionListener(this);
            vista.btn_registrar.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_borrar){
            System.out.println("borrar");
        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
        }else if(e.getSource() == vista.btn_listar){
            System.out.println("listar");
        }else if(e.getSource() == vista.btn_modificar){
            System.out.println("modificar");
        }else if(e.getSource() == vista.btn_registrar){
            System.out.println("registrar");
        }
        vista.frame.dispose();
    }
}
