package vistas.admin.productos;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.Border;

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;

public class VistaAdminProductos {
    private final CustomColors colores = new CustomColors();
    public JButton btn_registrar, btn_borrar,btn_modificar, btn_listar, btn_home;
    public JFrame frame;
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

        JLabel lbl_productos = new JLabel("Productos");
        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_productos.setForeground(colores.amarillo);
        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_productos.setBounds(673, 91, 238, 59);
        lbl_productos.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_productos);

        btn_registrar = new JButton("Registrar");
        btn_registrar.setToolTipText("Registrar un nuevo producto");
        btn_registrar.setVerticalAlignment(SwingConstants.TOP);
        btn_registrar.setForeground(colores.amarillo);
        btn_registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_registrar.setBounds(438, 170, 310, 55);
        btn_registrar.setBackground(colores.oscuro);
        frame.getContentPane().add(btn_registrar);

        btn_borrar = new JButton("Borrar");
        btn_borrar.setVerticalAlignment(SwingConstants.TOP);
        btn_borrar.setToolTipText("Eliminar un producto");
        btn_borrar.setForeground(colores.amarillo);
        btn_borrar.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_borrar.setBackground(colores.oscuro);
        btn_borrar.setBounds(876, 170, 310, 55);
        frame.getContentPane().add(btn_borrar);

        btn_modificar = new JButton("Modificar");
        btn_modificar.setVerticalAlignment(SwingConstants.TOP);
        btn_modificar.setToolTipText("Modificar un producto existente");
        btn_modificar.setForeground(colores.amarillo);
        btn_modificar.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
        btn_modificar.setBackground(colores.oscuro);
        btn_modificar.setBounds(438, 269, 310, 55);
        frame.getContentPane().add(btn_modificar);

        btn_listar = new JButton("Listar");
        btn_listar.setVerticalAlignment(SwingConstants.TOP);
        btn_listar.setToolTipText("Mostrar todos los productos");
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
