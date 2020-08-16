package controladores.user.venta;

import modelos.user.venta.ModUsrVenta;
import vistas.user.venta.VisUsrVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConUsrVenta implements ActionListener {
    public ModUsrVenta modelo;
    public VisUsrVenta vista;

    public ConUsrVenta(VisUsrVenta vista, ModUsrVenta modelo) {
        this.vista = vista;
        this.modelo = modelo;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
        agregarListeners();
    }

    private void agregarListeners() {
        if (vista.finished){
            vista.btn_agregar.addActionListener(this);
            vista.btn_home.addActionListener(this);
            vista.btn_eliminar.addActionListener(this);
            vista.btn_cancelar.addActionListener(this);
            vista.btn_pagar.addActionListener(this);
            vista.cmb_id.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_pagar){

        }else if(e.getSource() == vista.btn_cancelar){

        }else if(e.getSource() == vista.btn_eliminar){

        }else if (e.getSource() == vista.btn_home){

        }else if(e.getSource() == vista.btn_agregar){

        }else if(e.getSource() == vista.cmb_id){

        }

    }
}
