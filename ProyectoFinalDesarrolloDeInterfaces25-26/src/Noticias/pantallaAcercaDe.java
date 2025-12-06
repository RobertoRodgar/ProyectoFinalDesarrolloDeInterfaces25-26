package Noticias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class pantallaAcercaDe extends JPanel {
	private JFrame framePrincipal;
	private JLabel textoVersion;
	private JLabel textoDesarrollador;
	JButton botonVolver;
	public pantallaAcercaDe(Marco frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		textoVersion = new JLabel();
		textoVersion.setFont(new Font("Tahoma", Font.BOLD, 20));
		textoVersion.setHorizontalAlignment(SwingConstants.CENTER);
		textoVersion.setText("Version actual de la aplicación: " + getClass().getPackage().getImplementationVersion());
		textoVersion.setBounds(210, 130, 402, 107);
		add(textoVersion);
		
		textoDesarrollador = new JLabel();
		textoDesarrollador.setHorizontalAlignment(SwingConstants.CENTER);
		textoDesarrollador.setText("Desarrollado por: Roberto Rodíguez García");
		textoDesarrollador.setBounds(178, 258, 451, 113);
		textoDesarrollador.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(textoDesarrollador);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonVolver.setBounds(345, 406, 149, 38);
		botonVolver.setContentAreaFilled(false);
		botonVolver.setBorder(null);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaAdminVolver();;
				
			}
		});
		add(botonVolver);
	}
}
