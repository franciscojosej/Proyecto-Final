package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Control;
import logico.Tricom;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Control temp = (Control)empresaRead.readObject();
					Control.setControl(temp);
					if(Control.getInstance().getMisUsers().get(0).getUserName().equalsIgnoreCase("Admin")) {
						Control.getInstance().getMisUsers().remove(0);
					}
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						User aux = new User("Administrador", "Admin", "Admin");
						Control.getInstance().regUser(aux);
						empresaWrite.writeObject(Control.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(39, 39, 72, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(39, 98, 105, 14);
		panel.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(39, 64, 191, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContrase = new JTextField();
		textContrase.setBounds(39, 128, 191, 20);
		panel.add(textContrase);
		textContrase.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		Image imag = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(imag));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Control.getInstance().confirmLogin(textUsuario.getText()
						,textContrase.getText())){
					// run();				
					VisualPrincipal frame = new VisualPrincipal();
					dispose();
					frame.setVisible(true);
				};
				
			}

			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("miTricom.dat");
					empresaRead = new ObjectInputStream(empresa);
					Tricom temp = (Tricom)empresaRead.readObject();
					Tricom.setTricom(temp);
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("miTricom.dat");
						empresaWrite = new ObjectOutputStream(empresa2);

						empresaWrite.writeObject(Tricom.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		btnLogin.setBounds(37, 175, 89, 23);
		panel.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(278, 64, 116, 131);
		panel.add(lblNewLabel);
	}
}
