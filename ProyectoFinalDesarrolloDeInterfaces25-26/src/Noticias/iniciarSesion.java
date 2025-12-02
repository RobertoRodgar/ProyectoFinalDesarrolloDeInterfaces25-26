package Noticias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.ArrayList;

public class iniciarSesion extends JPanel{
	private JFrame framePrincipal;
	public iniciarSesion(JFrame frame, ArrayList<Usuario> listaUsuarios) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		JLabel titulo = new JLabel("Iniciar Sesión");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setLocation(340, 55);
		titulo.setSize(114,20);
		add(titulo);
		
		JLabel usuarioTitulo = new JLabel("Introduce tu usuario:");
		usuarioTitulo.setBounds(309, 125, 108, 27);
		add(usuarioTitulo);
		
		
		JTextField campoUsuario = new JTextField();
		campoUsuario.setBounds(309, 150, 165, 32);
		add(campoUsuario);
		
		JLabel contrasenaTitulo = new JLabel("Introduce tu contraseña:");
		contrasenaTitulo.setBounds(309, 206, 128, 27);
		add(contrasenaTitulo);
		
		JTextField campoContrasena = new JTextField();
		campoContrasena.setBounds(309, 231, 165, 32);
		add(campoContrasena);
	}
}
