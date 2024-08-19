/* #################################################
Noch eine umgebaute Schleife
################################################# */
package java03d_03_04;

public class Java03d_03_04 {
	public static void main(String[] args) {
		int schleifenVariable = 0;

		// die Schleife
		do {
			// der aktuelle Wert wird ausgegeben
			System.out.println("Die Variable hat jetzt den Wert " + schleifenVariable);
			// schleifenVariable wird erhöht
			schleifenVariable++;
		} while (schleifenVariable <= 10);
	}
}
