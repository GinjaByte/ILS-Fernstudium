/* #################################################
SO BITTE NICHT!
################################################# */
package java04d_01_09;
//für die Eingabe
import javax.swing.*;

public class Java04d_01_09 {
	//zwei Klassenvariablen
	static int zahl;
	static int quadrat;

	static void berechnung() {
		quadrat = zahl * zahl;
	}

	public static void main(String[] args) {
		zahl = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie eine Zahl ein:"));
		berechnung();
		System.out.println("Das Quadrat der Zahl ist " + quadrat);
		System.exit(0);
	}
}
