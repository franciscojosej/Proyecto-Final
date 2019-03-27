package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Tricom;
import logico.Facturacion;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class FacturacionVisual extends JDialog {

	private static final String Factu = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturacionVisual dialog = new FacturacionVisual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FacturacionVisual() {
		setBounds(100, 100, 548, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturacion TRICOM RD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo de La Factura:");
				lblNewLabel.setBounds(10, 35, 184, 14);
				panel.add(lblNewLabel);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 55, 36, 20);
				if(Factu == null) {
					
					 txtCodigo.setText("F-" + (Tricom.FacturacionCod+1));
				}
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Datos", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 80, 502, 130);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Nombre Del Cliente:");
					lblNewLabel_1.setBounds(10, 21, 115, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBounds(10, 37, 162, 20);
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Codigo Del Cliente:");
					lblNewLabel_2.setBounds(10, 68, 141, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					textField_2 = new JTextField();
					textField_2.setBounds(10, 93, 162, 20);
					panel_1.add(textField_2);
					textField_2.setColumns(10);
				}
				
				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setBounds(316, 21, 115, 14);
				panel_1.add(lblNewLabel_3);
				
				textField_3 = new JTextField();
				textField_3.setBounds(316, 37, 162, 20);
				panel_1.add(textField_3);
				textField_3.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Cedula de Identidad:");
				lblNewLabel_4.setBounds(316, 68, 129, 14);
				panel_1.add(lblNewLabel_4);
				{
					textField_4 = new JTextField();
					textField_4.setBounds(316, 93, 162, 20);
					panel_1.add(textField_4);
					textField_4.setColumns(10);
				}
				
				JButton btnNewButton = new JButton("Generar");
				btnNewButton.setBounds(197, 64, 89, 23);
				panel_1.add(btnNewButton);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Servicio", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 220, 502, 80);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_5 = new JLabel("Plan:");
					lblNewLabel_5.setBounds(10, 24, 110, 14);
					panel_1.add(lblNewLabel_5);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setBounds(10, 49, 110, 20);
					panel_1.add(comboBox);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("Fecha De Facturacion:");
					lblNewLabel_6.setBounds(130, 24, 150, 14);
					panel_1.add(lblNewLabel_6);
				}
				{
					textField_5 = new JTextField();
					textField_5.setBounds(130, 49, 121, 20);
					panel_1.add(textField_5);
					textField_5.setColumns(10);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Cargo Extra:");
					lblNewLabel_7.setBounds(266, 24, 110, 14);
					panel_1.add(lblNewLabel_7);
				}
				{
					textField_6 = new JTextField();
					textField_6.setBounds(261, 49, 115, 20);
					panel_1.add(textField_6);
					textField_6.setColumns(10);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Precio Base:");
					lblNewLabel_8.setBounds(396, 24, 96, 14);
					panel_1.add(lblNewLabel_8);
				}
				{
					textField_7 = new JTextField();
					textField_7.setBounds(386, 49, 106, 20);
					panel_1.add(textField_7);
					textField_7.setColumns(10);
				}
			}
			
			JLabel lblNewLabel_9 = new JLabel("Precio Total:");
			lblNewLabel_9.setBounds(29, 325, 120, 14);
			panel.add(lblNewLabel_9);
			
			textField_8 = new JTextField();
			textField_8.setBounds(127, 322, 141, 20);
			panel.add(textField_8);
			textField_8.setColumns(10);
			
			JTextPane txtpnParaBrindarMejor = new JTextPane();
			txtpnParaBrindarMejor.setText("Gracias Por Preferirnos....");
			txtpnParaBrindarMejor.setEditable(false);
			txtpnParaBrindarMejor.setBounds(344, 334, 168, 20);
			panel.add(txtpnParaBrindarMejor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Facturar\r\n");
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
