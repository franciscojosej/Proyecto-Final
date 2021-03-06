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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


public class ListarPlanes extends JDialog {

	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel tableModel;
	private static Object[] fila;
	private static JButton btnDelete;
	private int code;
	JComboBox cbxPlan;
	private static Plan plan;

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
	public ListarPlanes() {
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
		String[] columnNames = {"#","Nombre", "Servicio","Tipo de Servicio","Costo (RD$)"};
		tableModel.setColumnIdentifiers(columnNames);
		loadListaPlanes(1);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDePlan = new JLabel("Tipo de Plan:");
		lblTipoDePlan.setBounds(10, 14, 90, 14);
		panel.add(lblTipoDePlan);
		
		cbxPlan = new JComboBox();
		cbxPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxPlan.getSelectedIndex();
				loadListaPlanes(selection);
			}
		});
		cbxPlan.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione:>", "Internet", "Televisi�n", "Tel�fono"}));
		cbxPlan.setBounds(96, 11, 110, 20);
		panel.add(cbxPlan);
		
		JLabel lblNewLabel = new JLabel("Listado de Planes");
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
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	
		{
			{
				//Image imagn = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
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
					
					if(aux instanceof Internet)
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
					tableModel.addRow(fila);
				}
			

			break;
		case 1:
		
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
						fila[3] = "Televisi�n";
						
						tableModel.addRow(fila);
	
				}
			

			

			}
			break;	
		case 3:
			
				for (Plan aux: Tricom.getInstance().getMiPlan()) {
					if(aux instanceof Celular){
						fila[0] = aux.getCodigo();
						fila[1] = aux.getNombre();
						fila[2] = "Cantidad de minutos:  "+((Celular) aux).getMinutos();
						fila[4] = aux.CalcularCosto();
						fila[3] = "Tel�fono";
					
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
		columnModel.getColumn(2).setPreferredWidth(175);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(75);
		//columnModel.getColumn(5).setPreferredWidth(155);
		
		
	}
}
