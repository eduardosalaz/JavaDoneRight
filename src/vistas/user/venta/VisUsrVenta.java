package vistas.user.venta;

import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import com.bulenkov.darcula.DarculaLaf;
import crearColores.CustomColors;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VisUsrVenta {
    public CustomColors colores = new CustomColors();
    public JFrame frame;
    public boolean finished = false;
    public JButton btn_home, btn_cancelar, btn_eliminar, btn_pagar, btn_agregar;
    public JTable table;
    public JComboBox<Object> cmb_id;
    public JTextField txt_cantidad;
    public JLabel lbl_producto;

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
        lbl_titulo.setBackground(colores.oscuro);
        lbl_titulo.setBounds(560, 12, 463, 59);
        frame.getContentPane().add(lbl_titulo);

        //Placeholder para el reloj
        JLabel lbl_reloj = new JLabel("Mon 3, Aug 2020 13:13:45 -0500");
        lbl_reloj.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_reloj.setBounds(1288, 800, 286, 50);
        frame.getContentPane().add(lbl_reloj);

        JLabel lbl_venta = new JLabel("Nueva Venta");
        lbl_venta.setVerticalAlignment(SwingConstants.TOP);
        lbl_venta.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_venta.setForeground(colores.amarillo);
        lbl_venta.setBackground(colores.oscuro);
        lbl_venta.setFont(new Font("Bahnschrift", Font.BOLD, 48));
        lbl_venta.setBounds(518, 71, 545, 59);
        frame.getContentPane().add(lbl_venta);

        btn_home = new JButton();
        btn_home.setBackground(colores.oscuro);
        btn_home.setIcon(new ImageIcon("images/home_icon.png"));
        btn_home.setBounds(10, 700, 150, 150);
        Border bord = BorderFactory.createLineBorder(colores.amarillo);
        btn_home.setBorder(bord);
        frame.getContentPane().add(btn_home);

        String[] nombreCol = {"ID", "Nombre", "Precio", "Cantidad", "Total"};
        DefaultTableModel dtm= new DefaultTableModel()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        dtm.setColumnIdentifiers(nombreCol);
        table = new JTable(dtm);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setBackground(colores.oscuro);
        table.setForeground(colores.amarillo);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(392, 130, 800, 500);
        scroll.setBackground(colores.oscuro);
        scroll.setForeground(colores.amarillo);
                frame.getContentPane().add(scroll);

        btn_cancelar = new JButton("Cancelar Venta");
        btn_cancelar.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        btn_cancelar.setBounds(96, 130, 286, 59);
        btn_cancelar.setBackground(colores.oscuro);
        btn_cancelar.setForeground(colores.amarillo);
        frame.getContentPane().add(btn_cancelar);

        btn_eliminar = new JButton("Eliminar Producto");
        btn_eliminar.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        btn_eliminar.setBounds(96, 571, 286, 59);
        btn_eliminar.setForeground(colores.amarillo);
        btn_eliminar.setBackground(colores.oscuro);
        frame.getContentPane().add(btn_eliminar);

        btn_pagar = new JButton("Pagar");
        btn_pagar.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        btn_pagar.setBounds(1202, 127, 286, 59);
        btn_pagar.setForeground(colores.amarillo);
        btn_pagar.setBackground(colores.oscuro);
        frame.getContentPane().add(btn_pagar);

        btn_agregar = new JButton("Agregar Producto");
        btn_agregar.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        btn_agregar.setBounds(1202, 571, 286, 59);
        btn_agregar.setBackground(colores.oscuro);
        btn_agregar.setForeground(colores.amarillo);
        frame.getContentPane().add(btn_agregar);

        cmb_id = new JComboBox<Object>();
        cmb_id.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        cmb_id.setBounds(571, 641, 88, 42);
        cmb_id.setForeground(colores.amarillo);
        cmb_id.setBackground(colores.oscuro);
        frame.getContentPane().add(cmb_id);

        JLabel lbl_id = new JLabel("ID de Producto:");
        lbl_id.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        lbl_id.setBounds(392, 641, 228, 42);
        lbl_id.setForeground(colores.amarillo);
        lbl_id.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_id);

        JLabel lbl_cantidad = new JLabel("Cantidad:");
        lbl_cantidad.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        lbl_cantidad.setBounds(991, 641, 137, 42);
        lbl_cantidad.setBackground(colores.oscuro);
        lbl_cantidad.setForeground(colores.amarillo);
        frame.getContentPane().add(lbl_cantidad);

        txt_cantidad = new JTextField(4);
        txt_cantidad.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
        txt_cantidad.setBounds(1093, 641, 99, 42);
        frame.getContentPane().add(txt_cantidad);
        txt_cantidad.setBackground(colores.oscuro);
        txt_cantidad.setForeground(colores.amarillo);
        txt_cantidad.setColumns(10);

        lbl_producto = new JLabel("Mantecadas Bimbo 125g");
        lbl_producto.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_producto.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        lbl_producto.setBounds(674, 640, 307, 42);
        lbl_producto.setForeground(colores.amarillo);
        lbl_producto.setBackground(colores.oscuro);
        frame.getContentPane().add(lbl_producto);
    }
}
