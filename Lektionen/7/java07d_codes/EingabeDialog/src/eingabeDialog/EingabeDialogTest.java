/*###################################
 * Ein Test der Klasse EingabeDialog
 * Die Klasse wird über einen Verweis 
 * eingebunden
 ####################################
 * BITTE BEACHTEN!
 * Sie müssen den Verweis zu der Klasse
 * neu aufbauen.
 ####################################*/
package eingabeDialog;

import eindialog.EingabeDialog;

public class EingabeDialogTest {
	public static void main(String[] args) {
		int intWert = 0;
		double doubleWert = 0;
		
		//der Aufruf der Methode einlesen() mit einem int-Typen
		intWert = EingabeDialog.einlesen(intWert);
		if (EingabeDialog.abgebrochen == true)
			System.out.println("Sie haben die Eingabe abgebrochen.");
		else
			System.out.println("Sie haben " + intWert + " eingegeben");
		
		//und nun ein Test mit einem double-Typen
		doubleWert = EingabeDialog.einlesen(doubleWert);
		if (EingabeDialog.abgebrochen == true)
			System.out.println("Sie haben die Eingabe abgebrochen.");
		else
			System.out.println("Sie haben " + doubleWert + " eingegeben");
	}
}
