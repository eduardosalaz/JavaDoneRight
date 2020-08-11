package vistas.admin.prov;

import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmBorProv {
    public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_cve;
    public JButton btn_reg,btn_home;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisAdmBorProv window = new VisAdmBorProv();
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
    public VisAdmBorProv() {
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

        JLabel lbl_productos = new JLabel("Borrar a un proveedor");
        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_productos.setForeground(colores.amarillo);
        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_productos.setBounds(436, 91, 712, 59);
        lbl_productos.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_productos);

        JLabel lbl_cve = new JLabel("ID del Proveedor:");
        lbl_cve.setBackground(colores.oscuro);
        lbl_cve.setForeground(colores.amarillo);
        lbl_cve.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
        lbl_cve.setBounds(632, 200, 319, 60);
        frame.getContentPane().add(lbl_cve);

        txt_cve = new JTextField();
        txt_cve.setForeground(colores.azul);
        txt_cve.setBackground(colores.oscuro);
        txt_cve.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_cve.setBounds(617, 310, 350, 50);
        frame.getContentPane().add(txt_cve);
        txt_cve.setColumns(10);

        btn_reg = new JButton("Buscar Proveedor");
        btn_reg.setForeground(colores.amarillo);
        btn_reg.setBackground(colores.oscuro);
        btn_reg.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_reg.setBounds(522, 410, 540, 74);
        frame.getContentPane().add(btn_reg);

        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
    }

}
