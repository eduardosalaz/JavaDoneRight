package controladores.admin.prov;

import controladores.admin.ConAdmMain;
import modelos.admin.prov.ModAdmBorProv;
import modelos.admin.prov.ModAdmListProv;
import modelos.admin.prov.ModAdmModProv;
import modelos.admin.prov.ModAdmRegProv;
import vistas.admin.VisAdmMain;
import vistas.admin.prov.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmProv implements ActionListener {
    public VisAdmProv vista;

    public ConAdmProv(VisAdmProv visAdmProv){
        vista = visAdmProv;
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
        VisAdmBorProv visAdmBorProv = new VisAdmBorProv();
        ModAdmBorProv modAdmBorProv = new ModAdmBorProv();
        ConAdmBorProv conAdmBorProv = new ConAdmBorProv(visAdmBorProv, modAdmBorProv);
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
    }

    private void listar(){
        VisAdmListProv visAdmListProv = new VisAdmListProv();
        ModAdmListProv modAdmListProv = new ModAdmListProv();
        ConAdmListProv conAdmListProv = new ConAdmListProv(visAdmListProv, modAdmListProv);
    }

    private void modificar(){
        VisAdmModProv visAdmModProv = new VisAdmModProv();
        ModAdmModProv modAdmModProv = new ModAdmModProv();
        ConAdmModProv conAdmModProv = new ConAdmModProv(visAdmModProv, modAdmModProv);
    }

    private void registrar(){
        VisAdmRegProv visAdmRegProv = new VisAdmRegProv();
        ModAdmRegProv modAdmRegProv = new ModAdmRegProv();
        ConAdmRegProv conAdmRegProv = new ConAdmRegProv(visAdmRegProv, modAdmRegProv);
    }
}
