package Noticias;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UsuariosGestionar {
	File archivoUsuarios = new File("Extras/TXTs/usuarios.txt");
	
	public ArrayList<Usuario> iniciarUsuarios(ArrayList<Usuario> listaUsuarios) {
		Usuario usuarioTemp = null;
		String email, contrasena, nombre;
		boolean esAdmin;
		int inicio;
		try(BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				String[] parametros = linea.split(";");
				email = parametros[0];
				contrasena = parametros[1];
				nombre = parametros[2];
				
				if(parametros[3].equals("true")) {
					esAdmin = true;
				}else {
					esAdmin = false;
				}
				
				if(parametros[4].equals("0")) {
					inicio = 0;
				}else {
					inicio = 1;
				}

				usuarioTemp = new Usuario(email, contrasena, nombre, esAdmin, inicio);
				listaUsuarios.add(usuarioTemp);
			}
			
			return listaUsuarios;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
