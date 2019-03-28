package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import logico.Control;
import logico.Empleado;
import logico.Tricom;
import logico.User;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroDeEmpleado extends JDialog {
	

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private static Empleado Emple;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JRadioButton rdbtnAdministrativo;
	private JRadioButton rdbtnComercial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroDeEmpleado dialog = new RegistroDeEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroDeEmpleado() {
		setBounds(100, 100, 504, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText(" Datos Del Empleado");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Del Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 468, 255);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo Del Empleado:");
				lblNewLabel.setBounds(10, 34, 168, 14);
				panel.add(lblNewLabel);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 55, 36, 20);
				if(Emple == null) {
					
					 txtCodigo.setText("E-" + (Tricom.ClienteCod+1));
				}
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 86, 118, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(10, 111, 208, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Usuario:");
				lblNewLabel_2.setBounds(10, 142, 118, 14);
				panel.add(lblNewLabel_2);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(10, 167, 208, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setBounds(10, 198, 118, 14);
				panel.add(lblNewLabel_3);
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(10, 223, 208, 20);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
				lblNewLabel_4.setBounds(233, 142, 208, 14);
				panel.add(lblNewLabel_4);
			}
			{
				textField_4 = new JTextField();
				textField_4.setBounds(233, 223, 208, 20);
				panel.add(textField_4);
				textField_4.setColumns(10);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(233, 167, 208, 20);
				panel.add(passwordField);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Sexo:");
				lblNewLabel_7.setBounds(233, 86, 112, 14);
				panel.add(lblNewLabel_7);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino", ""}));
			comboBox.setBounds(233, 111, 158, 20);
			panel.add(comboBox);
			
			JLabel lblNewLabel_5 = new JLabel("Cedula De identidad:");
			lblNewLabel_5.setBounds(233, 198, 158, 14);
			panel.add(lblNewLabel_5);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Tipo De Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(10, 277, 468, 56);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				 rdbtnAdministrativo = new JRadioButton("Administrativo");
				rdbtnAdministrativo.setBounds(98, 26, 109, 23);
				panel.add(rdbtnAdministrativo);
			}
			{
				 rdbtnComercial = new JRadioButton("Comercial");
				rdbtnComercial.setBounds(254, 26, 109, 23);
				panel.add(rdbtnComercial);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 344, 468, 73);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_6 = new JLabel("Cargo:");
				lblNewLabel_6.setBounds(10, 35, 106, 14);
				panel.add(lblNewLabel_6);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(75, 32, 161, 20);
				panel.add(comboBox);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						if(	rdbtnAdministrativo.isSelected()	) {
							if(rdbtnComercial.isSelected()) {
								rdbtnComercial.setSelected(false);
							}
							
							JOptionPane.showConfirmDialog(okButton, "MM");
						}
						if(rdbtnComercial.isSelected()) {
							if(	rdbtnAdministrativo.isSelected()	) {
								rdbtnAdministrativo.setSelected(false);
							}
								
							JOptionPane.showConfirmDialog(okButton, "Moo");
						}
						//User user = new User(comboBox.getSelectedItem().toString(),textField.getText(),textField_1.getText());
					    //Control.getInstance().regUser(user);
					}
				});
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
