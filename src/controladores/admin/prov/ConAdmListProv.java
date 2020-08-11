package controladores.admin.prov;

import controladores.admin.ConAdmMain;
import modelos.admin.Proveedor;
import modelos.admin.prov.ModAdmListProv;
import vistas.admin.VisAdmMain;
import vistas.admin.prov.VisAdmListProv;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmListProv implements ActionListener {
    public VisAdmListProv vista;
    public ModAdmListProv modelo;
    public ConAdmListProv(VisAdmListProv vista, ModAdmListProv modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        modelo.buscar();
        vista.lanzarVista();
        ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) vista.table.getModel();
        for(Proveedor prov: modelo.Proveedores){
            model.addRow(new Object[]{""+prov.getId_prov(),""+prov.getNom_prov(),""+prov.getUltima_prov()});
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
            vista.frame.dispose();
        }
    }
}
