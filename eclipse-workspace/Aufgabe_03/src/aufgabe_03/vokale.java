package aufgabe_03;

import javax.swing.JOptionPane;

public class vokale {
	public static void main(String[] agrs) {
		// Zeichenkette einlesen
		String zeichenkette = JOptionPane.showInputDialog("Zeichenkette eingeben.");
		
		// Speichern der Anzahlen für Vokale und Konsonanten
		int numVokale = 0;
		int numKonsonanten = 0;
		
		// laufe über jedes Zeichen und eröhe die Anzahl der Vokale und nicht-Vokale (=Konsonanten in der Aufgabe)
		for(char zeichen : zeichenkette.toCharArray()) {
			//behandle Groß- und Kleinbuchstaben gleich
			zeichen = Character.toLowerCase(zeichen);
			
			switch(zeichen) {
			case 'a':
				numVokale++;
				break;
			case 'e':
				numVokale++;
				break;
			case 'i':
				numVokale++;
				break;
			case 'o':
				numVokale++;
				break;
			case 'u':
				numVokale++;
				break;
			default:
				numKonsonanten++;
			}
		}

		// Ausgabe
		System.out.printf("Anzahl der Vokale in der Zeichenkette: %d.\n", numVokale);
		System.out.printf("Anzahl der Konsonanten in der Zeichenkette: %d.\n", numKonsonanten);
	}
}