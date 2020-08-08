package controladores.admin.users;

import controladores.admin.ControladorPantallaAdmin;
import modelos.admin.users.ModeloAdmAltaUser;
import vistas.admin.users.VistaAdmAltaUser;
import vistas.admin.VistaPantallaAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorAdmAltaUser implements ActionListener{
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
        if(vista.finished){
            vista.btn_crear.addActionListener(this);
            vista.btn_home.addActionListener(this);
        }

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
                if(tel.length() > 10){
                    JOptionPane.showMessageDialog(null, "Número telefónico demasiado largo", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
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
            }
        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            vista.frame.dispose();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
        }
    }

}
