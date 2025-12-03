package Noticias;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Operaciones {
	private ImageIcon mostrar = new ImageIcon("Extras/Imagenes/OjoAbierto.png");
	private ImageIcon ocultar = new ImageIcon("Extras/Imagenes/OjoCerrado.png");
	public void ocultarContraseña(JPasswordField campoContraseña, char caracter, JButton botonOcultarContrasena) {
		char campoActual = campoContraseña.getEchoChar();
		if(campoActual == (char) 0) {
			campoContraseña.setEchoChar(caracter);
			botonOcultarContrasena.setIcon(mostrar);
		}else {
			campoContraseña.setEchoChar((char) 0);
			botonOcultarContrasena.setIcon(ocultar);
		}
	}
}
