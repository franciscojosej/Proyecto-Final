package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.Font;

public class VisualPrincipal extends JFrame {

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
		setBounds(100, 100, 438, 309);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 10, 434, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setToolTipText("Empleado");
		menuBar.setBounds(0, 0, 410, 21);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cliente");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro");
		Image imag = new ImageIcon(this.getClass().getResource("/RegCliente.png")).getImage();
		mntmRegistro.setIcon(new ImageIcon(imag));
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
		
		JMenuItem mntmListadoDeCliente = new JMenuItem("Listado De Clientes");
		Image img = new ImageIcon(this.getClass().getResource("/ListCliente.png")).getImage();
		mntmListadoDeCliente.setIcon(new ImageIcon(img));
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
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRegistroDeEmpleado = new JMenuItem("Registro");
		Image image = new ImageIcon(this.getClass().getResource("/RegCliente.png")).getImage();
		mntmRegistroDeEmpleado.setIcon(new ImageIcon(image));
		mntmRegistroDeEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroDeEmpleado RegEmpleado = new RegistroDeEmpleado();
				RegEmpleado.setModal(true);
				RegEmpleado.setLocationRelativeTo(null);
				RegEmpleado.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmRegistroDeEmpleado);
		
		JMenuItem mntmListarEmpleados = new JMenuItem("Listado de Empleados");
		Image im = new ImageIcon(this.getClass().getResource("/ListCliente.png")).getImage();
		mntmListarEmpleados.setIcon(new ImageIcon(im));
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
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnCrearPlanes);
		
		JMenuItem mntmCrearPlanes = new JMenuItem("Crear Plan");
		Image fot = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		mntmCrearPlanes.setIcon(new ImageIcon(fot));
		mntmCrearPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPlanes CrePlanes = new CrearPlanes();
				CrePlanes.setModal(true);
				CrePlanes.setLocationRelativeTo(null);
				CrePlanes.setVisible(true);
			}
				
		});
		mnCrearPlanes.add(mntmCrearPlanes);
		
		JMenuItem mntmlistaDePlanes = new JMenuItem("Lista De Planes");
		Image foto = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		mntmlistaDePlanes.setIcon(new ImageIcon(foto));
		mntmlistaDePlanes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ListarPlanes ListPlanes = new ListarPlanes();
				ListPlanes.setModal(true);
				ListPlanes.setLocationRelativeTo(null);
				ListPlanes.setVisible(true);
				
				
			}
		});
		mnCrearPlanes.add(mntmlistaDePlanes);
		
		JMenu mnContrato = new JMenu("Contrato");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnContrato);
		
		JMenuItem mntmContrato = new JMenuItem("Realizar Contrato");
		Image pic = new ImageIcon(this.getClass().getResource("/contrato.png")).getImage();
		mntmContrato.setIcon(new ImageIcon(pic));
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
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnFacturar);
		
		JMenuItem mntmfacturar = new JMenuItem("Facturar");
		Image pict = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		mntmfacturar.setIcon(new ImageIcon(pict));
		mntmfacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturacionVisual factu = new FacturacionVisual();
				factu.setModal(true);
				factu.setLocationRelativeTo(null);
				factu.setVisible(true);
				
			}
		});
		mnFacturar.add(mntmfacturar);
		
		JMenuItem mntmgenerarFactura = new JMenuItem("Generar Factura");
		Image pictu = new ImageIcon(this.getClass().getResource("/fact.png")).getImage();
		mntmgenerarFactura.setIcon(new ImageIcon(pictu));
		mnFacturar.add(mntmgenerarFactura);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image ima = new ImageIcon(this.getClass().getResource("/comu.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(ima));
		lblNewLabel.setBounds(0, 45, 400, 206);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a Tricom Dominicana");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 32, 242, 14);
		panel.add(lblNewLabel_1);
	}
}
