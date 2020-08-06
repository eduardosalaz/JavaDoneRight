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

import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;
import javax.swing.JTable;

public class VistaAdmListUser {

	public JFrame frame;
    private final CustomColors colores = new CustomColors();
    public boolean finished = false;
    public JButton btn_home;
    private JTable table;

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

        JLabel lbl_lista = new JLabel("Lista de todos los usuarios:");
        lbl_lista.setVerticalAlignment(SwingConstants.TOP);
        lbl_lista.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_lista.setForeground(colores.amarillo);
        lbl_lista.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_lista.setBounds(436, 91, 712, 59);
        lbl_lista.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_lista);
        
        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);
        
        table = new JTable();
        table.setBounds(254, 146, 1076, 664);
        frame.getContentPane().add(table);
	}
}
