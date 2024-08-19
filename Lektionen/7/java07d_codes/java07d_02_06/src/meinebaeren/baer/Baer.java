//Das Paket
//Es muss der vollständige Weg 
//von src aus angegeben werden
package meinebaeren.baer;

public class Baer {
		//die Instanzvariablen sind protected
		protected int gewicht;
		protected int alter;

		//alle Methoden sind public
		//ein eigener Konstruktor
		public Baer(int gewicht, int alter) {
			this.gewicht = gewicht;
			this.alter = alter;
		}

		//die Methode liefert das Gewicht
		public int getGewicht() {
			return gewicht;
		}

		//die Methode liefert das Alter
		public int getAlter() {
			return alter;
		}

		//die Methode zur Ausgabe der Werte
		public void ausgeben() {
			System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
			System.out.println("Der Bär ist " + alter + " Jahre alt und wiegt " + gewicht + " Kilo.");
		}

		//die überschriebene Methode toString() aus der Klasse Object
		@Override
		public String toString() {
			String ausgabe;
			ausgabe = "[" + this.getClass();
			ausgabe = ausgabe + " Alter: " + alter;
			ausgabe = ausgabe + " Gewicht: " + gewicht + "]";
			return ausgabe;
		}
}
