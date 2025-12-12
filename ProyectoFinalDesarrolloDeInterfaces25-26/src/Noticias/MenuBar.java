package Noticias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar {
	public static JMenuBar getMenuBar(Marco frame) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuAyuda = new JMenu("Ayuda");
		
		JMenuItem AcercaDe = new JMenuItem("AcercaDe");
		AcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Version: v1.0\n Desarrollador:\n Roberto Rodíguez García", "AcercaDe",1);
			}
		});
		menuAyuda.add(AcercaDe);
		menuBar.add(menuAyuda);

		return menuBar;
	}
}
