package Noticias;

import java.awt.CardLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Marco extends JFrame{
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	CardLayout cardLayout;
	JPanel contentPane;
	iniciarSesion iniciarSesion;
	pantallaAdminInicio pantallaAdminInicio;
	pantallaAcercaDe pantallaAcercaDe;
	pantallaNoticias pantallaNoticias;
	pantallaGuardarPreferencias pantallaGuardarPreferencias;
	pantallaUsuario pantallaUsuario;
	
	public Marco(ArrayList<Usuario> listaUsuarios) {
		ImageIcon np = new ImageIcon("Extras/Imagenes/np.png");
		setTitle("Noticias");
		setBounds(100,100,800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(np.getImage());
		
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

		iniciarSesion = new iniciarSesion(this, listaUsuarios);
		pantallaAdminInicio = new pantallaAdminInicio(this, listaUsuarios);
		pantallaAcercaDe = new pantallaAcercaDe(this);
		pantallaNoticias = new pantallaNoticias(this, listaUsuarios);
		pantallaGuardarPreferencias = new pantallaGuardarPreferencias(this);
		pantallaUsuario = new pantallaUsuario(this);
		
		contentPane.add(iniciarSesion, "IniciarSesion");
        contentPane.add(pantallaAdminInicio, "PantallaInicioAdmin");
        contentPane.add(pantallaAcercaDe, "PantallaAcercaDe");
        contentPane.add(pantallaNoticias, "PantallaNoticias");
        contentPane.add(pantallaGuardarPreferencias, "PantallaGuardarPreferencias");
        contentPane.add(pantallaUsuario, "PantallaUsuario");
		
        cardLayout.show(contentPane, "IniciarSesion");

		
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
	
	public void mostrarPantallaAcercaDe() {
		cardLayout.show(contentPane, "PantallaAcercaDe");
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
}
