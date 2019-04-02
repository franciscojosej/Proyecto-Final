package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.CableTV;
import logico.Celular;
import logico.Contrato;
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
	private JTextField textNombre;
	private JComboBox cbxData;
	private JComboBox cbxCanales;
	private JComboBox comboBox_2;
	   private JComboBox cbxMinutos ;

	   private JPanel panelData;
	   private JPanel panelMinutos;
	   private JPanel panelCanales;
	
	   private JRadioButton rdbtnTelevicion;
	   private JRadioButton rdbtnInternet;
	   private JRadioButton rdbtnTelefono;
	
	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;
	 private  Internet 	aux =null;
	 private  CableTV aux2=null;
	 private  Celular aux3=null;
	 private  float costoTotal=0;

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
		setBounds(100, 100, 407, 500);
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
			
				
		   txtCodigo.setText("P-" + (Tricom.PlanesCod+1));
			
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre Del Plan:");
			lblNewLabel_1.setBounds(10, 87, 176, 14);
			panel.add(lblNewLabel_1);
			
			textNombre = new JTextField();
			textNombre.setBounds(10, 104, 181, 20);
			panel.add(textNombre);
			textNombre.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo De Servicio", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 155, 379, 97);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			 rdbtnInternet = new JRadioButton("Internet.");
			rdbtnInternet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//panelData.setVisible(false);
				//	panelCanales.setVisible(false);
				//	panelMinutos.setVisible(false);
					
					
					if(rdbtnTelefono.isSelected()) {
						panelMinutos.setVisible(true);
					}else {
						panelMinutos.setVisible(false);
					}
					if(rdbtnTelevicion.isSelected()) {
						panelCanales.setVisible(true);
					}else {
						panelCanales.setVisible(false);
					}
					if(rdbtnInternet.isSelected()) {
						panelData.setVisible(true);
					}else {
						panelData.setVisible(false);	
					}
					
					
				}
			});
			rdbtnInternet.setBounds(6, 39, 109, 23);
			panel_1.add(rdbtnInternet);
			
			 rdbtnTelevicion = new JRadioButton("Televisi\u00F3n.");
			rdbtnTelevicion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//panelData.setVisible(false);
					//panelCanales.setVisible(false);
					//panelMinutos.setVisible(false);
					
					if(rdbtnInternet.isSelected()) {
						panelData.setVisible(true);
					}else {
						panelData.setVisible(false);	
					}
					if(rdbtnTelefono.isSelected()) {
						panelMinutos.setVisible(true);
					}else {
						panelMinutos.setVisible(false);
					}
					if(rdbtnTelevicion.isSelected()) {
						panelCanales.setVisible(true);
					}else {
						panelCanales.setVisible(false);
					}
					
					
					
				}
			});
			rdbtnTelevicion.setBounds(127, 39, 109, 23);
			panel_1.add(rdbtnTelevicion);
			
			 rdbtnTelefono = new JRadioButton("Tel\u00E9fono.");
			rdbtnTelefono.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					////panelData.setVisible(false);
					//panelCanales.setVisible(false);
					//panelMinutos.setVisible(false);
					
					if(rdbtnInternet.isSelected()) {
						panelData.setVisible(true);
					}else {
						panelData.setVisible(false);	
					}
					
					if(rdbtnTelevicion.isSelected()) {
						panelCanales.setVisible(true);
					}else {
						panelCanales.setVisible(false);
					}
					if(rdbtnTelefono.isSelected()) {
						panelMinutos.setVisible(true);
					}else {
						panelMinutos.setVisible(false);
					}
					

				}
			});
			rdbtnTelefono.setBounds(249, 39, 109, 23);
			panel_1.add(rdbtnTelefono);
			
			panelData = new JPanel();
			panelData.setBounds(0, 263, 124, 97);
			panel.add(panelData);
			panelData.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Data(MB)");
			lblNewLabel_2.setBounds(10, 11, 110, 14);
			panelData.add(lblNewLabel_2);
		    
		    cbxData = new JComboBox();
		    cbxData.setBounds(10, 36, 110, 20);
		    panelData.add(cbxData);
		    cbxData.setModel(new DefaultComboBoxModel(new String[] {"<Cantidad>", "5MB", "15MB", "50MB", "100MB", "1GB", "ilimitado"}));
		      
		       panelMinutos = new JPanel();
		       panelMinutos.setBounds(245, 263, 132, 97);
		       panel.add(panelMinutos);
		       panelMinutos.setLayout(null);
		       
		     cbxMinutos = new JComboBox();
		       cbxMinutos.setBounds(10, 36, 119, 20);
		       panelMinutos.add(cbxMinutos);
		       cbxMinutos.setModel(new DefaultComboBoxModel(new String[] {"<Plan Minutos>", "50 Minutos", "100 Minutos ", "300 Minutos ", "1000 Minutos", "Minutos ilimitado"}));
		       
		       JLabel lblNewLabel_4 = new JLabel("Minutos");
		       lblNewLabel_4.setBounds(10, 11, 104, 14);
		       panelMinutos.add(lblNewLabel_4);
		       
		       panelCanales = new JPanel();
		       panelCanales.setBounds(123, 263, 124, 97);
		       panel.add(panelCanales);
		       panelCanales.setLayout(null);
		       
		        cbxCanales = new JComboBox();
		        cbxCanales.setModel(new DefaultComboBoxModel(new String[] {"<Variedad>", "Canales Premium ", "Paquete de Adultos", "Entretenimiento", "Otros"}));
		        cbxCanales.setBounds(10, 36, 110, 20);
		        panelCanales.add(cbxCanales);
		        
		        JLabel lblNewLabel_3 = new JLabel("Canales");
		        lblNewLabel_3.setBounds(11, 11, 109, 14);
		        panelCanales.add(lblNewLabel_3);
				panelData.setVisible(false);
				panelMinutos.setVisible(false);
				panelCanales.setVisible(false);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						
						if(!textNombre.getText().equalsIgnoreCase("") && !txtCodigo.getText().equalsIgnoreCase("")){
		

						
							
						String nombre = textNombre.getText();
						
						int codigo = Tricom.PlanesCod;
						
						
						
						if(rdbtnInternet.isSelected()){
							int velocidad_conexion =0;
									
							if(cbxData.getSelectedIndex()==1) {
								velocidad_conexion=5;
							}
							if(cbxData.getSelectedIndex()==2) {
								velocidad_conexion=15;
							}
							
							if(cbxData.getSelectedIndex()==3) {
								velocidad_conexion=50;
							}
							if(cbxData.getSelectedIndex()==4) {
								velocidad_conexion=100;
							}
							if(cbxData.getSelectedIndex()==5) {
								velocidad_conexion=1000;
							}
							if(cbxData.getSelectedIndex()==6) {
								velocidad_conexion=5000;
							}
							
							
							aux = new Internet(codigo, nombre, velocidad_conexion);
						
							
						}
						if(rdbtnTelevicion.isSelected()){
							
							int cantidadCanales = 0;
							
							
						if(cbxCanales.getSelectedIndex()==1) {
							cantidadCanales=200;
							}
						if(cbxCanales.getSelectedIndex()==2) {
							cantidadCanales=400;
							}	
						if(cbxCanales.getSelectedIndex()==3) {
							cantidadCanales=100;
							}
						if(cbxCanales.getSelectedIndex()==4) {
							cantidadCanales=400;
							}
							aux2 = new CableTV(codigo, nombre, cantidadCanales);
							
						}
						if(rdbtnTelefono.isSelected()){
							int minutos =0;
									
							if(cbxMinutos.getSelectedIndex()==1) {
								minutos=50;
							}
							if(cbxMinutos.getSelectedIndex()==2) {
								minutos=100;
							}		
							if(cbxMinutos.getSelectedIndex()==3) {
								minutos=300;
							}
							if(cbxMinutos.getSelectedIndex()==4) {
								minutos=1000;
							}
							if(cbxMinutos.getSelectedIndex()==5) {
								minutos=2000;
							}							
							aux3 = new Celular(codigo, nombre, minutos);
						
						}
						if(aux!=null) {
							
							
							costoTotal+=aux.CalcularCosto();
						}
							
					
						if(aux2!=null) {
							
							costoTotal+=aux2.CalcularCosto();
						}
							
						if(aux3!=null) {
							
							costoTotal+=aux3.CalcularCosto();

						
						}
	
		
						
						
						int  num= JOptionPane.showConfirmDialog(null, "Costo Del Plan: "+costoTotal, "Crear", JOptionPane.YES_NO_OPTION);

						if(num==0)
								 {

							
							if(aux!=null) {
								
								Tricom.getInstance().insertarPlan(aux);
								
							}
								
						
							if(aux2!=null) {
								Tricom.getInstance().insertarPlan(aux2);
							
							}
								
							if(aux3!=null) {
								Tricom.getInstance().insertarPlan(aux3);
							

							
							}
						//	JOptionPane.showMessageDialog(null, "Plan registrado satisfactoriamente", 
							//		null, JOptionPane.INFORMATION_MESSAGE, null);
							++Tricom.PlanesCod;
							
						}else {
							 	aux =null;
							 aux2=null;
							    aux3=null;
						 costoTotal=0;
						}
						
						
					
					
						
					
						
						clear();
						}else{
							JOptionPane.showMessageDialog(null, "Verifique los campos", null, JOptionPane.ERROR_MESSAGE, null);
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
		//textField_2.setText("P-"+Tricom.PlanesCod+1);
		textNombre.setText("");
		txtCodigo.setText("P-"+(Tricom.PlanesCod+1));
		cbxData.setSelectedIndex(0);
		cbxCanales.setSelectedIndex(0);
		cbxMinutos.setSelectedIndex(0);

		
		
	}
}
