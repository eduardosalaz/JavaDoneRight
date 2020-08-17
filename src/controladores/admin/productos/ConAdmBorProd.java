package controladores.admin.productos;

import controladores.admin.ConAdmMain;
import modelos.admin.productos.ModAdmBorProd;
import vistas.admin.VisAdmMain;
import vistas.admin.productos.VisAdmBorProd;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmBorProd implements ActionListener {
    public VisAdmBorProd vista;
    public ModAdmBorProd modelo;

    public ConAdmBorProd(VisAdmBorProd vista, ModAdmBorProd modelo) {
        this.vista = vista;
        this.modelo = modelo;
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
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_borrar){
            borrar();
        }else if(e.getSource() == vista.btn_home){
            home();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        modelo.cerrar();
        vista.frame.dispose();
    }

    private void borrar(){
        if(vista.txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                int id = Integer.parseInt(vista.txt_id.getText());
                modelo.recibir(id);
                modelo.ejecutar();
                vista.txt_id.setText("");
            }catch (NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
