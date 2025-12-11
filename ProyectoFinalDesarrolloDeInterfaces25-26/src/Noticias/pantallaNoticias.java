package Noticias;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class pantallaNoticias extends JPanel{
	private Usuario usuario;
	private JButton botonEconomia;
	private JButton botonDeportes;
	private JButton botonNacional;
	private JButton botonInternacional;
	private JButton botonVideojuegos;
	private JButton botonReligiosas;
	private JLabel fuente1;
	private JLabel fuente2;
	private JLabel fuente3;
	private JTextArea titular1;
	private JTextArea titular2;
	private JTextArea titular3;
	private JButton botonVolver;
	Operaciones operaciones = new Operaciones();
	private JButton botonVolverAdmin;
	private JButton botonVolverUsuario;
	public pantallaNoticias(Marco frame, ArrayList<Usuario> listaUsuarios) {
		setBounds(100,100,800,600);
		setLayout(null);
		
		
		botonEconomia = new JButton("Economía");
        botonEconomia.setBounds(124, 153, 160, 100); 
        botonEconomia.setVisible(false);
        botonEconomia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setText("El País");
				fuente2.setText("El Economista");
				fuente3.setText("El Mundo");
				try {
				operaciones.noticiasEconomia1(titular1);
				operaciones.noticiasEconomia2(titular2);
				operaciones.noticiasEconomia3(titular3);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				botonEconomia.setVisible(false);
				botonDeportes.setVisible(false);
				botonNacional.setVisible(false);
				botonInternacional.setVisible(false);
				botonVideojuegos.setVisible(false);
				botonReligiosas.setVisible(false);
				fuente1.setVisible(true);
				fuente2.setVisible(true);
				fuente3.setVisible(true);
				titular1.setVisible(true);
				titular2.setVisible(true);
				titular3.setVisible(true);
				botonVolver.setVisible(true);
				botonVolverAdmin.setVisible(false);
			}
		});
        add(botonEconomia);

        botonDeportes = new JButton("Deportes");
        botonDeportes.setBounds(320, 153, 160, 100);
        botonDeportes.setVisible(false);
        botonDeportes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setText("Marca");
				fuente2.setText("RTVE.es");
				fuente3.setText("Mundo Deportivo");
				try {
					operaciones.noticiasDeportes1(titular1);
					operaciones.noticiasDeportes2(titular2);
					operaciones.noticiasDeportes3(titular3);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					botonEconomia.setVisible(false);
					botonDeportes.setVisible(false);
					botonNacional.setVisible(false);
					botonInternacional.setVisible(false);
					botonVideojuegos.setVisible(false);
					botonReligiosas.setVisible(false);
					fuente1.setVisible(true);
					fuente2.setVisible(true);
					fuente3.setVisible(true);
					titular1.setVisible(true);
					titular2.setVisible(true);
					titular3.setVisible(true);
					botonVolver.setVisible(true);
					botonVolverAdmin.setVisible(false);
			}
		});
        add(botonDeportes);

        botonNacional = new JButton("Nacional");
        botonNacional.setBounds(510, 153, 160, 100);
        botonNacional.setVisible(false);
        botonNacional.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setText("ABC");
				fuente2.setText("La Razón");
				fuente3.setText("Europa Press");
				try {
					operaciones.noticiasNacional1(titular1);
					operaciones.noticiasNacional2(titular2);
					operaciones.noticiasNacional3(titular3);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					botonEconomia.setVisible(false);
					botonDeportes.setVisible(false);
					botonNacional.setVisible(false);
					botonInternacional.setVisible(false);
					botonVideojuegos.setVisible(false);
					botonReligiosas.setVisible(false);
					fuente1.setVisible(true);
					fuente2.setVisible(true);
					fuente3.setVisible(true);
					titular1.setVisible(true);
					titular2.setVisible(true);
					titular3.setVisible(true);
					botonVolver.setVisible(true);
					botonVolverAdmin.setVisible(false);
			}
		});
        add(botonNacional);

        botonInternacional = new JButton("Internacional");
        botonInternacional.setBounds(124, 298, 160, 100);
        botonInternacional.setVisible(false);
        botonInternacional.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setText("CNN en Español");
				fuente2.setText("BBC");
				fuente3.setText("20Minutos");
				try {
					operaciones.noticiasInternacional1(titular1);
					operaciones.noticiasInternacional2(titular2);
					operaciones.noticiasInternacional3(titular3);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					botonEconomia.setVisible(false);
					botonDeportes.setVisible(false);
					botonNacional.setVisible(false);
					botonInternacional.setVisible(false);
					botonVideojuegos.setVisible(false);
					botonReligiosas.setVisible(false);
					fuente1.setVisible(true);
					fuente2.setVisible(true);
					fuente3.setVisible(true);
					titular1.setVisible(true);
					titular2.setVisible(true);
					titular3.setVisible(true);
					botonVolver.setVisible(true);
					botonVolverAdmin.setVisible(false);
			}
		});
        add(botonInternacional);

        botonVideojuegos = new JButton("Videojuegos");
        botonVideojuegos.setBounds(320, 298, 160, 100);
        botonVideojuegos.setVisible(false);
        botonVideojuegos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setText("Vandal");
				fuente2.setText("Diario Público");
				fuente3.setText("Xataka");
				try {
					operaciones.noticiasVideojuegos1(titular1);
					operaciones.noticiasVideojuegos2(titular2);
					operaciones.noticiasVideojuegos3(titular3);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					botonEconomia.setVisible(false);
					botonDeportes.setVisible(false);
					botonNacional.setVisible(false);
					botonInternacional.setVisible(false);
					botonVideojuegos.setVisible(false);
					botonReligiosas.setVisible(false);
					fuente1.setVisible(true);
					fuente2.setVisible(true);
					fuente3.setVisible(true);
					titular1.setVisible(true);
					titular2.setVisible(true);
					titular3.setVisible(true);
					botonVolver.setVisible(true);
					botonVolverAdmin.setVisible(false);
			}
		});
        add(botonVideojuegos);

        botonReligiosas = new JButton("Religiosas");
        botonReligiosas.setBounds(510, 298, 160, 100);
        botonReligiosas.setVisible(false);
        botonReligiosas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		fuente1.setText("Vida Nueva");
        		fuente2.setText("Vatican News");
        		fuente3.setText("Religión en Libertad");
        		try {
    				operaciones.noticiasReligiosas1(titular1);
    				operaciones.noticiasReligiosas2(titular2);
    				operaciones.noticiasReligiosas3(titular3);
    				}catch(Exception ex) {
    					ex.printStackTrace();
    				}
    				botonEconomia.setVisible(false);
    				botonDeportes.setVisible(false);
    				botonNacional.setVisible(false);
    				botonInternacional.setVisible(false);
    				botonVideojuegos.setVisible(false);
    				botonReligiosas.setVisible(false);
    				fuente1.setVisible(true);
    				fuente2.setVisible(true);
    				fuente3.setVisible(true);
    				titular1.setVisible(true);
    				titular2.setVisible(true);
    				titular3.setVisible(true);
    				botonVolver.setVisible(true);
    				botonVolverAdmin.setVisible(false);
        	}
        });
        add(botonReligiosas);
        
        fuente1 = new JLabel("");
        fuente1.setFont(new Font("Tahoma", Font.BOLD, 12));
        fuente1.setBounds(58, 116, 312, 17);
        fuente1.setVisible(false);
        add(fuente1);
        
        fuente2 = new JLabel("");
        fuente2.setFont(new Font("Tahoma", Font.BOLD, 12));
        fuente2.setBounds(58, 253, 312, 17);
        fuente2.setVisible(false);
        add(fuente2);
        
        fuente3 = new JLabel("");
        fuente3.setFont(new Font("Tahoma", Font.BOLD, 12));
        fuente3.setBounds(58, 390, 312, 17);
        fuente3.setVisible(false);
        add(fuente3);
        
        titular1 = new JTextArea("");
        titular1.setEditable(false);
        titular1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        titular1.setLineWrap(true);
        titular1.setBackground(null);
        titular1.setBounds(58, 144, 442, 74);
        titular1.setVisible(false);
        add(titular1);
        
        titular2 = new JTextArea("");
        titular2.setLineWrap(true);
        titular2.setEditable(false);
        titular2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        titular2.setBounds(58, 281, 442, 74);
        titular2.setBackground(null);
        titular2.setVisible(false);
        add(titular2);
        
        titular3 = new JTextArea("");
        titular3.setLineWrap(true);
        titular3.setEditable(false);
        titular3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        titular3.setBounds(58, 418, 442, 74);
        titular3.setBackground(null);
        titular3.setVisible(false);
        add(titular3);
        
        botonVolver = new JButton("Volver");
        botonVolver.setBounds(686, 489, 89, 23);
        botonVolver.setVisible(false);
        botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fuente1.setVisible(false);
				fuente2.setVisible(false);
				fuente3.setVisible(false);
				titular1.setVisible(false);
				titular2.setVisible(false);
				titular3.setVisible(false);
				//
				//AL VOLVER SE MUESTRAN TODAS LAS NOTICIAS, ENCONTRAR LA LÓGICAS PRA COMPROBAR EL USER
				//
				/*botonEconomia.setVisible(true);
				botonDeportes.setVisible(true);
				botonNacional.setVisible(true);
				botonInternacional.setVisible(true);
				botonVideojuegos.setVisible(true);
				botonReligiosas.setVisible(true);*/
				botonVolver.setVisible(false);
				mostrarBotones();
				comprobarAdmin();
				//botonVolverAdmin.setVisible(true);
			}
		});
        add(botonVolver);
        
        botonVolverAdmin = new JButton("Volver");
        botonVolverAdmin.setBounds(686, 489, 89, 23);
        botonVolverAdmin.setVisible(false);
        botonVolverAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaAdminVolver();
			}
		});
        add(botonVolverAdmin);
        
        botonVolverUsuario = new JButton("Volver");
        botonVolverUsuario.setBounds(686, 489, 89, 23);
        botonVolverUsuario.setVisible(false);
        botonVolverUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarPantallaUsuarioVolver();
			}
		});
        add(botonVolverUsuario);
        
        
        
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		botonEconomia.setVisible(false);
	    botonDeportes.setVisible(false);
	    botonNacional.setVisible(false);
	    botonInternacional.setVisible(false);
	    botonVideojuegos.setVisible(false);
	    botonReligiosas.setVisible(false);
		
		comprobarAdmin();
		
		mostrarBotones();
	}
	
	public void mostrarBotones() {
		if(usuario.getEsAdmin() == true) {
			botonEconomia.setVisible(true);
			botonDeportes.setVisible(true);
			botonNacional.setVisible(true);
			botonInternacional.setVisible(true);
			botonVideojuegos.setVisible(true);
			botonReligiosas.setVisible(true);
		}else {
			String[] preferencias;
			preferencias = operaciones.consultarPreferencias(usuario.getNombre());
			if(preferencias != null) {
				for (int i = 1; i < preferencias.length; i++) {
					switch (preferencias[i]) {
					case "Economia":
						botonEconomia.setVisible(true);
						break;
					case "Deportes":
						botonDeportes.setVisible(true);
						break;
					case "Nacional":
						botonNacional.setVisible(true);
						break;
					case "Internacional":
						botonInternacional.setVisible(true);
						break;
					case "Videojuegos":
						botonVideojuegos.setVisible(true);
						break;
					case "Religiosas":
						botonReligiosas.setVisible(true);
						break;
					default:

					}
				}
			}
		}
	}
	
	public void comprobarAdmin() {
		if(usuario.getEsAdmin()) {
			botonVolverAdmin.setVisible(true);
			botonVolverUsuario.setVisible(false);
		}else {
			botonVolverUsuario.setVisible(true);
			botonVolverAdmin.setVisible(false);
		}
	}
}
