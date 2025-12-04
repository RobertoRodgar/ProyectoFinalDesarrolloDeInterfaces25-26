package Noticias;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Marco extends JFrame{
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	CardLayout cardLayout;
	JPanel contentPane;
	iniciarSesion iniciarSesion;
	pantallaAdminInicio pantallaAdminInicio;
	
	public Marco(ArrayList<Usuario> listaUsuarios) {
		setTitle("Noticias");
		setBounds(100,100,800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        
		iniciarSesion = new iniciarSesion(this, listaUsuarios);
		pantallaAdminInicio = new pantallaAdminInicio(this);
		
		contentPane.add(iniciarSesion, "IniciarSesion");
        contentPane.add(pantallaAdminInicio, "PantallaInicioAdmin");
		
		cardLayout.show(contentPane, "IniciarSesion");
		
	}
	
	
	
	public void mostrarPantallaInicio() {
		
	}
	
	public void mostrarPantallaAdmin(Usuario usuario) {
		pantallaAdminInicio.establecerUsuario(usuario);
		cardLayout.show(contentPane, "PantallaInicioAdmin");
	}
}
