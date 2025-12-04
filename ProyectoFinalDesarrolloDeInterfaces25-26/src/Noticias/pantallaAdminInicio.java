package Noticias;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pantallaAdminInicio extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JLabel textotemp;
	public pantallaAdminInicio(JFrame frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		textotemp = new JLabel();
		textotemp.setFont(new Font("Tahoma", Font.BOLD, 24));
		textotemp.setLocation(309, 55);
		textotemp.setSize(165,20);
		add(textotemp);
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		if(usuario != null) {
			textotemp.setText(usuario.getNombre());
		}
	}
}
