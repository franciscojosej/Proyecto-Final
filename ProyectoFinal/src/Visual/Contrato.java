package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import logico.Tricom;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Contrato extends JDialog {

	private static final String Contra = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contrato dialog = new Contrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Contrato() {
		setBounds(100, 100, 587, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formulario de Contrato Tricom RD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setBounds(10, 28, 138, 14);
				panel.add(lblNewLabel);
			}
			{
				
				

				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 56, 149, 20);
				if(Contra == null) {
					
					 txtCodigo.setText("C-" + (Tricom.ClienteCod+1));
				}
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imformacion Del Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBounds(10, 80, 541, 141);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Indentidad Del Cliente:");
					lblNewLabel_1.setBounds(10, 22, 181, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBounds(10, 47, 181, 20);
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
				
				JButton btnNewButton = new JButton(" Buscar Cliente");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton.setBounds(201, 46, 146, 23);
				panel_1.add(btnNewButton);
				
				JLabel lblNewLabel_2 = new JLabel("Nombre:");
				lblNewLabel_2.setBounds(10, 78, 129, 14);
				panel_1.add(lblNewLabel_2);
				
				textField_2 = new JTextField();
				textField_2.setBounds(10, 103, 181, 20);
				panel_1.add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("Numero Telefonico:");
				lblNewLabel_3.setBounds(345, 78, 146, 14);
				panel_1.add(lblNewLabel_3);
				
				textField_3 = new JTextField();
				textField_3.setBounds(345, 103, 186, 20);
				panel_1.add(textField_3);
				textField_3.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Planes Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(23, 245, 190, 115);
			panel.add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carrito De Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(356, 245, 182, 115);
			panel.add(panel_2);
			
			JButton btnNewButton_1 = new JButton("Seleccionar ");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			
			JLabel lblPrecioTotal = new JLabel("Precio Total:");
			lblPrecioTotal.setBounds(282, 406, 118, 14);
			panel.add(lblPrecioTotal);
			
			textField_4 = new JTextField();
			textField_4.setBounds(394, 403, 108, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Forma De Pago:");
			lblNewLabel_4.setBounds(49, 381, 150, 14);
			panel.add(lblNewLabel_4);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Tarjeta De Credito", "Efectivo ", "Cheque "}));
			comboBox.setBounds(49, 403, 154, 20);
			panel.add(comboBox);
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
}
