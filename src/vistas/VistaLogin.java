package vistas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import crearColores.CustomColors;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



public class VistaLogin extends JFrame {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public CustomColors colores = new CustomColors();
    public JTextField txt_usuario;
    public JPasswordField pwd_password;
    public JButton btn_login;
    public boolean finished = false;
    public String Nombre;

    public void lanzarVista() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    crearGUI();
                    setVisible(true);
                    setResizable(false);
                    finished = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Initialize the contents of the frame.
     */
    public void crearGUI() {
        getContentPane().setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        setBounds(100, 100, 1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        getContentPane().setLayout(null);
        getContentPane().setBackground(colores.gris);

        JLabel lbl_titulo = new JLabel("Smart Tienda 1.0");
        lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_titulo.setVerticalAlignment(SwingConstants.TOP);
        lbl_titulo.setFont(new Font("Bahnschrift", Font.BOLD, 58));
        lbl_titulo.setForeground(colores.amarillo);
        lbl_titulo.setBounds(560, 12, 463, 59);
        getContentPane().add(lbl_titulo);

        JLabel lbl_img = new JLabel();
        Image img = new ImageIcon("images/login2.png").getImage();
        lbl_img.setIcon(new ImageIcon(img));
        lbl_img.setBounds(717, 83, 150, 150);
        getContentPane().add(lbl_img);

        JLabel lblNewLabel = new JLabel("ID de Usuario:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblNewLabel.setBounds(667, 254, 250, 40);
        lblNewLabel.setForeground(colores.azul);
        getContentPane().add(lblNewLabel);

        JLabel lblContrasea = new JLabel("Contraseña: ");
        lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasea.setVerticalAlignment(SwingConstants.TOP);
        lblContrasea.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lblContrasea.setBounds(667, 374, 250, 40);
        lblContrasea.setForeground(colores.azul);
        getContentPane().add(lblContrasea);

        txt_usuario = new JTextField();
        txt_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        txt_usuario.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        txt_usuario.setForeground(colores.azul);
        txt_usuario.setBounds(667, 304, 250, 40);
        txt_usuario.setBackground(colores.gris);
        getContentPane().add(txt_usuario);
        txt_usuario.setColumns(15);

        pwd_password = new JPasswordField();
        pwd_password.setEchoChar('*');
        pwd_password.setHorizontalAlignment(SwingConstants.CENTER);
        pwd_password.setColumns(15);
        pwd_password.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        pwd_password.setBackground(colores.gris);
        pwd_password.setBounds(667, 424, 250, 40);
        pwd_password.setForeground(colores.azul);
        getContentPane().add(pwd_password);

        btn_login = new JButton("Login");
        btn_login.setVerticalAlignment(SwingConstants.TOP);
        btn_login.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        btn_login.setForeground(colores.amarillo);
        btn_login.setBounds(667, 494, 250, 50);
        btn_login.setBackground(colores.gris);
        getContentPane().add(btn_login);
    }
}
