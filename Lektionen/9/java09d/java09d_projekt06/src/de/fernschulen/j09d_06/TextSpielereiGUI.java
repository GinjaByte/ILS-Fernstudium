package de.fernschulen.j09d_06;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TextSpielereiGUI extends JFrame{
	
	//die ID wurde automatisch mit Eclipse ergänzt
	private static final long serialVersionUID = 9101793356610287754L;

	//ein Label und zwei Schaltflächen als Instanzvariablen
	private JLabel ausgabe;
	private JButton schaltflaecheGroesser, schaltflaecheKleiner;
	//für die aktuelle Schriftgröße
	private int schriftGroesse;
	
	//eine innere Klasse für den WindowListener und den ActionListener
	//die Klasse ist von WindowAdapter abgeleitet und
	//implementiert die Schnittstelle ActionListener
	class MeinKompakterListener extends WindowAdapter implements ActionListener{
		//für das Öffnen des Fensters
		@Override
		public void windowOpened(WindowEvent e) {
			//für die Eingabe
			String eingabe;
			eingabe = JOptionPane.showInputDialog("Geben Sie einen Text ein");
			//den Text in das Label setzen
			ausgabe.setText(eingabe);
			//das Fenster neu "packen"
			pack();
		}

		//für die Schaltflächen
		@Override
		public void actionPerformed(ActionEvent e) {
			//wurde auf Größer geklickt
			if (e.getActionCommand().equals("<")) 
				//die Schriftgröße um 1 erhöhen
				schriftGroesse++;
			//wurde auf Kleiner geklickt
			if (e.getActionCommand().equals(">")) 
				//die Schriftgröße um 1 verringern
				schriftGroesse--;
			//und neu setzen
			ausgabe.setFont(new Font("Arial", Font.PLAIN, schriftGroesse));
			//das Fenster neu "packen"
			pack();
		}
	}

	//der Konstruktor
	//er erzeugt die Komponenten und setzt die Fenstereinstellungen
	public TextSpielereiGUI(String titel) {
		//den Konstruktor der Basisklasse aufrufen und den Fenstertitel übergeben
		super(titel);
		//die beiden Schaltflächen
		schaltflaecheGroesser = new JButton("<");
		schaltflaecheKleiner = new JButton(">");
		//ein leeres Label
		ausgabe = new JLabel();
		
		//die Größe für die Schrift setzen
		schriftGroesse = 10;
		//die Schriftart im Label setzen
		ausgabe.setFont(new Font("Arial",Font.PLAIN, schriftGroesse));
		//ein Layout anwenden
		setLayout(new FlowLayout());
		add(schaltflaecheGroesser);
		add(schaltflaecheKleiner);
		add(ausgabe);
		
		//den Listener verbinden
		MeinKompakterListener listener = new MeinKompakterListener();
		addWindowListener(listener);
		schaltflaecheGroesser.addActionListener(listener);
		schaltflaecheKleiner.addActionListener(listener);
		
		//das Fenster packen
		pack();
		//die Standardaktion beim Schließen festlegen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//das Fenster anzeigen
		setVisible(true);
	}
}
