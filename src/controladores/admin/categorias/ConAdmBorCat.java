package controladores.admin.categorias;

import controladores.admin.ConAdmMain;
import modelos.admin.categorias.ModAdmBorCat;
import vistas.admin.VisAdmMain;
import vistas.admin.categorias.VisAdmBorCat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmBorCat implements ActionListener {
    public VisAdmBorCat vista;
    public ModAdmBorCat modelo;

    public ConAdmBorCat(VisAdmBorCat vista, ModAdmBorCat modelo) {
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
            home();
        }else if(e.getSource() == vista.btn_bor){
            borrar();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        vista.frame.dispose();
        modelo.cerrar();
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

