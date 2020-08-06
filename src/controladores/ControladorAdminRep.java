package controladores;
import vistas.VistaAdminReportes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdminRep implements ActionListener {
    VistaAdminReportes vista;

    public ControladorAdminRep(VistaAdminReportes vistaAdminReportes){
        vista = vistaAdminReportes;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        System.out.println("vista admin rep lista");
        agregarListeners();
    }

    private void agregarListeners() {
        if(vista.finished){
            vista.btn_home.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_home){
            System.out.println("home");
        }
    }
}
