/* ######################################################
Einsendeaufgabe 5.2
###################################################### */

//die Klasse für die Listenelemente
//jetzt auch mit Methoden
class Listenelement2 {
		String daten;
		Listenelement2 naechster;

		//die Methode zum Setzen der Daten
		void setDaten(String datenNeu) {
			//die Zeichenkette setzen
			daten = datenNeu;
			//das Ende markieren
			naechster = null;
		}

		//die Methode zum Anhängen eines neuen Elements
		//sie ruft sich rekursiv auf, bis das Ende erreicht ist
		Listenelement2 anhaengen(String datenNeu) {
			//wenn das Ende erreicht ist, ein neues Element erzeugen
			if (naechster == null) {
				naechster = new Listenelement2();
				naechster.setDaten(datenNeu);
				//nur zur Veranschaulichung
				System.out.println("Daten " + datenNeu + " wurden eingefügt.");
				return naechster;
			}
			//sonst ruft sich die Methode selbst wieder auf
			else
				return naechster.anhaengen(datenNeu);
		}

		//die Methode zur Ausgabe der Liste
		//sie ruft sich ebenfalls rekursiv auf, bis das Ende erreicht ist
		void ausgeben() {
			System.out.println(daten);
			if (naechster != null)
				naechster.ausgeben();
		}

		//die Methode zur Ausgabe der Liste
		//sie ruft sich ebenfalls rekursiv auf, bis das Ende erreicht ist
		void ausgebenRueckwaerts() {
			if (naechster != null) {
				naechster.ausgebenRueckwaerts();
				System.out.println(daten);
			} else {
				System.out.println(daten);
			}
		}
	}

public class JAVA05D_3 {
	public static void main(String[] args) {
		//ein neues Listenelement erzeugen
		Listenelement2 listenAnfang = new Listenelement2();
		Listenelement2 listenEnde = listenAnfang;

		//die Daten im ersten Listenelement setzen
		listenEnde.setDaten("Element 1");

		//weitere Elemente in einer Schleife einfügen
		for (int element = 2; element < 21; element++)
			listenEnde = listenEnde.anhaengen("Element " + element);

		//die Liste ausgeben
		System.out.println("\nVorwärts:");
		listenAnfang.ausgeben();
		
		System.out.println("\nRückwärts:");
		listenAnfang.ausgebenRueckwaerts();
	}
}
