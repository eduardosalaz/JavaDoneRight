package controladores.admin.reportes;
import controladores.admin.ConAdmMain;
import vistas.admin.reportes.VisAdmRep;
import vistas.admin.VisAdmMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmRep implements ActionListener {
    VisAdmRep vista;

    public ConAdmRep(VisAdmRep visAdmRep){
        vista = visAdmRep;
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
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        }
        vista.frame.dispose();
    }
}
