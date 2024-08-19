/* #################################################
Eine Methode mit mehreren Argumenten
################################################# */
package java03d_04_08;
//für die Eingabe
import javax.swing.*;

public class Java03d_04_08 {
	static int summe(int x, int y) {
		return (x + y);
	}

	public static void main(String[] args) {
		int einVariable1, einVariable2;
		einVariable1 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die erste Zahl ein:"));
		einVariable2 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die zweite Zahl ein:"));
		System.out.println("Die Summe der beiden Zahlen ist " + summe(einVariable1, einVariable2));
		System.exit(0);
	}
}
