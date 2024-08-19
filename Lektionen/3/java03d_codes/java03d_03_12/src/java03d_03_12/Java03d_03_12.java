/*  ################################################
Eingabe mit Ausnahmebehandlung
################################################# */
package java03d_03_12;

//für das Einlesen
import javax.swing.*;

public class Java03d_03_12 {
	public static void main(String[] args) {
		int eingabe = 0;
		// für das Einlesen und die Auswertung
		String eingabeRoh = null;
		boolean gelungen = false;

		while (gelungen == false) {
			// erst die Daten als Zeichenkette lesen
			eingabeRoh = JOptionPane.showInputDialog("Geben Sie eine Zahl ein: ");
			// wurde auf OK geklickt?
			if (eingabeRoh != null) {
				// gelingt die Konvertierung?
				try {
					eingabe = Integer.parseInt(eingabeRoh);
					gelungen = true;
				}
				// wenn nicht, wird eine Meldung ausgegeben und die Schleife wiederholt
				catch (NumberFormatException e) {
					System.out.println("Ihre Eingabe war nicht gültig. Bitte wiederholen... ");
				}
			}
			// wenn Cancel angeklickt wurde, die Schleife beenden
			else
				gelungen = true;
		}
		// hier jetzt auch überprüfen, ob auf OK oder Cancel geklickt wurde
		if (eingabeRoh != null)
			System.out.println("Sie haben die Zahl " + eingabe + " eingegeben.");
		else
			System.out.println("Sie haben die Eingabe abgebrochen.");
		System.exit(0);
	}
}
