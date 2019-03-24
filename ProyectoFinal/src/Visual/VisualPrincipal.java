package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VisualPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualPrincipal frame = new VisualPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualPrincipal() {
		setTitle("Tricom RD...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 10, 434, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Empleado");
		menuBar.setBounds(0, 0, 434, 21);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Empleado");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u2022Registro");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmListadoDeEmpleados = new JMenuItem("\u2022Listado De Empleados");
		mnNewMenu.add(mntmListadoDeEmpleados);
		
		JMenu mnNewMenu_1 = new JMenu("Cliente");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u2022Registro");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmlistadoDeClientes = new JMenuItem("\u2022Listado de Clientes");
		mnNewMenu_1.add(mntmlistadoDeClientes);
		
		JMenu mnNewMenu_2 = new JMenu("Planes");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u2022Crear Plan");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmlistaDePlanes = new JMenuItem("\u2022Lista De Planes");
		mnNewMenu_2.add(mntmlistaDePlanes);
		
		JMenu mnNewMenu_3 = new JMenu("Contrato");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u2022Realizar Contrato");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("Facturas");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmfacturar = new JMenuItem("\u2022Facturar");
		mnNewMenu_4.add(mntmfacturar);
		
		JMenuItem mntmgenerarFactura = new JMenuItem("\u2022Generar Factura");
		mnNewMenu_4.add(mntmgenerarFactura);
	}
}
