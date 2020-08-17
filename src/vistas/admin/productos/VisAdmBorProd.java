package vistas.admin.productos;

import com.formdev.flatlaf.FlatDarkLaf;
import crearColores.CustomColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisAdmBorProd {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_borrar, btn_home;

    public void lanzarVista(){
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try{
                    UIManager.setLookAndFeel(new FlatDarkLaf());
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

        Image ico = new ImageIcon("images/carro.png").getImage();
        frame.setIconImage(ico);
        frame.setTitle("TITULO ACÁ");

        Border border = BorderFactory.createEmptyBorder();

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

        JLabel lbl_borProd = new JLabel("Borrar un producto");
        lbl_borProd.setVerticalAlignment(SwingConstants.TOP);
        lbl_borProd.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_borProd.setForeground(colores.amarillo);
        lbl_borProd.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_borProd.setBounds(436, 91, 712, 59);
        frame.getContentPane().add(lbl_borProd);
        
        JLabel lbl_clave = new JLabel("Inserte la clave del producto a borrar");
        lbl_clave.setVerticalAlignment(SwingConstants.TOP);
        lbl_clave.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_clave.setForeground(colores.amarillo);
        lbl_clave.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        lbl_clave.setBounds(436, 230, 712, 59);
        frame.getContentPane().add(lbl_clave);
        
        txt_id = new JTextField();
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setForeground(colores.azul);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 300, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);
        
        btn_borrar = new JButton("Borrar Producto");
        btn_borrar.setForeground(colores.amarillo);
        btn_borrar.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_borrar.setBounds(558, 635, 468, 74);
        btn_borrar.setBorder(border);
        frame.getContentPane().add(btn_borrar);
        
        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        btn_home.setBorder(border);
        frame.getContentPane().add(btn_home);
	}

}
