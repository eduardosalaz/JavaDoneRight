package controladores.admin.reportes;
import controladores.admin.ConAdmMain;
import vistas.admin.reportes.VisAdmRep;
import vistas.admin.VisAdmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConAdmRep implements ActionListener {
    public VisAdmRep vista;

    public ConAdmRep(VisAdmRep visAdmRep){
        vista = visAdmRep;
        ejecutar();
    }

    private void ejecutar() {
        vista.lanzarVista();
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
            home();
        }
    }

    private void home(){
        VisAdmMain visAdmMain = new VisAdmMain();
        ConAdmMain conAdmMain = new ConAdmMain(visAdmMain);
        vista.frame.dispose();
    }

}
