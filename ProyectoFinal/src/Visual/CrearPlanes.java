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

import logico.Plan;
import logico.Tricom;

import javax.swing.JLabel;
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
			
			JLabel lblNewLabel = new JLabel("Codigo:");
			lblNewLabel.setBounds(10, 23, 176, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(10, 55, 42, 20);
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
			rdbtnNewRadioButton.setBounds(6, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cable.");
			rdbtnNewRadioButton_1.setBounds(127, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Telefono.");
			rdbtnNewRadioButton_2.setBounds(249, 39, 109, 23);
			panel_1.add(rdbtnNewRadioButton_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 263, 379, 97);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Data(MB)");
			lblNewLabel_2.setBounds(10, 11, 110, 14);
			panel_2.add(lblNewLabel_2);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Cantidad>", "5MB", "15MB", "50MB", "100MB", "1GB", "ilimitado"}));
			comboBox.setBounds(10, 33, 110, 20);
			panel_2.add(comboBox);
			
			JLabel lblNewLabel_3 = new JLabel("Canales");
			lblNewLabel_3.setBounds(130, 11, 110, 14);
			panel_2.add(lblNewLabel_3);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Variedad>", "Canales Premium ", "Paquete de Adultos", "Entretenimiento", "Otros"}));
			comboBox_1.setBounds(130, 33, 110, 20);
			panel_2.add(comboBox_1);
			
			JLabel lblNewLabel_4 = new JLabel("Minutos");
			lblNewLabel_4.setBounds(250, 11, 104, 14);
			panel_2.add(lblNewLabel_4);
			
			JComboBox comboBox_2 = new JComboBox();
		    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Plan Minutos>", "50 Minutos", "100 Minutos ", "300 Minutos ", "1000 Minutos", "Minutos ilimitado"}));
			comboBox_2.setBounds(250, 33, 119, 20);
			panel_2.add(comboBox_2);
			
			JLabel lblNewLabel_5 = new JLabel("Precio:");
			lblNewLabel_5.setBounds(13, 381, 68, 14);
			panel.add(lblNewLabel_5);
			
			textField_2 = new JTextField();
			textField_2.setBounds(64, 378, 106, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Data ilimitada", "Canales Premium", "Minutos ilimitado", "Otros"}));
			comboBox_3.setBounds(10, 112, 189, 20);
			panel.add(comboBox_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
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
