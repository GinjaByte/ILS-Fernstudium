/*##############################
 * Der Programmablauf wird durch
 * Testmeldungen nachvollziehbar
 ###############################*/
package java08d_01_07;

public class Java08d_01_07 {
	public static void main(String[] args) {
		int zahl = 1;
		switch (zahl) {
			case  1:	zahl = zahl + 10;
						System.out.println("Zahl hat jetzt den Wert " + zahl);
						System.out.println("Ausgeführt wird der Zweig 1");
						//eindeutiger werden Testmeldung bei der Ausgabe über
						//System.err, zum Beispiel
						System.err.println("Ausgeführt wird der Zweig 1");
			case  2:	zahl = zahl + 20;
						System.out.println("Ausgeführt wird der Zweig 2");
			case  3:	zahl = zahl + 30;
						System.out.println("Ausgeführt wird der Zweig 3");
			default:	zahl = zahl + 100;
						System.out.println("Ausgeführt wird der Zweig default");
		}
	}
}
