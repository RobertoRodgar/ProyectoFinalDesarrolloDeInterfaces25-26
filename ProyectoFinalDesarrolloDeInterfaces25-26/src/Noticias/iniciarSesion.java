package Noticias;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class iniciarSesion extends JPanel{
	private JLabel titulo;
	private JLabel usuarioTitulo;
	private JTextField campoUsuario;
	private JLabel contrasenaTitulo;
	private JPasswordField campoContrasena;
	private JButton botonIniciarSesion;
	private Operaciones operaciones = new Operaciones();

	private JButton botonOcultarContrasena;
	private ImageIcon mostrar = new ImageIcon("Extras/Imagenes/OjoAbierto.png");
	private Usuario usuarioIniciado;
	JLabel errorInicio;
	
	public iniciarSesion(Marco frame, ArrayList<Usuario> listaUsuarios) {
		setBounds(100,100,800,600);
		setLayout(null);
		
		titulo = new JLabel("Iniciar Sesión");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		titulo.setLocation(309, 55);
		titulo.setSize(165,20);
		add(titulo);
		
		usuarioTitulo = new JLabel("Introduce tu usuario:");
		usuarioTitulo.setBounds(309, 125, 145, 27);
		add(usuarioTitulo);
		
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(309, 150, 165, 32);
		add(campoUsuario);
		
		contrasenaTitulo = new JLabel("Introduce tu contraseña:");
		contrasenaTitulo.setBounds(309, 206, 145, 27);
		add(contrasenaTitulo);
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(309, 231, 120, 32);
		char caracter = '•';
		campoContrasena.setEchoChar(caracter);
		add(campoContrasena);
		
		botonOcultarContrasena = new JButton("");
		botonOcultarContrasena.setBounds(434, 231, 40, 32);
		botonOcultarContrasena.setIcon(mostrar);
		botonOcultarContrasena.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        operaciones.ocultarContraseña(campoContrasena, caracter, botonOcultarContrasena);
		    }
		});
		add(botonOcultarContrasena);
		
		errorInicio = new JLabel("");
		errorInicio.setForeground(new Color(255, 0, 0));
		errorInicio.setHorizontalAlignment(SwingConstants.CENTER);
		errorInicio.setBounds(246, 304, 296, 14);
		add(errorInicio);
		
		botonIniciarSesion = new JButton("INICIAR SESIÓN");
		botonIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonIniciarSesion.setForeground(new Color(255, 255, 255));
		botonIniciarSesion.setBackground(new Color(0, 128, 255));
		botonIniciarSesion.setBounds(309, 327, 165, 32);
		botonIniciarSesion.setFocusPainted(false);
		botonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = campoUsuario.getText();
				String contrasena = new String(campoContrasena.getPassword());
				usuarioIniciado = operaciones.comprobarUsuario(nombreUsuario, contrasena, listaUsuarios);
				if(usuarioIniciado == null) {
					errorInicio.setText("Error. El usuario o la contraseña no son correctos.");
				}else if(usuarioIniciado.getEsAdmin()) {
					errorInicio.setText("");
					frame.mostrarPantallaAdmin(usuarioIniciado);
				}else if(!usuarioIniciado.getEsAdmin()){
					errorInicio.setText("");
					if(usuarioIniciado.getInicio() == 0) {
						frame.mostrarPantallaGuardarPreferencias(usuarioIniciado);
					}else {
						frame.mostrarPantallaUsuario(usuarioIniciado);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado...");
				}
			}
		});
		add(botonIniciarSesion);
		
		
		
	}
}
