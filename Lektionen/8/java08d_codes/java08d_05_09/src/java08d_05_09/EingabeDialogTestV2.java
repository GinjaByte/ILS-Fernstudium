/*####################################
 * Ein Test der Klasse EingabeDialogV2
 * Die Klasse wird über einen Verweis 
 * eingebunden
 * ###################################
 * BITTE BEACHTEN!
 * Sie müssen den Verweis zu der Klasse
 * neu aufbauen.
 ####################################*/
package java08d_05_09;

//für den Ausgabedialog
import javax.swing.JOptionPane;
//für die Klasse der Ausnahme AbbruchException
import eindialogV2.AbbruchException;
//für die Klasse mit dem Eingabedialog
import eindialogV2.EingabeDialogV2;

public class EingabeDialogTestV2 {
	public static void main(String[] args) {
		int intWert = 0;
		double doubleWert = 0;
		
		//der Aufruf der Methode einlesen() mit einem int-Typen
		try {
				intWert = EingabeDialogV2.einlesen(intWert);
				JOptionPane.showMessageDialog(null,"Ihre Eingabe war " + intWert);
		}
		//die Behandlung der eigenen Exception
		catch (AbbruchException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		//der Aufruf der Methode einlesen() mit einem double-Typen
		try {
				doubleWert = EingabeDialogV2.einlesen(doubleWert);
				JOptionPane.showMessageDialog(null,"Ihre Eingabe war " + doubleWert);
		}
		//die Behandlung der eigenen Exception
		catch (AbbruchException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}

