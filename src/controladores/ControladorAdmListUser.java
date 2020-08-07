package controladores;

import modelos.ModeloAdmListUser;
import modelos.Usuario;
import vistas.VistaAdmListUser;
import vistas.VistaPantallaAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmListUser implements ActionListener {
    VistaAdmListUser vista;
    ModeloAdmListUser modelo;

    public ControladorAdmListUser(VistaAdmListUser vista, ModeloAdmListUser modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        modelo.buscar();
        vista.lanzarVista();
        ((DefaultTableModel) vista.table.getModel()).setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) vista.table.getModel();
        for(Usuario user:modelo.Usuarios){
            model.addRow(new Object[]{""+user.getID_Usuario(), ""+user.getNombre(), ""+user.getPass(), ""+user.isAdmin(), ""+user.getTelefono(), ""+user.getFecha_Alta(), ""+user.getUltima_Sesion()});
        }
        System.out.println("vista admin lista de users");
        agregarListeners();
    }
    private void agregarListeners() {
        if(vista.finished){
            vista.btn_home.addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_home){
            VistaPantallaAdmin vistaPantallaAdmin = new VistaPantallaAdmin();
            ControladorPantallaAdmin controladorPantallaAdmin = new ControladorPantallaAdmin(vistaPantallaAdmin);
            System.out.println("home");
            vista.frame.dispose();
        }
    }
}
