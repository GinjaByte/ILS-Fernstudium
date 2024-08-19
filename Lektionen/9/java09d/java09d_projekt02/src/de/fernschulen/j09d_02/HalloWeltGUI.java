package de.fernschulen.j09d_02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//das Swing-Fenster
//die Klasse erbt von der Swing-Klasse JFrame
//JFrame bildet ein Anwendungsfenster ab
public class HalloWeltGUI extends JFrame{

	//die ID wurde automatisch über Eclipse eingefügt
	private static final long serialVersionUID = 6515501657865745493L;

	//der Konstruktor
	//er ruft den Konstruktor der Basisklasse auf
	//übergibt den Titel des Fensters
	//erzeugt die Komponenten und setzt weitere Eigenschaften des Fensters
	public HalloWeltGUI(String fenstertitel) {
		super(fenstertitel);
		//ein neues Label erzeugen
		JLabel ausgabe = new JLabel("Hallo Welt");
		//ein weiteres Label erzeugen
		JLabel ausgabe2 = new JLabel("Es grüßt Dich Max Meier");
		//eine Schaltfläche erzeugen
		JButton schaltflaeche = new JButton("Beenden");
		//ein Layout anwenden
		setLayout(new FlowLayout());
		//die Komponenten hinzufügen
		add(ausgabe);
		add(ausgabe2);
		add(schaltflaeche);
		//die Verbindung zwischen der Schaltfläche und dem Listener herstellen
		//übergeben wird eine neue Instanz unserer eigenen Listener-Klasse
		schaltflaeche.addActionListener(new SchaltflaecheListener());
		//das Fenster packen
		pack();
		//das Verhalten beim Schließen setzen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//das Fenster sichtbar machen
		setVisible(true);
	}
}
