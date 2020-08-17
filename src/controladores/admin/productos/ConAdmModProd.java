package controladores.admin.productos;

import controladores.admin.ConAdmMain;
import modelos.admin.Categoria;
import modelos.admin.Proveedor;
import modelos.admin.productos.ModAdmModProd;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmModProd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmModProd implements ActionListener {
    public VisAdmModProd vista;
    public ModAdmModProd modelo;
    public JComboBox<String> cmb_cat;
    public JComboBox<String> cmb_prov;

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
            modificar();
        }else if(e.getSource() == vista.btn_home){
            home();
        }
    }
    private void comboProv(){
        cmb_prov.removeAllItems();
        for(Proveedor prov:modelo.Proveedores){
            cmb_prov.addItem(prov.getNom_prov());
        }
    }

    private void comboCat(){
        cmb_cat.removeAllItems();
        for(Categoria cat: modelo.Categorias){
            cmb_cat.addItem(cat.getNom_cat());
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        modelo.cerrar();
        vista.frame.dispose();
    }

    private void modificar(){
        try{
            int id = Integer.parseInt(vista.txt_id.getText());
            modelo.recibir(id);
            modelo.ejecutar();
            if(modelo.checked){
                JTextField nombre = new JTextField();
                JTextField cve = new JTextField();
                JTextField prec = new JTextField();
                JSpinner inv = new JSpinner();
                cmb_cat  = new JComboBox<String>();
                cmb_prov = new JComboBox<String>();
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
    }
}
