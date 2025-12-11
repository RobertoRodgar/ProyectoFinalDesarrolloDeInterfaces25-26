package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Operaciones {
	private ImageIcon mostrar = new ImageIcon("Extras/Imagenes/OjoAbierto.png");
	private ImageIcon ocultar = new ImageIcon("Extras/Imagenes/OjoCerrado.png");
	private String correo, contrasena, nombre, esAdmin, inicio;
	private boolean esAdminAnadir;
	private int inicioAnadir;
	private File archivoUsuarios = new File("Extras/TXTs/usuarios2.txt");
	private File configs = new File("Extras/TXTs/configuraciones.txt");
	private SacarTitular sacarTitular = new SacarTitular();
	
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
	
	
	public Usuario comprobarUsuario(String nombreUsuario, String contrasena, ArrayList<Usuario> listaUsuarios) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getNombre().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	public void mostrarPanelOpciones(JPanel panelOpciones) {
		if(!panelOpciones.isVisible()) {
			panelOpciones.setVisible(true);
		}else {
			panelOpciones.setVisible(false);
		}
		
	}
	
	public void mostrarPanelGestion(JPanel panelGestionar) {
		if(!panelGestionar.isVisible()) {
			panelGestionar.setVisible(true);
		}else {
			panelGestionar.setVisible(false);
		}
		
	}
	
	public void mostrarPanelCrear(JPanel panelCrear) {
		if(!panelCrear.isVisible()) {
			panelCrear.setVisible(true);
		}else {
			panelCrear.setVisible(false);
		}
		
	}
	
	public void mostrarPanelBorrar(JPanel panelBorrar) {
		if(!panelBorrar.isVisible()) {
			panelBorrar.setVisible(true);
		}else {
			panelBorrar.setVisible(false);
		}
	}
	
	public String agregarUsuario(int contador, JTextField campoTexto, JLabel titulos, JLabel textoError, ArrayList<Usuario> listaUsuarios) {
		switch (contador) {
		case 0:
			correo = campoTexto.getText();
			campoTexto.setText("");
			titulos.setText("Introduce la contraseña:");
			break;
		case 1:
			contrasena = campoTexto.getText();
			campoTexto.setText("");
			titulos.setText("Introduce el nombre de usuario:");
			break;
		case 2:
			nombre = campoTexto.getText();
			if(nombre.contains(";")) {
				textoError.setText("ERROR. El nombre de usuario no puede tener ;");
			}else {
				textoError.setText("");
				campoTexto.setText("");
				titulos.setText("Introduce si es admin o no (true / false):");
				break;
			}
		case 3:
			String texto = campoTexto.getText();
		    
		    if(texto.equals("true") || texto.equals("false")) {
		        textoError.setText("");
		        if(texto.equals("true")) {
		        	esAdminAnadir = true;
		        	inicioAnadir = 1;
		            inicio = "1";
		        } else {
		        	esAdminAnadir = false;
		        	inicioAnadir = 0;
		            inicio = "0";
		        }
		        esAdmin = texto;
		        campoTexto.setText("");
		        titulos.setText("Introduce el correo:");
		        
		        Usuario nuevoUsuario = new Usuario(correo, contrasena, nombre, esAdminAnadir, inicioAnadir);
		        listaUsuarios.add(nuevoUsuario);
		        return correo + ";" + contrasena + ";" + nombre + ";" + esAdmin + ";" + inicio;
		        
		    } else {
		        textoError.setText("ERROR. Debes introducir 'true' o 'false'");
		        return null;
		    }
		default:
			break;
		}
		return null;
	}
	
	public void escribirNuevoUsuario(String linea) {
		ArrayList<String> lineas = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String lineaTemp;
            while ((lineaTemp = br.readLine()) != null) {
                lineas.add(lineaTemp);
            }
        } catch (Exception e) {
        	System.out.println("Ha ocurrido un error inesperado.");
        }
		lineas.add(linea);
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {
            
            for (String lineaEscribir : lineas) {
                fw.write(lineaEscribir + "\n"); 
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
	}
	
	public void borrarUsuario(JLabel textoError, JTextField texto, ArrayList<Usuario> listaUsuarios, Usuario usuario) {
		if(usuario.getNombre().equals(texto.getText())) {
			textoError.setText("No puedes borrarte a ti mismo.");
		}else {
			Usuario usuarioBorrar = null;
			for(Usuario temp : listaUsuarios) {
				if(temp.getNombre().equals(texto.getText())) {
					usuarioBorrar = temp;
				}
			}
			if(usuarioBorrar == null) {
				textoError.setText("No se ha encontrado a ningun usuario con tal nombre.");
			}else {
				textoError.setText("Se ha borrado al usuario con éxito.");
				listaUsuarios.remove(usuarioBorrar);
				borrarUsuarioTxt(usuarioBorrar);
			}
		}
	}

	public void borrarUsuarioTxt(Usuario usuarioBorrar) {
		ArrayList<String> lineas = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String lineaTemp;
            String[] parametros;
            while ((lineaTemp = br.readLine()) != null) {
            	parametros = lineaTemp.split(";");
            	if(!parametros[0].equals(usuarioBorrar.getEmail())) {
            		lineas.add(lineaTemp);
            	}  
            }
        } catch (Exception e) {
        	System.out.println("Ha ocurrido un error inesperado.");
        }
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {
            for (String lineaEscribir : lineas) {
                fw.write(lineaEscribir + "\n"); 
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
	}
	
	public void noticiasEconomia1(JTextArea titular) throws IOException {
		String web = extraerWeb("Economia", 1);
		String aBuscar = extraerABuscar("Economia", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasEconomia2(JTextArea titular) throws IOException {
		String web = extraerWeb("Economia", 3);
		String aBuscar = extraerABuscar("Economia", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasEconomia3(JTextArea titular) throws IOException {
		String web = extraerWeb("Economia", 5);
		String aBuscar = extraerABuscar("Economia", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	

	public void noticiasDeportes1(JTextArea titular) throws IOException {
		String web = extraerWeb("Deportes", 1);
		String aBuscar = extraerABuscar("Deportes", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasDeportes2(JTextArea titular) throws IOException {
		String web = extraerWeb("Deportes", 3);
		String aBuscar = extraerABuscar("Deportes", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasDeportes3(JTextArea titular) throws IOException {
		String web = extraerWeb("Deportes", 5);
		String aBuscar = extraerABuscar("Deportes", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	

	public void noticiasNacional1(JTextArea titular) throws IOException {
		String web = extraerWeb("Nacional", 1);
		String aBuscar = extraerABuscar("Nacional", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasNacional2(JTextArea titular) throws IOException {
		String web = extraerWeb("Nacional", 3);
		String aBuscar = extraerABuscar("Nacional", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasNacional3(JTextArea titular) throws IOException {
		String web = extraerWeb("Nacional", 5);
		String aBuscar = extraerABuscar("Nacional", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	

	
	public void noticiasInternacional1(JTextArea titular) throws IOException {
		String web = extraerWeb("Internacional", 1);
		String aBuscar = extraerABuscar("Internacional", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasInternacional2(JTextArea titular) throws IOException {
		String web = extraerWeb("Internacional", 3);
		String aBuscar = extraerABuscar("Internacional", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasInternacional3(JTextArea titular) throws IOException {
		String web = extraerWeb("Internacional", 5);
		String aBuscar = extraerABuscar("Internacional", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	

	
	public void noticiasVideojuegos1(JTextArea titular) throws IOException {
		String web = extraerWeb("Videojuegos", 1);
		String aBuscar = extraerABuscar("Videojuegos", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasVideojuegos2(JTextArea titular) throws IOException {
		String web = extraerWeb("Videojuegos", 3);
		String aBuscar = extraerABuscar("Videojuegos", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasVideojuegos3(JTextArea titular) throws IOException {
		String web = extraerWeb("Videojuegos", 5);
		String aBuscar = extraerABuscar("Videojuegos", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	
	
	public void noticiasReligiosas1(JTextArea titular) throws IOException {
		String web = extraerWeb("Religiosas", 1);
		String aBuscar = extraerABuscar("Religiosas", 2);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasReligiosas2(JTextArea titular) throws IOException {
		String web = extraerWeb("Religiosas", 3);
		String aBuscar = extraerABuscar("Religiosas", 4);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	public void noticiasReligiosas3(JTextArea titular) throws IOException {
		String web = extraerWeb("Religiosas", 5);
		String aBuscar = extraerABuscar("Religiosas", 6);
		titular.setText(sacarTitular.sacarTitular(web, aBuscar));
	}
	
	
	
	public String extraerWeb(String tipo, int numTitular) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String linea;
			String web = null;
			while((linea = br.readLine()) != null) {
				String[] parametros = linea.split(";");
				if(parametros[0].equals(tipo)) {
					web = parametros[numTitular];
				}
			}
			
			return web;
		} catch (IOException e) {
			return null;
		}
	}
	
	
	public String extraerABuscar(String tipo, int numBusqueda) {
		try(BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String linea;
			String web = null;
			while((linea = br.readLine()) != null) {
				String[] parametros = linea.split(";");
				if(parametros[0].equals(tipo)) {
					web = parametros[numBusqueda];
				}
			}
			
			return web;
		} catch (IOException e) {
			return null;
		}
	}
	
	public void guardarPreferencias(String preferenciaNueva) {
		ArrayList<String> lineas = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
            String lineaTemp;
            while ((lineaTemp = br.readLine()) != null) {
                lineas.add(lineaTemp);
            }
            lineas.add(preferenciaNueva);
        } catch (Exception e) {
        	System.out.println("Ha ocurrido un error inesperado.");
        }
		try (FileWriter fw = new FileWriter(configs)) {
            
            for (String lineaEscribir : lineas) {
                fw.write(lineaEscribir + "\n"); 
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
		
	}
	
	public String[] consultarPreferencias(String nombreUsuario) {
		String[] preferencias = null;
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
            String lineaTemp;
            while ((lineaTemp = br.readLine()) != null) {
                preferencias = lineaTemp.split(";");
                if(preferencias[0].equals(nombreUsuario)) {
                	break;
                }
            }
            return preferencias;
        } catch (Exception e) {
        	System.out.println("Ha ocurrido un error inesperado.");
        	return null;
        }
	}
	
	public void guardarUsuario(String nombre) {
		ArrayList<String> lineas = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String lineaTemp;
            while ((lineaTemp = br.readLine()) != null) {
            	String[] parametros = lineaTemp.split(";");
				if(parametros[2].equals(nombre)) {
					parametros[4] = "1";
					lineaTemp = String.join(";", parametros);
				}
				lineas.add(lineaTemp);
            }
        } catch (Exception e) {
        	System.out.println("Ha ocurrido un error inesperado.");
        }
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {
            
            for (String lineaEscribir : lineas) {
                fw.write(lineaEscribir + "\n"); 
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
	}
}
