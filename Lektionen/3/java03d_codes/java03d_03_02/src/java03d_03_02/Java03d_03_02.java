/* #################################################
do-while-Schleife
################################################# */

package java03d_03_02;

//für die Eingabe
import javax.swing.*;

public class Java03d_03_02 {
	public static void main(String[] args) {
		int schleifenVariable = 0;

		do {
			schleifenVariable = Integer
					.parseInt(JOptionPane.showInputDialog("Bitte geben Sie einen Wert größer als 10 ein. "));
		} while (schleifenVariable <= 10);

		System.out.println("Danke.");
		System.exit(0);
	}
}
