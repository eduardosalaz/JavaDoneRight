package vistas.admin.prov;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmModProv {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_mod, btn_home;

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

        JLabel lbl_modProv = new JLabel("Modificar a un proveedor");
        lbl_modProv.setVerticalAlignment(SwingConstants.TOP);
        lbl_modProv.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_modProv.setForeground(colores.amarillo);
        lbl_modProv.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_modProv.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_modProv);

        JLabel lbl_idProv = new JLabel("ID del Proveedor:");
        lbl_idProv.setForeground(colores.amarillo);
        lbl_idProv.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_idProv.setBounds(632, 200, 319, 60);
        frame.getContentPane().add(lbl_idProv);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 310, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        btn_mod = new JButton("Modificar Proveedor");
        btn_mod.setForeground(colores.amarillo);
        btn_mod.setBorder(border);
        btn_mod.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_mod.setBounds(522, 410, 540, 74);
        frame.getContentPane().add(btn_mod);

        btn_home = new JButton();
        btn_home.setBorder(border);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        frame.getContentPane().add(btn_home);
    }
}
