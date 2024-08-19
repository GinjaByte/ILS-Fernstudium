package de.fernschulen.j09d_08;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FensterBorder extends JFrame{
	
	//die ID wurde automatisch über Eclipse erzeugt
	private static final long serialVersionUID = 7661252556514353510L;

	public FensterBorder(String titel) {
		super(titel);
		JButton schaltflaeche1 = new JButton("Schaltfläche 1");
		JButton schaltflaeche2 = new JButton("Schaltfläche 2");
		JButton schaltflaeche3 = new JButton("Schaltfläche 3");
		JButton schaltflaeche4 = new JButton("Schaltfläche 4");
		JButton schaltflaeche5 = new JButton("Schaltfläche 5");

		//ein neues Border-Layout mit je 10 Pixeln Abstand setzen
		setLayout(new BorderLayout(10,10));
		
		//die Schaltfläche einfügen
		//dabei muss die "Himmelsrichtung" bzw. die Mitte angegeben werden
		add(BorderLayout.NORTH,schaltflaeche1);
		add(BorderLayout.EAST,schaltflaeche2);
		add(BorderLayout.CENTER,schaltflaeche3);
		add(BorderLayout.SOUTH,schaltflaeche4);
		add(BorderLayout.WEST,schaltflaeche5);
		
		//die Fenstergröße setzen
		setSize(400,400);
		
		//automatisch anordnen
		setLocationByPlatform(true);
		
		//und anzeigen
		setVisible(true);
	}
}
