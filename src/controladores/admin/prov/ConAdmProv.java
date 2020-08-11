package controladores.admin.prov;
import controladores.admin.ConAdmMain;
import modelos.admin.productos.ModAdmBorProd;
import modelos.admin.prov.ModAdmBorProv;
import modelos.admin.prov.ModAdmListProv;
import modelos.admin.prov.ModAdmModProv;
import modelos.admin.prov.ModAdmRegProv;
import vistas.admin.productos.VisAdmBorProd;
import vistas.admin.prov.*;
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
            VisAdmBorProv visAdmBorProv = new VisAdmBorProv();
            ModAdmBorProv modAdmBorProv = new ModAdmBorProv();
            ConAdmBorProv conAdmBorProv = new ConAdmBorProv(visAdmBorProv, modAdmBorProv);
        }else if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        }else if(e.getSource() == vista.btn_listar){
            VisAdmListProv visAdmListProv = new VisAdmListProv();
            ModAdmListProv modAdmListProv = new ModAdmListProv();
            ConAdmListProv conAdmListProv = new ConAdmListProv(visAdmListProv, modAdmListProv);
        }else if(e.getSource() == vista.btn_modificar){
            VisAdmModProv visAdmModProv = new VisAdmModProv();
            ModAdmModProv modAdmModProv = new ModAdmModProv();
            ConAdmModProv conAdmModProv = new ConAdmModProv(visAdmModProv, modAdmModProv);
            System.out.println("modificar");
        }else if(e.getSource() == vista.btn_registrar){
            VisAdmRegProv visAdmRegProv = new VisAdmRegProv();
            ModAdmRegProv modAdmRegProv = new ModAdmRegProv();
            ConAdmRegProv conAdmRegProv = new ConAdmRegProv(visAdmRegProv, modAdmRegProv);
        }
        vista.frame.dispose();
    }
}
