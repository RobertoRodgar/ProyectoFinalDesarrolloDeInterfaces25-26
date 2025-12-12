package Noticias;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SimpleEmail {	
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (SSL)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	static Session sesion;
	private static Operaciones operaciones = new Operaciones();
	public static void config() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "465");		
		Authenticator auth = new Authenticator() {		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(operaciones.obtenerFrom(), operaciones.obtenerPass());
			}
		};		
		sesion = Session.getDefaultInstance(props, auth);
		
	}
	
	public static String cuerpoMensaje(Usuario usuario) throws IOException {
		String mensaje = "";
		if (usuario.getEsAdmin()) {
			mensaje += "Economía\n";
			mensaje += "El País\n";
			mensaje += operaciones.noticiasEconomia1() + "\n";
			mensaje += "El Economista\n";
			mensaje += operaciones.noticiasEconomia2() + "\n";
			mensaje += "El Mundo\n";
			mensaje += operaciones.noticiasEconomia3() + "\n\n\n";
			
			mensaje += "Deportes\n";
			mensaje += "Marca\n";
			mensaje += operaciones.noticiasDeportes1() + "\n";
			mensaje += "RTVE.es\n";
			mensaje += operaciones.noticiasDeportes2() + "\n";
			mensaje += "Mundo Deportivo\n";
			mensaje += operaciones.noticiasDeportes3() + "\n\n\n";
			
			mensaje += "Nacional\n";
			mensaje += "ABC\n";
			mensaje += operaciones.noticiasNacional1() + "\n";
			mensaje += "La Razón\n";
			mensaje += operaciones.noticiasNacional2() + "\n";
			mensaje += "Europa Press\n";
			mensaje += operaciones.noticiasNacional3() + "\n\n\n";
			
			mensaje += "Internacional\n";
			mensaje += "CNN en Español\n";
			mensaje += operaciones.noticiasInternacional1() + "\n";
			mensaje += "BBC\n";
			mensaje += operaciones.noticiasInternacional2() + "\n";
			mensaje += "20Minutos\n";
			mensaje += operaciones.noticiasInternacional3() + "\n\n\n";
			
			mensaje += "Videojuegos\n";
			mensaje += "Vandal\n";
			mensaje += operaciones.noticiasVideojuegos1() + "\n";
			mensaje += "Diario Público\n";
			mensaje += operaciones.noticiasVideojuegos2() + "\n";
			mensaje += "Xataka\n";
			mensaje += operaciones.noticiasVideojuegos3() + "\n\n\n";
			
			mensaje += "Religiosas\n";
			mensaje += "Vida Nueva\n";
			mensaje += operaciones.noticiasReligiosas1() + "\n";
			mensaje += "Vatican News\n";
			mensaje += operaciones.noticiasReligiosas2() + "\n";
			mensaje += "Religión en Libertad\n";
			mensaje += operaciones.noticiasReligiosas3() + "\n\n\n";
			
			return mensaje;
		}else {
			String[] preferencias;
			preferencias = operaciones.consultarPreferencias(usuario.getNombre());
			if (preferencias != null) {
				for (int i = 1; i < preferencias.length; i++) {
					switch (preferencias[i]) {
					case "Economia":
						mensaje += "Economía\n";
						mensaje += "El País\n";
						mensaje += operaciones.noticiasEconomia1() + "\n";
						mensaje += "El Economista\n";
						mensaje += operaciones.noticiasEconomia2() + "\n";
						mensaje += "El Mundo\n";
						mensaje += operaciones.noticiasEconomia3() + "\n\n\n";
						break;
					case "Deportes":
						mensaje += "Deportes\n";
						mensaje += "Marca\n";
						mensaje += operaciones.noticiasDeportes1() + "\n";
						mensaje += "RTVE.es\n";
						mensaje += operaciones.noticiasDeportes2() + "\n";
						mensaje += "Mundo Deportivo\n";
						mensaje += operaciones.noticiasDeportes3() + "\n\n\n";
						break;
					case "Nacional":
						mensaje += "Nacional\n";
						mensaje += "ABC\n";
						mensaje += operaciones.noticiasNacional1() + "\n";
						mensaje += "La Razón\n";
						mensaje += operaciones.noticiasNacional2() + "\n";
						mensaje += "Europa Press\n";
						mensaje += operaciones.noticiasNacional3() + "\n\n\n";
						break;
					case "Internacional":
						mensaje += "Internacional\n";
						mensaje += "CNN en Español\n";
						mensaje += operaciones.noticiasInternacional1() + "\n";
						mensaje += "BBC\n";
						mensaje += operaciones.noticiasInternacional2() + "\n";
						mensaje += "20Minutos\n";
						mensaje += operaciones.noticiasInternacional3() + "\n\n\n";
						break;
					case "Videojuegos":
						mensaje += "Videojuegos\n";
						mensaje += "Vandal\n";
						mensaje += operaciones.noticiasVideojuegos1() + "\n";
						mensaje += "Diario Público\n";
						mensaje += operaciones.noticiasVideojuegos2() + "\n";
						mensaje += "Xataka\n";
						mensaje += operaciones.noticiasVideojuegos3() + "\n\n\n";
						break;
					case "Religiosas":
						mensaje += "Religiosas\n";
						mensaje += "Vida Nueva\n";
						mensaje += operaciones.noticiasReligiosas1() + "\n";
						mensaje += "Vatican News\n";
						mensaje += operaciones.noticiasReligiosas2() + "\n";
						mensaje += "Religión en Libertad\n";
						mensaje += operaciones.noticiasReligiosas3() + "\n\n\n";
						break;
					default:

					}
				}
			}
		}
		return mensaje;
	}
	
	public static void enviarNoticias(String toEmail, String cuerpoMensaje) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD-MM-YYYY");
		LocalDate hoy = LocalDate.now();
		LocalDateTime tiempo = LocalDateTime.now();
		int hora = tiempo.getHour();
		int minuto = tiempo.getMinute();
		config();
		if(minuto < 10 ) {
			EmailUtil.sendEmail(sesion, toEmail, "Noticias", hoy + " " + hora + ":0" + minuto + "\n" + cuerpoMensaje);
		}else {
			EmailUtil.sendEmail(sesion, toEmail, "Noticias", hoy + " " + hora + ":" + minuto + "\n" + cuerpoMensaje);

		}	
	}
}

