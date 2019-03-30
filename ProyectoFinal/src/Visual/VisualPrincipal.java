package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Control;
import logico.Factura;
import logico.Tricom;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VisualPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected RegistroDeClientes RegCliente;

	
	  //Launch the application.
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa3;
				ObjectOutputStream empresaWrite2;
				try {
					empresa3 = new  FileOutputStream("miTricom.dat");
					empresaWrite2 = new ObjectOutputStream(empresa3);
					empresaWrite2.writeObject(Tricom.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Control.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setTitle("Telefonia e Internet Tricom RD...");
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
		
		JMenu mnCrearPlanes = new JMenu("Planes");
		menuBar.add(mnCrearPlanes);
		
		JMenuItem mntmCrearPlanes = new JMenuItem("\u2022Crear Plan");
		mntmCrearPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPlanes CrePlanes = new CrearPlanes();
				CrePlanes.setModal(true);
				CrePlanes.setLocationRelativeTo(null);
				CrePlanes.setVisible(true);
			}
				
		});
		mnCrearPlanes.add(mntmCrearPlanes);
		
		JMenuItem mntmlistaDePlanes = new JMenuItem("\u2022Lista De Planes");
		mntmlistaDePlanes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ListarPlanes ListPlanes = new ListarPlanes(null);
				ListPlanes.setModal(true);
				ListPlanes.setLocationRelativeTo(null);
				ListPlanes.setVisible(true);
				
				
			}
		});
		mnCrearPlanes.add(mntmlistaDePlanes);
		
		JMenu mnContrato = new JMenu("Contrato");
		menuBar.add(mnContrato);
		
		JMenuItem mntmContrato = new JMenuItem("\u2022Realizar Contrato");
		mntmContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContratoVisual contratar = new ContratoVisual();
				
				contratar.setModal(true);
				contratar.setLocationRelativeTo(null);
				contratar.setVisible(true);
				
			}
		});
		mnContrato.add(mntmContrato);
		
		JMenu mnFacturar = new JMenu("Facturas");
		menuBar.add(mnFacturar);
		
		JMenuItem mntmfacturar = new JMenuItem("\u2022Facturar");
		mntmfacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturacionVisual factu = new FacturacionVisual();
				factu.setModal(true);
				factu.setLocationRelativeTo(null);
				factu.setVisible(true);
				
			}
		});
		mnFacturar.add(mntmfacturar);
		
		JMenuItem mntmgenerarFactura = new JMenuItem("\u2022Generar Factura");
		mnFacturar.add(mntmgenerarFactura);
	}
}
