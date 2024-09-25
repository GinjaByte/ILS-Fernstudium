package aufgabe_06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class GrundstueckeStart extends JFrame{
	private JTextField textLaenge, textBreite, textPreisProQm; 
	JLabel labelGrundpreis, labelProvision, labelMehrwertsteuer;
	
	// die innere Klasse für den ActionListener
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("berechnen"))
				berechnen();
			if (e.getActionCommand().equals("ende"))
				beenden();
		}
	}
	
	// der Konstruktor
	public GrundstueckeStart(String titel) {
		super(titel);
		// ein äußeres Grid Layout
		setLayout(new GridLayout(7, 2));
		
		
		// die Textfelder für Input
		textLaenge = new JTextField();
		textBreite = new JTextField();
		textPreisProQm = new JTextField();
		add(new JLabel("Länge des Grundstücks"));
		add(textLaenge);
		add(new JLabel("Breite des Grundstücks"));
		add(textBreite);
		add(new JLabel("Preis pro Qudratmeter"));
		add(textPreisProQm);
		
		// Label für die Anzeige der Ergebnisse
		labelGrundpreis = new JLabel();
		labelProvision = new JLabel();
		labelMehrwertsteuer = new JLabel();
		add(new JLabel("Grundpreis: "));
		add(labelGrundpreis);
		add(new JLabel("mit Provision (5%): "));
		add(labelProvision);
		add(new JLabel("mit Provision (5%) und Mwst (19%): "));
		add(labelMehrwertsteuer);
		
		// die Schaltflächen
		JButton buttonBerechnen = new JButton("Berechnen");
		JButton buttonBeenden = new JButton("Beenden");
		buttonBerechnen.setActionCommand("berechnen");
		buttonBeenden.setActionCommand("ende");
		
		MeinListener listener = new MeinListener();
		buttonBerechnen.addActionListener(listener);
		buttonBeenden.addActionListener(listener);
	
		add(buttonBerechnen);
		add(buttonBeenden);
		
		// Größe setzen, Standardverhalten festlegen und anzeigen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void berechnen() {
		// symbolische Konstanten für Aufschläge
		final double PROVISION = 0.05;
		final double MWST = 0.19;
		
		// Eingaben mit Punkt/Komma möglich
		double laenge = Double.parseDouble(textLaenge.getText().replace(',', '.'));
		double breite = Double.parseDouble(textBreite.getText().replace(',', '.'));
		double preisProQm = Double.parseDouble(textPreisProQm.getText().replace(',', '.'));
		
		// Bereichnungs des Grundpreises
		double preis = laenge * breite * preisProQm;

		// Ausgaben und Berechnung der Preise mit Aufschlägen
	    labelGrundpreis.setText(String.format("%.2f", preis));
		preis += preis * PROVISION;
	    labelProvision.setText(String.format("%.2f", preis));
		preis += preis * MWST;
	    labelMehrwertsteuer.setText(String.format("%.2f", preis));
	}
	
	private void beenden() {
		System.exit(0);
	}
}
