/* #################################################
Undefinierte Rückgabe aus einer Methode
Das Beispiel lässt sich nicht übersetzen
################################################# */
package java03d_04_04;
//für die Eingabe
import javax.swing.*;

public class Java03d_04_04 {
	static int eingabe() {
		int einVariable;
		einVariable = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie eine Zahl ein:"));
		if (einVariable <= 20)
			return einVariable;
	}

	public static void main(String[] args) {
		System.out.println("Die Methode eingabe() liefert den Wert " + eingabe());
		System.exit(0);
	}
}
