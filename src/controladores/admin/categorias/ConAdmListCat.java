package controladores.admin.categorias;

import controladores.admin.ConAdmMain;
import modelos.admin.Categoria;
import modelos.admin.categorias.ModAdmListCat;
import vistas.admin.VisAdmMain;
import vistas.admin.categorias.VisAdmListCat;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmListCat implements ActionListener {
    public VisAdmListCat vista;
    public ModAdmListCat modelo;

    public ConAdmListCat(VisAdmListCat vista, ModAdmListCat modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        modelo.buscar();
        vista.lanzarVista();
        ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) vista.table.getModel();
        for(Categoria Cat: modelo.Categorias){
            model.addRow(new Object[]{""+Cat.getId_cat(),""+Cat.getNom_cat()});
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
            home();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        vista.frame.dispose();
    }
}
