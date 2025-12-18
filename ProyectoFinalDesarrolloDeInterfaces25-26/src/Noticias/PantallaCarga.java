package Noticias;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class PantallaCarga extends JWindow{
	JProgressBar barraProgreso;
	Timer tiempo;
	int i = 0;
	ImageIcon np = new ImageIcon("Extras/Imagenes/np.png");
	File archivoNp = new File("Extras/Imagenes/np.png");
	File fotoUsuario = new File("Extras/Imagenes/fotoUsuario.png");
	File ojoAbierto = new File("Extras/Imagenes/OjoAbierto.png");
	File ojoCerrado = new File("Extras/Imagenes/OjoCerrado.png");
	private File archivoUsuarios = new File("Extras/TXTs/usuarios.txt");
	private File configs = new File("Extras/TXTs/configuraciones.txt");
	private File archivoLog = new File("Extras/TXTs/log.txt");
	public PantallaCarga (final ArrayList<Usuario> listaUsuarios) {
		JLabel panelFondo = new JLabel(np);
		panelFondo.setLayout(new BorderLayout());
		
		barraProgreso = new JProgressBar(0,100);
		barraProgreso.setStringPainted(true);
		barraProgreso.setBorderPainted(false);
        panelFondo.add(barraProgreso, BorderLayout.SOUTH);
		
        setContentPane(panelFondo);
        pack();
		//setSize(300, 50);
        setLocationRelativeTo(null);

		tiempo = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i+=20;
				barraProgreso.setValue(i);
				if(i==80) {
					
					try {
						InetAddress direccion = InetAddress.getByName("8.8.8.8");
						if(!direccion.isReachable(3000)) {
							JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar conectarse a internet.");
							tiempo.stop();
							dispose();
						}else {
							UsuariosGestionar gestion = new UsuariosGestionar();
							gestion.iniciarUsuarios(listaUsuarios);
							if(listaUsuarios.isEmpty() || !archivoUsuarios.exists() || !configs.exists() || !archivoLog.exists() || !archivoNp.exists() || !fotoUsuario.exists() || !ojoAbierto.exists() || !ojoCerrado.exists()) {
								JOptionPane.showMessageDialog(null, "Error crítico: No se han podido cargar los usuarios o los archivos. La aplicación se cerrará.");
								tiempo.stop();
								dispose();
							}
						}
					}catch(Exception ex) {
						tiempo.stop();
						dispose();
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.");
					}
				} 
				if(i==100) {
					tiempo.stop();
					dispose();
					Marco miVentana = new Marco(listaUsuarios);
					miVentana.setVisible(true);
					
				}
			}
		});
		
		tiempo.start();

	}
}