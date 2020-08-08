package vistas.admin.users;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;

public class VistaAdminUsers {

    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public JButton btn_alta, btn_baja,btn_modificar, btn_listar, btn_home;
    public boolean finished = false;

    public void lanzarVista(){
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

        JLabel lbl_usuarios = new JLabel("Usuarios");
        lbl_usuarios.setVerticalAlignment(SwingConstants.TOP);
        lbl_usuarios.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_usuarios.setForeground(colores.amarillo);
        lbl_usuarios.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_usuarios.setBounds(676, 91, 231, 59);
        lbl_usuarios.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_usuarios);

        btn_alta = new JButton("Alta");
        btn_alta.setToolTipText("Registrar un nuevo usuario");
        btn_alta.setVerticalAlignment(SwingConstants.TOP);
        btn_alta.setForeground(colores.amarillo);
        btn_alta.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_alta.setBounds(438, 170, 310, 55);
        btn_alta.setBackground(colores.oscuro);
        frame.getContentPane().add(btn_alta);

        btn_baja = new JButton("Baja");
        btn_baja.setVerticalAlignment(SwingConstants.TOP);
        btn_baja.setToolTipText("Eliminar un usuario");
        btn_baja.setForeground(colores.amarillo);
        btn_baja.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_baja.setBackground(colores.oscuro);
        btn_baja.setBounds(876, 170, 310, 55);
        frame.getContentPane().add(btn_baja);

        btn_modificar = new JButton("Modificar");
        btn_modificar.setVerticalAlignment(SwingConstants.TOP);
        btn_modificar.setToolTipText("Modificar un usuario existente");
        btn_modificar.setForeground(colores.amarillo);
        btn_modificar.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_modificar.setBackground(colores.oscuro);
        btn_modificar.setBounds(438, 269, 310, 55);
        frame.getContentPane().add(btn_modificar);

        btn_listar = new JButton("Listar");
        btn_listar.setVerticalAlignment(SwingConstants.TOP);
        btn_listar.setToolTipText("Mostrar a todos los usuarios");
        btn_listar.setForeground(colores.amarillo);
        btn_listar.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_listar.setBackground(colores.oscuro);
        btn_listar.setBounds(876, 269, 310, 55);
        frame.getContentPane().add(btn_listar);

        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
    }
}
