package de.fernschulen.j09d_03a;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class FensterListener implements WindowListener{
	
	//eine Instanzvariable für die Referenz der Klasse mit der Oberfläche
	private HalloWeltGUI referenz;
	
	//der Konstruktor setzt die Referenz auf die Klasse der grafischen Oberfläche
	//die Referenz wird als Parameter übergeben
	public FensterListener(HalloWeltGUI referenz) {
		this.referenz = referenz;
	}

	//die "leeren" Methoden dürfen nicht gelöscht werden!!
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		//für die Eingabe
		String eingabe;
		//die Eingabe einlesen
		eingabe = JOptionPane.showInputDialog("Wer will die Welt grüßen?");
		//der Zugriff auf die Instanz der Klasse mit der grafischen Oberfläche
		//erfolgt über die Instanzvariable referenz
		referenz.setAusgabe2Text(eingabe);
	}
}
