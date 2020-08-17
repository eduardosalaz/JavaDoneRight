package vistas.user;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisUsrMain {

    public JFrame frame;
    public CustomColors colores = new CustomColors();
    public JButton btn_venta, btn_compra, btn_corte;
    public boolean finished = false;

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


    public void crearGUI() {
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

        JLabel lbl_usr = new JLabel("Menú de Usuario");
        lbl_usr.setVerticalAlignment(SwingConstants.TOP);
        lbl_usr.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_usr.setForeground(colores.amarillo);
        lbl_usr.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_usr.setBounds(588, 91, 408, 59);
        frame.getContentPane().add(lbl_usr);

        btn_venta = new JButton("Nueva Venta");
        btn_venta.setVerticalAlignment(SwingConstants.TOP);
        btn_venta.setForeground(colores.amarillo);
        btn_venta.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_venta.setBounds(352, 170, 400, 55);
        btn_venta.setBorder(border);
        frame.getContentPane().add(btn_venta);

        btn_compra = new JButton("Nueva Compra");
        btn_compra.setVerticalAlignment(SwingConstants.TOP);
        btn_compra.setForeground(colores.amarillo);
        btn_compra.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_compra.setBorder(border);
        btn_compra.setBounds(832, 170, 400, 55);
        frame.getContentPane().add(btn_compra);

        btn_corte = new JButton("Corte de Venta");
        btn_corte.setVerticalAlignment(SwingConstants.TOP);
        btn_corte.setForeground(colores.amarillo);
        btn_corte.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_corte.setBorder(border);
        btn_corte.setBounds(592, 261, 400, 55);
        frame.getContentPane().add(btn_corte);
    }
}
