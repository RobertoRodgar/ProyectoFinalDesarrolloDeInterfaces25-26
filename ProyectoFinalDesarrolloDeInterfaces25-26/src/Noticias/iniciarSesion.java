package Noticias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class iniciarSesion extends JPanel{
	private JFrame framePrincipal;
	public iniciarSesion(JFrame frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		JLabel titulo = new JLabel("Iniciar Sesión");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setLocation(340, 55);
		titulo.setSize(114,20);
		add(titulo);
		
		
	}
}
