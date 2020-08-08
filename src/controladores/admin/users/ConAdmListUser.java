package controladores.admin.users;

import controladores.admin.ConAdmMain;
import modelos.admin.users.ModAdmListUser;
import modelos.admin.users.Usuario;
import vistas.admin.users.VisAdmListUser;
import vistas.admin.VisAdmMain;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmListUser implements ActionListener {
    VisAdmListUser vista;
    ModAdmListUser modelo;

    public ConAdmListUser(VisAdmListUser vista, ModAdmListUser modelo) {
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
            VisAdmMain visAdmMain = new VisAdmMain();
            ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
            System.out.println("home");
            vista.frame.dispose();
        }
    }
}
