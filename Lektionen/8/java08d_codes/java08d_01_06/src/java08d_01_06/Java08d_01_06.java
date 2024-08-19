/*########################################
 * Ein Problem durch vertauschte Argumente
 * beim Aufruf einer Methode
######################################## */
package java08d_01_06;

public class Java08d_01_06 {
	//die Methode zur Subtraktion
	static int subtraktion(int wert1, int wert2) {
		return (wert1 - wert2);
	}
	
	public static void main(String[] args) {
		int zahl;
		//eigentlich soll 20 - 10 gerechnet werden
		zahl = subtraktion(10, 20);
		System.out.println("Zahl hat den Wert: " + zahl);
	}
}
