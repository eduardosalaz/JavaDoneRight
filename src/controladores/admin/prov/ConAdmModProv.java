package controladores.admin.prov;

import controladores.admin.ConAdmMain;
import modelos.admin.prov.ModAdmModProv;
import vistas.admin.VisAdmMain;
import vistas.admin.prov.VisAdmModProv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmModProv implements ActionListener {
    public VisAdmModProv vista;
    public ModAdmModProv modelo;

    public ConAdmModProv(VisAdmModProv vista, ModAdmModProv modelo) {
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
            vista.btn_mod.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_home) {
            home();
        } else if (e.getSource() == vista.btn_mod) {
            modificar();
        }
    }

    private void home() {
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        modelo.cerrar();
        vista.frame.dispose();
    }

    private void modificar() {
        try {
            int id = Integer.parseInt(vista.txt_id.getText());
            modelo.recibir(id);
            modelo.ejecutar();
            if (modelo.checked) {
                JTextField nombre = new JTextField();
                JTextField txt_id = new JTextField();
                Object[] message = {
                        "Ingresar datos nuevos\n",
                        "ID:", txt_id,
                        "Nombre:", nombre,
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Modificar", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    if (nombre.getText().isEmpty() || txt_id.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            String n_nombre = nombre.getText();
                            int n_id = Integer.parseInt(txt_id.getText());
                            modelo.actualizar(n_nombre, n_id);
                        } catch (NumberFormatException e2) {
                            JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
                            e2.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor no modificado");
                }
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Asignar un número válido al ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
