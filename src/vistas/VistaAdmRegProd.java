package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import crearColores.CustomColors;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class VistaAdmRegProd {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id, txt_contra;
    public JCheckBox chck_admin;
    public JButton btn_crear, btn_home;
    private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdmRegProd window = new VistaAdmRegProd();
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
	public VistaAdmRegProd() {
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

	        JLabel lbl_productos = new JLabel("Registrar un nuevo producto");
	        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
	        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl_productos.setForeground(colores.amarillo);
	        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
	        lbl_productos.setBounds(436, 91, 712, 59);
	        lbl_productos.setBackground(colores.oscuro);
	        frame.getContentPane().add(lbl_productos);
	        
	        JLabel lbl_id = new JLabel("Clave del producto:");
	        lbl_id.setBackground(colores.oscuro);
	        lbl_id.setForeground(colores.amarillo);
	        lbl_id.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_id.setBounds(10, 200, 350, 60);
	        frame.getContentPane().add(lbl_id);

	        JLabel lbl_contra = new JLabel("Nombre:");
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

	        JLabel lbl_nombre = new JLabel("Existencias:");
	        lbl_nombre.setForeground(colores.amarillo);
	        lbl_nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_nombre.setBackground(colores.oscuro);
	        lbl_nombre.setBounds(864, 200, 350, 60);
	        frame.getContentPane().add(lbl_nombre);

	        JLabel lbl_tel = new JLabel("Categoría");
	        lbl_tel.setForeground(colores.amarillo);
	        lbl_tel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_tel.setBackground(colores.oscuro);
	        lbl_tel.setBounds(864, 370, 350, 60);
	        frame.getContentPane().add(lbl_tel);
	        
	        btn_crear = new JButton("Registrar Producto");
	        btn_crear.setForeground(colores.amarillo);
	        btn_crear.setBackground(colores.oscuro);
	        btn_crear.setFont(new Font("Bahnschrift", Font.BOLD, 50));
	        btn_crear.setBounds(532, 635, 519, 74);
	        frame.getContentPane().add(btn_crear);

	        btn_home = new JButton();
	        btn_home.setBackground(colores.oscuro);
	        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
	        btn_home.setBounds(10, 700, 150, 150);
	        Border bord = BorderFactory.createLineBorder(colores.amarillo);
	        btn_home.setBorder(bord);
	        frame.getContentPane().add(btn_home);
	        
	        JLabel lbl_tel_1 = new JLabel("ID del proveedor:");
	        lbl_tel_1.setForeground(new Color(253, 163, 17));
	        lbl_tel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_tel_1.setBackground(new Color(60, 63, 65));
	        lbl_tel_1.setBounds(864, 540, 350, 60);
	        frame.getContentPane().add(lbl_tel_1);
	        
	        JLabel lbl_tel_1_1 = new JLabel("Precio: ");
	        lbl_tel_1_1.setForeground(new Color(253, 163, 17));
	        lbl_tel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_tel_1_1.setBackground(new Color(60, 63, 65));
	        lbl_tel_1_1.setBounds(10, 540, 350, 60);
	        frame.getContentPane().add(lbl_tel_1_1);
	        
	        JSpinner spinner = new JSpinner();
	        spinner.setFont(new Font("Carlito", Font.PLAIN, 35));
	        spinner.setBounds(1224, 200, 350, 50);
	        frame.getContentPane().add(spinner);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setFont(new Font("Carlito", Font.PLAIN, 35));
	        comboBox.setBounds(1224, 370, 350, 50);
	        frame.getContentPane().add(comboBox);
	        
	        textField = new JTextField();
	        textField.setForeground(new Color(20, 33, 61));
	        textField.setFont(new Font("Carlito", Font.PLAIN, 35));
	        textField.setColumns(10);
	        textField.setBackground(new Color(60, 63, 65));
	        textField.setBounds(370, 540, 350, 50);
	        frame.getContentPane().add(textField);
	        
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setFont(new Font("Carlito", Font.PLAIN, 35));
	        comboBox_1.setBounds(1224, 540, 350, 50);
	        frame.getContentPane().add(comboBox_1);
	}
}
