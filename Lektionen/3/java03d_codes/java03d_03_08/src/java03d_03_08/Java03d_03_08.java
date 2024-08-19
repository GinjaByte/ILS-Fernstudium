/* #################################################
break in einer Schleife
################################################# */
package java03d_03_08;

//für das Einlesen
import javax.swing.*;

public class Java03d_03_08 {
	public static void main(String[] args) {
		int summe, schleifenVariable, eingabe;
		// Initialisierung
		summe = 0;
		schleifenVariable = 1;
		while (schleifenVariable <= 10) {
			eingabe = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die " + schleifenVariable + ". Zahl ein: "));
			// wenn 0 eingegeben wurde, wird die Schleife abgebrochen
			if (eingabe == 0)
				break;
			// die Summe durch Zusammenrechnen bilden
			summe = eingabe + summe;
			schleifenVariable++;
		}
		System.out.println("Das Einlesen ist beendet.");
		System.out.println("Die Summe der Zahlen ist " + summe);

		System.exit(0);
	}
}
