package vistas;

import crearColores.CustomColors;

import javax.swing.*;
import java.awt.*;

public class VistaAdmAltaUser {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id, txt_contra, txt_nombre, txt_tel;
    public JCheckBox chck_admin;
    public JButton btn_crear;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaAdmAltaUser window = new VistaAdmAltaUser();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VistaAdmAltaUser() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        frame.setBounds(100, 100, 1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(colores.oscuro);

        Image ico = new ImageIcon("images/carro.png").getImage();
        frame.setIconImage(ico);
        frame.setTitle("Smart Tienda 1.0");

        JLabel lbl_titulo = new JLabel("Smart Tienda 1.0");
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

        JLabel lbl_productos = new JLabel("Dar de alta un nuevo usuario");
        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_productos.setForeground(colores.amarillo);
        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_productos.setBounds(436, 91, 712, 59);
        lbl_productos.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_productos);

        JLabel lbl_id = new JLabel("ID del Usuario:");
        lbl_id.setBackground(colores.oscuro);
        lbl_id.setForeground(colores.amarillo);
        lbl_id.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_id.setBounds(10, 200, 350, 60);
        frame.getContentPane().add(lbl_id);

        JLabel lbl_contra = new JLabel("Contraseña:");
        lbl_contra.setForeground(colores.amarillo);
        lbl_contra.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_contra.setBackground(colores.oscuro);
        lbl_contra.setBounds(10, 370, 350, 60);
        frame.getContentPane().add(lbl_contra);

        txt_id = new JTextField();
        txt_id.setForeground(colores.azul);
        txt_id.setBackground(colores.oscuro);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(370, 200, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);

        txt_contra = new JTextField();
        txt_contra.setForeground(colores.azul);
        txt_contra.setBackground(colores.oscuro);
        txt_contra.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_contra.setColumns(10);
        txt_contra.setBounds(370, 370, 350, 50);
        frame.getContentPane().add(txt_contra);

        JLabel lbl_nombre = new JLabel("Nombre Completo:");
        lbl_nombre.setForeground(colores.amarillo);
        lbl_nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_nombre.setBackground(colores.oscuro);
        lbl_nombre.setBounds(864, 200, 350, 60);
        frame.getContentPane().add(lbl_nombre);

        txt_nombre = new JTextField();
        txt_nombre.setForeground(colores.azul);
        txt_nombre.setBackground(colores.oscuro);
        txt_nombre.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_nombre.setColumns(10);
        txt_nombre.setBounds(1224, 200, 350, 50);
        frame.getContentPane().add(txt_nombre);

        JLabel lbl_tel = new JLabel("Teléfono Celular:");
        lbl_tel.setForeground(colores.amarillo);
        lbl_tel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_tel.setBackground(colores.oscuro);
        lbl_tel.setBounds(864, 370, 350, 60);
        frame.getContentPane().add(lbl_tel);

        txt_tel = new JTextField();
        txt_tel.setForeground(colores.azul);
        txt_tel.setBackground(colores.oscuro);
        txt_tel.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_tel.setColumns(10);
        txt_tel.setBounds(1224, 370, 350, 50);
        frame.getContentPane().add(txt_tel);

        chck_admin = new JCheckBox("¿Administrador?");
        chck_admin.setBackground(colores.oscuro);
        chck_admin.setForeground(colores.amarillo);
        chck_admin.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        chck_admin.setBounds(634, 513, 315, 60);
        frame.getContentPane().add(chck_admin);

        btn_crear = new JButton("Crear Usuario");
        btn_crear.setForeground(colores.amarillo);
        btn_crear.setBackground(colores.oscuro);
        btn_crear.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_crear.setBounds(584, 635, 416, 74);
        frame.getContentPane().add(btn_crear);
    }
}
