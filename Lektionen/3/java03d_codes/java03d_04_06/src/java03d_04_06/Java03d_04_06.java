package java03d_04_06;
/* #################################################
Das klappt nicht!
################################################# */

//für das Einlesen
import javax.swing.*;

public class Java03d_04_06 {
	static int eingabe() {
		int einVariable1, einVariable2;

		einVariable1 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Zahl 1 ein:"));
		einVariable2 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Zahl 2 ein:"));

		return (einVariable1, einVariable2);
	}

	public static void main(String[] args) {
		System.out.println("Die Methode eingabe() liefert die Werte" + eingabe());
		System.exit(0);
	}

}
