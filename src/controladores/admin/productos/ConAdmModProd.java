package controladores.admin.productos;

import com.mysql.cj.jdbc.exceptions.NotUpdatable;
import controladores.admin.ConAdmMain;
import modelos.admin.Categoria;
import modelos.admin.Proveedor;
import modelos.admin.productos.ModAdmModProd;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmModProd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConAdmModProd implements ActionListener {
    public VisAdmModProd vista;
    public ModAdmModProd modelo;
    public JComboBox<Object> cmb_cat;
    public JComboBox<Object> cmb_prov;

    public ConAdmModProd(VisAdmModProd vista, ModAdmModProd modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
        modelo.queryCategorias();
        modelo.queryProv();
    }

    private void agregarListeners() {
        if (vista.finished){
            vista.btn_home.addActionListener(this);
            vista.btn_modificar.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_modificar){
            try{
                int id = Integer.parseInt(vista.txt_id.getText());
                modelo.recibir(id);
                modelo.ejecutar();
                if(modelo.checked){
                    System.out.println("existe el producto");
                    JTextField nombre = new JTextField();
                    JTextField cve = new JTextField();
                    JTextField prec = new JTextField();
                    JSpinner inv = new JSpinner();
                    cmb_cat  = new JComboBox<Object>();
                    cmb_prov = new JComboBox<Object>();
                    comboCat();
                    comboProv();
                    Object[] message ={
                            "Ingresar datos nuevos\n",
                            "Clave:",cve,
                            "Nombre:",nombre,
                            "Precio:",prec,
                            "Existencias:",inv,
                            "Categoría:",cmb_cat,
                            "Proveedor:",cmb_prov
                    };
                    int option = JOptionPane.showConfirmDialog(null, message, "Modificar", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION){
                        if(nombre.getText().isEmpty()||cve.getText().isEmpty()||prec.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            int inventario = (Integer) inv.getValue();
                            if(inventario<0){
                                JOptionPane.showMessageDialog(null, "No puede haber existencias negativas", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                try{
                                    String n_nombre = nombre.getText();
                                    int n_cve = Integer.parseInt(cve.getText());
                                    float n_prec = Float.parseFloat(prec.getText());
                                    String cat = (String) cmb_cat.getSelectedItem();
                                    String prov = (String) cmb_prov.getSelectedItem();
                                    modelo.recibirDatos(n_cve,n_nombre,n_prec,inventario,cat,prov);
                                    modelo.modProducto();
                                }catch (NumberFormatException e2){
                                    JOptionPane.showMessageDialog(null, "Número no válido", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                }
            }catch (NumberFormatException e2){
                e2.printStackTrace();
            }

        }else if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            modelo.cerrar();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            vista.frame.dispose();
        }
    }
    private void comboProv(){
        ArrayList<String> names = new ArrayList<>();
        cmb_prov.removeAllItems();
        for(Proveedor prov:modelo.Proveedores){
            cmb_prov.addItem(prov.getNom_prov());
        }
    }

    private void comboCat(){
        ArrayList<String> names = new ArrayList<>();
        cmb_cat.removeAllItems();
        for(Categoria cat: modelo.Categorias){
            cmb_cat.addItem(cat.getNom_cat());
        }

    }
}
