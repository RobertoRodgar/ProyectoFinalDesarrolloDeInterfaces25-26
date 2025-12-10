package Noticias;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
	private JLabel titular1;
	private JLabel titular2;
	private JLabel titular3;
	public pantallaNoticias(Marco frame, ArrayList<Usuario> listaUsuarios) {
		setBounds(100,100,800,600);
		setLayout(null);
		
		if(usuario.getEsAdmin() == true) {
			botonEconomia.setVisible(true);
			botonDeportes.setVisible(true);
			botonNacional.setVisible(true);
			botonInternacional.setVisible(true);
			botonVideojuegos.setVisible(true);
			botonReligiosas.setVisible(true);
		}else {
			
		}
		botonEconomia = new JButton("Economía");
        botonEconomia.setBounds(124, 153, 160, 100); 
        botonEconomia.setVisible(false);
        add(botonEconomia);

        botonDeportes = new JButton("Deportes");
        botonDeportes.setBounds(320, 153, 160, 100);
        botonDeportes.setVisible(false);
        add(botonDeportes);

        botonNacional = new JButton("Nacional");
        botonNacional.setBounds(510, 153, 160, 100);
        botonNacional.setVisible(false);
        add(botonNacional);

        botonInternacional = new JButton("Internacional");
        botonInternacional.setBounds(124, 298, 160, 100);
        botonInternacional.setVisible(false);
        add(botonInternacional);

        botonVideojuegos = new JButton("Videojuegos");
        botonVideojuegos.setBounds(320, 298, 160, 100);
        botonVideojuegos.setVisible(false);
        add(botonVideojuegos);

        botonReligiosas = new JButton("Religiosas");
        botonReligiosas.setBounds(510, 298, 160, 100);
        botonReligiosas.setVisible(false);
        botonReligiosas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        
        titular1 = new JLabel("");
        titular1.setVerticalAlignment(SwingConstants.TOP);
        titular1.setBounds(58, 144, 442, 74);
        titular1.setVisible(false);
        add(titular1);
        
        titular2 = new JLabel("");
        titular2.setVerticalAlignment(SwingConstants.TOP);
        titular2.setBounds(58, 281, 442, 74);
        titular2.setVisible(false);
        add(titular2);
        
        titular3 = new JLabel("");
        titular3.setVerticalAlignment(SwingConstants.TOP);
        titular3.setBounds(58, 418, 442, 74);
        titular3.setVisible(false);
        add(titular3);
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
