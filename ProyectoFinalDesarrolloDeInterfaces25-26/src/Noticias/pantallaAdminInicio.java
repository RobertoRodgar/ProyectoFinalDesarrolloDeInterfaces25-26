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

public class pantallaAdminInicio extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JPanel panelCabecera;
	JLabel cabeceraAdmin;
	private JButton botonOpciones;
	private ImageIcon fotoUsuario = new ImageIcon("Extras/Imagenes/fotoUsuario.png");
	private JPanel panelOpciones;
	private JPanel panelCuerpo;
	JButton botonAcercaDe;
	JButton botonCerrarSesion;
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
		
		textotemp = new JLabel();
		textotemp.setBounds(42, 38, 89, 33);
		panelCuerpo.add(textotemp);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelOpciones, botonAcercaDe, botonCerrarSesion, textotemp}));
		
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		if(usuario != null) {
			textotemp.setText(usuario.getNombre());
		}
	}
}
