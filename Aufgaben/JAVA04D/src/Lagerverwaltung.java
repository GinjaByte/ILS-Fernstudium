import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/* ######################################################
Einsendeaufgabe 4
###################################################### */

public class Lagerverwaltung {
	static int currentNumber = 1; // Klassenvariable zum speichern der nächsten freien Nummer für eine neue Kiste.
	
	/**
	 * Findet den Index der ersten Kiste mit gegebener Nummer innerhalb des Arrays von Kisten und gibt ihn zurück. -1 sonst
	 * @param kisten Array aller Kisten im System
	 * @param number Nummer der zu suchenden Kiste
	 * @return index der Kiste im Array, oder -1, wenn es die Kiste mit der Nummer nicht gibt
	 */
	static int findIndex(int[][] kisten, int number) {
		int index = -1; // Index der zu findenden Kiste im Array kisten. -1 als default oder wenn es die Kiste nicht gibt
		
		for (int i = 0; i < kisten.length; i++) {
			if (kisten[i][0] == number) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Fügt eine neue Kiste zum System hinzu solange Platz ist. 
	 * @param kisten Array aller Kisten im System
	 * @param width Breite der neuen Kiste
	 * @param length Länge der neuen Kiste
	 * @param height Höhe der neuen Kiste
	 * @return Die Nummer der neuen Kiste, oder -1, wenn kein PLatz ist
	 */
	static int add(int[][]kisten, int width, int length, int height) {
		int index = findIndex(kisten, 0); // Index der zu findenden Kiste im Array kisten. -1 als default oder wenn es die Kiste nicht gibt
		if (index < 0) {
			return -1;
		}
		
		int newNumber = currentNumber++; // Nummer der neuen Kiste. gelesen aus der Klassenvariable

		// überspringe alle Nummern, die entweder kleiner-gleich 0 sind, oder bereits im System vorhanden sind und nehme die erst beste, die noch nicht im System ist.
		while(currentNumber == 0 || currentNumber == -1 || findIndex(kisten, currentNumber) >= 0) {
			if (currentNumber <= 0) {
				currentNumber = 1;
			}
			newNumber = currentNumber++;
		}

		kisten[index][0] = newNumber;
		kisten[index][1] = width;
		kisten[index][2] = length;
		kisten[index][3] = height;
		
		return newNumber;
	}
	
	/**
	 * Löscht eine Kiste aus dem System, wenn sie existiert.
	 * @param kisten Array aller Kisten im System
	 * @param number Nummer der zu löschenden Kiste
	 * @return Nummer der gelöschten Kiste, oder -1, wenn es die Kiste mit der Nummer nicht gibt
	 */
	static int delete(int[][] kisten, int number) {
		int index = findIndex(kisten, number); // Index der zu findenden Kiste im Array kisten. -1 als default oder wenn es die Kiste nicht gibt
		
		if (index < 0) {
			return -1;
		}
		
		kisten[index][0] = 0;
		return number;
	}
	
	/**
	 * Ändert alle Daten einer Kiste und setzt sie neu.
	 * @param kisten Array aller Kisten im System
	 * @param number Nummer der zu ändernden Kiste
	 * @param width Breite der neuen Kiste
	 * @param length Länge der neuen Kiste
	 * @param height Höhe der neuen Kiste
	 * @return Nummer der geänderten Kiste, oder -1, wenn es die Kiste mit der Nummer nicht gibt 
	 */
	static int change(int[][] kisten, int number, int width, int length, int height) {
		int index = findIndex(kisten, number); // Index der zu findenden Kiste im Array kisten. -1 als default oder wenn es die Kiste nicht gibt
		
		if (index < 0) {
			return -1;
		}
		
		kisten[index][1] = width;
		kisten[index][2] = length;
		kisten[index][3] = height;
		
		return number;
	}
	
	/**
	 * Zeigt entweder die Daten einer Kiste, oder eine Fehlermeldung wenn die Kiste nicht existiert per Konsolenausgabe an.
	 * @param kisten Array aller Kisten im System
	 * @param number Nummer der zu zeigenden Kiste
	 * @return Nummer der gezeigten Kiste, oder -1, wenn es die Kiste mit der Nummer nicht gibt 
	 */
	static int show(int[][] kisten, int number) {
		int index = findIndex(kisten, number); // Index der zu findenden Kiste im Array kisten. -1 als default oder wenn es die Kiste nicht gibt
		
		if (index < 0) {
			System.out.printf("Die Kiste mit Nummer %d existiert nicht (mehr).\n", number);
			return -1;
		}
		
		System.out.printf("Kiste Nummer: %d:\n", number);
		System.out.printf("- Breite: %d, Länge: %d, Höhe: %d\n", kisten[index][1], kisten[index][2], kisten[index][3]);
		return kisten[index][0];
	}
	
	/**
	 * Zeigt alle Kisten im Systemm per Konsolenausgabe an
	 * @param kisten Array aller Kisten im System
	 */
	static void showAll(int[][] kisten) {
		System.out.println("Hier sind alle Kisten, die sich gerade im System befinden:");
		for (int[] kiste : kisten) {
			if (kiste[0] == 0) {
				continue;
			}
			show(kisten, kiste[0]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] kisten = new int[75][4]; // 2-dimensionales Array zum speichern der Kisten. die erste Dimension ist für die Liste von Kisten. Das  zweite int[] Array stellt die Daten einer Kiste dar.
		char inputOperation = ' '; // 1 Zeichen zum speichern der Auswahl im Hauptmenü
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Der BufferReader reader hilft für den Input per Konsole auch in der Eclipse Konsole.
		
		while(inputOperation != 'q') {
			System.out.println("\n\nHauptmenü. Wählen Sie eine der folgenden Optionen:\n- [q] Beendet das Programm\n- [+] neue Kiste hinzufügen\n- [-] löschen einer vorhandene Kiste\n- [v] verändert die Daten einer vorhandenen Kiste\n- [z] Zeigt eine vorhandene Kiste an\n- [l] Listet alle Kisten im System auf.");
			inputOperation = reader.readLine().trim().charAt(0);

			switch(inputOperation) {
				case 'q':
					System.out.println("Auf Wiedersehen!");
					break;
				case '+':
					System.out.println("Geben Sie die Daten der neuen Kiste an:");
					System.out.print("Breite: ");
					// Die Variablen width1, length1 und height1 speichern die Daten der neuen Kiste zwischen.
					try {
						int width1 = Integer.parseInt(reader.readLine().trim());
						System.out.print("Länge: ");
						int length1 = Integer.parseInt(reader.readLine().trim());
						System.out.print("Höhe: ");
						int height1 = Integer.parseInt(reader.readLine().trim());
						// res1 speichert den Rückgabewert der add Funktion um zu prüfen, ob eine neue Kiste hinzugefügt werden konnte oder nicht
						int res1 = add(kisten, width1, length1, height1);
						if (res1 < 0) {
							System.out.println("Es können keine neuen Kisten zum System hinzugefügt werden, da es bereits voll ist.");
						} else {
							System.out.printf("Kiste mit Nummer %d wurde hinzugefügt.\n", res1);
						}
					} catch(Exception e) { // Input Fehler abfangen
						System.out.println("Lesen der Zahl fehlgeschlagen. Versuchen Sie es erneut");
					}
					break;
				case '-':
					System.out.print("Die Kiste mit welcher Nummer möchten Sie löschen? ");
					int numberDelete = Integer.parseInt(reader.readLine().trim()); // Nummer der zu löschenden Kiste
					// res2 speichert den Rückgabewert der delete Funktion um zu prüfen, ob die Kiste gelöscht werden konnte oder nicht
					int res2 = delete(kisten, numberDelete);
					if (res2 < 0) {
						System.out.printf("Es wurde keine Kiste mit Nummer %d im System gefunden.", res2);
					} else {
						System.out.printf("Kiste mit Nummer %d wurde gelöscht.\n", res2);
					}
					break;
				case 'v':
					System.out.print("Die Kiste mit welcher Nummer möchten Sie ändern? ");
					int numberChange = Integer.parseInt(reader.readLine().trim()); // Nummer der zu ändernden Kiste
					// res3 speichert den Rückgabewert der show Funktion um zu prüfen, ob die Kiste existiert oder nicht
					int res3 = show(kisten, numberChange);
					if (res3 < 0) {
						continue;
					}
					
					System.out.print("Neue Breite: ");
					// Die Variablen width2, length2 und height2 speichern die Daten der zu ändernden Kiste zwischen.
					try {
						int width2 = Integer.parseInt(reader.readLine().trim());
						System.out.print("Neue Länge: ");
						int length2 = Integer.parseInt(reader.readLine().trim());
						System.out.print("Neue Höhe: ");
						int height2 = Integer.parseInt(reader.readLine().trim());

						// res4 speichert den Rückgabewert der change Funktion um zu prüfen, ob die Kiste geändert werden konnte oder nicht
						int res4 = change(kisten, numberChange, width2, length2, height2);
						if (res4 < 0) {
							System.out.printf("Es wurde keine Kiste mit Nummer %d im System gefunden.", res3);
						} else {
							System.out.printf("Kiste mit Nummer %d wurde geändert.", res3);
						}
						show(kisten, numberChange);
					} catch(Exception e) { // Input Fehler abfangen
						System.out.println("Lesen der Zahl fehlgeschlagen. Versuchen Sie es erneut");
					}
					
					break;
				case 'z':
					System.out.print("Die Kiste mit welcher Nummer möchten Sie anzeigen? ");
					try {
						int numberShow = Integer.parseInt(reader.readLine().trim()); // Nummer der zu zeigenden Kiste
						show(kisten, numberShow);
					} catch(Exception e) { // Input Fehler abfangen
						System.out.println("Lesen der Zahl fehlgeschlagen. Versuchen Sie es erneut");
					}
					break;
				case 'l':
					showAll(kisten);
					break;
				default:
					System.out.println("ungültige Eingabe. Bitte geben Sie nur den Buchstaben oder das Symbol der gewünschten Option in eckigen Klammern an.");
					break;
					
			}
		}
	}
}
