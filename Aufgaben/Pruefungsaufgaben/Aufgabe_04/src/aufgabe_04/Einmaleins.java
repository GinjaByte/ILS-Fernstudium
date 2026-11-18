package aufgabe_04;

public class Einmaleins {
	public static void main(String[] args) {
		// Array mit den Ergebnissen
		int[][] ergebnisse = new int[10][10];
		int[] zahlen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Ergebnisse berechnen
		for(int i = 0; i < 10; i++) {
			for(int k = 0; k < 10; k++) {
				ergebnisse[i][k] = zahlen[i] * zahlen[k];
			}
		}
		
		// Ausgabe
		// Header der Tabelle
		System.out.println("Das kleine Einmaleins:");
		System.out.println("x |   1   2   3   4   5   6   7   8   9  10");
		System.out.println("--+-----------------------------------------");
		// Inhalte der Tabelle im Format: Header | Zahlen.. \n 
		for(int i = 0; i < 10; i++) {
			System.out.printf("%2s|", Integer.toString(zahlen[i]));
			for(int ergebnis : ergebnisse[i]) {
				System.out.printf("%4s", Integer.toString(ergebnis));
			}
			System.out.print('\n');
		}
	}
}
