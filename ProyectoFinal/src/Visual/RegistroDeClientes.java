
package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logico.Factura;
import logico.Persona;
import logico.Cliente;
import logico.Tricom;
import logico.Plan;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;



import javax.swing.UIManager;
import java.awt.Color;



public class RegistroDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFormattedTextField formattedTextField;
	private static Cliente cliente;
	private JTextField textFieldnumber;
	private JTextField textFieldCedula;
	private JTextField textFieldDireccion;
	private JButton cancelButton; 
	private JPanel buttonPane;
	private JComboBox comboBox;

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		try {
			
			RegistroDeClientes dialog = new RegistroDeClientes(cliente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroDeClientes(Cliente cli) {
		final int code= 0;
		cliente = cli;{
			
		}
		setTitle("Registro de Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Del Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 11, 434, 217);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo Del Cliente:");
			lblNewLabel.setBounds(10, 36, 126, 14);
			panel.add(lblNewLabel);
		}
		{
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(10, 56, 33, 20);
			txtCodigo.setEditable(false);
			if(cli == null) {
				
				 txtCodigo.setText("C-" + (Tricom.ClienteCod+1));
			}
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 87, 111, 14);
			panel.add(lblNewLabel_1);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 103, 149, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(10, 134, 126, 14);
			panel.add(lblNewLabel_2);
		}
		{
			textFieldnumber = new JTextField();
			textFieldnumber.setBounds(10, 159, 149, 20);
			panel.add(textFieldnumber);
			textFieldnumber.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Cedula de Identidad:");
			lblNewLabel_3.setBounds(253, 87, 166, 14);
			panel.add(lblNewLabel_3);
		}
		{
			textFieldCedula = new JTextField();
			textFieldCedula.setBounds(253, 103, 166, 20);
			panel.add(textFieldCedula);
			textFieldCedula.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Direccion:");
			lblNewLabel_4.setBounds(253, 134, 117, 14);
			panel.add(lblNewLabel_4);
		}
		{
			textFieldDireccion = new JTextField();
			textFieldDireccion.setBounds(253, 159, 166, 20);
			panel.add(textFieldDireccion);
			textFieldDireccion.setColumns(10);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(253, 36, 46, 14);
		panel.add(lblNewLabel_5);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
		comboBox.setBounds(253, 56, 166, 20);
		panel.add(comboBox);
		{
		 buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton();
				okButton.setText("Registrar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						if(!txtNombre.getText().equalsIgnoreCase("") && !textFieldCedula.getText().equalsIgnoreCase("") && Tricom.getInstance().BuscarByCedula(textFieldCedula.getText())==null
								&& !textFieldDireccion.getText().equalsIgnoreCase("") && !textFieldnumber.getText().equalsIgnoreCase("") && comboBox.getSelectedIndex()!=0){
						Cliente a = new Cliente(txtNombre.getText(), textFieldDireccion.getText(), textFieldnumber.getText(), textFieldCedula.getText(), null, null, null, null, null, code);
						 for (int i = 0; i < 10; i++) {
							 Tricom.getInstance().insertarCliente(a);
						}
						 txtCodigo.setText("C-" + (Tricom.ClienteCod+1));
						JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						clear();
						}else{
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}
						
	
				}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
				
				/*JButton RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("Registrar");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);*/
			}
			{
				
				
				cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
	
					public void actionPerformed(ActionEvent e) {
				dispose();
						
					}
				});
				
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent e) {
					dispose();
					
					}
				});
				
				buttonPane.add(cancelButton);
			}
	}


private void clear() {
	
	txtNombre.setText("");
	textFieldCedula.setText("");
	textFieldDireccion.setText("");
	textFieldnumber.setText("");
	
	
}

}
