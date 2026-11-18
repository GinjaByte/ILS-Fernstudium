/* ####################################################
Einsendeaufgabe 3.1
#################################################### */
import javax.swing.*;

public class Aufgabe1 {
	/**
	 * Ermittelt und gibt als Konsolenausgabe an, ob ein Jahr ein Schaltjahr ist indem der Wert isLeapYear zunächst als falsch initiiert wird.
	 * Der Wert wird nur auf wahr gesetzt, sollte eine der beiden Bedingungen wahr sein:
	 *     - das Jahr ist durch 4 und nicht durch 100 teilbar.
	 *     - das Jahr ist durch 4, 100, und 400 teilbar.
	 * 
	 */
	public static void main(String[] args) {
		int year; // Wert des eingegebenen Jahres als Integer
		boolean isLeapYear = false; // später berechneter Wert
		year = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie eine Jahreszahl ein."));
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeapYear = true;
				}
			} else {
				isLeapYear = true;
			}
		}
		
		System.out.printf("Das Jahr %d ist %s Schaltjahr", year, isLeapYear ? "ein" : "kein");
	}
}