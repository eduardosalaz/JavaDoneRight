package controladores.admin.productos;

import controladores.admin.ConAdmMain;
import modelos.Articulo;
import modelos.admin.Categoria;
import modelos.admin.productos.ModAdmListProd;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmListProd;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmListProd implements ActionListener {
    VisAdmListProd vista;
    ModAdmListProd modelo;
    public ConAdmListProd(VisAdmListProd vista, ModAdmListProd modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        modelo.buscar();
        vista.lanzarVista();
        ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) vista.table.getModel();
        for(Articulo art: modelo.Articulos){
            model.addRow(new Object[]{""+art.getCve_art(),""+art.getNom_art(),""+art.getPre_art(),""+art.getInv_art(),""+art.getNom_cat(),""+art.getNom_prov()});
        }
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
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            System.out.println("home");
            vista.frame.dispose();
        }
    }
}
