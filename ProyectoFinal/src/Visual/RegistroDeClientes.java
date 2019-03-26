
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
import logico.Facturacion;
import logico.Persona;
import logico.Cliente;
import logico.Tricom;
import logico.Plan;



public class RegistroDeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFormattedTextField formattedTextField;
	private static Cliente cliente;
	private JTextField textFieldnumber;
	private JTextField textFieldCedula;
	private JTextField textFieldDireccion;

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
		cliente = cli;{
			
		}
		setTitle("Registro de Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 434, 217);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblRegistroClientes = new JLabel("Datos Del Clientes");
			lblRegistroClientes.setBounds(10, 0, 111, 14);
			panel.add(lblRegistroClientes);
		}
		{
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 36, 46, 14);
			panel.add(lblNewLabel);
		}
		{
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(10, 56, 149, 20);
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
			JLabel lblNewLabel_3 = new JLabel("Cedula:");
			lblNewLabel_3.setBounds(253, 87, 46, 14);
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegistrarButton = new JButton("Registrar");
				RegistrarButton.setActionCommand("Registrar");
				buttonPane.add(RegistrarButton);
				getRootPane().setDefaultButton(RegistrarButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
}
}
