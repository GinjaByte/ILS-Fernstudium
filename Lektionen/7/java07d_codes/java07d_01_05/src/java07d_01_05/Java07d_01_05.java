/*###############################
/* Private Klassenmethode
 * und Klassenvariable
 * Der Code lässt sich nicht
 * übersetzen
 ################################*/
package java07d_01_05;

//die selbst erstellte Klasse
class Quadrat {
	//eine private Klassenvariable
	private static int ergebnis;

	//eine private Klassenmethode
	private static int berechnen(int wert) {
		ergebnis = wert * wert;
		return ergebnis;
	}
}
public class Java07d_01_05 {
	public static void main(String[] args) {
		//der Aufruf der Klassenmethode
		System.out.println("Das Quadrat von 4 ist " + Quadrat.berechnen(4));
		System.out.println("Das Ergebnis der Rechnung ist " + Quadrat.ergebnis);
	}
}
