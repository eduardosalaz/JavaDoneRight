package vistas.admin.prov;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmRegProv {

    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id, txt_nom;
    public JButton btn_reg, btn_home;

    public void lanzarVista() {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (Exception e) {
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

        Image ico = new ImageIcon("images/carro.png").getImage();
        frame.setIconImage(ico);
        frame.setTitle("TITULO ACÁ");

        Border border = BorderFactory.createEmptyBorder();

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

        JLabel lbl_regProd = new JLabel("Registrar un nuevo proveedor");
        lbl_regProd.setVerticalAlignment(SwingConstants.TOP);
        lbl_regProd.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_regProd.setForeground(colores.amarillo);
        lbl_regProd.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_regProd.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_regProd);

        JLabel lbl_idProv = new JLabel("ID del Proveedor:");
        lbl_idProv.setForeground(colores.amarillo);
        lbl_idProv.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_idProv.setBounds(632, 200, 319, 60);
        frame.getContentPane().add(lbl_idProv);

        JLabel lbl_nomProv = new JLabel("Nombre del Proveedor:");
        lbl_nomProv.setForeground(colores.amarillo);
        lbl_nomProv.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_nomProv.setBounds(580, 410, 424, 60);
        frame.getContentPane().add(lbl_nomProv);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 310, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        txt_nom = new JTextField();
        txt_nom.setForeground(colores.azul);
        txt_nom.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_nom.setColumns(10);
        txt_nom.setBounds(617, 520, 350, 50);
        frame.getContentPane().add(txt_nom);

        btn_reg = new JButton("Registrar Proveedor");
        btn_reg.setForeground(colores.amarillo);
        btn_reg.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_reg.setBounds(522, 635, 540, 74);
        btn_reg.setBorder(border);
        frame.getContentPane().add(btn_reg);

        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        btn_home.setBorder(border);
        frame.getContentPane().add(btn_home);

    }

}
