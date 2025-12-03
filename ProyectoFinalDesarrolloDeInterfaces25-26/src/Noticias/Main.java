package Noticias;

import java.awt.EventQueue;
import java.util.ArrayList;


public class Main {
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					//UsuariosGestionar gestion = new UsuariosGestionar();
					//listaUsuarios = gestion.crearUsuarios(listaUsuarios);
					Marco miVentana = new Marco(listaUsuarios);
					miVentana.setVisible(true);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
