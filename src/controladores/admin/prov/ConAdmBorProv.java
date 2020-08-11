package controladores.admin.prov;

import controladores.admin.ConAdmMain;
import modelos.admin.prov.ModAdmBorProv;
import vistas.admin.VisAdmMain;
import vistas.admin.prov.VisAdmBorProv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmBorProv implements ActionListener {
    VisAdmBorProv vista;
    ModAdmBorProv modelo;
    public ConAdmBorProv(VisAdmBorProv vista, ModAdmBorProv modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        vista.btn_home.addActionListener(this);
        vista.btn_bor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            vista.frame.dispose();
            modelo.cerrar();
        }else if(e.getSource() == vista.btn_bor){
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
}

