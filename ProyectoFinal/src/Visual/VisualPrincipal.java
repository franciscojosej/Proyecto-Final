package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VisualPrincipal extends JFrame {

	private JPanel contentPane;
	protected RegistroDeClientes RegCliente;
	private Dimension dm;
private	JMenu mnFacturar = new JMenu("Facturas");
	

	
	  //Launch the application.
	/*
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e5) {
					e5.printStackTrace();
				}
				
			}
		});
	}
*/
	 
	/**
	 * Create the frame.
	 */
	public VisualPrincipal() {
		FileInputStream empresaExistente;//primero veo si exite primer cach
		ObjectInputStream empEntrada;
		
		FileOutputStream empresaNoExiste ;
		ObjectOutputStream crearDatol;
		try {
			 empresaExistente=new FileInputStream("tricom.dat");
			 empEntrada= new ObjectInputStream( empresaExistente);
			 Tricom tem= (Tricom) empEntrada.readObject();
			// tem.init();
			
			 Tricom.setTricom(tem);
			// JOptionPane.showConfirmDialog(null,Tricom.getInstance().getClieod());
			 Tricom.ClienteCod= Tricom.getInstance().getClieod();
			 Tricom.ContratoCod=Tricom.getInstance().getContd();
			 Tricom.FacturacionCod=Tricom.getInstance().getFactuCod();
			 Tricom.PlanesCod=Tricom.getInstance().getPlanCod();
			 Tricom.EmpleadoCod= Tricom.getInstance().getEmpCod();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			try {
				empresaNoExiste=new FileOutputStream("tricom.dat");
				crearDatol= new ObjectOutputStream(empresaNoExiste);
				crearDatol.writeObject(Tricom.getInstance());
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		} 
		
		setBackground(SystemColor.scrollbar);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			
				FileOutputStream tricom;
				ObjectOutputStream empresaWrite;
				try {
					 tricom = new  FileOutputStream("tricom.dat");
					empresaWrite = new ObjectOutputStream(tricom);
					empresaWrite.writeObject(Tricom.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileOutputStream user;
				ObjectOutputStream empresaW;
	
				try {
					user = new  FileOutputStream("empresa.dat");
					empresaW = new ObjectOutputStream(user);
					empresaW.writeObject(Control.getInstance());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		dm= getToolkit().getScreenSize();
		setTitle(" Tricom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(dm.width,dm.height);///
		//setBounds(100, 100, 438, 309);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlHighlight);
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.WHITE);
		panel.setForeground(UIManager.getColor("Button.highlight"));
		panel.setBounds(0, 10, 1360, 719);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(UIManager.getColor("Button.light"));
		menuBar.setBackground(SystemColor.control);
		menuBar.setToolTipText("Empleado");
		menuBar.setBounds(0, 0, 1360, 21);
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
			  //  RegCliente.setLocation(5, 5);
			    RegCliente.setModal(true);
			   RegCliente.setLocationRelativeTo(null );
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
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRegistroDeEmpleado = new JMenuItem("Registro");
		Image image = new ImageIcon(this.getClass().getResource("/RegCliente.png")).getImage();
		mntmRegistroDeEmpleado.setIcon(new ImageIcon(image));
		if(Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Administrativo")){
			mntmRegistroDeEmpleado.setEnabled(false);
		}
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
		mnCrearPlanes.setForeground(Color.BLACK);
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
		mnContrato.setForeground(Color.BLACK);
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
		Image picture = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		
		

		
		mnFacturar.setForeground(Color.BLACK);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnFacturar);
		
		JMenuItem mntmfacturar = new JMenuItem("Facturar");
		Image pict = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		mntmfacturar.setIcon(new ImageIcon(pict));

		mntmfacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturaGenerar factu = new FacturaGenerar();
				factu.setModal(true);
				factu.setLocationRelativeTo(null);
				factu.setVisible(true);
				
			}
		});
		mnFacturar.add(mntmfacturar);
		
		JMenuItem mntmgenerarFactura = new JMenuItem("Generar Factura");
		if(Control.getInstance().getLoginUser().getTipo().equalsIgnoreCase("Administrativo")){
			mntmgenerarFactura.setEnabled(false);
		}
		mntmgenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tricom.getInstance().generaFacturaAutomatico();
			}
		});
		Image pictu = new ImageIcon(this.getClass().getResource("/fact.png")).getImage();
		mntmgenerarFactura.setIcon(new ImageIcon(pictu));
		mnFacturar.add(mntmgenerarFactura);
		Image f = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		
		JMenuItem mntmGenerar = new JMenuItem("Generar");
		mntmGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturaTxt f = new FacturaTxt();
				f.setModal(true);
				f.setVisible(true);
			}
		});
		mnFacturar.add(mntmGenerar);
		
		JMenu mnGraficos = new JMenu("Gr�ficos");
		mnGraficos.setForeground(Color.BLACK);
		menuBar.add(mnGraficos);
		
		JMenuItem mntmMasUsado = new JMenuItem("Mas Usado");
		mntmMasUsado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraCircular v1 = new GraCircular();
				
				v1.setVisible(true);
				
			}
		});
		mnGraficos.add(mntmMasUsado);
		
		JMenuItem mntmFacMes = new JMenuItem("Facturas por Mes");
		mntmFacMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacturasPorMes v2 = new FacturasPorMes();
				
				v2.setVisible(true);
				
			}
		});
		mnGraficos.add(mntmFacMes);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image i = new ImageIcon(this.getClass().getResource("/tri.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(i));
		lblNewLabel.setBounds(0, 10, 1360, 719);
		panel.add(lblNewLabel);
		//JLabel lblNewLabel = new JLabel("");
		//Image ima = new ImageIcon(this.getClass().getResource("/Tele.jpg")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(ima));
		//lblNewLabel.setBounds(0, -11, 1045, 553);//(0, 21, 1045, 549);
		//panel.add(lblNewLabel);
	}
}
