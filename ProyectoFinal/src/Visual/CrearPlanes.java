package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.CableTV;
import logico.Celular;
import logico.Internet;
import logico.Plan;
import logico.Tricom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CrearPlanes extends JDialog {

	private static final String Plans = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField textField_2;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearPlanes dialog = new CrearPlanes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPlanes() {
		setBounds(100, 100, 425, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos De Los Planes ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo Del Plan:");
			lblNewLabel.setBounds(10, 23, 176, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(10, 42, 42, 20);
			if(Plans == null) {
				
				 txtCodigo.setText("P-" + (Tricom.PlanesCod+1));
			}
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre Del Plan:");
			lblNewLabel_1.setBounds(10, 87, 176, 14);
			panel.add(lblNewLabel_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo De Servicio", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 155, 379, 97);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Internet.");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnNewRadioButton.setSelected(true);
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					panel_2.setVisible(true);
					panel_3.setVisible(false);
					panel_4.setVisible(false);
				}
			});
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton.setBounds(6, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Televisi\u00F3n.");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(true);
					rdbtnNewRadioButton_2.setSelected(false);
					panel_2.setVisible(false);
					panel_3.setVisible(true);
					panel_4.setVisible(false);
					
				}
			});
			rdbtnNewRadioButton_1.setBounds(127, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Tel\u00E9fono.");
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(true);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
					panel_4.setVisible(true);
				}
			});
			rdbtnNewRadioButton_2.setBounds(249, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 263, 379, 97);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Data(MB)");
			lblNewLabel_2.setBounds(10, 11, 110, 14);
			panel_2.add(lblNewLabel_2);
			
		    comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Cantidad>", "5MB", "15MB", "50MB", "100MB", "1GB", "ilimitado"}));
			comboBox.setBounds(10, 33, 110, 20);
			panel_2.add(comboBox);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 263, 379, 97);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Canales");
			lblNewLabel_3.setBounds(130, 11, 110, 14);
			panel_3.add(lblNewLabel_3);
			
			 comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Variedad>", "Canales Premium ", "Paquete de Adultos", "Entretenimiento", "Otros"}));
			comboBox_1.setBounds(130, 33, 110, 20);
			panel_3.add(comboBox_1);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 263, 379, 97);
			panel.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Minutos");
			lblNewLabel_4.setBounds(250, 11, 104, 14);
			panel_4.add(lblNewLabel_4);
			
			JComboBox comboBox_2 = new JComboBox();
		    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Plan Minutos>", "50 Minutos", "100 Minutos ", "300 Minutos ", "1000 Minutos", "Minutos ilimitado"}));
			comboBox_2.setBounds(250, 33, 119, 20);
			panel_4.add(comboBox_2);
			
			JLabel lblNewLabel_5 = new JLabel("Precio Total:");
			lblNewLabel_5.setBounds(13, 381, 124, 14);
			panel.add(lblNewLabel_5);
			
			textField_2 = new JTextField();
			textField_2.setBounds(94, 378, 76, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			textField = new JTextField();
			textField.setBounds(10, 104, 181, 20);
			panel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!textField.getText().equalsIgnoreCase("")){
		
						Plan aux = null;
						String nombre = new Integer(textField.getText());
						int codigo = new Integer(txtCodigo.getText());
						
						if(rdbtnNewRadioButton.isSelected()){
							int velocidad_conexion = new Integer(comboBox.getName().toString());
							aux = new Internet(codigo, nombre, velocidad_conexion);
							
						}
						if(rdbtnNewRadioButton_1.isSelected()){
							
							int cantidadCanales = new Integer(comboBox_1.getName().toString());
							aux = new CableTV(codigo, nombre, cantidadCanales);
							
						}
						if(rdbtnNewRadioButton_2.isSelected()){
							int minutos = new Integer(comboBox_2.getName().toString());
							aux = new Celular(codigo, nombre, minutos);
						}
						Tricom.getInstance().insertarPlan(aux);
						JOptionPane.showMessageDialog(null, "Queso registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						clear();
						}else{
							JOptionPane.showMessageDialog(null, "Verifique todos los campos", null, JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
				okButton.setActionCommand("Registrar");
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
	
	private void clear() {
		
		textField.setText("");
		txtCodigo.setText("");
		comboBox.setToolTipText("");
		comboBox_1.setToolTipText("");
		comboBox_2.setToolTipText("");
		
		
	}
}
