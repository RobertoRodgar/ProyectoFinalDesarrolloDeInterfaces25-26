package Noticias;

public class Usuario {
	
	String email;
	String nombre;
	String contrasena;
	boolean esAdmin;
	int inicio; //0 = nunca iniciado, 1 = iniciado alguna vez
	
	public Usuario(String email, String contrasena, String nombre, boolean esAdmin, int inicio) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.esAdmin = esAdmin;
		this.inicio = inicio;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", contrasena=" + contrasena + ", esAdmin=" + esAdmin
				+ ", inicio=" + inicio + "]";
	}
	
}
