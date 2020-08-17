package controladores.admin.productos;
import controladores.admin.ConAdmMain;
import modelos.admin.productos.ModAdmBorProd;
import modelos.admin.productos.ModAdmListProd;
import modelos.admin.productos.ModAdmModProd;
import modelos.admin.productos.ModAdmRegProd;
import vistas.admin.productos.*;
import vistas.admin.VisAdmMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmProd implements ActionListener {
    public VisAdmProd vista;

    public ConAdmProd(VisAdmProd visAdmProd){
        vista = visAdmProd;
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
        if(e.getSource() == vista.btn_registrar){
            registrar();
        }else if(e.getSource() == vista.btn_borrar){
            borrar();
        }else if(e.getSource() == vista.btn_listar){
            listar();
        }else if(e.getSource() == vista.btn_modificar){
            modificar();
        }else if(e.getSource() == vista.btn_home){
            home();
        }
        vista.frame.dispose();
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
    }

    private void registrar(){
        VisAdmRegProd visAdmRegProd = new VisAdmRegProd();
        ModAdmRegProd modAdmRegProd = new ModAdmRegProd();
        ConAdmRegProd conAdmRegProd = new ConAdmRegProd(visAdmRegProd, modAdmRegProd);
    }

    private void borrar(){
        VisAdmBorProd visAdmBorProd = new VisAdmBorProd();
        ModAdmBorProd modAdmBorProd = new ModAdmBorProd();
        ConAdmBorProd conAdmBorProd = new ConAdmBorProd(visAdmBorProd, modAdmBorProd);
    }

    private void listar(){
        VisAdmListProd visAdmListProd = new VisAdmListProd();
        ModAdmListProd modAdmListProd = new ModAdmListProd();
        ConAdmListProd conAdmListProd = new ConAdmListProd(visAdmListProd,modAdmListProd);
    }

    private void modificar(){
        VisAdmModProd visAdmModProd = new VisAdmModProd();
        ModAdmModProd mod = new ModAdmModProd();
        ConAdmModProd conAdmModProd = new ConAdmModProd(visAdmModProd,mod);
    }
}
