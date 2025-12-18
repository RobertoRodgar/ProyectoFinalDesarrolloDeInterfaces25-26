package Noticias;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Main {
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					PantallaCarga ventanaCarga = new PantallaCarga(listaUsuarios);
					ventanaCarga.setLocationRelativeTo(null);
					ventanaCarga.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error fatal al iniciar la aplicación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

}
