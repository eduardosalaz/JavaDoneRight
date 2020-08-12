package controladores.admin.categorias;

import controladores.admin.ConAdmMain;
import modelos.admin.categorias.ModAdmBorCat;
import modelos.admin.categorias.ModAdmListCat;
import modelos.admin.categorias.ModAdmModCat;
import modelos.admin.categorias.ModAdmRegCat;
import vistas.admin.VisAdmMain;
import vistas.admin.categorias.VisAdmBorCat;
import vistas.admin.categorias.VisAdmCat;
import vistas.admin.categorias.VisAdmListCat;
import vistas.admin.categorias.VisAdmModCat;
import vistas.admin.categorias.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmCat implements ActionListener {
    VisAdmCat vista;

    public ConAdmCat(VisAdmCat visAdmCat){
        System.out.println("estoy en el constructor");
        vista = visAdmCat;
        ejecutar();
    }

    private void ejecutar() {
        System.out.println("en ejecutar");
        vista.lanzarVista();
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
            VisAdmBorCat visAdmBorCat = new VisAdmBorCat();
            ModAdmBorCat modAdmBorCat = new ModAdmBorCat();
            ConAdmBorCat conAdmBorCat = new ConAdmBorCat(visAdmBorCat, modAdmBorCat);
        }else if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        }else if(e.getSource() == vista.btn_listar){
            VisAdmListCat visAdmListCat = new VisAdmListCat();
            ModAdmListCat modAdmListCat = new ModAdmListCat();
            ConAdmListCat conAdmListCat = new ConAdmListCat(visAdmListCat, modAdmListCat);
        }else if(e.getSource() == vista.btn_modificar){
            VisAdmModCat visAdmModCat = new VisAdmModCat();
            ModAdmModCat modAdmModCat = new ModAdmModCat();
            ConAdmModCat conAdmModCat = new ConAdmModCat(visAdmModCat, modAdmModCat);
            System.out.println("modificar");
        }else if(e.getSource() == vista.btn_registrar){
            VisAdmRegCat visAdmRegCat = new VisAdmRegCat();
            ModAdmRegCat modAdmRegCat = new ModAdmRegCat();
            ConAdmRegCat conAdmRegCat = new ConAdmRegCat(visAdmRegCat, modAdmRegCat);
        }
        vista.frame.dispose();
    }
}
