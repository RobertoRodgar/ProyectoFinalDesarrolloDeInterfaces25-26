package Noticias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class PantallaCarga extends JWindow{
	JProgressBar barraProgreso;
	Timer tiempo;
	int i = 0;
	ImageIcon np = new ImageIcon("Extras/Imagenes/np.png");
	public PantallaCarga (final ArrayList<Usuario> listaUsuarios) {
		barraProgreso = new JProgressBar(0,100);
		barraProgreso.setStringPainted(true);
        add(barraProgreso);
		
		setSize(300, 50);
		

		tiempo = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i+=20;
				barraProgreso.setValue(i);
				if(i==100) {
					tiempo.stop();
					dispose();	
					UsuariosGestionar gestion = new UsuariosGestionar();
					gestion.iniciarUsuarios(listaUsuarios);
					if(listaUsuarios == null) {
						System.out.println("Ha ocurrido un error a la hora de cargar los usuarios.");
					}else {
						Marco miVentana = new Marco(listaUsuarios);
						miVentana.setVisible(true);
					}
				}
			}
		});
		
		tiempo.start();

	}
}