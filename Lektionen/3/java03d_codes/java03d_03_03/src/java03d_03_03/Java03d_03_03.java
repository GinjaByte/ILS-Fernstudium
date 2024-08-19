/* #################################################
Die umgebaute Schleife
################################################# */

package java03d_03_03;

//für die Eingabe
import javax.swing.*;

public class Java03d_03_03 {
	public static void main(String[] args) {
		int schleifenVariable = 0;

		// der Fuß wird jetzt zum Kopf
		// Denken Sie daran, das Semikolon zu löschen!
		while (schleifenVariable <= 10) {
			schleifenVariable = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie einen Wert größer als 10 ein. "));
		}
		System.out.println("Danke.");
		System.exit(0);
	}
}
