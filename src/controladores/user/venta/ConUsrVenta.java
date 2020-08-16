package controladores.user.venta;

import controladores.user.ConUsrMain;
import modelos.admin.Articulo;
import modelos.user.venta.ModUsrVenta;
import vistas.user.VisUsrMain;
import vistas.user.venta.VisUsrVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConUsrVenta implements ActionListener {
    public ModUsrVenta modelo;
    public VisUsrVenta vista;
    public float dineroTotal = 0;

    public ConUsrVenta(VisUsrVenta vista, ModUsrVenta modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        modelo.queryProductos();
        vista.lanzarVista();
        comboID();
        agregarListeners();
        ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
    }

    private void agregarListeners() {
        if (vista.finished){
            vista.btn_agregar.addActionListener(this);
            vista.btn_home.addActionListener(this);
            vista.btn_eliminar.addActionListener(this);
            vista.btn_cancelar.addActionListener(this);
            vista.btn_pagar.addActionListener(this);
            vista.cmb_id.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_pagar){

        }else if(e.getSource() == vista.btn_cancelar){
            ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
            vista.lbl_dinero.setText("$$$");
            vista.txt_cantidad.setText("");
            vista.cmb_id.setSelectedItem("1");
            dineroTotal = 0;

        }else if(e.getSource() == vista.btn_eliminar){

        }else if (e.getSource() == vista.btn_home){
            VisUsrMain visUsrMain = new VisUsrMain();
            ConUsrMain conUsrMain = new ConUsrMain(visUsrMain);
            modelo.cerrarConexion();
            vista.frame.dispose();
        }else if(e.getSource() == vista.btn_agregar){
            if(!vista.txt_cantidad.getText().isEmpty()){
                try{
                    int cantidad = Integer.parseInt(vista.txt_cantidad.getText());
                    int id = (Integer) vista.cmb_id.getSelectedItem();
                    modelo.calcularPrecio(id, cantidad);
                    float prec_ind = obtenerPrecio(id);
                    float prec_total = modelo.prec_total;
                    if(modelo.prec_total>0){
                        DefaultTableModel model = (DefaultTableModel) vista.table.getModel();
                        model.addRow(new Object[]{""+id,""+vista.lbl_producto.getText(),""+prec_ind,""+cantidad,""+prec_total});
                        dineroTotal += prec_total;
                    }

                    vista.lbl_dinero.setText(""+dineroTotal);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Use sólo numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == vista.cmb_id){
            int clave =(Integer) vista.cmb_id.getSelectedItem();
            cambiarArt(clave);
        }
    }

    private void comboID(){
        for (Articulo art:modelo.Articulos){
            vista.cmb_id.addItem(art.getCve_art());
        }
    }
    private float obtenerPrecio(int cve){
        for (Articulo art: modelo.Articulos){
            if(art.getCve_art() == cve){
                return art.getPre_art();
            }
        }
        return 0;
    }

    private void cambiarArt(int cve){
        for (Articulo art:modelo.Articulos){
            if(art.getCve_art() == cve){
                vista.lbl_producto.setText(art.getNom_art());
            }
        }
    }
}