package controladores.admin.categorias;

import controladores.admin.ConAdmMain;
import modelos.admin.categorias.ModAdmRegCat;
import vistas.admin.VisAdmMain;
import vistas.admin.categorias.VisAdmRegCat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmRegCat implements ActionListener {
    public VisAdmRegCat vista;
    public ModAdmRegCat modelo;

    public ConAdmRegCat(VisAdmRegCat vista, ModAdmRegCat modelo) {
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
            home();
        }else if(e.getSource() == vista.btn_reg){
            registrar();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        modelo.cerrar();
        vista.frame.dispose();
    }

    private void registrar(){
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
