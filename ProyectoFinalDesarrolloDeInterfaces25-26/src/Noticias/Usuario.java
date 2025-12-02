package Noticias;

public class Usuario {
	
	String nombre;
	String contrasena;
	String email;
	boolean esAdmin;
	
	public Usuario(String nombre, String contrasena, String email, boolean esAdmin) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.esAdmin = esAdmin;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
}
