//Das Paket
//Es muss der vollständige Weg von src aus
//angegeben werden
package meinebaeren.elternbaer;

//Der Import für den Bären
//auch hier muss der vollständige Weg angegeben werden
import meinebaeren.baer.Baer;

//die Klasse ElternBaer erbt von der Klasse Baer
public class ElternBaer extends Baer{
		//die Instanzvariable ist private
		private int anzahlKinder;

		//die Methoden sind public
		//ein eigener Konstruktor
		public ElternBaer(int gewicht, int alter, int anzahlKinder) {
			//der Aufruf des Konstruktors der übergeordneten Klasse Baer
			//gewicht und alter werden "durchgereicht"
			super(gewicht, alter);
			this.anzahlKinder = anzahlKinder;
		}

		//die Methode liefert die Anzahl der Kinder
		public int getAnzahlKinder() {
			return anzahlKinder;
		}

		//die Methode zur Ausgabe der Werte
		//Sie überschreibt die gleichnamige Methode der Basisklasse
		@Override
		public void ausgeben() {
			System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
			System.out.println("Der Bär ist " + alter + " Jahre alt,wiegt " + gewicht + " Kilo und hat " + anzahlKinder + " Kinder.");
		}

		//die überschriebene Methode toString() aus der Klasse Baer
		//die Methode ist in der Basisklasse selbst ebenfalls überschrieben
		@Override
		public String toString() {
			String ausgabe;
			//die Daten mit der Methode aus der übergeordneten Klasse beschaffen
			ausgabe = super.toString();
			ausgabe = ausgabe + " Kinder: " + anzahlKinder +"]";
			return ausgabe;
		}
		
		//die Eltern erleiden einen Schock und verlieren Gewicht
		public void schock() {
			gewicht--;
		}
}
