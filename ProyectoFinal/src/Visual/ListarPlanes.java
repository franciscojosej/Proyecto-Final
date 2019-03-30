package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logico.Plan;
import logico.Internet;
import logico.CableTV;
import logico.Celular;
import logico.Contrato;
import logico.Tricom;


public class ListarPlanes extends JDialog {

	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel tableModel;
	private static Object[] fila;
	private static JButton btnUpdate;
	private static JButton btnDelete;
	private int code;
	JComboBox cbxQueso;
	private static Plan plan;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListaQueso dialog = new ListaQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListarPlanes() {
		setBounds(100, 100, 571, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de planes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 534, 226);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 514, 165);
		panel.add(scrollPane);
		
		table = new JTable();
		
		tableModel = new DefaultTableModel();
		String[] columnNames = {"#","Nombre", "Servicio"};
		tableModel.setColumnIdentifiers(columnNames);
		loadListaPlanes(1);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDeQueso = new JLabel("Tipo de Plan:");
		lblTipoDeQueso.setBounds(10, 25, 90, 14);
		panel.add(lblTipoDeQueso);
		
		cbxQueso = new JComboBox();
		cbxQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxQueso.getSelectedIndex();
				loadListaPlanes(selection);
			}
		});
		cbxQueso.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione:>", "Internet", "Televisión", "Teléfono"}));
		cbxQueso.setBounds(96, 22, 110, 20);
		panel.add(cbxQueso);
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnUpdate = new JButton("Modificar");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CrearPlanes modi = new CrearPlanes();
						modi.setModal(true);
						modi.setLocationRelativeTo(null);
						modi.setVisible(true);
					}
				});
				
				
				
				JButton btnDelete = new JButton("Eliminar");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				buttonPane.add(btnDelete);
				buttonPane.add(btnUpdate);
				btnUpdate.setEnabled(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public static void loadListaPlanes(int selection) {
		tableModel.setRowCount(0);
		
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
		
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					fila[0] = aux.getCodigo();
					fila[1] = aux.getNombre();
					//fila[2] = aux.getUnidades_Plan();
					//fila[3] = aux.get;
					//fila[4] = aux.PrecioTotal();
					if(aux instanceof Internet)
						fila[3] = "Internet";
					if(aux instanceof CableTV)
						fila[3] = "Television";
					if(aux instanceof Celular)
						fila[3] = "Telefono";
					tableModel.addRow(fila);
				}
			

			break;
		case 1:
		
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof Internet){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = ((Internet) aux).getVelocidad_conexion();
						//fila[3] = aux.getPrecio_uni();
						//fila[4] = aux.PrecioTotal();
						//fila[3] = "Internet";
						
						tableModel.addRow(fila);
				}
			

			}
			break;	
		case 2:
			
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof CableTV){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = ((CableTV) aux).getCantidadCanales();
						//fila[3] = aux.getPrecio_uni();
						//fila[4] = aux.PrecioTotal();
						//fila[3] = "Televisión";
						
						tableModel.addRow(fila);
	
				}
			

			

			}
			break;	
		case 3:
			
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof Celular){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = ((Celular) aux).getMinutos();
						//fila[3] = aux.getPrecio_uni();
						//fila[4] = aux.PrecioTotal();
						//fila[3] = "Teléfono";
					
						tableModel.addRow(fila);
	
				}
			

			

			}

			break;
		}

		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(25);
		columnModel.getColumn(1).setPreferredWidth(100);
		//columnModel.getColumn(2).setPreferredWidth(56);
		//columnModel.getColumn(3).setPreferredWidth(100);
		//columnModel.getColumn(4).setPreferredWidth(75);
		//columnModel.getColumn(5).setPreferredWidth(155);
		
		
	}
}
