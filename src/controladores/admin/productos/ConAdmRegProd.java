package controladores.admin.productos;

import controladores.admin.ConAdmMain;
import modelos.admin.Categoria;
import modelos.admin.Proveedor;
import modelos.admin.productos.ModAdmRegProd;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmRegProd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmRegProd implements ActionListener {
    VisAdmRegProd vista;
    ModAdmRegProd modelo;
    public ConAdmRegProd(VisAdmRegProd vista, ModAdmRegProd modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        modelo.queryCategorias();
        comboCategoria();
        modelo.queryProv();
        comboProv();
        agregarListeners();
    }

    private void comboProv() {
        vista.cmb_prov.removeAllItems();
        for(Proveedor prov: modelo.Proveedores){
            vista.cmb_prov.addItem(prov.getNom_prov());
        }
    }

    private void comboCategoria() {
        vista.cmb_cat.removeAllItems();
        for(Categoria categoria: modelo.Categorias){
            vista.cmb_cat.addItem(categoria.getNom_cat());
        }
    }

    private void agregarListeners() {
        if(vista.finished){
            vista.btn_home.addActionListener(this);
            vista.btn_reg.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            modelo.cerrarConexion();
            vista.frame.dispose();
        }else if(e.getSource() == vista.btn_reg){
            try{
                if(vista.txt_cve.getText().isEmpty()||vista.txt_nom.getText().isEmpty()||vista.txt_prec.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    int cve = Integer.parseInt(vista.txt_cve.getText());
                    String nom = vista.txt_nom.getText();
                    float precio = Float.parseFloat(vista.txt_prec.getText());
                    int inv = (Integer) vista.spn_inv.getValue();
                    String cat = (String) vista.cmb_cat.getSelectedItem();
                    String prov = (String) vista.cmb_prov.getSelectedItem();
                    if(inv<0){
                        JOptionPane.showMessageDialog(null, "No puede haber existencias negativas", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        modelo.recibirDatos(cve,nom,precio,inv,cat,prov);
                        modelo.registrarProducto();
                    }
                }
            }catch (NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Usa sólo numeros para la clave y el precio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
