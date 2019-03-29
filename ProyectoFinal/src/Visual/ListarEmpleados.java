package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import logico.Empleado;
import logico.Tricom;
import Visual.RegistroDeEmpleado;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListarEmpleados extends JDialog {

	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private static JTable tableLista;
	private static  DefaultTableModel tableModel;
	private static Object[] fila;
	private static JButton btnUpdate;
	private static JButton btnDelete;
	private int code;
	private Empleado worker;

	public ListarEmpleados() {
		setBounds(100, 100, 934, 454);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(null, "Lista de Empleados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1090, 421);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 24, 890, 321);
		panel.add(scrollPane);
		
		tableLista = new JTable();
		tableLista.setOpaque(false);
		tableLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				if(tableLista.getSelectedRow()>=0){
					btnUpdate.setEnabled(true);
					int index = tableLista.getSelectedRow();
					code = (int)tableLista.getModel().getValueAt(index, 0);
					
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Codigo", "Nombre","Cédula", "Sexo", "Teléfono"};
		tableModel.setColumnIdentifiers(columnNames);
		loadCliente();
		scrollPane.setViewportView(tableLista);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 918, 382);
		contentPanel.add(label);
		
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
						RegistroDeEmpleado mod = new RegistroDeEmpleado();
						mod.setModal(true);
						mod.setLocationRelativeTo(null);
						mod.setVisible(true);
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
				cancelButton.setActionCommand("Delete");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	public static  void loadCliente(){
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Empleado aux : Tricom.getInstance().getMiPersonal()) {
			fila[0] = aux.getCodigo_empleado();
			fila[1] = aux.getNombre();
			fila[2] = aux.getCedula();
			fila[3] = aux.getSexo();
			fila[4] = aux.getTelefono(); 
			tableModel.addRow(fila);
			
			
		}
		tableLista.setModel(tableModel);
		tableLista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableLista.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = tableLista.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(300);
		columnModel.getColumn(4).setPreferredWidth(177);
		
		
		
	
	}
}
