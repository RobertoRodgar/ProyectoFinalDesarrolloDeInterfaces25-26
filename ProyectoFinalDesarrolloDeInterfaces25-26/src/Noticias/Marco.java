package Noticias;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Marco extends JFrame{
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	public Marco(ArrayList<Usuario> listaUsuarios) {
		setTitle("Noticias");
		setBounds(100,100,800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		

		JPanel iniciarSesion = new iniciarSesion(this, listaUsuarios);
		add(iniciarSesion);
	}
}
