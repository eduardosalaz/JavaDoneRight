package vistas.admin.prov;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;

public class VisAdmRegProv {

    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id,txt_nom;
    public JButton btn_reg,btn_home;

    public void lanzarVista() {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try{
                    javax.swing.UIManager.setLookAndFeel(new DarculaLaf());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
        try {
            crearGUI();
            frame.setVisible(true);
            frame.setResizable(false);
            finished = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void crearGUI() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        frame.setBounds(100, 100, 1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(colores.oscuro);

        Image ico = new ImageIcon("images/carro.png").getImage();
        frame.setIconImage(ico);
        frame.setTitle("TITULO ACÁ");

        JLabel lbl_titulo = new JLabel("TITULO ACÁ");
        lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_titulo.setVerticalAlignment(SwingConstants.TOP);
        lbl_titulo.setFont(new Font("Bahnschrift", Font.BOLD, 58));
        lbl_titulo.setForeground(colores.amarillo);
        lbl_titulo.setBounds(560, 12, 463, 59);

        frame.getContentPane().add(lbl_titulo);

        //Placeholder para el reloj
        JLabel lblNewLabel = new JLabel("Mon 3, Aug 2020 13:13:45 -0500");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(1288, 800, 286, 50);
        frame.getContentPane().add(lblNewLabel);

        JLabel lbl_productos = new JLabel("Registrar un nuevo proveedor");
        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_productos.setForeground(colores.amarillo);
        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_productos.setBounds(436, 91, 712, 59);
        lbl_productos.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_productos);

        JLabel lbl_cve = new JLabel("ID del Proveedor:");
        lbl_cve.setBackground(colores.oscuro);
        lbl_cve.setForeground(colores.amarillo);
        lbl_cve.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_cve.setBounds(632, 200, 319, 60);
        frame.getContentPane().add(lbl_cve);

        JLabel lbl_nom = new JLabel("Nombre del Proveedor:");
        lbl_nom.setForeground(colores.amarillo);
        lbl_nom.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_nom.setBackground(colores.oscuro);
        lbl_nom.setBounds(580, 410, 424, 60);
        frame.getContentPane().add(lbl_nom);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setBackground(colores.oscuro);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 310, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        txt_nom = new JTextField();
        txt_nom.setForeground(colores.azul);
        txt_nom.setBackground(colores.oscuro);
        txt_nom.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_nom.setColumns(10);
        txt_nom.setBounds(617, 520, 350, 50);
        frame.getContentPane().add(txt_nom);

        btn_reg = new JButton("Registrar Proveedor");
        btn_reg.setForeground(colores.amarillo);
        btn_reg.setBackground(colores.oscuro);
        btn_reg.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_reg.setBounds(522, 635, 540, 74);
        frame.getContentPane().add(btn_reg);

        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);

    }

}
