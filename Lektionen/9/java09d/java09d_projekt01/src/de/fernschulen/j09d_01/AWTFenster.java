package de.fernschulen.j09d_01;

import java.awt.Frame;
import java.awt.Label;

//das AWT-Fenster
//die Klasse erbt von der AWT-Klasse Frame
//Frame bildet ein Anwendungsfenster ab
public class AWTFenster extends Frame{

	//die ID wurde automatisch über Eclipse eingefügt
	private static final long serialVersionUID = -4606955614012768129L;

	//der Konstruktor
	//er ruft den Konstruktor der Basisklasse auf
	//übergibt den Titel des Fensters
	//und erzeugt ein Label mit dem Text "Hallo Welt"
	public AWTFenster(String fenstertitel) {
		super(fenstertitel);
		//ein neues Label erzeugen
		Label ausgabe = new Label("Hallo Welt");
		//das Label hinzufügen
		add(ausgabe);
	}

}
