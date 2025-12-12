package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Operaciones {
	private ImageIcon mostrar = new ImageIcon("Extras/Imagenes/OjoAbierto.png");
	private ImageIcon ocultar = new ImageIcon("Extras/Imagenes/OjoCerrado.png");
	private String correo, contrasena, nombre, esAdmin, inicio;
	private boolean esAdminAnadir;
	private int inicioAnadir;
	private File archivoUsuarios = new File("Extras/TXTs/usuarios.txt");
	private File configs = new File("Extras/TXTs/configuraciones.txt");
	private File archivoLog = new File("Extras/TXTs/log.txt");
	private SacarTitular sacarTitular = new SacarTitular();

	public void ocultarContraseña(JPasswordField campoContraseña, char caracter, JButton botonOcultarContrasena) {
		char campoActual = campoContraseña.getEchoChar();
		if (campoActual == (char) 0) {
			campoContraseña.setEchoChar(caracter);
			botonOcultarContrasena.setIcon(mostrar);
		} else {
			campoContraseña.setEchoChar((char) 0);
			botonOcultarContrasena.setIcon(ocultar);
		}
	}

	public Usuario comprobarUsuario(String nombreUsuario, String contrasena, ArrayList<Usuario> listaUsuarios) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getNombre().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}

	public void mostrarPanelOpciones(JPanel panelOpciones) {
		if (!panelOpciones.isVisible()) {
			panelOpciones.setVisible(true);
		} else {
			panelOpciones.setVisible(false);
		}

	}

	public void mostrarPanelGestion(JPanel panelGestionar) {
		if (!panelGestionar.isVisible()) {
			panelGestionar.setVisible(true);
		} else {
			panelGestionar.setVisible(false);
		}

	}

	public void mostrarPanelCrear(JPanel panelCrear) {
		if (!panelCrear.isVisible()) {
			panelCrear.setVisible(true);
		} else {
			panelCrear.setVisible(false);
		}

	}

	public void mostrarPanelBorrar(JPanel panelBorrar) {
		if (!panelBorrar.isVisible()) {
			panelBorrar.setVisible(true);
		} else {
			panelBorrar.setVisible(false);
		}
	}

	public boolean comprobarUsuario(ArrayList<Usuario> listaUsuarios, String correoNuevo) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getEmail().equals(correoNuevo)) {
				return true;
			}
		}
		return false;
	}

	public String agregarUsuario(int contador, JTextField campoTexto, JLabel titulos, JLabel textoError,
			ArrayList<Usuario> listaUsuarios) {
		switch (contador) {
			case 0:
				correo = campoTexto.getText();
				if (correo.contains("@") && correo.contains(".")) {
					if (comprobarUsuario(listaUsuarios, correo) == false) {
						textoError.setText("");
						campoTexto.setText("");
						titulos.setText("Introduce la contraseña:");
					} else {
						textoError.setText("ERROR. Ese correo ya está en uso.");
					}
				} else {
					textoError.setText("ERROR. El correo debe llevar un @ y un .");
				}
				break;
			case 1:
				contrasena = campoTexto.getText();
				if (contrasena.contains(";")) {
					textoError.setText("ERROR. La contraseña no puede tener ;");
				} else {
					textoError.setText("");
					campoTexto.setText("");
					titulos.setText("Introduce el nombre de usuario:");
				}
				break;
			case 2:
				nombre = campoTexto.getText();
				if (nombre.contains(";")) {
					textoError.setText("ERROR. El nombre de usuario no puede tener ;");
				} else {
					textoError.setText("");
					campoTexto.setText("");
					titulos.setText("Introduce si es admin o no (true / false):");
					break;
				}
			case 3:
				String texto = campoTexto.getText();

				if (texto.equals("true") || texto.equals("false")) {
					textoError.setText("");
					if (texto.equals("true")) {
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
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al leer usuarios.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		lineas.add(linea);
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {

			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al escribir usuarios.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void borrarUsuario(JLabel textoError, JTextField texto, ArrayList<Usuario> listaUsuarios, Usuario usuario) {
		if (usuario.getNombre().equals(texto.getText())) {
			textoError.setText("No puedes borrarte a ti mismo.");
		} else {
			Usuario usuarioBorrar = null;
			for (Usuario temp : listaUsuarios) {
				if (temp.getNombre().equals(texto.getText())) {
					usuarioBorrar = temp;
				}
			}
			if (usuarioBorrar == null) {
				textoError.setText("No se ha encontrado a ningun usuario con tal nombre.");
			} else {
				textoError.setText("Se ha borrado al usuario con éxito.");
				listaUsuarios.remove(usuarioBorrar);
				borrarUsuarioTxt(usuarioBorrar);
				borrarPreferenciasUsaurio(usuarioBorrar);
			}
		}
	}

	public void borrarPreferenciasUsaurio(Usuario usuarioBorrar) {
		ArrayList<String> lineas = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String lineaTemp;
			String[] parametros;
			while ((lineaTemp = br.readLine()) != null) {
				parametros = lineaTemp.split(";");
				if (!parametros[0].equals(usuarioBorrar.getNombre())) {
					lineas.add(lineaTemp);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al leer para borrar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		try (FileWriter fw = new FileWriter(configs)) {
			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al reescribir tras borrar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void borrarUsuarioTxt(Usuario usuarioBorrar) {
		ArrayList<String> lineas = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
			String lineaTemp;
			String[] parametros;
			while ((lineaTemp = br.readLine()) != null) {
				parametros = lineaTemp.split(";");
				if (!parametros[0].equals(usuarioBorrar.getEmail())) {
					lineas.add(lineaTemp);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al leer para borrar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {
			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al reescribir tras borrar.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public String noticiasEconomia1() throws IOException {
		String web = extraerWeb("Economia", 1);
		String aBuscar = extraerABuscar("Economia", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasEconomia2() throws IOException {
		String web = extraerWeb("Economia", 3);
		String aBuscar = extraerABuscar("Economia", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasEconomia3() throws IOException {
		String web = extraerWeb("Economia", 5);
		String aBuscar = extraerABuscar("Economia", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasDeportes1() throws IOException {
		String web = extraerWeb("Deportes", 1);
		String aBuscar = extraerABuscar("Deportes", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasDeportes2() throws IOException {
		String web = extraerWeb("Deportes", 3);
		String aBuscar = extraerABuscar("Deportes", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasDeportes3() throws IOException {
		String web = extraerWeb("Deportes", 5);
		String aBuscar = extraerABuscar("Deportes", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasNacional1() throws IOException {
		String web = extraerWeb("Nacional", 1);
		String aBuscar = extraerABuscar("Nacional", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasNacional2() throws IOException {
		String web = extraerWeb("Nacional", 3);
		String aBuscar = extraerABuscar("Nacional", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasNacional3() throws IOException {
		String web = extraerWeb("Nacional", 5);
		String aBuscar = extraerABuscar("Nacional", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasInternacional1() throws IOException {
		String web = extraerWeb("Internacional", 1);
		String aBuscar = extraerABuscar("Internacional", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasInternacional2() throws IOException {
		String web = extraerWeb("Internacional", 3);
		String aBuscar = extraerABuscar("Internacional", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasInternacional3() throws IOException {
		String web = extraerWeb("Internacional", 5);
		String aBuscar = extraerABuscar("Internacional", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasVideojuegos1() throws IOException {
		String web = extraerWeb("Videojuegos", 1);
		String aBuscar = extraerABuscar("Videojuegos", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasVideojuegos2() throws IOException {
		String web = extraerWeb("Videojuegos", 3);
		String aBuscar = extraerABuscar("Videojuegos", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasVideojuegos3() throws IOException {
		String web = extraerWeb("Videojuegos", 5);
		String aBuscar = extraerABuscar("Videojuegos", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasReligiosas1() throws IOException {
		String web = extraerWeb("Religiosas", 1);
		String aBuscar = extraerABuscar("Religiosas", 2);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasReligiosas2() throws IOException {
		String web = extraerWeb("Religiosas", 3);
		String aBuscar = extraerABuscar("Religiosas", 4);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String noticiasReligiosas3() throws IOException {
		String web = extraerWeb("Religiosas", 5);
		String aBuscar = extraerABuscar("Religiosas", 6);
		return sacarTitular.sacarTitular(web, aBuscar);
	}

	public String extraerWeb(String tipo, int numTitular) {

		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String linea;
			String web = null;
			while ((linea = br.readLine()) != null) {
				String[] parametros = linea.split(";");
				if (parametros[0].equals(tipo)) {
					web = parametros[numTitular];
				}
			}

			return web;
		} catch (IOException e) {
			return null;
		}
	}

	public String extraerABuscar(String tipo, int numBusqueda) {
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String linea;
			String web = null;
			while ((linea = br.readLine()) != null) {
				String[] parametros = linea.split(";");
				if (parametros[0].equals(tipo)) {
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
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al leer preferencias.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		try (FileWriter fw = new FileWriter(configs)) {

			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al guardar preferencias.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public String[] consultarPreferencias(String nombreUsuario) {
		String[] preferencias = null;
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				preferencias = lineaTemp.split(";");
				if (preferencias[0].equals(nombreUsuario)) {
					break;
				}
			}
			return preferencias;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al consultar preferencias.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void guardarUsuario(String nombre) {
		ArrayList<String> lineas = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				String[] parametros = lineaTemp.split(";");
				if (parametros[2].equals(nombre)) {
					parametros[4] = "1";
					lineaTemp = String.join(";", parametros);
				}
				lineas.add(lineaTemp);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al leer usuario para guardar.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		try (FileWriter fw = new FileWriter(archivoUsuarios)) {

			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al guardar usuario.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public String obtenerFrom() {
		String[] datos = null;
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				datos = lineaTemp.split(";");
				if (datos[0].equals("fromEmail")) {
					break;
				}
			}
			return datos[1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener configuración de email.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public String obtenerPass() {
		String[] datos = null;
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				datos = lineaTemp.split(";");
				if (datos[0].equals("password")) {
					break;
				}
			}
			return datos[1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener contraseña de email.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public String obtenerHora() {
		String[] datos = null;
		try (BufferedReader br = new BufferedReader(new FileReader(configs))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				datos = lineaTemp.split(";");
				if (datos[0].equals("Hora")) {
					break;
				}
			}
			return datos[1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener hora de envío.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void guardarNoticias(Usuario usuario) throws IOException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD-MM-YYYY");
		LocalDate hoy = LocalDate.now();
		LocalDateTime tiempo = LocalDateTime.now();
		int hora = tiempo.getHour();
		int minuto = tiempo.getMinute();

		ArrayList<String> lineas = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(archivoLog))) {
			String lineaTemp;
			while ((lineaTemp = br.readLine()) != null) {
				lineas.add(lineaTemp);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer log.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		String lineaNueva = "";
		lineaNueva += usuario.getNombre() + " " + hora + ":" + minuto + "\n" + SimpleEmail.cuerpoMensaje(usuario);
		lineas.add(lineaNueva);
		try (FileWriter fw = new FileWriter(archivoLog)) {

			for (String lineaEscribir : lineas) {
				fw.write(lineaEscribir + "\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar en log.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
