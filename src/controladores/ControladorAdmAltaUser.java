package controladores;
import vistas.VistaAdmAltaUser;
import modelos.ModeloAdmAltaUser;
import vistas.VistaPantallaAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ControladorAdmAltaUser implements ActionListener, ItemListener {
    VistaAdmAltaUser vista;
    ModeloAdmAltaUser modelo;

    public ControladorAdmAltaUser(VistaAdmAltaUser vistaAdmAltaUser, ModeloAdmAltaUser modeloAdmAltaUser){
        vista = vistaAdmAltaUser;
        modelo = modeloAdmAltaUser;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        System.out.println("vista adm alta user");
        agregarListeners();
    }

    private void agregarListeners() {
        vista.btn_crear.addActionListener(this);
        vista.btn_home.addActionListener(this);
        vista.chck_admin.addItemListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_crear){
            if(vista.txt_contra.getText().isEmpty() || vista.txt_id.getText().isEmpty() || vista.txt_tel.getText().isEmpty() || vista.txt_nombre.getText().isEmpty()){
                System.out.println("vacio");
                JOptionPane.showMessageDialog(null, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                String nombre = vista.txt_nombre.getText();
                String pass = vista.txt_contra.getText();
                String tel = vista.txt_tel.getText();
                boolean admin = vista.chck_admin.isSelected();
                int id;
                try{
                    id = Integer.parseInt(vista.txt_id.getText());
                    System.out.println("Nombre: " + nombre + " pass: " + pass + " tel: " + tel + " id: " + id + " admin: " + admin);
                    modelo.recibir(nombre, pass, tel, id, admin);
                    modelo.ejecutar();
                }catch (NumberFormatException e2){
                    JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            vista.frame.dispose();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == vista.chck_admin){

        }
    }
}
