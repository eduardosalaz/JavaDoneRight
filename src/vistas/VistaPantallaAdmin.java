package vistas;

import com.bulenkov.darcula.DarculaLaf;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VistaPantallaAdmin {

	private JFrame frame;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			System.out.println(info.getName());
			if ("Nimbus".equals(info.getName())) {
				try{
					javax.swing.UIManager.setLookAndFeel(new DarculaLaf());
				}catch (Exception e){
					e.printStackTrace();
				}
				break;
			}
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
