package vistas;

import java.awt.EventQueue;
import javax.swing.*;
import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;
import java.awt.Font;
import java.awt.Image;

public class VistaLogin {
    public JFrame frame;
    public CustomColors colores = new CustomColors();
    public JTextField txt_usuario;
    public JPasswordField pwd_password;
    public JButton btn_login;
    public boolean finished = false;


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
        EventQueue.invokeLater(() -> {
            try {
                crearGUI();
                frame.setVisible(true);
                frame.setResizable(false);
                finished = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void crearGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        frame.setBounds(100, 100, 1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.getContentPane().setLayout(null);

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

        JLabel lbl_img = new JLabel();
        Image img = new ImageIcon("images/logo_1.png").getImage();
        lbl_img.setIcon(new ImageIcon(img));
        lbl_img.setBounds(717, 83, 150, 150);
        frame.getContentPane().add(lbl_img);

        JLabel lbl_id = new JLabel("ID de Usuario:");
        lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_id.setVerticalAlignment(SwingConstants.TOP);
        lbl_id.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_id.setBounds(667, 254, 250, 40);
        lbl_id.setForeground(colores.amarillo);
        frame.getContentPane().add(lbl_id);

        JLabel lbl_contra = new JLabel("Contraseña: ");
        lbl_contra.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_contra.setVerticalAlignment(SwingConstants.TOP);
        lbl_contra.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_contra.setBounds(667, 374, 250, 40);
        lbl_contra.setForeground(colores.amarillo);
        frame.getContentPane().add(lbl_contra);

        txt_usuario = new JTextField();
        txt_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        txt_usuario.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        txt_usuario.setForeground(colores.amarillo);
        txt_usuario.setBounds(667, 304, 250, 40);
        frame.getContentPane().add(txt_usuario);
        txt_usuario.setColumns(15);

        pwd_password = new JPasswordField();
        pwd_password.setEchoChar('*');
        pwd_password.setHorizontalAlignment(SwingConstants.CENTER);
        pwd_password.setColumns(15);
        pwd_password.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        pwd_password.setBounds(667, 424, 250, 40);
        pwd_password.setForeground(colores.amarillo);
        frame.getContentPane().add(pwd_password);

        btn_login = new JButton("Login");
        btn_login.setVerticalAlignment(SwingConstants.TOP);
        btn_login.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        btn_login.setForeground(colores.amarillo);
        btn_login.setBounds(667, 494, 250, 50);
        frame.getContentPane().add(btn_login);
    }
}
