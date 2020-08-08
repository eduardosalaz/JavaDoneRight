package vistas.admin.users;

import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;
import java.awt.Color;
import javax.swing.JButton;

public class VisAdmBajaUser {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JTextField txt_id;
    public JButton btn_borrar, btn_home;

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

        JLabel lbl_baja = new JLabel("Dar de baja a un usuario");
        lbl_baja.setVerticalAlignment(SwingConstants.TOP);
        lbl_baja.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_baja.setForeground(colores.amarillo);
        lbl_baja.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_baja.setBounds(436, 91, 712, 59);
        lbl_baja.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_baja);
        
        JLabel lbl_id = new JLabel("Inserte el ID del usuario a eliminar");
        lbl_id.setVerticalAlignment(SwingConstants.TOP);
        lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_id.setForeground(new Color(253, 163, 17));
        lbl_id.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        lbl_id.setBackground(new Color(60, 63, 65));
        lbl_id.setBounds(436, 230, 712, 59);
        frame.getContentPane().add(lbl_id);
        
        txt_id = new JTextField();
        txt_id.setHorizontalAlignment(SwingConstants.CENTER);
        txt_id.setForeground(colores.azul);
        txt_id.setBackground(colores.oscuro);
        txt_id.setFont(new Font("Carlito", Font.PLAIN, 35));
        txt_id.setBounds(617, 300, 350, 50);
        frame.getContentPane().add(txt_id);
        txt_id.setColumns(10);
        
        btn_borrar = new JButton("Borrar Usuario");
        btn_borrar.setForeground(colores.amarillo);
        btn_borrar.setBackground(colores.oscuro);
        btn_borrar.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        btn_borrar.setBounds(584, 635, 416, 74);
        frame.getContentPane().add(btn_borrar);
        
        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
	}
}