package Noticias;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Marco extends JFrame {
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	CardLayout cardLayout;
	JPanel contentPane;
	iniciarSesion iniciarSesion;
	pantallaAdminInicio pantallaAdminInicio;
	pantallaNoticias pantallaNoticias;
	pantallaGuardarPreferencias pantallaGuardarPreferencias;
	pantallaUsuario pantallaUsuario;
	Operaciones operaciones = new Operaciones();

	public Marco(ArrayList<Usuario> listaUsuarios) {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?", "Confirmación",

						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					System.exit(0);

				}

			}

		});
		ImageIcon np = new ImageIcon("Extras/Imagenes/np.png");
		setTitle("Noticias");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(np.getImage());

		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		setContentPane(contentPane);

		iniciarSesion = new iniciarSesion(this, listaUsuarios);
		pantallaAdminInicio = new pantallaAdminInicio(this, listaUsuarios);
		pantallaNoticias = new pantallaNoticias(this, listaUsuarios);
		pantallaGuardarPreferencias = new pantallaGuardarPreferencias(this);
		pantallaUsuario = new pantallaUsuario(this);

		contentPane.add(iniciarSesion, "IniciarSesion");
		contentPane.add(pantallaAdminInicio, "PantallaInicioAdmin");
		contentPane.add(pantallaNoticias, "PantallaNoticias");
		contentPane.add(pantallaGuardarPreferencias, "PantallaGuardarPreferencias");
		contentPane.add(pantallaUsuario, "PantallaUsuario");

		cardLayout.show(contentPane, "IniciarSesion");

		this.setJMenuBar(MenuBar.getMenuBar(this));
		comprobarHora();
	}

	public void mostrarPantallaInicio() {
		cardLayout.show(contentPane, "IniciarSesion");
	}

	public void mostrarPantallaAdmin(Usuario usuario) {
		pantallaAdminInicio.establecerUsuario(usuario);
		cardLayout.show(contentPane, "PantallaInicioAdmin");
	}

	public void mostrarPantallaAdminVolver() {
		cardLayout.show(contentPane, "PantallaInicioAdmin");
	}

	public void mostrarPantallaNoticias(Usuario usuario) {
		pantallaNoticias.establecerUsuario(usuario);
		cardLayout.show(contentPane, "PantallaNoticias");
	}

	public void mostrarPantallaGuardarPreferencias(Usuario usuario) {
		pantallaGuardarPreferencias.establecerUsuario(usuario);
		cardLayout.show(contentPane, "PantallaGuardarPreferencias");
	}

	public void mostrarPantallaUsuario(Usuario usuario) {
		pantallaUsuario.establecerUsuario(usuario);
		cardLayout.show(contentPane, "PantallaUsuario");
	}

	public void mostrarPantallaUsuarioVolver() {
		cardLayout.show(contentPane, "PantallaUsuario");
	}

	public void comprobarHora() {
		Thread hilo = new Thread(() -> {
			while (true) {
				try {
					int hora = Integer.parseInt(operaciones.obtenerHora());
					LocalDateTime tiempo = LocalDateTime.now();
					if (hora == tiempo.getHour() && tiempo.getMinute() == 0) {
						for (Usuario usuario : listaUsuarios) {
							if (!usuario.getEsAdmin()) {
								String cuerpo = SimpleEmail.cuerpoMensaje(usuario);
								if (!cuerpo.isEmpty()) {
									String toEmail = usuario.getEmail();
									SimpleEmail.enviarNoticias(toEmail, cuerpo);
								}
							}
						}
					}
					Thread.sleep(60000);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		hilo.setDaemon(true);
		hilo.start();
	}

	public void enviarNoticias() {

	}
}
