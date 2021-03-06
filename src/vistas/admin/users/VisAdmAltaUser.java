package vistas.admin.users;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmAltaUser {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id, txt_contra, txt_nombre, txt_tel;
    public JCheckBox chck_admin;
    public JButton btn_crear, btn_home;


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

        JLabel lbl_altaUser = new JLabel("Dar de alta un nuevo usuario");
        lbl_altaUser.setVerticalAlignment(SwingConstants.TOP);
        lbl_altaUser.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_altaUser.setForeground(colores.amarillo);
        lbl_altaUser.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_altaUser.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_altaUser);

        JLabel lbl_idUser = new JLabel("ID del Usuario:");
        lbl_idUser.setForeground(colores.amarillo);
        lbl_idUser.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_idUser.setBounds(10, 200, 350, 60);
        frame.getContentPane().add(lbl_idUser);

        JLabel lbl_contra = new JLabel("Contraseña:");
        lbl_contra.setForeground(colores.amarillo);
        lbl_contra.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_contra.setBounds(10, 370, 350, 60);
        frame.getContentPane().add(lbl_contra);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(370, 200, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        txt_contra = new JTextField();
        txt_contra.setForeground(colores.azul);
        txt_contra.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_contra.setColumns(10);
        txt_contra.setBounds(370, 370, 350, 50);
        frame.getContentPane().add(txt_contra);

        JLabel lbl_nombre = new JLabel("Nombre Completo:");
        lbl_nombre.setForeground(colores.amarillo);
        lbl_nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_nombre.setBounds(864, 200, 350, 60);
        frame.getContentPane().add(lbl_nombre);

        txt_nombre = new JTextField();
        txt_nombre.setForeground(colores.azul);
        txt_nombre.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_nombre.setColumns(10);
        txt_nombre.setBounds(1224, 200, 350, 50);
        frame.getContentPane().add(txt_nombre);

        JLabel lbl_tel = new JLabel("Teléfono Celular:");
        lbl_tel.setForeground(colores.amarillo);
        lbl_tel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_tel.setBounds(864, 370, 350, 60);
        frame.getContentPane().add(lbl_tel);

        txt_tel = new JTextField();
        txt_tel.setForeground(colores.azul);
        txt_tel.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_tel.setColumns(10);
        txt_tel.setBounds(1224, 370, 350, 50);
        frame.getContentPane().add(txt_tel);

        chck_admin = new JCheckBox("¿Administrador?");
        chck_admin.setForeground(colores.amarillo);
        chck_admin.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        chck_admin.setBounds(627, 513, 330, 60);
        frame.getContentPane().add(chck_admin);

        btn_crear = new JButton("Crear Usuario");
        btn_crear.setForeground(colores.amarillo);
        btn_crear.setBorder(border);
        btn_crear.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_crear.setBounds(584, 635, 416, 74);
        frame.getContentPane().add(btn_crear);

        btn_home = new JButton();
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        btn_home.setBorder(border);
        frame.getContentPane().add(btn_home);
    }
}
