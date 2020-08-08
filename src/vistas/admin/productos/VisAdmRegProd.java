package vistas.admin.productos;

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmRegProd {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_cve, txt_nom, txt_prec;
    public JButton btn_reg, btn_home;
    public JSpinner spn_inv;
    public JComboBox cmb_cat, cmb_prov;

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

	        JLabel lbl_productos = new JLabel("Registrar un nuevo producto");
	        lbl_productos.setVerticalAlignment(SwingConstants.TOP);
	        lbl_productos.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl_productos.setForeground(colores.amarillo);
	        lbl_productos.setFont(new Font("Bahnschrift", Font.BOLD, 48));
	        lbl_productos.setBounds(436, 91, 712, 59);
	        lbl_productos.setBackground(colores.oscuro);
	        frame.getContentPane().add(lbl_productos);
	        
	        JLabel lbl_cve = new JLabel("Clave del producto:");
	        lbl_cve.setBackground(colores.oscuro);
	        lbl_cve.setForeground(colores.amarillo);
	        lbl_cve.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_cve.setBounds(10, 200, 350, 60);
	        frame.getContentPane().add(lbl_cve);

	        JLabel lbl_nom = new JLabel("Nombre:");
	        lbl_nom.setForeground(colores.amarillo);
	        lbl_nom.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_nom.setBackground(colores.oscuro);
	        lbl_nom.setBounds(10, 370, 350, 60);
	        frame.getContentPane().add(lbl_nom);

	        txt_cve = new JTextField();
	        txt_cve.setForeground(colores.azul);
	        txt_cve.setBackground(colores.oscuro);
	        txt_cve.setFont(new Font("Carlito", Font.PLAIN, 35));
	        txt_cve.setBounds(370, 200, 350, 50);
	        frame.getContentPane().add(txt_cve);
	        txt_cve.setColumns(10);

	        txt_nom = new JTextField();
	        txt_nom.setForeground(colores.azul);
	        txt_nom.setBackground(colores.oscuro);
	        txt_nom.setFont(new Font("Carlito", Font.PLAIN, 35));
	        txt_nom.setColumns(10);
	        txt_nom.setBounds(370, 370, 350, 50);
	        frame.getContentPane().add(txt_nom);

	        JLabel lbl_inv = new JLabel("Existencias:");
	        lbl_inv.setForeground(colores.amarillo);
	        lbl_inv.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_inv.setBackground(colores.oscuro);
	        lbl_inv.setBounds(864, 200, 350, 60);
	        frame.getContentPane().add(lbl_inv);

	        JLabel lbl_cat = new JLabel("Categoría");
	        lbl_cat.setForeground(colores.amarillo);
	        lbl_cat.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_cat.setBackground(colores.oscuro);
	        lbl_cat.setBounds(864, 370, 350, 60);
	        frame.getContentPane().add(lbl_cat);
	        
	        btn_reg = new JButton("Registrar Producto");
	        btn_reg.setForeground(colores.amarillo);
	        btn_reg.setBackground(colores.oscuro);
	        btn_reg.setFont(new Font("Bahnschrift", Font.BOLD, 50));
	        btn_reg.setBounds(532, 635, 519, 74);
	        frame.getContentPane().add(btn_reg);

	        btn_home = new JButton();
	        btn_home.setBackground(colores.oscuro);
	        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
	        btn_home.setBounds(10, 700, 150, 150);
	        Border bord = BorderFactory.createLineBorder(colores.amarillo);
	        btn_home.setBorder(bord);
	        frame.getContentPane().add(btn_home);
	        
	        JLabel lbl_prov = new JLabel("Proveedor:");
	        lbl_prov.setForeground(colores.amarillo);
	        lbl_prov.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_prov.setBackground(colores.oscuro);
	        lbl_prov.setBounds(864, 540, 350, 60);
	        frame.getContentPane().add(lbl_prov);
	        
	        JLabel lbl_prec = new JLabel("Precio: ");
	        lbl_prec.setForeground(colores.amarillo);
	        lbl_prec.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
	        lbl_prec.setBackground(colores.oscuro);
	        lbl_prec.setBounds(10, 540, 350, 60);
	        frame.getContentPane().add(lbl_prec);
	        
	        spn_inv = new JSpinner();
	        spn_inv.setFont(new Font("Carlito", Font.PLAIN, 35));
	        spn_inv.setBounds(1224, 200, 350, 50);
			spn_inv.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
	        frame.getContentPane().add(spn_inv);
	        
	        cmb_cat = new JComboBox<Object>();
	        cmb_cat.setFont(new Font("Carlito", Font.PLAIN, 35));
	        cmb_cat.setBounds(1224, 370, 350, 50);
	        frame.getContentPane().add(cmb_cat);
	        
	        txt_prec = new JTextField();
	        txt_prec.setForeground(colores.azul);
	        txt_prec.setFont(new Font("Carlito", Font.PLAIN, 35));
	        txt_prec.setColumns(10);
	        txt_prec.setBackground(new Color(60, 63, 65));
	        txt_prec.setBounds(370, 540, 350, 50);
	        frame.getContentPane().add(txt_prec);
	        
	        cmb_prov = new JComboBox<Object>();
	        cmb_prov.setFont(new Font("Carlito", Font.PLAIN, 35));
	        cmb_prov.setBounds(1224, 540, 350, 50);
	        frame.getContentPane().add(cmb_prov);
	}
}
