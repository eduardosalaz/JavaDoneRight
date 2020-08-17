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
    public VisAdmCat vista;

    public ConAdmCat(VisAdmCat visAdmCat){
        vista = visAdmCat;
        ejecutar();
    }

    private void ejecutar() {
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
            borrar();
        }else if(e.getSource() == vista.btn_home){
            home();
        }else if(e.getSource() == vista.btn_listar){
            listar();
        }else if(e.getSource() == vista.btn_modificar){
            modificar();
        }else if(e.getSource() == vista.btn_registrar){
            registrar();
        }
        vista.frame.dispose();
    }

    private void borrar(){
        VisAdmBorCat visAdmBorCat = new VisAdmBorCat();
        ModAdmBorCat modAdmBorCat = new ModAdmBorCat();
        ConAdmBorCat conAdmBorCat = new ConAdmBorCat(visAdmBorCat, modAdmBorCat);
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
    }

    private void listar(){
        VisAdmListCat visAdmListCat = new VisAdmListCat();
        ModAdmListCat modAdmListCat = new ModAdmListCat();
        ConAdmListCat conAdmListCat = new ConAdmListCat(visAdmListCat, modAdmListCat);
    }

    private void modificar(){
        VisAdmModCat visAdmModCat = new VisAdmModCat();
        ModAdmModCat modAdmModCat = new ModAdmModCat();
        ConAdmModCat conAdmModCat = new ConAdmModCat(visAdmModCat, modAdmModCat);
    }

    private void registrar(){
        VisAdmRegCat visAdmRegCat = new VisAdmRegCat();
        ModAdmRegCat modAdmRegCat = new ModAdmRegCat();
        ConAdmRegCat conAdmRegCat = new ConAdmRegCat(visAdmRegCat, modAdmRegCat);
    }
}
