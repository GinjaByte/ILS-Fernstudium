package de.fernschulen.j09d_01;

//für die Konstante zum Schließen des Swing-Fensters
import javax.swing.JFrame;

public class AWTSwingDemoProgramm {
	public static void main(String[] args) {
		//ein neues AWT-Fenster erstellen
		AWTFenster awtFenster = new AWTFenster("Hallo Welt mit AWT");
		//das Fenster "packen"
		awtFenster.pack();
		//und anzeigen
		awtFenster.setVisible(true);
		
		//ein neues Swing-Fenster erstellen
		SwingFenster swingFenster = new SwingFenster("Hallo Welt mit Swing");
		//die Standard-Aktion beim Schließen des Fensters setzen
		//hier wird die gesamte Anwendung beendet
		swingFenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//das Fenster "packen"
		swingFenster.pack();
		//und anzeigen
		swingFenster.setVisible(true);
	}
}
