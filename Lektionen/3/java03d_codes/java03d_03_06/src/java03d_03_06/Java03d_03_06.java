/* #################################################
Von 0 bis 10 mit while
################################################# */
package java03d_03_06;

public class Java03d_03_06 {
	public static void main(String[] args) {
		int i = 0; // der Vorlauf

		while (i <= 10) { // der Testausdruck
			System.out.println("Die Variable hat jetzt den Wert " + i);
			i++; // der Nachlauf
		}
	}
}
