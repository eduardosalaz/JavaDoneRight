package controladores.admin.users;

import controladores.admin.ConAdmMain;
import modelos.admin.users.ModAdmAltaUser;
import vistas.admin.users.VisAdmAltaUser;
import vistas.admin.VisAdmMain;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConAdmAltaUser implements ActionListener{
    public VisAdmAltaUser vista;
    public ModAdmAltaUser modelo;

    public ConAdmAltaUser(VisAdmAltaUser visAdmAltaUser, ModAdmAltaUser modAdmAltaUser){
        vista = visAdmAltaUser;
        modelo = modAdmAltaUser;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if(vista.finished){
            vista.btn_crear.addActionListener(this);
            vista.btn_home.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_crear){
            alta();
        }else if(e.getSource() == vista.btn_home){
            home();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        modelo.cerrar();
        vista.frame.dispose();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
    }

    private void alta(){
        if(vista.txt_contra.getText().isEmpty() || vista.txt_id.getText().isEmpty() || vista.txt_tel.getText().isEmpty() || vista.txt_nombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String nombre = vista.txt_nombre.getText();
            String pass = vista.txt_contra.getText();
            String tel = vista.txt_tel.getText();
            if(tel.length() > 10){
                JOptionPane.showMessageDialog(null, "Número telefónico demasiado largo", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                boolean admin = vista.chck_admin.isSelected();
                int id;
                try{
                    id = Integer.parseInt(vista.txt_id.getText());
                    modelo.recibir(nombre, pass, tel, id, admin);
                    modelo.ejecutar();
                }catch (NumberFormatException e2){
                    JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
