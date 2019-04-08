package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import logico.CableTV;
import logico.Celular;
import logico.Cliente;
import logico.Contrato;
import logico.Factura;
import logico.Internet;
import logico.Plan;
import logico.Tricom;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.awt.event.MouseWheelEvent;
import com.toedter.calendar.JDateChooser;

public class FacturaGenerar extends JDialog {

	private static final String Contra = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField texCedulaCleinte=new JTextField();;
	private JTextField textNombre;
	private Cliente cliente;
	private Contrato nuevoContrato;
	private ArrayList<Plan> nuevoPlan=null;
	private JLabel  lblTotalApagat = new JLabel("0.0");
	private  Object[][] datofila=llenararregloCarrito();	
	private  Object[][] datofilaCa=llenararregloFactura();	
	private JDateChooser dateChooser = new JDateChooser();
	
	private static String columnNombre[] = {"Nombre","Servicio","x"};
	private static String columnNombreFacturas[] = {"Nombre","Servicio","x","y"};
	
	final Class[] columnClass = new Class[] {
		    Integer.class, String.class, Double.class, Boolean.class
		};
	//create table model with data
	DefaultTableModel model = new DefaultTableModel(datofila,  columnNombre) {
	    @Override
	    public boolean isCellEditable(int row, int column)
	    {
	        return false;
	    }
	    @Override
	    public Class<?> getColumnClass(int columnIndex)
	    {
	        return columnClass[columnIndex];
	    }
	    
	};
	DefaultTableModel model2 = new DefaultTableModel(datofilaCa,  columnNombreFacturas) {
	    @Override
	    public boolean isCellEditable(int row, int column)
	    {
	        return false;
	    }
	    @Override
	    public Class<?> getColumnClass(int columnIndex)
	    {
	        return columnClass[columnIndex];
	    }
	    
	};
	
	private JTable t= new  JTable(model);//llenararreglo(),columnNombre
	
	private JScrollPane scrollPane = new JScrollPane(t);
	
	private JTable t2= new  JTable(model2);//llenararreglo(),columnNombre
	
	private JScrollPane scrollPaneCarrito = new JScrollPane(t2);
	//private Runnable label =new  PrecioL(lblTotalApagat, t);//:)
	
	PrecioL tarea = new PrecioL(lblTotalApagat, t);
    Timer temporizador = new Timer();
    Integer segundos = 1;
    private  JLabel labelFechaInicio = new JLabel("");
   
	

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturaGenerar dialog = new FacturaGenerar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public FacturaGenerar() {
		
	//	hilo.start();
			
		
			try {
				 temporizador.scheduleAtFixedRate(tarea, 0, 1000*segundos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

	//	t.setDefaultRenderer(Object.class, new MiRender());

		//int  m=(int) datofila[t.getSelectedColumn()][0];
			setResizable(false);
			setBounds(5, 59, 612, 548);
		//setBounds(100, 100, 612, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
		//	t.setSelectionBackground(getBackground());
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.addMouseListener(new MouseAdapter() {

			});
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Factura Tricom RD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo de Factura");
				lblNewLabel.setBounds(10, 28, 138, 14);
				panel.add(lblNewLabel);
			}
			
			{
				
				

				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 56, 50, 20);
				if(Contra == null) {
					
					 txtCodigo.setText("C-" + (Tricom.FacturacionCod+1));
				}
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Información del Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(22, 80, 541, 141);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel Cedula = new JLabel("Cedula:");
					Cedula.setBounds(10, 22, 181, 14);
					panel_1.add(Cedula);
				}
				{
					
					texCedulaCleinte.setBounds(10, 47, 171, 20);
					panel_1.add(texCedulaCleinte);
					texCedulaCleinte.setColumns(10);
				}
				
				JButton btnNewButton = new JButton(" Buscar Cliente");
				Image ima = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
				btnNewButton.setIcon(new ImageIcon(ima));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null) {
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						
						}

						if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())!=null) {
							cliente=Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
							JOptionPane.showMessageDialog(null, "Cliente Encontrado", null, JOptionPane.INFORMATION_MESSAGE, null);
						

							datofila=llenararregloCarrito();
							 model= new DefaultTableModel(datofila,  columnNombre);
							t.setModel(model);
	
						}
						
						
					}
				});
				btnNewButton.setBounds(201, 46, 162, 23);
				panel_1.add(btnNewButton);
				
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setBounds(10, 78, 129, 14);
				panel_1.add(lblNewLabel_2);
				
				textNombre = new JTextField();
				textNombre.setBounds(10, 103, 171, 20);
				panel_1.add(textNombre);
				textNombre.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("");
				Image fotico = new ImageIcon(this.getClass().getResource("/cli.png")).getImage();
				lblNewLabel_1.setIcon(new ImageIcon(fotico));
				lblNewLabel_1.setBounds(394, 5, 108, 125);
				panel_1.add(lblNewLabel_1);
			}
			
			JPanel panelPlanesDisponibles = new JPanel();
			panelPlanesDisponibles.setBackground(Color.WHITE);
			panelPlanesDisponibles.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPlanesDisponibles.setBounds(10, 219, 209, 141);
			panel.add(panelPlanesDisponibles);
			panelPlanesDisponibles.setLayout(null);
			scrollPane.addMouseWheelListener(new MouseWheelListener() {
				public void mouseWheelMoved(MouseWheelEvent e) {
					int codigo=-1,row=0;
					if(Tricom.getInstance().getMiPlan().size()>=1 ) 
					{
						 row= t.getSelectedRow();	
					}
				
					//int column=t.getSelectedColumn();
					if(Tricom.getInstance().getMiPlan().size()>=1&&(row != -1) ) {
						codigo =(int) t.getValueAt(row, 2);
					}
					
					
					lblTotalApagat.setText(String.valueOf(Tricom.getInstance().calcularCostopordode(codigo)));
					
				}
			});
			scrollPane.addFocusListener(new FocusAdapter() {

			});
			scrollPane.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
				//	JOptionPane.showConfirmDialog(null, "mmmmmg");
					int codigo=-1,row=0;
					if(Tricom.getInstance().getMiPlan().size()>=1 ) 
					{
						 row= t.getSelectedRow();	
					}
				
					//int column=t.getSelectedColumn();
					if(Tricom.getInstance().getMiPlan().size()>=1&&(row != -1) ) {
						codigo =(int) t.getValueAt(row, 2);
					}
					
					
					lblTotalApagat.setText(String.valueOf(Tricom.getInstance().calcularCostopordode(codigo)));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					
					int codigo=-1,row=0;
					if(Tricom.getInstance().getMiPlan().size()>=1 ) 
					{
						 row= t.getSelectedRow();	
					}
				
					//int column=t.getSelectedColumn();
					if(Tricom.getInstance().getMiPlan().size()>=1&&(row != -1) ) {
						codigo =(int) t.getValueAt(row, 2);
					}
					
					
					lblTotalApagat.setText(String.valueOf(Tricom.getInstance().calcularCostopordode(codigo)));
				}
			});
			
			
			scrollPane.setBounds(10, 21, 189, 109);
			panelPlanesDisponibles.add(scrollPane);
			

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas Emitidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(338, 219, 238, 141);
			panel.add(panel_2);
			panel_2.setLayout(null);
			scrollPaneCarrito.addMouseListener(new MouseAdapter() {

			});
			
			
			scrollPaneCarrito.setBounds(10, 21, 218, 109);
			panel_2.add(scrollPaneCarrito);
			
			JButton btnNewButton_1 = new JButton("Facturar");
			Image im = new ImageIcon(this.getClass().getResource("/bil.png")).getImage();
			btnNewButton_1.setIcon(new ImageIcon(im));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int codigo=-1,row=0;
					if(Tricom.getInstance().getMiPlan().size()>=1 ) 
					{
						 row= t.getSelectedRow();	
					}
					int tam=0;
				
					//int column=t.getSelectedColumn();
					Cliente cli = Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
					if(cli!=null) {
						tam=cli.getMiscontract().size();
					}
					if(tam>=1&&(row != -1) ) {
						codigo =(int) t.getValueAt(row, 2);
					}
					 
					 Date m =dateChooser.getDate();
					 int dia;
					 int mes;
					 int an;
					if(m!=null) {
						  dia=dateChooser.getDate().getDate();
						  mes= dateChooser.getDate().getMonth()+1;
						 an=m.getYear()+1900;
					}else {
						 dia=0;
					 mes= 0;
					an=0;
					}

			
				
					
				//	JOptionPane.showConfirmDialog(null, dia+" "+mes+" "+an);
			Factura factura_Aux= new Factura(" ", 1, 0, labelFechaInicio.getText() ,
					String.valueOf(dia+"-"+mes+"-"+an), 0, 0);

					
				//JOptionPane.showConfirmDialog(null, codigo);
				
				if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null||
						texCedulaCleinte.getText().equalsIgnoreCase("")&&textNombre.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
				
				}
				if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null) 
				{
					JOptionPane.showMessageDialog(null, "Cliente no encontrado", null, JOptionPane.ERROR_MESSAGE, null);
				}
				//control
				cliente=Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
				nuevoContrato=Tricom.getInstance().findContratoByCode(codigo);
				if(codigo!=-1 && nuevoContrato.getEstado()&&Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())!=null)
				{
					factura_Aux.setCodiFactura(Tricom.getFacturacionCod());

						
					//	JOptionPane.showMessageDialog(null, " Encontrado", null, JOptionPane.INFORMATION_MESSAGE, null);

						 
						if(cliente.getMiscontract().indexOf(nuevoContrato)!=-1) {

							if(Tricom.getInstance().generarFactura2(cliente, nuevoContrato,factura_Aux )) {
								JOptionPane.showMessageDialog(null, "Factura realizada", null, JOptionPane.INFORMATION_MESSAGE, null);
						//	Tricom.setFacturacionCod();//aumentar code Factura
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo realizar factura", null, JOptionPane.INFORMATION_MESSAGE, null);
							}
							


						}else{
							JOptionPane.showMessageDialog(null, "No Encontradoff", null, JOptionPane.INFORMATION_MESSAGE, null);
						}
						
					
					datofilaCa=llenararregloFactura();
					 model2= new DefaultTableModel(datofilaCa,  columnNombreFacturas);
					t2.setModel(model2);
				}
				if(nuevoContrato!=null)
				if(nuevoContrato.getEstado()==false) {
					JOptionPane.showMessageDialog(null, "ContraroCancelado", null, JOptionPane.ERROR_MESSAGE, null);
				}
				
					
				}
			});
			btnNewButton_1.setBounds(223, 257, 111, 20);
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Pagar");
			Image foto = new ImageIcon(this.getClass().getResource("/pay.png")).getImage();
			btnNewButton_2.setIcon(new ImageIcon(foto));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(223, 308, 111, 20);
			panel.add(btnNewButton_2);
			
			JLabel lbllabel = new JLabel("Precio Total a Pagar:");
			lbllabel.setBounds(295, 406, 169, 14);
			panel.add(lbllabel,BorderLayout.CENTER);
			
			JLabel lblNewLabel_4 = new JLabel("Fecha De Inicio:");
			lblNewLabel_4.setBounds(23, 381, 150, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblFechaDeCulminacion = new JLabel("Fecha De Culminacion:");
			lblFechaDeCulminacion.setBounds(23, 406, 138, 14);
			panel.add(lblFechaDeCulminacion);
			
			labelFechaInicio.setText(Tricom.getFechaInicio());
			labelFechaInicio.setBounds(155, 381, 81, 14);
			panel.add(labelFechaInicio);
			
			
			lblTotalApagat.setBounds(416, 406, 81, 14);
			panel.add(lblTotalApagat);
			dateChooser.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			
			dateChooser.setBounds(168, 405, 104, 20);
			panel.add(dateChooser);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				Image imagn = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
				cancelButton.setIcon(new ImageIcon(imagn));
			    cancelButton.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
					
					
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}


	private Object[][] llenararregloFactura() {
		Cliente cliente = Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
		ArrayList<Factura> misF=null;
		int tama=0;
		if(cliente!=null) {
		
		misF=Tricom.getInstance().buscarFacturasActivasByCedulaClinte(cliente.getCodigo_cliente());
		if(misF.size()>=1) {
			tama=misF.size();
		}
		}
		
	Object[][] datofila=new Object[ tama][4];
	
		
		int i=0;
	
		if(misF!=null)
		for (Factura aux : misF) {
			
			datofila[i][0]= aux.getCodiFactura();
			
				 
			
							datofila[i][1]= aux.getFechaDevencimiento();
			
							datofila[i][2]=aux.getRecargo();
							datofila[i][3]=aux.getTotalA_Pagar();
							++i;
							
							//JOptionPane.showConfirmDialog(null, cliente.getCedula());

				
			}
	
		//JOptionPane.showConfirmDialog(null, "mm");
			
		return datofila;
		
		
	}
	public String getString(String n[]) {
		return n[0]+n[1]+n[2];
	}
	private Object[][] llenararregloCarrito() {
		
		Cliente cliente = Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
		int tama=0;
		if(cliente!=null) {
		tama=	cliente.getMiscontract().size();
		}
		
	Object[][] datofila=new Object[ tama][3];
	
		String miServ[]= {"","",""};
		float costo=0;
		int i=0;
		ArrayList<Plan> planes=null;
		if(cliente!=null)
		for (Contrato aux : cliente.getMiscontract()) {
			
			//datofila[i][0]= aux.getCodigoDeContrato();
			
				 planes = aux.getMisPlanes();
						if(planes!=null)
							datofila[i][0]= planes.get(0).getNombre();
							if(planes!=null)
							for (Plan plan : planes) {
								if (plan instanceof Celular) {
									miServ[0]="Cel";
									costo+=((Celular)plan).CalcularCosto();
								}
								if (plan instanceof CableTV) {
									miServ[1]=" -Tv";	
									costo+=(( CableTV)plan).CalcularCosto();
								}
								if (plan instanceof Internet) {
									miServ[2]=" -Int";	
									costo+=((  Internet)plan).CalcularCosto();
								}
								
							}
							if(planes!=null)
							datofila[i][1]= getString(miServ);
							if(planes!=null)
							datofila[i][2]=aux.getCodigoDeContrato();
							++i;
							
							//JOptionPane.showConfirmDialog(null, cliente.getCedula());

				
			}

			
		//JOptionPane.showConfirmDialog(null, "mm");
			
			

		return datofila;
		
		
	}
	public class MiRender extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component cell = super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);

				//cell.setBackground(Color.RED);
			
				cell.setForeground(Color.WHITE);
				///Establecemos las filas que queremos cambiar el color. == 0 para pares y != 0 para impares
				        boolean oddRow = true;//(row % 2 == 0);
				 
				        //Creamos un color para las filas. El 200, 200, 200 en RGB es un color gris
				        Color c = new Color(200, 200, 200);
				 
				        //Si las filas son pares, se cambia el color a gris
				        if (oddRow) {
				            setBackground(c);
				            
				        }
				      
			
			return cell;// cell;
		}
	}
}

 class Precio extends TimerTask{
	 //static private final Logger LOGGER = Logger.getLogger("mx.com.hash.tareaprogramada.Tarea");
	   // private Integer contador;    
	    
	private  int codigo=-1;
	private int  row=0;
	private JLabel lblTotalApagat;
	private JTable t;
	
	public Precio(  JLabel lblTotalApagat, JTable t) {
		super();
		this.codigo = 0;
		this.row = -1;
		this.lblTotalApagat = lblTotalApagat;
		this.t = t;
	//	contador=0;
	}


	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Tricom.getInstance().getMiPlan().size()>=1 ) {
			 row= t.getSelectedRow();	
		}
			
	

		//int column=t.getSelectedColumn();
		if(Tricom.getInstance().getMiPlan().size()>=1&&(row != -1) ) {
			codigo =(int) t.getValueAt(row, 2);
			lblTotalApagat.setText(String.valueOf(Tricom.getInstance().calcularCostopordode(codigo)));
		}
		//JOptionPane.showConfirmDialog(null, "mm");
		
     //   LOGGER.log(Level.INFO, "Numero de ejecución {0}", contador);
        //contador++;
		
	}
	
	
	
	


}

