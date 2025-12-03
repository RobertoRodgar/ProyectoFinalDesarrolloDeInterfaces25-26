package Noticias;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UsuariosGestionar {
	File archivoUsuarios = new File("Extras/TXTs/usuarios.txt");
	
	public ArrayList<Usuario> crearUsuarios(ArrayList<Usuario> listaUsuarios) {
		try(FileOutputStream fos = new FileOutputStream(archivoUsuarios); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			listaUsuarios.add(new Usuario("Roberto", "a", "roberto.rodriguez.dosa@gmail.com", true));
			listaUsuarios.add(new Usuario("Miguel", "a2", "miguel@gmail.com", false));
			listaUsuarios.add(new Usuario("Sebas", "a3", "sebas@gmail.com", false));
			listaUsuarios.add(new Usuario("Jeremy", "a4", "jeremy@gmail.com", false));
			
			oos.writeObject(listaUsuarios);
			return listaUsuarios;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
