package de.fernschulen.j09d_01;

import javax.swing.JFrame;
import javax.swing.JLabel;

//das Swing-Fenster
//die Klasse erbt von der Swing-Klasse JFrame
//JFrame bildet ein Anwendungsfenster ab
public class SwingFenster extends JFrame{

	//die ID wurde automatisch über Eclipse eingefügt
	private static final long serialVersionUID = 2166027190024830871L;

	//der Konstruktor
	//er ruft den Konstruktor der Basisklasse auf
	//übergibt den Titel des Fensters
	//und erzeugt ein Label mit dem Text "Hallo Welt"
	public SwingFenster(String fenstertitel) {
		super(fenstertitel);
		//ein neues Label erzeugen
		JLabel ausgabe = new JLabel("Hallo Welt");
		//das Label hinzufügen
		add(ausgabe);
	}
}
