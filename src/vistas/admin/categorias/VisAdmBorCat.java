package vistas.admin.categorias;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmBorCat {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_bor, btn_home;

    public void lanzarVista() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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

        Border bord = BorderFactory.createEmptyBorder();

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

        JLabel lbl_borCat = new JLabel("Borrar a una categoría");
        lbl_borCat.setVerticalAlignment(SwingConstants.TOP);
        lbl_borCat.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_borCat.setForeground(colores.amarillo);
        lbl_borCat.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_borCat.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_borCat);

        JLabel lbl_idCat = new JLabel("ID de Categoría:");
        lbl_idCat.setForeground(colores.amarillo);
        lbl_idCat.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_idCat.setBounds(632, 200, 319, 60);
        frame.getContentPane().add(lbl_idCat);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 310, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setColumns(10);

        btn_bor = new JButton("Borrar Categoría");
        btn_bor.setForeground(colores.amarillo);
        btn_bor.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_bor.setBounds(522, 410, 540, 74);
        btn_bor.setBorder(bord);
        frame.getContentPane().add(btn_bor);

        btn_home = new JButton();
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
    }


}
