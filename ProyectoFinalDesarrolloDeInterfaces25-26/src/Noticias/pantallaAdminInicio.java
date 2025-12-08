package Noticias;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;

public class pantallaAdminInicio extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JPanel panelCabecera;
	private JLabel cabeceraAdmin;
	private JButton botonOpciones;
	private ImageIcon fotoUsuario = new ImageIcon("Extras/Imagenes/fotoUsuario.png");
	private JPanel panelOpciones;
	private JPanel panelCuerpo;
	private JButton botonAcercaDe;
	private JButton botonCerrarSesion;
	private JButton botonGestionarUsuarios;
	private JButton botonVerNoticias;
	private JPanel panelGestionarUsuario;
	private JLabel tituloPregunta;
	private JButton botonCrear;
	private JButton botonBorrar;
	private JPanel panelCrear;
	private JLabel titulosCrear;
	private JTextField textosCrear;
	private JButton botonSiguienteCrear;
	private JPanel panelBorrar;
	private JLabel titulosBorrar;
	private JTextField textosBorrar;
	private JButton botonSiguienteBorrar;
	private Operaciones operaciones = new Operaciones();
	private JLabel textotemp;
	public pantallaAdminInicio(Marco frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(218, 218, 218));
		panelOpciones.setBounds(627, 70, 145, 154);
		panelOpciones.setVisible(false);
		add(panelOpciones);
		panelOpciones.setLayout(null);
		
		botonAcercaDe = new JButton("Acerca de");
		botonAcercaDe.setForeground(new Color(74, 74, 74));
		botonAcercaDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonAcercaDe.setBounds(18, 36, 109, 23);
		botonAcercaDe.setContentAreaFilled(false);
		botonAcercaDe.setBorder(null);
		panelOpciones.add(botonAcercaDe);
		
		botonCerrarSesion = new JButton("Cerrar sesión");
		botonCerrarSesion.setForeground(new Color(74, 74, 74));
		botonCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCerrarSesion.setBounds(18, 93, 109, 23);
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
		
		cabeceraAdmin = new JLabel("Panel de Administración");
		cabeceraAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		cabeceraAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		cabeceraAdmin.setBounds(10, 22, 211, 36);
		botonAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaAcercaDe();
				
			}
		});
		panelCabecera.add(cabeceraAdmin);
		
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
		
		panelCuerpo = new JPanel();
		panelCuerpo.setBorder(null);
		panelCuerpo.setBounds(0, 80, 800, 520);
		add(panelCuerpo);
		panelCuerpo.setLayout(null);
		
		panelGestionarUsuario = new JPanel();
		panelGestionarUsuario.setBackground(new Color(192, 192, 192));
		panelGestionarUsuario.setBounds(201, 106, 385, 244);
		panelGestionarUsuario.setLayout(null);
		panelGestionarUsuario.setVisible(false);
		panelCuerpo.add(panelGestionarUsuario);
		
		panelCrear = new JPanel();
		panelCrear.setBackground(new Color(192, 192, 192));
		panelCrear.setBounds(0, 0, 385, 244);
		panelCrear.setLayout(null);
		panelCrear.setVisible(false);
		panelGestionarUsuario.add(panelCrear);
		
		titulosCrear = new JLabel("");
		titulosCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulosCrear.setHorizontalAlignment(SwingConstants.CENTER);
		titulosCrear.setBounds(90, 26, 210, 35);
		panelCrear.add(titulosCrear);
		
		textosCrear = new JTextField();
		textosCrear.setBounds(90, 101, 210, 35);
		panelCrear.add(textosCrear);
		textosCrear.setColumns(10);
		
		botonSiguienteCrear = new JButton("Siguiente");
		botonSiguienteCrear.setBounds(150, 171, 89, 23);
		panelCrear.add(botonSiguienteCrear);
		
		panelBorrar = new JPanel();
		panelBorrar.setBackground(new Color(192, 192, 192));
		panelBorrar.setBounds(0, 0, 385, 244);
		panelBorrar.setLayout(null);
		panelBorrar.setVisible(false);
		panelGestionarUsuario.add(panelBorrar);
		
		titulosBorrar = new JLabel("New label");
		titulosBorrar.setBounds(90, 26, 210, 35);
		panelBorrar.add(titulosBorrar);
		
		textosBorrar = new JTextField();
		textosBorrar.setBounds(90, 101, 210, 35);
		panelBorrar.add(textosBorrar);
		textosBorrar.setColumns(10);
		
		botonSiguienteBorrar = new JButton("New button");
		botonSiguienteBorrar.setBounds(150, 171, 89, 23);
		panelBorrar.add(botonSiguienteBorrar);
		
		tituloPregunta = new JLabel("¿Que quieres hacer?");
		tituloPregunta.setFont(new Font("Tahoma", Font.BOLD, 14));
		tituloPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPregunta.setBounds(82, 11, 217, 50);
		panelGestionarUsuario.add(tituloPregunta);
		
		botonCrear = new JButton("Crear");
		botonCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCrear.setBounds(32, 96, 134, 77);
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones.mostrarPanelCrear(panelCrear);
			}
		});
		panelGestionarUsuario.add(botonCrear);
		
		botonBorrar = new JButton("Borrar");
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBorrar.setBounds(220, 96, 134, 77);
		botonBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones.mostrarPanelBorrar(panelBorrar);
			}
		});
		panelGestionarUsuario.add(botonBorrar);
		
		textotemp = new JLabel();
		textotemp.setBounds(42, 38, 89, 33);
		panelCuerpo.add(textotemp);
		
		botonGestionarUsuarios = new JButton("Gestionar usuarios");
		botonGestionarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonGestionarUsuarios.setBounds(128, 171, 195, 113);
		botonGestionarUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones.mostrarPanelGestion(panelGestionarUsuario);
			}
		});
		panelCuerpo.add(botonGestionarUsuarios);
		
		botonVerNoticias = new JButton("Ver noticias");
		botonVerNoticias.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonVerNoticias.setBounds(469, 171, 195, 113);
		panelCuerpo.add(botonVerNoticias);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelOpciones, botonAcercaDe, botonCerrarSesion, panelGestionarUsuario, tituloPregunta, botonCrear, botonBorrar, panelCrear, panelBorrar, titulosCrear, textosCrear, botonSiguienteCrear, titulosBorrar, textosBorrar, botonSiguienteBorrar}));
		
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		if(usuario != null) {
			textotemp.setText(usuario.getNombre());
		}
	}
}
