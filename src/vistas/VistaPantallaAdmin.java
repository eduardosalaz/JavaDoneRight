package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;
import java.awt.Color;
import javax.swing.JButton;

public class VistaPantallaAdmin {
	public CustomColors colores = new CustomColors();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPantallaAdmin window = new VistaPantallaAdmin();
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
	public VistaPantallaAdmin() {
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

		JLabel lblNewLabel = new JLabel("Mon 3, Aug 2020 13:13:45 -0500");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(1288, 800, 286, 50);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_admin = new JLabel("Menú de Administrador");
		lbl_admin.setVerticalAlignment(SwingConstants.TOP);
		lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_admin.setForeground(new Color(253, 163, 17));
		lbl_admin.setFont(new Font("Bahnschrift", Font.BOLD, 48));
		lbl_admin.setBounds(519, 91, 545, 59);
		frame.getContentPane().add(lbl_admin);

		JButton btn_usuarios = new JButton("Usuarios");
		btn_usuarios.setVerticalAlignment(SwingConstants.TOP);
		btn_usuarios.setForeground(colores.amarillo);
		btn_usuarios.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
		btn_usuarios.setBounds(438, 170, 310, 55);
		frame.getContentPane().add(btn_usuarios);

		JButton btn_prod = new JButton("Productos");
		btn_prod.setVerticalAlignment(SwingConstants.TOP);
		btn_prod.setForeground(colores.amarillo);
		btn_prod.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
		btn_prod.setBounds(838, 170, 310, 55);
		frame.getContentPane().add(btn_prod);

		JButton btn_prov = new JButton("Proveedores");
		btn_prov.setVerticalAlignment(SwingConstants.TOP);
		btn_prov.setForeground(colores.amarillo);
		btn_prov.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
		btn_prov.setBounds(438, 331, 310, 55);
		frame.getContentPane().add(btn_prov);

		JButton btn_rep = new JButton("Reportes");
		btn_rep.setVerticalAlignment(SwingConstants.TOP);
		btn_rep.setForeground(colores.amarillo);
		btn_rep.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
		btn_rep.setBounds(838, 331, 310, 55);
		frame.getContentPane().add(btn_rep);
	}
}
