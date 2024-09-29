package aufgabe_08;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BanditStart extends JFrame {
	// nötige globale Variablen
	private JLabel labelWuerfel1, labelWuerfel2, labelWuerfel3, labelGuthaben;
	private JButton btnWuerfeln;
	private int guthaben;
	
	// "mapped" eine Zahl auf das dazugehörige Würfel Icon
	private Map<Integer, ImageIcon> iconMap;

		
	// die innere Klasse für den ActionListener
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("wuerfeln"))
				wuerfeln();
		}
	}
	
	
	// der Konstruktor
	public BanditStart(String titel) {
		super(titel);

		// Map für Icons initialisieren - so dass es sowohl in Eclipse, als auch nach einem Export funktioniert
		iconMap = new HashMap<Integer, ImageIcon>();
		iconMap.put(1, new ImageIcon(getClass().getResource("/aufgabe_08/icons/eins.png")));
		iconMap.put(2, new ImageIcon(getClass().getResource("/aufgabe_08/icons/zwei.png")));
		iconMap.put(3, new ImageIcon(getClass().getResource("/aufgabe_08/icons/drei.png")));
		iconMap.put(4, new ImageIcon(getClass().getResource("/aufgabe_08/icons/vier.png")));
		iconMap.put(5, new ImageIcon(getClass().getResource("/aufgabe_08/icons/fuenf.png")));
		iconMap.put(6, new ImageIcon(getClass().getResource("/aufgabe_08/icons/sechs.png")));
	
		guthaben = 100;	
		initGUI();
		labelGuthaben.setText(String.format("Guthaben: %d", guthaben));
		
		// Größe setzen, Standardverhalten festlegen und anzeigen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	// erzeugt die ganze GUI
	private void initGUI() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 200));
		
		// Label für Würfel
		JPanel panelWuerfel = new JPanel();
		panelWuerfel.setLayout(new FlowLayout());
		labelWuerfel1 = new JLabel();
		labelWuerfel2 = new JLabel();
		labelWuerfel3 = new JLabel();
		setWuerfel(labelWuerfel1, 6);
		setWuerfel(labelWuerfel2, 6);
		setWuerfel(labelWuerfel3, 6);
		panelWuerfel.add(labelWuerfel1);
		panelWuerfel.add(labelWuerfel2);
		panelWuerfel.add(labelWuerfel3);
		
		// Ausgabe des Guthabens und Button zum Würfeln
		JPanel panelSteuerung= new JPanel();
		panelSteuerung.setLayout(new FlowLayout());
		
		labelGuthaben = new JLabel();
		
		btnWuerfeln= new JButton("Würfeln!");
		MeinListener listener = new MeinListener();
		btnWuerfeln.setActionCommand("wuerfeln");
		btnWuerfeln.addActionListener(listener);

		panelSteuerung.add(labelGuthaben);
		panelSteuerung.add(btnWuerfeln);
		
		// Panels zur root hinzufügen
		add(panelWuerfel, BorderLayout.CENTER);
		add(panelSteuerung, BorderLayout.SOUTH);
	}
	
	// Wuerfelt die Würfel und passt das Guthaben entsprechend an 
	private void wuerfeln() {
		btnWuerfeln.setEnabled(true);
		
		int guthabenDavor = guthaben;
		guthaben -= 10;
		
		int zahl1 = (int) (Math.random() * 6) + 1;
		int zahl2 = (int) (Math.random() * 6) + 1;
		int zahl3 = (int) (Math.random() * 6) + 1;
		setWuerfel(labelWuerfel1, zahl1);
		setWuerfel(labelWuerfel2, zahl2);
		setWuerfel(labelWuerfel3, zahl3);
		
		// Checks für die Gewinne
		if (zahl1 == zahl2 && zahl2 == zahl3) {
			guthaben += 100;
		} else if (zahl1 == zahl2 || zahl1 == zahl3 || zahl2 == zahl3) {
			guthaben += 20;
		}
		
		// update das Guthaben und zeige Veränderung (Gewinn/Verlust) an
		labelGuthaben.setText(String.format("Guthaben: %d (%+d)", guthaben, guthaben - guthabenDavor));
		
		// wenn kein Guthaben mehr: Spiel beenden (nach einem 5 Sekunden Timer)
		if (guthaben <= 0) {
	        Timer timer = new Timer();
	        TimerTask taskBeenden = new TimerTask() {
	            @Override
	            public void run() {
	                System.exit(0);  // Beendet das Programm
	            }
	        };

	        timer.schedule(taskBeenden, 5000);
	        labelGuthaben.setText("Kein Guthaben mehr. Das Programm wird in 5 Sekunden beendet");
		} else {
			btnWuerfeln.setEnabled(true);
		}
	}
	
	
	// Setzt das Icon eines Labels auf das Würfel Icon der jeweiligen Zahl (von 1 bis 6)
	private void setWuerfel(JLabel label, int zahl) {
		// nur Zahlen von 1-6 zulassen
		if (zahl < 1 && zahl > 6) {
			return;
		}
		
		ImageIcon icon = iconMap.get(zahl);
		label.setIcon(icon);
	}
}
