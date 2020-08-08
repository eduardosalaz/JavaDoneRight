package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import crearColores.CustomColors;

public class VistaAdmModProd {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_modificar, btn_home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdmModProd window = new VistaAdmModProd();
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
	public VistaAdmModProd() {
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

        JLabel lbl_modificar = new JLabel("Modificar a un producto");
        lbl_modificar.setVerticalAlignment(SwingConstants.TOP);
        lbl_modificar.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_modificar.setForeground(colores.amarillo);
        lbl_modificar.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_modificar.setBounds(436, 91, 712, 59);
        lbl_modificar.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_modificar);
        
        JLabel lbl_id = new JLabel("Inserte la clave del producto a modificar");
        lbl_id.setVerticalAlignment(SwingConstants.TOP);
        lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_id.setForeground(new Color(253, 163, 17));
        lbl_id.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        lbl_id.setBackground(new Color(60, 63, 65));
        lbl_id.setBounds(399, 230, 785, 59);
        frame.getContentPane().add(lbl_id);
        
        txt_id = new JTextField();
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setForeground(colores.azul);
        txt_id.setBackground(colores.oscuro);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 300, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);
        
        btn_modificar = new JButton("Modificar Producto");
        btn_modificar.setForeground(colores.amarillo);
        btn_modificar.setBackground(colores.oscuro);
        btn_modificar.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_modificar.setBounds(550, 635, 483, 74);
        frame.getContentPane().add(btn_modificar);
        
        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
	}

}
