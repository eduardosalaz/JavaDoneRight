package controladores.admin.prov;
import controladores.admin.ConAdmMain;
import vistas.admin.prov.VisAdmProv;
import vistas.admin.VisAdmMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmProv implements ActionListener {
    VisAdmProv vista;

    public ConAdmProv(VisAdmProv visAdmProv){
        vista = visAdmProv;
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
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
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
