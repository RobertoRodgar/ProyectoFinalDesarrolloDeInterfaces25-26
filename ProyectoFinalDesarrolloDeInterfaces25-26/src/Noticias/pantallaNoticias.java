package Noticias;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

public class pantallaNoticias extends JPanel{
	private Usuario usuario;
	private JButton botonEconomia;
	private JButton botonDeportes;
	private JButton botonNacional;
	private JButton botonInternacional;
	private JButton botonVideojuegos;
	private JButton botonReligiosas;
	public pantallaNoticias(Marco frame, ArrayList<Usuario> listaUsuarios) {
		setBounds(100,100,800,600);
		setLayout(null);
		
		if(usuario.getEsAdmin() == true) {
			
		}else {
			
		}
		botonEconomia = new JButton("Economía");
		botonEconomia.setBounds(86, 203, 89, 23);
		add(botonEconomia);
		
		botonDeportes = new JButton("Deportes");
		botonDeportes.setBounds(310, 201, 89, 23);
		add(botonDeportes);
		
		botonNacional = new JButton("Nacional");
		botonNacional.setBounds(537, 214, 89, 23);
		add(botonNacional);
		
		botonInternacional = new JButton("Internacional");
		botonInternacional.setBounds(107, 303, 89, 23);
		add(botonInternacional);
		
		botonVideojuegos = new JButton("Videojuegos");
		botonVideojuegos.setBounds(310, 330, 89, 23);
		add(botonVideojuegos);
		
		botonReligiosas = new JButton("Religiosas");
		botonReligiosas.setBounds(535, 327, 89, 23);
		add(botonReligiosas);
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
