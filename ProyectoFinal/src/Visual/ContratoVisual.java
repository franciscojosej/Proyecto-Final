package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import logico.Internet;
import logico.Plan;
import logico.Tricom;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ContratoVisual extends JDialog {

	private static final String Contra = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField texCedulaCleinte;
	private JTextField textNombre;
	private JTextField textPrecioTotal;
	private JTextField texFechaDeInicio;
	private JTextField textFechaculminacion;
	private Cliente cliente;
	private Contrato nuevoContrato;
	private  Object[][] datofila=llenararreglo();	
	
	
	private static String columnNombre[] = {"Nombre","Servicio","x"};

	
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
	
	JTable t= new  JTable(model);//llenararreglo(),columnNombre
	
	JScrollPane scrollPane = new JScrollPane(t);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ContratoVisual dialog = new ContratoVisual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContratoVisual() {
	//	t.setDefaultRenderer(Object.class, new MiRender());

		//int  m=(int) datofila[t.getSelectedColumn()][0];
		
		setBounds(100, 100, 587, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
		//	t.setSelectionBackground(getBackground());
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formulario de Contrato Tricom RD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo del Contrato:");
				lblNewLabel.setBounds(10, 28, 138, 14);
				panel.add(lblNewLabel);
			}
			
			{
				
				

				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 56, 50, 20);
				if(Contra == null) {
					
					 txtCodigo.setText("C-" + (Tricom.ClienteCod+1));
				}
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Información del Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 80, 541, 141);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel Cedula = new JLabel("Cedula:");
					Cedula.setBounds(10, 22, 181, 14);
					panel_1.add(Cedula);
				}
				{
					texCedulaCleinte = new JTextField();
					texCedulaCleinte.setBounds(10, 47, 171, 20);
					panel_1.add(texCedulaCleinte);
					texCedulaCleinte.setColumns(10);
				}
				
				JButton btnNewButton = new JButton(" Buscar Cliente");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null) {
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}

						if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())!=null) {
							cliente=Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
							JOptionPane.showMessageDialog(null, "Cliente Encontrado", null, JOptionPane.INFORMATION_MESSAGE, null);
							

							
							
						}
						
					}
				});
				btnNewButton.setBounds(201, 46, 136, 23);
				panel_1.add(btnNewButton);
				
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setBounds(10, 78, 129, 14);
				panel_1.add(lblNewLabel_2);
				
				textNombre = new JTextField();
				textNombre.setBounds(10, 103, 171, 20);
				panel_1.add(textNombre);
				textNombre.setColumns(10);
			}
			
			JPanel panelPlanesDisponibles = new JPanel();
			panelPlanesDisponibles.setBorder(new TitledBorder(null, "Planes Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelPlanesDisponibles.setBounds(10, 219, 209, 141);
			panel.add(panelPlanesDisponibles);
			panelPlanesDisponibles.setLayout(null);
			
			
			scrollPane.setBounds(10, 21, 189, 109);
			panelPlanesDisponibles.add(scrollPane);
			

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carrito de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(356, 245, 182, 115);
			panel.add(panel_2);
			
			JButton btnNewButton_1 = new JButton("Seleccionar ");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row= t.getSelectedRow();
					//int column=t.getSelectedColumn();
					int codigo =(int) t.getValueAt(row, 2);
				ArrayList<Plan> nuevoPlan=null;
					Contrato nuevoContrato=new Contrato(" ", Tricom.getFechaInicio(), "", 1);
					nuevoPlan=Tricom.getInstance().buscarPlanes(codigo);
					if(nuevoPlan!=null)
					nuevoContrato.setMisPlanes(nuevoPlan);
					
				JOptionPane.showConfirmDialog(null, codigo);
				
				if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null||
						texCedulaCleinte.getText().equalsIgnoreCase("")&&textNombre.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
				}
				if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())==null) {
					JOptionPane.showMessageDialog(null, "Cliente no encontrado", null, JOptionPane.ERROR_MESSAGE, null);
				}
				if(Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText())!=null) {
					cliente=Tricom.getInstance().BuscarByCedula(texCedulaCleinte.getText());
					
					//JOptionPane.showMessageDialog(null, " Encontrado", null, JOptionPane.INFORMATION_MESSAGE, null);
					int  num= JOptionPane.showConfirmDialog(null, "Costo Del Plan: "+Tricom.getInstance().calcularCostopordode(codigo), 
							"Crear", JOptionPane.YES_NO_OPTION);

					if(num==0) {
						JOptionPane.showMessageDialog(null, "Contrato registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						cliente.agrregarcontrato(nuevoContrato);
					}
					
					
					
				}
				cliente=null;
					
				}
			});
			btnNewButton_1.setBounds(223, 257, 123, 23);
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Borrar");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(223, 309, 123, 23);
			panel.add(btnNewButton_2);
			
			JLabel lblPrecioTotal = new JLabel("Precio Total a Pagar:");
			lblPrecioTotal.setBounds(282, 406, 169, 14);
			panel.add(lblPrecioTotal,BorderLayout.CENTER);
			
			textPrecioTotal = new JTextField();
			textPrecioTotal.setBounds(408, 403, 94, 20);
			panel.add(textPrecioTotal);
			textPrecioTotal.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Fecha De Inicio:");
			lblNewLabel_4.setBounds(23, 381, 150, 14);
			panel.add(lblNewLabel_4);
			
			texFechaDeInicio = new JTextField();
			texFechaDeInicio.setEditable(false);
			texFechaDeInicio.setBounds(133, 378, 86, 20);
			panel.add(texFechaDeInicio);
			texFechaDeInicio.setColumns(10);
			
			JLabel lblFechaDeCulminacion = new JLabel("Fecha De Culminacion:");
			lblFechaDeCulminacion.setBounds(23, 406, 150, 14);
			panel.add(lblFechaDeCulminacion);
			
			textFechaculminacion = new JTextField();
			textFechaculminacion.setEditable(false);
			textFechaculminacion.setColumns(10);
			textFechaculminacion.setBounds(133, 403, 86, 20);
			panel.add(textFechaculminacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Contratar\r\n");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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


	private Object[][] llenararreglo() {
		Object[][] datofila=new Object[Tricom.getPlanesCod()][3];
		String miServ[]= {"","",""};
		float costo=0;
		for (int i = 0; i < Tricom.getPlanesCod(); i++) {
			
			ArrayList<Plan> planes=Tricom.getInstance().buscarPlanes(i);
			
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
			datofila[i][2]=planes.get(0).getCodigo();

	
			
			
		}
		

		return datofila;
		
		
	}
	public String getString(String n[]) {
		return n[0]+n[1]+n[2];
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

