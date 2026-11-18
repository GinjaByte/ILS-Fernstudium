package hangman;

import javax.swing.JOptionPane;

public class Hangman {
	
	public static void main(String[] args) {
		int versuche = 10;
		// wähle wort und erstelle anzeige-Wort
		String wort = neuesWort();
		StringBuilder anzeige = new StringBuilder(wort);
		for (int i = 0; i < anzeige.length(); i++)
			anzeige.setCharAt(i, '_');
		
		// spiele das Spiel - lese Eingabe und reagiere entsprechend bis Versuche 0 ist
		while (versuche > 0) {
			// Gebe den aktuellen Spiel Status aus
			System.out.printf("Hier ist das aktuelle Wort: %s\n", anzeige.toString());
			System.out.printf("Verbleibende Versuche: %d\n", versuche);
			
			// lese das erste Zeichen der Eingabe-Zeichenkette und transformiere es in lowercse
			char zeichen = JOptionPane.showInputDialog("Geben Sie ein Zeichen ein.").charAt(0);
			zeichen = Character.toLowerCase(zeichen);
			System.out.printf("Geratenes zeichen: %s\n", zeichen);
			System.out.println();
			
			
			// teste, ob der Buchstabe enthalten ist und zeige alle zeichen im anzeige-Wort an
			int index = wort.toLowerCase().indexOf(zeichen);
			
			// reduziere Versuche um 1, wenn der Buchstabe beim ersten Versuch nicht gefunden wurde
			if (index < 0)
				versuche--;
			
			while (index >= 0) {
				anzeige.setCharAt(index, wort.charAt(index));
				index = wort.indexOf(zeichen, index + 1);
			}
			
			// Prüfe, ob das Spiel gewonnen wurde und beende das Programm ggf.
			if (anzeige.toString().indexOf('_') < 0) {
				System.out.printf("Glückwunsch, Sie haben das Wort %s erraten!\n", wort);
				return;
			}
		}
		
		// Wenn keine Versuche übrig sind UND nicht gewonnen wurde: Leider Verloren - Ausgabe
		System.out.println("Sie haben das Wort leider nicht erraten. Starten Sie das Programm erneut um ein neues Wort zu erraten.");
	}
	
	
	// wählt ein zufälliges Wort und gibt es zurück
	private static String neuesWort() {
		// Liste verfügbarer Wörter
		String[] wortListe = {"Apfel", "Schmetterling", "Hund", "Fenster", "Baum", "Telefon", "Kabel", "Universum", "Tisch", "Kamera", "Sonne", "Wissenschaft", "Boden", "Wald", "Auto", "Zug", "Wasserfall", "Brille", "Vogel", "Steinzeit", "Blume", "Flugzeug", "Maus", "Licht", "Himmel", "Staubsauger", "Kaffeemaschine", "Zebra", "Lampe", "Papier", "Schule", "Baustelle", "Mond", "Straße", "Garten", "Herbst", "Sommer", "Schnee", "Welle", "Wiese", "Radio", "Sand", "Computer", "Klavier", "Rucksack", "Taschenlampe", "Rakete", "Blatt", "Schloss", "Pinsel", "Spielplatz"};

		// zufälligen Index wählen und zurückgeben
		int randomIndex = (int) (Math.random() * wortListe.length);
		return wortListe[randomIndex];
	}
}
