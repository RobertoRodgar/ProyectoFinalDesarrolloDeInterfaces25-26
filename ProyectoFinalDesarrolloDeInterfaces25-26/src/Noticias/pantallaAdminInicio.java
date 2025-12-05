package Noticias;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class pantallaAdminInicio extends JPanel{
	private JFrame framePrincipal;
	private Usuario usuario;
	private JPanel panelCabecera;
	JLabel cabeceraAdmin;
	private JButton botonOpciones;
	private ImageIcon fotoUsuario = new ImageIcon("Extras/Imagenes/fotoUsuario.png");
	private JPanel panelOpciones;
	private JPanel panelCuerpo;
	public pantallaAdminInicio(JFrame frame) {
		this.framePrincipal = frame;
		setBounds(100,100,800,600);
		setLayout(null);
		
		panelOpciones = new JPanel();
		panelOpciones.setBackground(Color.MAGENTA);
		panelOpciones.setBounds(655, 70, 117, 143);
		add(panelOpciones);
		
		panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(128, 128, 128));
		panelCabecera.setBounds(0, 0, 800, 80);
		add(panelCabecera);
		panelCabecera.setLayout(null);
		
		cabeceraAdmin = new JLabel("Panel de Administración");
		cabeceraAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		cabeceraAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		cabeceraAdmin.setBounds(10, 22, 211, 36);
		panelCabecera.add(cabeceraAdmin);
		
		botonOpciones = new JButton("");
		botonOpciones.setBounds(714, 11, 58, 58);
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setIcon(fotoUsuario);
		botonOpciones.setBorder(null);
		panelCabecera.add(botonOpciones);
		
		panelCuerpo = new JPanel();
		panelCuerpo.setBounds(0, 80, 800, 520);
		add(panelCuerpo);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelOpciones, panelCuerpo}));
		
		
		
		
	}
	
	public void establecerUsuario(Usuario usuario) {
		this.usuario = usuario;
		
		/*if(usuario != null) {
			textotemp.setText(usuario.getNombre());
		}*/
	}
}
