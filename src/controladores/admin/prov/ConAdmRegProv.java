package controladores.admin.prov;

import controladores.admin.ConAdmMain;
import modelos.admin.prov.ModAdmRegProv;
import vistas.admin.VisAdmMain;
import vistas.admin.prov.VisAdmRegProv;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmRegProv implements ActionListener {
    public VisAdmRegProv vista;
    public ModAdmRegProv modelo;

    public ConAdmRegProv(VisAdmRegProv vista, ModAdmRegProv modelo) {
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
        vista.btn_reg.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_home){
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            modelo.cerrar();
            vista.frame.dispose();
        }else if(e.getSource() == vista.btn_reg){
            if(vista.txt_id.getText().isEmpty()||vista.txt_nom.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    String nombre = vista.txt_nom.getText();
                    int id = Integer.parseInt(vista.txt_id.getText());
                    modelo.ejecutar(id,nombre);
                }catch (NumberFormatException e2){
                    JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }
}
