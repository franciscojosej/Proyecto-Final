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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logico.Plan;
import logico.Internet;
import logico.CableTV;
import logico.Celular;
import logico.Contrato;
import logico.Tricom;
import logico.Factura;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


public class ListarFactura extends JDialog {

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
	JComboBox cbxFactura;
	private static Factura fact;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListarPlanes dialog = new ListarPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListarFactura() {
		setBounds(100, 100, 571, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
	//panel.setBorder(new TitledBorder(null, "Listado de planes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 114, 534, 209);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 514, 165);
		panel.add(scrollPane);
		
		table = new JTable();
		
		tableModel = new DefaultTableModel();
		String[] columnNames = {"# Factura","# Cliente", "# Contrato","Nombre del Cliente"};
		tableModel.setColumnIdentifiers(columnNames);
		loadListaFacturas(1);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDePlan = new JLabel("Tipo de Factura:");
		lblTipoDePlan.setBounds(8, 14, 90, 14);
		panel.add(lblTipoDePlan);
		
		cbxFactura = new JComboBox();
		cbxFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxFactura.getSelectedIndex();
				loadListaFacturas(selection);
			}
		});
		cbxFactura.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Activa", "No Activa"}));
		cbxFactura.setBounds(120, 11, 110, 20);
		panel.add(cbxFactura);
		
		JLabel lblNewLabel = new JLabel("Listado de Facturas");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 58, 203, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image fotico = new ImageIcon(this.getClass().getResource("/Tricom.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(fotico));
		lblNewLabel_1.setBounds(347, 11, 165, 110);
		contentPanel.add(lblNewLabel_1);
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 322, 555, 35);
		contentPanel.add(buttonPane);
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton cancelButton = new JButton("Salir");
		Image imagn = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		cancelButton.setIcon(new ImageIcon(imagn));
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
		
		
		
		JButton btnDelete_1 = new JButton("Eliminar");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		buttonPane.add(btnDelete_1);
		buttonPane.add(btnUpdate);
		btnUpdate.setEnabled(false);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	
		{
			{
				//Image imagn = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
			}
		}
	}
	public static void loadListaFacturas(int selection) {
		tableModel.setRowCount(0);
		
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
		
				for (Factura aux: Tricom.getInstance().getMisFacturas()) {
					fila[0] = aux.getCodiCliente();
					fila[1] = aux.getCodiFactura();
					fila[2]= aux.getCodigoContrato();
					fila[3]= aux.getNombreCliente();
					
					/*if(aux instanceof Internet)
						fila[2] = "Velocidad de conexion:  "+((Internet) aux).getVelocidad_conexion();
						fila[4] = aux.CalcularCosto();
						fila[3] = "Internet";
					if(aux instanceof CableTV)
						fila[2] = "Cantidad de Canales:  "+((CableTV) aux).getCantidadCanales();
						fila[4] = aux.CalcularCosto();
						fila[3] = "Television";
					if(aux instanceof Celular)
						fila[2] = "Cantidad de minutos:  "+((Celular) aux).getMinutos();
						fila[4] = aux.CalcularCosto();
						fila[3] = "Telefono";
					tableModel.addRow(fila);*/
				}
			

			break;
		/*case 1:
		
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof Internet){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = "Velocidad de conexion:  "+((Internet) aux).getVelocidad_conexion();
						fila[4] = aux.CalcularCosto();
						fila[3] = "Internet";
						
						tableModel.addRow(fila);
				}
			

			}
			break;	
		case 2:
			
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof CableTV){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = "Cantidad de Canales:  "+((CableTV) aux).getCantidadCanales();
						fila[4] = aux.CalcularCosto();						
						fila[3] = "Televisión";
						
						tableModel.addRow(fila);
	
				}
			

			

			}
			break;	*/
		}

		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(75);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(175);
		columnModel.getColumn(3).setPreferredWidth(170);
		//columnModel.getColumn(4).setPreferredWidth(75);
		//columnModel.getColumn(5).setPreferredWidth(155);
		
		
	}
}