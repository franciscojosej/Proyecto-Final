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

import logico.Comercial;
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
	private JTextField textUsuario;
	private JTextField textTelefono;
	private JTextField textCedula;
	private JPasswordField txtPassword;
	private JRadioButton rdbtnAdministrativo;
	private JRadioButton rdbtnComercial;
	private JComboBox cbxSexo ;

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
				textUsuario = new JTextField();
				textUsuario.setBounds(10, 167, 208, 20);
				panel.add(textUsuario);
				textUsuario.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setBounds(10, 198, 118, 14);
				panel.add(lblNewLabel_3);
			}
			{
				textTelefono = new JTextField();
				textTelefono.setBounds(10, 223, 208, 20);
				panel.add(textTelefono);
				textTelefono.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
				lblNewLabel_4.setBounds(233, 142, 208, 14);
				panel.add(lblNewLabel_4);
			}
			{
				textCedula = new JTextField();
				textCedula.setBounds(233, 223, 208, 20);
				panel.add(textCedula);
				textCedula.setColumns(10);
			}
			{
				txtPassword = new JPasswordField();
				txtPassword.setBounds(233, 167, 208, 20);
				panel.add(txtPassword);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Sexo:");
				lblNewLabel_7.setBounds(233, 86, 112, 14);
				panel.add(lblNewLabel_7);
			}
			
			 cbxSexo = new JComboBox();
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino", ""}));
			cbxSexo.setBounds(233, 111, 158, 20);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_5 = new JLabel("Cedula De identidad:");
			lblNewLabel_5.setBounds(233, 198, 158, 14);
			panel.add(lblNewLabel_5);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 277, 468, 73);
			contentPanel.add(panel);
			panel.setLayout(null);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 356, 468, 56);
			contentPanel.add(panel_1);
			panel_1.setBorder(new TitledBorder(null, "Tipo De Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_1.setLayout(null);
			{
				 rdbtnAdministrativo = new JRadioButton("Administrativo");
				 rdbtnAdministrativo.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
						if(	rdbtnAdministrativo.isSelected()	) {
							if(rdbtnComercial.isSelected()) {
								rdbtnComercial.setSelected(false);
							}
							
						}
				 	}
				 });
				rdbtnAdministrativo.setBounds(91, 26, 109, 23);
				panel_1.add(rdbtnAdministrativo);
			}
			{
				 rdbtnComercial = new JRadioButton("Comercial");
				 rdbtnComercial.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
						if(rdbtnComercial.isSelected()) {
							if(	rdbtnAdministrativo.isSelected()	) {
								rdbtnAdministrativo.setSelected(false);
							}
								
						
						}
				 	}
				 });
				rdbtnComercial.setBounds(254, 26, 109, 23);
				panel_1.add(rdbtnComercial);
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
						String cargo="";
					Empleado nuevoEmpleado=null;

						if(rdbtnComercial.isSelected()) {

								cargo="Administrativo";
nuevoEmpleado =new Comercial(txtNombre.getText(), " ", textCedula.getText(), textTelefono.getText(), " ",  cbxSexo.getSelectedItem().toString(),
		" ", " ", " ", " ", 2.3,	" ", 2.2,1, 1, Tricom.getFechaInicio(),	" ");

							
						}
						else if(	rdbtnAdministrativo.isSelected()	) {

							cargo="Comercial";
						}
						User user = new User(cargo,textUsuario.getText(),
								txtPassword.getPassword().toString() );
						
						if((rdbtnAdministrativo.isSelected()||rdbtnComercial.isSelected())&&!textUsuario.getText().equalsIgnoreCase("")&&
								!txtPassword.getPassword().toString().equalsIgnoreCase("")&&!textCedula.getText().equalsIgnoreCase("")
								&&!txtNombre.getText().equalsIgnoreCase("")&&!textTelefono.getText().equalsIgnoreCase("")) {
							 Control.getInstance().regUser(user);
							 JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						}else {
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos", null, JOptionPane.ERROR_MESSAGE, null);
						}
						
						
					 
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
