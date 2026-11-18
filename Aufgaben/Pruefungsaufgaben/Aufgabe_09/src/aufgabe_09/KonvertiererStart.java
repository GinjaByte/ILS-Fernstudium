package aufgabe_09;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KonvertiererStart extends JFrame {
	// nötige globale Variablen
	private JTextField textArabisch, textRoemisch;
	
	// Map zum schnellen Konvertieren römischer Ziffern
    private Map<Character, Integer> roemischeMap;
	// Alle römischen Zahlen in aufsteigender Reihenfolge
	private String roemischeReihenfolge = "IVXLCDM";
    
	
	// die innere Klasse für den ActionListener
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("zu römisch"))
				zuRoemisch();
			if (e.getActionCommand().equals("zu arabisch"))
				zuArabisch();
		}
	}
	
	
	// der Konstruktor
	public KonvertiererStart(String titel) {
		super(titel);
		
		// map initialisieren
		roemischeMap = new HashMap<>();
		roemischeMap.put('I', 1);
    	roemischeMap.put('V', 5);
        roemischeMap.put('X', 10);
        roemischeMap.put('L', 50);
        roemischeMap.put('C', 100);
        roemischeMap.put('D', 500);
        roemischeMap.put('M', 1000);

		initGUI();
		
		// Größe setzen, Standardverhalten festlegen und anzeigen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// erzeugt die ganze GUI
	private void initGUI() {
		setLayout(new BorderLayout());

		// Label für die Pfeile
		JPanel panelPfeile = new JPanel();
		panelPfeile.setLayout(new BoxLayout(panelPfeile, BoxLayout.Y_AXIS));
		
		// Buttons zum umrechnen
		JButton btnArabToRoem = new JButton();
		JButton btnRoemToArab = new JButton();
		btnArabToRoem.setIcon(new ImageIcon(getClass().getResource("/aufgabe_09/icons/pfeilRechts.png")));
		btnRoemToArab.setIcon(new ImageIcon(getClass().getResource("/aufgabe_09/icons/pfeilLinks.png")));
		btnArabToRoem.setActionCommand("zu römisch");
		btnRoemToArab.setActionCommand("zu arabisch");
		MeinListener listener = new MeinListener();
		btnArabToRoem.addActionListener(listener);
		btnRoemToArab.addActionListener(listener);
		btnArabToRoem.setPreferredSize(new Dimension(25, 25));
		btnRoemToArab.setPreferredSize(new Dimension(25, 25));

		panelPfeile.add(btnArabToRoem);
		panelPfeile.add(btnRoemToArab);
		
		// Label für die arabische Zahl
		JPanel panelArabisch = new JPanel();
		panelArabisch.setLayout(new BoxLayout(panelArabisch, BoxLayout.Y_AXIS));
		JLabel labelArabisch = new JLabel("Arabische Zahl");
		textArabisch = new JTextField();
		textArabisch.setPreferredSize(new Dimension(150, 20));
		panelArabisch.add(labelArabisch);
		panelArabisch.add(textArabisch);
		
		// Label für die römische Zahl
		JPanel panelRoemisch = new JPanel();
		panelRoemisch.setLayout(new BoxLayout(panelRoemisch, BoxLayout.Y_AXIS));
		JLabel labelRoemisch = new JLabel("Römische Zahl");
		textRoemisch = new JTextField();
		textRoemisch.setPreferredSize(new Dimension(150, 20));
		panelRoemisch.add(labelRoemisch);
		panelRoemisch.add(textRoemisch);
		
		// Label für Fehlermeldungen
		JPanel panelAusgabe= new JPanel();
		textRoemisch.setPreferredSize(new Dimension(150, 20));
		
		// Panels zur root hinzufügen
		add(panelPfeile, BorderLayout.CENTER);
		add(panelArabisch, BorderLayout.WEST);
		add(panelRoemisch, BorderLayout.EAST);
	}
	
	// liest die arabische Zahl ein, rechnet sie um und zeigt sie in dem Feld für die römische Zahl an 
	private void zuRoemisch() {
		int arabischeZahl;
		
		try {
			arabischeZahl = Integer.parseInt(textArabisch.getText());
			
			textRoemisch.setText(arabischZuRoemisch(arabischeZahl));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Die Zahl im Feld für die arabische Zahl ist ungültig", "Ungültige Zahl", JOptionPane.ERROR_MESSAGE);
		}
	}

	// liest die römische Zahl ein, rechnet sie um und zeigt sie in dem Feld für die arabische Zahl an 
	private void zuArabisch() {
		String roemischeZahl = textRoemisch.getText();

		try {
			textArabisch.setText(Integer.toString(RoemischZuArabisch(roemischeZahl)));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Die Zahl im Feld für die römische Zahl ist ungültig", "Ungültige Zahl", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// konvertiere die übergebene arabische Zahl in eine römische Zahl und gebe sie als String zurück
	// nimmt an, dass die zahl eine gültige arabische Zahl zur Umwandlung ist (zwischen 1 und 3999). wirft sonst eine NumberFormatException
	private String arabischZuRoemisch(int zahl) throws NumberFormatException {
		if (zahl < 1 || zahl > 3999)
			throw new NumberFormatException();

        String[] tausender = {"", "M", "MM", "MMM"};
        String[] hunderter = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] zehner = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] einer = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return tausender[zahl / 1000] +
        		hunderter[(zahl % 1000) / 100] +
        		zehner[(zahl % 100) / 10] +
        		einer[zahl % 10];
	}
	
	// konvertiere die übergebene römische Zahl in eine arabische Zahl und gebe sie als int zurück
	// nimmt an, dass die zahl eine gültige römische Zahl ist. wirft sonst eine NumberFormatException
	private int RoemischZuArabisch(String zahl) throws NumberFormatException {		
		// Endresultat wird inkrementell erstellt
		int arabischeZahl = 0;
		
		// prüfe, ob die römische Zahl valide ist. Wirft eine NumberFormatException, falls nicht
		checkRoemischeZahl(zahl);
		
		// ab hier wird angenommen, dass die römische Zahl eine valide Zahl ist, da keine der Checks einen Fehler gegeben hat
		// Konvertierung der Zahl Ziffer für Ziffer
		for (int i = 0; i < zahl.length(); i++) {
			char ziffer = zahl.charAt(i);
			char naechsteZiffer = 0;
			if (i + 1 < zahl.length())
				naechsteZiffer = zahl.charAt(i+1);
			
			if (naechsteZiffer != 0 && roemischeMap.get(naechsteZiffer) > roemischeMap.get(ziffer)) {
				// wenn es eine nächste Ziffer gibt und diese größer ist als die aktuelle:
				// zähle die aktuelle und nächste Zahl zusammen und überspringe die nächste Zahl
				arabischeZahl += roemischeMap.get(naechsteZiffer) - roemischeMap.get(ziffer);
				i++;
			} else {
				// sonst: addiere nur die entsprechende ziffer
				arabischeZahl += roemischeMap.get(ziffer);
			}
		}
		
		return arabischeZahl;
	}
	
	// prüfe, ob die römische Zahl valide ist. Wirft eine NumberFormatException, falls nicht
	private void checkRoemischeZahl(String zahl) throws NumberFormatException {
		int count = 0;
		char c = 0;
		char lastChar;
		// prüfe, ob es irgendwelche anderen Zeichen gitb als die römischen Werte
		for (int i = 0; i < zahl.length(); i++) {
			if (!roemischeReihenfolge.contains(Character.toString(zahl.charAt(i))))
				throw new NumberFormatException();
		}

		// prüfe, ob mehr als 3 gleiche Zeichen hintereinander stehen
		for (int i = 0; i < zahl.length(); i++) {
			lastChar = c;
			c = zahl.charAt(i);
			
			if (c == lastChar) {
				if (count == 0)
					count = 2;
				else
					count++;
			}
			
			if (count > 3)
				throw new NumberFormatException();
		}
		
		// prüfe, ob 2 gleiche und dann später ein höherer Wert kommen
		for (int i = 0; i < zahl.length(); i++) {
			lastChar = c;
			c = zahl.charAt(i);
			
			if (c == lastChar) {
				// zwei gleiche Zahlen nacheinander gefunden:
				// prüfe nach einem späteren höheren Wert
				for (int k = i + 1; k < zahl.length(); k++) {
					char c2 = zahl.charAt(k);
					if (roemischeReihenfolge.indexOf(c2) > roemischeReihenfolge.indexOf(c))
						throw new NumberFormatException();
				}
			}
		}
		
		// prüfe, ob es invalide Konstrukte gibt, die anders dargestellt werden: VIV, LXL, DCD
		if (zahl.contains("VIV") || zahl.contains("LXL") || zahl.contains("DCD")) {
			throw new NumberFormatException();
		}
		
		// prüfe, ob nach einem Wert ein Wert kommt, der mehr als 2 Werte größer ist
		for (int i = 0; i + 1 < zahl.length(); i++) {
			c = zahl.charAt(i);
			if (roemischeReihenfolge.indexOf(zahl.charAt(i + 1)) > roemischeReihenfolge.indexOf(zahl.charAt(i + 1)) + 2)
				throw new NumberFormatException();
		}
		
		
		// -------------------------------------------------- ! ! ! ! ! ! ! ! ! ! -------------------------------------------------- 
		// weitere (zunehmend seltsame) Checks nach invaliden Formaten werden nicht ausgeführt, da diese nicht in der Aufgabenstellung waren 
		// und ich mich "jeweils peinlichst genau an die Aufgabenstellung und an eventuell formulierte Randbedingungen" halten soll
		
		// andere Fehlerhafte Konstrukte, nach denen nicht gesucht wird wären zum Beispiel:
			// es erscheinen 2 VV / LL / DD hintereinander
			// V / L / D können nicht vor größeren Werten stehen
			// nach einem Wert kommen mindestens 2 Werte, die höher sind
		
	}
}
