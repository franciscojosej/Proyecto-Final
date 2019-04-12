package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

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

import logico.Administrativo;
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
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class RegistroDeEmpleado extends JDialog {
	

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private static Empleado Emple;
	private JTextField textUsuario;
	private JTextField textTelefono;
	private JTextField textCedula;
	private JPasswordField txtPassword;
	private JRadioButton rdbtnAdministrativo;
	private JRadioButton rdbtnComercial;
	private JComboBox cbxSexo ;
	private JLabel lbCodeEmpl ;
	private JLabel lblRegistrado ;
	private JLabel lblCheck;
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
		setForeground(SystemColor.controlShadow);
		setResizable(false);
		setBounds(5, 59, 504, 500);
	//	setBounds(100, 100, 504, 500);
	
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setToolTipText(" Datos Del Empleado");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);//null
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlHighlight);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Del Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 468, 338);
		//	panel.setBounds(5, 50, 468, 338);
			
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo Del Empleado:");
				lblNewLabel.setBounds(10, 114, 168, 14);
				panel.add(lblNewLabel);
			}
			{
				if(Emple == null) {
					
					// lbCodeEmpl.setText("E-" + (Tricom.ClienteCod+1));
				}
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 170, 118, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(10, 195, 208, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Usuario:");
				lblNewLabel_2.setBounds(10, 226, 118, 14);
				panel.add(lblNewLabel_2);
			}
			{
				textUsuario = new JTextField();
				textUsuario.setBounds(10, 251, 208, 20);
				panel.add(textUsuario);
				textUsuario.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setBounds(10, 282, 118, 14);
				panel.add(lblNewLabel_3);
			}
			{
				textTelefono = new JTextField();
				textTelefono.setBounds(10, 307, 208, 20);
				panel.add(textTelefono);
				textTelefono.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
				lblNewLabel_4.setBounds(228, 226, 208, 14);
				panel.add(lblNewLabel_4);
			}
			{
				textCedula = new JTextField();
				textCedula.setBounds(228, 307, 208, 20);
				panel.add(textCedula);
				textCedula.setColumns(10);
			}
			{
				txtPassword = new JPasswordField();
				txtPassword.setBounds(228, 251, 208, 20);
				panel.add(txtPassword);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Sexo:");
				lblNewLabel_7.setBounds(228, 170, 112, 14);
				panel.add(lblNewLabel_7);
			}
			
			 cbxSexo = new JComboBox();
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
			cbxSexo.setBounds(228, 195, 158, 20);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_5 = new JLabel("Cedula De identidad:");
			lblNewLabel_5.setBounds(228, 282, 158, 14);
			panel.add(lblNewLabel_5);
			
			{
				Image img = new ImageIcon(this.getClass().getResource("/Empleados.png")).getImage();
			}
			
			 lbCodeEmpl = new JLabel("E"+"-"+(Tricom.EmpleadoCod+1));
			lbCodeEmpl.setBounds(20, 139, 46, 14);
			panel.add(lbCodeEmpl);
			{
				 lblRegistrado = new JLabel("");
					Image imgaa = new ImageIcon(this.getClass().getResource("/erorBusq.png")).getImage();
					lblRegistrado .setIcon(new ImageIcon(imgaa));
					lblRegistrado .setVisible(false);
					 
					lblRegistrado .setBounds(211, 53, 158, 106);
				panel.add(lblRegistrado);
			}
			{
				 lblCheck = new JLabel("");
					Image i = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
					 lblCheck .setIcon(new ImageIcon(i));
					 lblCheck .setVisible(false);
				 
				lblCheck.setBounds(228, 44, 118, 115);
				panel.add(lblCheck);
			}
			{
				JLabel lblEmployee = new JLabel("");
				Image f = new ImageIcon(this.getClass().getResource("/employee.png")).getImage();
				lblEmployee.setIcon(new ImageIcon(f));
				lblEmployee.setBounds(10, 23, 86, 80);
				panel.add(lblEmployee);
			}
		}
		
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 277, 468, 1);
			contentPanel.add(panel);
			panel.setLayout(null);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.controlHighlight);
			panel_1.setBounds(10, 360, 468, 53);
			contentPanel.add(panel_1);
			panel_1.setBorder(new TitledBorder(null, "Tipo De Empleado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_1.setLayout(null);
			{
				 rdbtnAdministrativo = new JRadioButton("Administrativo");
				 rdbtnAdministrativo.setBackground(SystemColor.controlHighlight);
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
				 rdbtnComercial.setBackground(SystemColor.controlHighlight);
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
			buttonPane.setBackground(SystemColor.controlHighlight);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				Image ima = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
				okButton.setIcon(new ImageIcon(ima));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cargo="";
					Empleado nuevoEmpleado=null;

						if(rdbtnComercial.isSelected()) {

								cargo="Administrativo";
								
						nuevoEmpleado= new Administrativo(txtNombre.getText(), " ", textCedula.getText(), textTelefono.getText(), " ", 
		cbxSexo.getSelectedItem().toString(), " ", " ", " ", " ", (float)2.3, " ", (float)2.3, 0, 
		0,  Tricom.getFechaInicio(), " ");
						
						}
						else if(	rdbtnAdministrativo.isSelected()	) {

							cargo="Comercial";
							nuevoEmpleado=new Comercial(txtNombre.getText(), " ", textCedula.getText(), textTelefono.getText(), " ",  cbxSexo.getSelectedItem().toString(),
									" ", " ", " ", " ", (float)2.3,	" ", (float)2.2,1, 1, Tricom.getFechaInicio(),	" ");
						}
						User user = new User(cargo,textUsuario.getText(),
								String.copyValueOf(txtPassword.getPassword()) );
						
						if((rdbtnAdministrativo.isSelected()||rdbtnComercial.isSelected())&&!textUsuario.getText().equalsIgnoreCase("")&&
								!txtPassword.getPassword().toString().equalsIgnoreCase("")&&!textCedula.getText().equalsIgnoreCase("")
								&&!txtNombre.getText().equalsIgnoreCase("")&&!textTelefono.getText().equalsIgnoreCase("")&&cbxSexo.getSelectedIndex()!=0) {
							 Control.getInstance().regUser(user);
							 Tricom.getInstance().insertarEmpleado(nuevoEmpleado);
							// JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								lblRegistrado .setVisible(false);
								 lblCheck .setVisible(true);
							 
							 clear();
						}else {
							//JOptionPane.showMessageDialog(null, "Verifique que todos los campos", null, JOptionPane.ERROR_MESSAGE, null);
							lblRegistrado .setVisible(true);
							 lblCheck .setVisible(false);
						}
						
						
					 
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				Image imag = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
				cancelButton.setIcon(new ImageIcon(imag));
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

	private void clear() {
		
		txtNombre.setText("");
		textTelefono.setText("");
		textUsuario.setText("");
		textCedula.setText("");
		txtPassword.setText("");
		cbxSexo.setSelectedIndex(0);
		lbCodeEmpl.setText("E"+"-"+(1+Tricom.EmpleadoCod));
	
	}
}
