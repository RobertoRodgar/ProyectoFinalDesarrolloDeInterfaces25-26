package Noticias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class pantallaUsuario extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JPanel panelCabecera;
	private JLabel cabeceraUsuario;
	private JButton botonOpciones;
	private JPanel panelOpciones;
	private JButton botonSalir;
	private JButton botonCerrarSesion;
	private JButton botonNoticias;
	private JButton botonGuardarNoticias;
	Operaciones operaciones = new Operaciones();
	private ImageIcon fotoUsuario = new ImageIcon("Extras/Imagenes/fotoUsuario.png");
	public pantallaUsuario(Marco frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(218, 218, 218));
		panelOpciones.setBounds(627, 70, 145, 154);
		panelOpciones.setVisible(false);
		add(panelOpciones);
		panelOpciones.setLayout(null);
		
		botonSalir = new JButton("Salir");
		botonSalir.setForeground(new Color(74, 74, 74));
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonSalir.setBounds(18, 93, 109, 23);
		botonSalir.setContentAreaFilled(false);
		botonSalir.setBorder(null);
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);

				}
				
			}
		});
		panelOpciones.add(botonSalir);
		
		botonCerrarSesion = new JButton("Cerrar sesión");
		botonCerrarSesion.setForeground(new Color(74, 74, 74));
		botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCerrarSesion.setBounds(18, 36, 109, 23);
		botonCerrarSesion.setContentAreaFilled(false);
		botonCerrarSesion.setBorder(null);
		botonCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaInicio();
			}
		});
		panelOpciones.add(botonCerrarSesion);
		
		panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(128, 128, 128));
		panelCabecera.setBounds(0, 0, 800, 80);
		add(panelCabecera);
		panelCabecera.setLayout(null);
		
		cabeceraUsuario = new JLabel("Panel de Usuario");
		cabeceraUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		cabeceraUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		cabeceraUsuario.setBounds(10, 22, 211, 36);
		panelCabecera.add(cabeceraUsuario);
		
		botonOpciones = new JButton("");
		botonOpciones.setBounds(714, 11, 58, 58);
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setIcon(fotoUsuario);
		botonOpciones.setBorder(null);
		botonOpciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones.mostrarPanelOpciones(panelOpciones);
			}
		});
		panelCabecera.add(botonOpciones);
		
		botonNoticias = new JButton();
		botonNoticias.setText("Ver noticias");
		botonNoticias.setBounds(128, 220, 195, 113);
		botonNoticias.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaNoticias(usuario);
			}
		});
		add(botonNoticias);
		
		botonGuardarNoticias = new JButton();
		botonGuardarNoticias.setText("Guardar noticias");
		botonGuardarNoticias.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonGuardarNoticias.setBounds(456, 220, 195, 113);
		botonGuardarNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					operaciones.guardarNoticias(usuario);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(botonGuardarNoticias);
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
