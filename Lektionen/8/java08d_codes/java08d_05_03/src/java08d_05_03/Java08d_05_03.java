/*############################################
 * auch das Einlesen wird jetzt behandelt
 * allerdings mit demselben Exception Handler  
 #############################################*/
package java08d_05_03;

//für den Eingabedialog
import javax.swing.JOptionPane;

public class Java08d_05_03 {
	public static void main(String[] args) {
		int zahl1, zahl2, ergebnis;
		try {
			zahl1 = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die erste Zahl ein."));
			zahl2 = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die zweite Zahl ein."));
			ergebnis = zahl1 / zahl2;
		}
		//wenn es nicht geklappt hat
		catch (Exception e) {
			System.out.println("Es ist ein Fehler aufgetreten.");
			System.out.println("Das Ergebnis wird auf 0 gesetzt.");
			ergebnis = 0;
		}
		System.out.println("Das Ergebnis ist " + ergebnis);
	}
}
