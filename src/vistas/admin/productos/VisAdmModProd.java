package vistas.admin.productos;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmModProd {

    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_modificar, btn_home;

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

        JLabel lbl_modProd = new JLabel("Modificar a un producto");
        lbl_modProd.setVerticalAlignment(SwingConstants.TOP);
        lbl_modProd.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_modProd.setForeground(colores.amarillo);
        lbl_modProd.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_modProd.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_modProd);

        JLabel lbl_cve = new JLabel("Inserte la clave del producto a modificar");
        lbl_cve.setVerticalAlignment(SwingConstants.TOP);
        lbl_cve.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_cve.setForeground(colores.amarillo);
        lbl_cve.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        lbl_cve.setBounds(399, 230, 785, 59);
        frame.getContentPane().add(lbl_cve);

        txt_id = new JTextField();
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setForeground(colores.azul);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 300, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        btn_modificar = new JButton("Modificar Producto");
        btn_modificar.setForeground(colores.amarillo);
        btn_modificar.setBorder(border);
        btn_modificar.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_modificar.setBounds(533, 635, 500, 74);
        frame.getContentPane().add(btn_modificar);

        btn_home = new JButton();
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        btn_home.setBorder(border);
        frame.getContentPane().add(btn_home);
    }

}
