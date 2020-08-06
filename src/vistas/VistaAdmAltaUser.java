package vistas;

import crearColores.CustomColors;

import javax.swing.*;
import java.awt.*;

public class VistaAdmAltaUser {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;


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

        JLabel lblNewLabel_1 = new JLabel("ID del Usuario:");
        lblNewLabel_1.setBackground(colores.oscuro);
        lblNewLabel_1.setForeground(colores.amarillo);
        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblNewLabel_1.setBounds(10, 200, 350, 60);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
        lblNewLabel_1_1.setForeground(colores.amarillo);
        lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblNewLabel_1_1.setBackground(colores.oscuro);
        lblNewLabel_1_1.setBounds(10, 370, 350, 60);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setForeground(colores.azul);
        textField.setBackground(colores.oscuro);
        textField.setFont(new Font("Carlito", Font.PLAIN, 35));
        textField.setBounds(370, 200, 350, 50);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setForeground(colores.azul);
        textField_1.setBackground(colores.oscuro);
        textField_1.setFont(new Font("Carlito", Font.PLAIN, 35));
        textField_1.setColumns(10);
        textField_1.setBounds(370, 370, 350, 50);
        frame.getContentPane().add(textField_1);

        JLabel lblNewLabel_1_2 = new JLabel("Nombre Completo:");
        lblNewLabel_1_2.setForeground(colores.amarillo);
        lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblNewLabel_1_2.setBackground(colores.oscuro);
        lblNewLabel_1_2.setBounds(864, 200, 350, 60);
        frame.getContentPane().add(lblNewLabel_1_2);

        textField_2 = new JTextField();
        textField_2.setForeground(colores.azul);
        textField_2.setBackground(colores.oscuro);
        textField_2.setFont(new Font("Carlito", Font.PLAIN, 35));
        textField_2.setColumns(10);
        textField_2.setBounds(1224, 200, 350, 50);
        frame.getContentPane().add(textField_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("Teléfono Celular:");
        lblNewLabel_1_2_1.setForeground(colores.amarillo);
        lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblNewLabel_1_2_1.setBackground(colores.oscuro);
        lblNewLabel_1_2_1.setBounds(864, 370, 350, 60);
        frame.getContentPane().add(lblNewLabel_1_2_1);

        textField_3 = new JTextField();
        textField_3.setForeground(colores.azul);
        textField_3.setBackground(colores.oscuro);
        textField_3.setFont(new Font("Carlito", Font.PLAIN, 35));
        textField_3.setColumns(10);
        textField_3.setBounds(1224, 370, 350, 50);
        frame.getContentPane().add(textField_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("¿Administrador?");
        chckbxNewCheckBox.setBackground(colores.oscuro);
        chckbxNewCheckBox.setForeground(colores.amarillo);
        chckbxNewCheckBox.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        chckbxNewCheckBox.setBounds(634, 513, 315, 60);
        frame.getContentPane().add(chckbxNewCheckBox);

        JButton btnNewButton = new JButton("Crear Usuario");
        btnNewButton.setForeground(colores.amarillo);
        btnNewButton.setBackground(colores.oscuro);
        btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btnNewButton.setBounds(584, 635, 416, 74);
        frame.getContentPane().add(btnNewButton);
    }
}
