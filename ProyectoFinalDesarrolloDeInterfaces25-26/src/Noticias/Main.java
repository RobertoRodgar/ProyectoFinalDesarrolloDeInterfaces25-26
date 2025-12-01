package Noticias;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					Marco miVentana = new Marco();
					miVentana.setSize(1200, 800);
					miVentana.setVisible(true);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
