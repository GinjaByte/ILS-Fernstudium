package de.fernschulen.j09d_04;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TextTauscherGUI extends JFrame {
	//die ID wurde automatisch mit Eclipse ergänzt
	private static final long serialVersionUID = -6104907653187043005L;

	//zwei Labels und zwei Schaltflächen als Instanzvariablen
	private JLabel ausgabe1, ausgabe2;
	private JButton schaltflaeche1, schaltflaeche2;
	
	//der Konstruktor
	//er erzeugt die Komponenten und setzt die Fenstereinstellungen
	public TextTauscherGUI(String titel) {
		//den Konstruktor der Basisklasse aufrufen und den Fenstertitel übergeben
		super(titel);
		//die Komponenten erzeugen und hinzufügen
		ausgabe1 = new JLabel("Ich stehe eigentlich links");
		ausgabe2 = new JLabel("Und ich stehe eigentlich rechts");
		schaltflaeche1 = new JButton("Text tauschen");
		schaltflaeche2 = new JButton("Beenden");
		//ein Layout anwenden
		setLayout(new FlowLayout());
		add(ausgabe1);
		add(ausgabe2);
		add(schaltflaeche1);
		add(schaltflaeche2);
		//beide Schaltflächen werden mit demselben Listener verbunden
		//dabei wird die Referenz auf die Instanz übergeben
		SchaltflaechenListener listener = new SchaltflaechenListener(this); 
		schaltflaeche1.addActionListener(listener);
		schaltflaeche2.addActionListener(listener);
		//das Fenster packen
		pack();
		//die Standardaktion beim Schließen festlegen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//das Fenster anzeigen
		setVisible(true);
	}
	
	//die Methode tauscht die Texte in den beiden Labels
	public void texteTauschen() {
		//zum Sichern des Textes
		String sichern;
		//den Text des ersten Labels zwischenspeichern
		sichern = ausgabe1.getText();
		//das erste Label bekommt den Text des zweiten
		ausgabe1.setText(ausgabe2.getText());
		//und das zweite Label den gesicherten Text
		ausgabe2.setText(sichern);
	}
}
