package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VisualPrincipal extends JFrame {

	private JPanel contentPane;
	protected RegistroDeClientes RegCliente;

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
		
		JMenu mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistro = new JMenuItem("\u2022Registro");
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente Clien = null;
				 RegistroDeClientes RegCliente 	= null;
			    RegCliente = new RegistroDeClientes (Clien);	
			    RegCliente.setModal(true);
			    RegCliente.setLocationRelativeTo(null);
			    RegCliente.setVisible(true);
			    
			
			}
		});
		
		mnNewMenu.add(mntmRegistro);
		
		JMenuItem mntmListadoDeCliente = new JMenuItem("\u2022Listado De Clientes");
		mntmListadoDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente ListCliente = new ListarCliente();
				ListCliente.setModal(true);
				ListCliente.setLocationRelativeTo(null);
				ListCliente.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmListadoDeCliente);
		
		
		JMenu mnNewMenu_1 = new JMenu("Empleados");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRegistroDeEmpleado = new JMenuItem("\u2022Registro");
		mntmRegistroDeEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeEmpleado RegEmpleado = new RegistroDeEmpleado();
				RegEmpleado.setModal(true);
				RegEmpleado.setLocationRelativeTo(null);
				RegEmpleado.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmRegistroDeEmpleado);
		
		JMenuItem mntmListarEmpleados = new JMenuItem("\u2022Listado de Empleados");
		mntmListarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListarEmpleados ListEmpleado = new ListarEmpleados();
				ListEmpleado.setModal(true);
				ListEmpleado.setLocationRelativeTo(null);
				ListEmpleado.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmListarEmpleados);
		
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
