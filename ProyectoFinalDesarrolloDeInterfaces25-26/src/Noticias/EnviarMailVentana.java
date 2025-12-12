package Noticias;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JFrame;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EnviarMailVentana {

	private JFrame frame;
	private JTextField textField;
	final String fromEmail = "roberto.rodriguez.dosa@gmail.com"; // EMAIL DE SALIDA
	final String password = "nmjr dsvk trib uddx"; // CONTRASEÑA DEL EMAIL DE SALIDA (aplicaciones de 3ros) Contraseñas
													// de aplicación -- Verificación en 2 pasos
	final String toEmail = "sebastian.silva1.dosa@gmail.com"; // EMAIL DESTINATARIO

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarMailVentana window = new EnviarMailVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnviarMailVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Enviar mail");
		btnNewButton.setBounds(80, 114, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP de GMAIL en este caso
				props.put("mail.smtp.socketFactory.port", "465"); // PUERTO SSL
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
				props.put("mail.smtp.auth", "true"); // ACTIVAR SMTP AUTENTIFICACI�N
				props.put("mail.smtp.port", "465"); // SMTP Port
				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};
				Session session = Session.getDefaultInstance(props, auth);// CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y
																			// EL "LOGIN"
				System.out.println("Sesión Creada");

				EmailUtil.sendEmail(session, toEmail, "ASUNTO ventana", "MENSAJE/CUERPO");
				textField.setText("Mensaje enviado!!");

				// SimpleEmail.main(null);
			}
		});
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(202, 116, 139, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}
