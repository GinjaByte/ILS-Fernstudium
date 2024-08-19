package de.fernschulen.j09d_03;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class FensterListener implements WindowListener{

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
		//für den Zugriff auf die Instanz der Klasse mit der grafischen Oberfläche
		HalloWeltGUI temp;
		//für die Eingabe
		String eingabe;
		//die Eingabe einlesen
		eingabe = JOptionPane.showInputDialog("Wer will die Welt grüßen?");
		//temp erhält die Referenz des Aufrufers
		//das Ergebnis von e.getSource() muss in den passenden Typen umgewandelt werden
		temp = (HalloWeltGUI)e.getSource();
		//die Methode setAusgabe2Text über temp aufrufen
		temp.setAusgabe2Text(eingabe);
	}
}
