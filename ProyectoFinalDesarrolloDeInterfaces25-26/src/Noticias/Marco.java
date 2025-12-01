package Noticias;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Marco extends JFrame{
	public Marco() {
		setTitle("Noticias");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel iniciarSesion = new iniciarSesion(this);

		add(iniciarSesion);
	}
}
