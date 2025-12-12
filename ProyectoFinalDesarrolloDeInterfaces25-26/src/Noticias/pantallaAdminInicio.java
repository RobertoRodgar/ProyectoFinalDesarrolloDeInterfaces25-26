package Noticias;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;

public class pantallaAdminInicio extends JPanel {
	private JFrame framePrincipal;
	private Usuario usuario;
	private JPanel panelCabecera;
	private JLabel cabeceraAdmin;
	private JButton botonOpciones;
	private ImageIcon fotoUsuario = new ImageIcon("Extras/Imagenes/fotoUsuario.png");
	private JPanel panelOpciones;
	private JPanel panelCuerpo;
	private JButton botonSalir;
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
	private JLabel textoError;
	private JButton botonVolver;
	private Operaciones operaciones = new Operaciones();
	private JLabel textotemp;
	private int contador = 0;
	private JButton botonCerrarCrear;
	private JButton botonCerrarBorrar;
	private JLabel textoErrorBorrar;
	private JButton botonProbarMail;
	private JButton botonVerDatos;

	public pantallaAdminInicio(Marco frame, ArrayList<Usuario> listaUsuarios) {
		this.framePrincipal = frame;
		setBounds(100, 100, 800, 600);
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

		cabeceraAdmin = new JLabel("Panel de Administración");
		cabeceraAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		cabeceraAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		cabeceraAdmin.setBounds(10, 22, 211, 36);
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

		titulosCrear = new JLabel("Introduce el correo:");
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
		botonSiguienteCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contador >= 3) {
					String linea;
					linea = operaciones.agregarUsuario(contador, textosCrear, titulosCrear, textoError, listaUsuarios);
					if (linea != null) {
						operaciones.escribirNuevoUsuario(linea);
						contador = 0;
					}
				} else if (contador <= 2) {
					operaciones.agregarUsuario(contador, textosCrear, titulosCrear, textoError, listaUsuarios);
					if (!textoError.getText().equals("ERROR. El nombre de usuario no puede tener ;")
							&& !textoError.getText().equals("ERROR. El correo debe llevar un @ y un .") &&
							!textoError.getText().equals("ERROR. Ese correo ya está en uso.")
							&& !textoError.getText().equals("ERROR. La contraseña no puede tener ;")) {
						contador += 1;
					}
				}

			}
		});
		panelCrear.add(botonSiguienteCrear);

		textoError = new JLabel("");
		textoError.setBounds(52, 147, 299, 21);
		panelCrear.add(textoError);

		botonCerrarCrear = new JButton("Cerrar");
		botonCerrarCrear.setBounds(296, 221, 89, 23);
		botonCerrarCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCrear.setVisible(false);
				botonCrear.setVisible(true);
				botonBorrar.setVisible(true);
				contador = 0;
			}
		});
		panelCrear.add(botonCerrarCrear);

		panelBorrar = new JPanel();
		panelBorrar.setBackground(new Color(192, 192, 192));
		panelBorrar.setBounds(0, 0, 385, 244);
		panelBorrar.setLayout(null);
		panelBorrar.setVisible(false);
		panelGestionarUsuario.add(panelBorrar);

		titulosBorrar = new JLabel("Introduce el usuario de la persona que quieres borrar:");
		titulosBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		titulosBorrar.setBounds(32, 26, 321, 35);
		panelBorrar.add(titulosBorrar);

		textosBorrar = new JTextField();
		textosBorrar.setBounds(90, 101, 210, 35);
		panelBorrar.add(textosBorrar);
		textosBorrar.setColumns(10);

		botonSiguienteBorrar = new JButton("Borrar");
		botonSiguienteBorrar.setBounds(150, 171, 89, 23);
		botonSiguienteBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operaciones.borrarUsuario(textoErrorBorrar, textosBorrar, listaUsuarios, usuario);
			}
		});
		panelBorrar.add(botonSiguienteBorrar);

		botonCerrarBorrar = new JButton("Cerrar");
		botonCerrarBorrar.setBounds(296, 221, 89, 23);
		botonCerrarBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelBorrar.setVisible(false);
				botonCrear.setVisible(true);
				botonBorrar.setVisible(true);
			}
		});
		panelBorrar.add(botonCerrarBorrar);

		textoErrorBorrar = new JLabel("");
		textoErrorBorrar.setHorizontalAlignment(SwingConstants.CENTER);
		textoErrorBorrar.setBounds(10, 147, 365, 21);
		panelBorrar.add(textoErrorBorrar);

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
				botonCrear.setVisible(false);
				botonBorrar.setVisible(false);
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
				botonCrear.setVisible(false);
				botonBorrar.setVisible(false);
				operaciones.mostrarPanelBorrar(panelBorrar);
			}
		});
		panelGestionarUsuario.add(botonBorrar);

		botonVolver = new JButton("Volver");
		botonVolver.setBounds(296, 221, 89, 23);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelGestionarUsuario.setVisible(false);
				botonGestionarUsuarios.setVisible(true);
				botonVerNoticias.setVisible(true);
				botonVerDatos.setVisible(true);
				botonProbarMail.setVisible(true);
			}
		});
		panelGestionarUsuario.add(botonVolver);

		textotemp = new JLabel();
		textotemp.setBounds(42, 38, 89, 33);
		panelCuerpo.add(textotemp);

		botonGestionarUsuarios = new JButton("Gestionar usuarios");
		botonGestionarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonGestionarUsuarios.setBounds(128, 110, 195, 113);
		botonGestionarUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botonGestionarUsuarios.setVisible(false);
				botonVerNoticias.setVisible(false);
				botonProbarMail.setVisible(false);
				botonVerDatos.setVisible(false);
				operaciones.mostrarPanelGestion(panelGestionarUsuario);
			}
		});
		panelCuerpo.add(botonGestionarUsuarios);

		botonVerNoticias = new JButton("Ver noticias");
		botonVerNoticias.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonVerNoticias.setBounds(469, 110, 195, 113);
		botonVerNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaNoticias(usuario);
			}
		});
		panelCuerpo.add(botonVerNoticias);

		botonProbarMail = new JButton("Enviar mail prueba");
		botonProbarMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonProbarMail.setBounds(128, 240, 195, 113);
		botonProbarMail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cuerpo = "";
				try {
					cuerpo = SimpleEmail.cuerpoMensaje(usuario);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al generar cuerpo del mensaje: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				String toEmail = usuario.getEmail();
				SimpleEmail.enviarNoticias(toEmail, cuerpo);

			}
		});
		panelCuerpo.add(botonProbarMail);

		botonVerDatos = new JButton("Ver datos email");
		botonVerDatos.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonVerDatos.setBounds(469, 240, 195, 113);
		botonVerDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, operaciones.obtenerHora(), "Hora envio", 1);
				JOptionPane.showMessageDialog(frame, operaciones.obtenerFrom(), "Correo de envío", 1);
			}
		});
		panelCuerpo.add(botonVerDatos);
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { panelOpciones, botonSalir, botonCerrarSesion, panelGestionarUsuario, panelCrear,
						titulosCrear, textosCrear, botonSiguienteCrear, textoError, botonVolver, botonCerrarCrear,
						botonCerrarBorrar, textoErrorBorrar, botonProbarMail, botonVerDatos }));

	}

	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;

		if (usuario != null) {
			textotemp.setText(usuario.getNombre());
		}
	}
}
