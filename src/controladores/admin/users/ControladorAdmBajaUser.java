package controladores.admin.users;
import controladores.admin.ControladorPantallaAdmin;
import modelos.admin.users.ModeloAdmBajaUser;
import vistas.admin.users.VistaAdmBajaUser;
import vistas.admin.VistaPantallaAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmBajaUser implements ActionListener {
    VistaAdmBajaUser vista;
    ModeloAdmBajaUser modelo;

    public ControladorAdmBajaUser(VistaAdmBajaUser vista, ModeloAdmBajaUser modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        System.out.println("vista baja user");
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

        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            vista.frame.dispose();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
        }
    }
}
