package Noticias;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class pantallaUsuario extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JButton botonNoticias;
	public pantallaUsuario(Marco frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		botonNoticias = new JButton();
		botonNoticias.setText("Ver noticias");
		botonNoticias.setBounds(310, 220, 195, 113);
		botonNoticias.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaNoticias(usuario);
			}
		});
		add(botonNoticias);
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
