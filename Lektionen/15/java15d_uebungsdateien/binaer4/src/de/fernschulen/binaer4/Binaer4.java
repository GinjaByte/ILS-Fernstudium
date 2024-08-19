package de.fernschulen.binaer4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Binaer4 extends JFrame{
	//automatisch über Eclipse ergänzt
	private static final long serialVersionUID = 7153594179655951229L;
	//für die Schaltflächen
	private JButton einlesen, beenden;
	//für das Eingabefeld
	private JTextField suchkriterium;
	
	//die innere Klasse für den ActionListener
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//wurde auf Lesen geklickt?
			if (e.getActionCommand().equals("lesen"))
				//dann die Datei einlesen
				datenLesen();
			//wurde auf Beenden geklickt?
			if (e.getActionCommand().equals("ende"))
				System.exit(0);
		}
	}
	
	//der Konstruktor
	public Binaer4(String titel) {
		super(titel);
			
		//ein GridLayout mit 2 Spalten anwenden
		setLayout(new GridLayout(0, 2));
		//ein Label und ein Eingabefeld
		add(new JLabel("Suchkriterium: "));
		suchkriterium = new JTextField("0");
		add(suchkriterium);
		
		//die Schaltflächen
		einlesen = new JButton("Einlesen");
		einlesen.setActionCommand("lesen");
		beenden = new JButton("Beenden");
		beenden.setActionCommand("ende");
		
		MeinListener listener = new MeinListener();
		einlesen.addActionListener(listener);
		beenden.addActionListener(listener);
	
		add(einlesen);
		add(beenden);
		
		//gibt es die Datei daten.bin schon?
		File dateiTest = new File("liste.bin");
		//wenn nicht, erstellen wir sie neu
		if (dateiTest.exists() == false)
			datenSchreiben();
		
		//Größe setzen, Standard-Verhalten festlegen und anzeigen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//die Methode zum Lesen
	private void datenLesen() {
		int gesucht;
		//steht im Eingabefeld ein Wert?
		//sonst verlassen wir die Methode direkt wieder
		if (suchkriterium.getText().isEmpty())
			return;
		gesucht = Integer.parseInt(suchkriterium.getText());
		//geöffnet wird die Datei liste.bin im Nur-Lesen-Modus
		try (RandomAccessFile datei = new RandomAccessFile("liste.bin","r")){
			//für das Positionieren
			long neuePosition = 0;
			int punkte = 0;
			int treffer = 0;
			//die gesamte Datei durchsuchen
			while (datei.getFilePointer() < datei.length()) {
				//die Punktzahl lesen
				punkte = datei.readInt();
				//stimmen Punkte und Suchkriterium überein?
				if (punkte == gesucht) {
					//dann die Treffer erhöhen
					treffer++;
					//die Punkte anzeigen
					add(new JLabel(Integer.toString(punkte)));
					//den Namen lesen
					add(new JLabel(datei.readUTF()));
				}
				//wenn nicht, dann den Namen überlesen
				else {
					//die Länge beschaffen
					neuePosition = datei.readUnsignedShort();
					//die neue Position ansteuern
					datei.seek(datei.getFilePointer() + neuePosition);
				}
			}
			//wenn es keinen Treffer gab, eine Meldung ausgeben
			if (treffer == 0)
				JOptionPane.showMessageDialog(this, "Kein Treffer");
		}
		catch (IOException e ) {
			JOptionPane.showMessageDialog(this, "Beim Laden ist ein Problem aufgetreten");
	    }
		//das Fenster neu "packen"
		pack();
	}
	
	//die Methode zum Schreiben
	private void datenSchreiben() {
		//geöffnet wird die Datei liste.bin im Lese- und Schreibmodus
		try (RandomAccessFile datei = new RandomAccessFile("liste.bin","rw")){
			//ein paar Werte in die Datei schreiben
			datei.writeInt(100);
			datei.writeUTF("Wambo");
			datei.writeInt(10);
			datei.writeUTF("Meier");
			datei.writeInt(100);
			datei.writeUTF("Müller");
			datei.writeInt(1);
			datei.writeUTF("Strietzel");
			datei.close();
		}
		catch (IOException e ) {
			JOptionPane.showMessageDialog(this, "Beim Schreiben ist ein Problem aufgetreten");
	    }
	}
}
