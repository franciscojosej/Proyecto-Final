package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import logico.Cliente;
import logico.Tricom;
import Visual.RegistroDeClientes;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class ListarCliente extends JDialog {

	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private static JTable tableLista;
	private static  DefaultTableModel tableModel;
	private static Object[] fila;
	private static JButton btnDelete;
	private int code;
	private Cliente clie;

	public ListarCliente() {
		setBounds(100, 100, 957, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		//panel.setBorder(new TitledBorder(null, "Lista de Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 114, 921, 241);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 890, 219);
		panel.add(scrollPane);
		
		tableLista = new JTable();
		tableLista.setOpaque(false);
		tableLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				if(tableLista.getSelectedRow()>=0){
				//	btnUpdate.setEnabled(true);
					int index = tableLista.getSelectedRow();
					code = (int)tableLista.getModel().getValueAt(index, 0);
					
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Código", "Nombre","Cédula", "Dirección", "Teléfono"};
		tableModel.setColumnIdentifiers(columnNames);
		loadCliente();
		scrollPane.setViewportView(tableLista);
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(20, 353, 911, 35);
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
		cancelButton.setActionCommand("Delete");
		buttonPane.add(cancelButton);
		
		JLabel lblNewLabel = new JLabel("Listado de Clientes");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(10, 45, 330, 35);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image fotico = new ImageIcon(this.getClass().getResource("/Tricom.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(fotico));
		lblNewLabel_1.setBounds(748, 12, 165, 110);
		contentPanel.add(lblNewLabel_1);

		
		
		{
			{
				//Image imagn = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
			}
		}
		
		
	}
	public static  void loadCliente(){
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Cliente aux : Tricom.getInstance().getMiCliente()) {
			fila[0] = aux.getCodigo_cliente();
			fila[1] = aux.getNombre();
			fila[2] = aux.getCedula(); //Está recibiendo lo de teléfono.
			fila[3] = aux.getDireccion(); //Está recibiendo apellido en vez de dirección.
			fila[4] = aux.getTelefono(); //Está recibiendo lo de cédula.
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
