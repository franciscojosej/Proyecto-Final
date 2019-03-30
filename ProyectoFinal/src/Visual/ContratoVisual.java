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

public class ContratoVisual extends JDialog {

	private static final String Contra = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField texNombreCliente;
	private JTextField textNombre;
	private JTextField textField_3;
	private JTextField textPrecioTotal;
	private JTextField texFechaDeInicio;
	private JTextField textFechaculminacion;

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
					texNombreCliente = new JTextField();
					texNombreCliente.setBounds(10, 47, 171, 20);
					panel_1.add(texNombreCliente);
					texNombreCliente.setColumns(10);
				}
				
				JButton btnNewButton = new JButton(" Buscar Cliente");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
				
				JLabel lblNewLabel_3 = new JLabel("N\u00FAmero Telef\u00F3nico:");
				lblNewLabel_3.setBounds(345, 78, 146, 14);
				panel_1.add(lblNewLabel_3);
				
				textField_3 = new JTextField();
				textField_3.setBounds(355, 103, 186, 20);
				panel_1.add(textField_3);
				textField_3.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Planes Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(23, 245, 190, 115);
			panel.add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carrito de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			
			JLabel lblPrecioTotal = new JLabel("Precio Total a Pagar:");
			lblPrecioTotal.setBounds(282, 406, 169, 14);
			panel.add(lblPrecioTotal);
			
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
}
