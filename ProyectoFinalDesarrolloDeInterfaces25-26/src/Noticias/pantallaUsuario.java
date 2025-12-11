package Noticias;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class pantallaUsuario extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	public pantallaUsuario(Marco frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
