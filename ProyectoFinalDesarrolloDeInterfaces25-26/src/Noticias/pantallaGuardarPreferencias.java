package Noticias;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class pantallaGuardarPreferencias extends JPanel {
    private JFrame framePrincipal;
    private Usuario usuario;
    private JLabel pregunta;
    private JCheckBox botonEconomia;
    private JCheckBox botonDeportes;
    private JCheckBox botonNacional;
    private JCheckBox botonInternacional;
    private JCheckBox botonVideojuegos;
    private JCheckBox botonReligiosas;
    private JButton botonSiguiente;
    private JLabel textoError;
    private Operaciones operaciones = new Operaciones();
    public pantallaGuardarPreferencias(Marco frame) {
        this.framePrincipal = frame;
        setBounds(100, 100, 800, 600);
        setLayout(null);


        
        pregunta = new JLabel("Selecciona las categorías que te interesan");
        pregunta.setFont(new Font("Segoe UI", Font.BOLD, 22));
        pregunta.setForeground(new Color(33, 33, 33)); 
        pregunta.setHorizontalAlignment(SwingConstants.CENTER);
        pregunta.setBounds(0, 40, 800, 40); 
        add(pregunta);

        
        botonEconomia = new JCheckBox("Economía");
        botonEconomia.setBounds(325, 120, 150, 30);
        botonEconomia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonEconomia.setFocusPainted(false);
        add(botonEconomia);

        botonDeportes = new JCheckBox("Deportes");
        botonDeportes.setBounds(325, 170, 150, 30);
        botonDeportes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonDeportes.setFocusPainted(false);
        add(botonDeportes);

        botonNacional = new JCheckBox("Nacional");
        botonNacional.setBounds(325, 220, 150, 30);
        botonNacional.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonNacional.setFocusPainted(false);
        add(botonNacional);

        botonInternacional = new JCheckBox("Internacional");
        botonInternacional.setBounds(325, 270, 150, 30);
        botonInternacional.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonInternacional.setFocusPainted(false);
        add(botonInternacional);

        botonVideojuegos = new JCheckBox("Videojuegos");
        botonVideojuegos.setBounds(325, 320, 150, 30);
        botonVideojuegos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonVideojuegos.setFocusPainted(false);
        add(botonVideojuegos);

        botonReligiosas = new JCheckBox("Religiosas");
        botonReligiosas.setBounds(325, 370, 150, 30);
        botonReligiosas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        botonReligiosas.setFocusPainted(false);
        add(botonReligiosas);
        
        botonSiguiente = new JButton("Guardar y siguiente");
        botonSiguiente.setBounds(617, 465, 127, 23);
        botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String preferencias = "";
				
                if (botonEconomia.isSelected()) {
                    preferencias += ";Economia";
                }
                if (botonDeportes.isSelected()) {
                    preferencias += ";Deportes";
                }
                if (botonNacional.isSelected()) {
                    preferencias += ";Nacional";
                }
                if (botonInternacional.isSelected()) {
                    preferencias += ";Internacional";
                }
                if (botonVideojuegos.isSelected()) {
                    preferencias += ";Videojuegos";
                }
                if (botonReligiosas.isSelected()) {
                    preferencias += ";Religiosas";
                }
				
                if(!preferencias.isEmpty()) {
                	preferencias = usuario.getNombre() + preferencias;
                	operaciones.guardarPreferencias(preferencias);
                	textoError.setText("");
                	usuario.setInicio(1);
                	operaciones.guardarUsuario(usuario.getNombre());
                	frame.mostrarPantallaUsuario(usuario);
                }else {
                	textoError.setText("Error. Debes seleccionar al menos una preferencia de las opciones");
                }
			}
		});
        add(botonSiguiente);
        
        textoError = new JLabel("");
        textoError.setFont(new Font("Tahoma", Font.BOLD, 13));
        textoError.setHorizontalAlignment(SwingConstants.CENTER);
        textoError.setBounds(208, 419, 380, 30);
        add(textoError);
        
        
    }
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
