package aufgabe_02;

import javax.swing.JOptionPane;

public class Iterationen {
	public static void main(String args[]) {
		// lese beide Zahlen ein
		int zahl1 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die erste Zahl ein."));
		int zahl2 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die zweite Zahl ein."));
		
		// lese die Zahl erneut ein, fall eine nicht größer oder kleiner als die andere ist
		while(zahl1 == zahl2) {
			zahl2 = Integer.parseInt(JOptionPane.showInputDialog("Falsche Eingabe. Geben Sie die zweite Zahl erneut ein."));
		}
		
		// iteriere von der kleineren zur größeren Zahl
		// Variable zum Zählen der Durchläufe
		int k = 0;
		for(int i = Math.min(zahl1, zahl2); i <= Math.max(zahl1,  zahl2); i++) {
			System.out.printf("Durchlaufe die Schleife mit Zahl: %d\n", i);
			k++;
		}
		
		System.out.printf("Die Schleife wurde %d Mal durchlaufen\n", k);
	}
}
