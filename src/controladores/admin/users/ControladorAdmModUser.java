package controladores.admin.users;

import controladores.admin.ControladorPantallaAdmin;
import modelos.admin.users.ModeloAdmModUser;
import vistas.admin.users.VistaAdmModUser;
import vistas.admin.VistaPantallaAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmModUser implements ActionListener {
    VistaAdmModUser vista;
    ModeloAdmModUser modelo;

    public ControladorAdmModUser(VistaAdmModUser vista, ModeloAdmModUser modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if (vista.finished) {
            vista.btn_home.addActionListener(this);
            vista.btn_modificar.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_modificar) {
            try {
                int id = Integer.parseInt(vista.txt_id.getText());
                modelo.recibir(id);
                modelo.ejecutar();
                if (modelo.checked) {
                    JTextField nombre = new JTextField();
                    JTextField telefono = new JTextField();
                    JTextField password = new JPasswordField();
                    JCheckBox admin = new JCheckBox();
                    Object[] message = {
                            "Ingresar datos nuevos\n",
                            "Nombre:", nombre,
                            "Teléfono:", telefono,
                            "Contraseña:", password,
                            "¿Administrador?", admin
                    };
                    int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        if (nombre.getText().isEmpty() || password.getText().isEmpty() || telefono.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                String n_nombre = nombre.getText();
                                String n_tel = telefono.getText();
                                String n_pass = password.getText();
                                boolean n_admin = admin.isSelected();
                                modelo.actualizar(n_nombre, n_pass, n_admin, n_tel);
                            } catch (NumberFormatException e2) {
                                JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no modificado");
                    }
                } else if (e.getSource() == vista.btn_home) {
                    VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
                    vista.frame.dispose();
                    ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
            vista.frame.dispose();
        }
    }
}
