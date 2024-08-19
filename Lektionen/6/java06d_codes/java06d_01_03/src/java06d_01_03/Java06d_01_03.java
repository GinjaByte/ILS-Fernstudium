/*#####################
 * Ein Finalisierer
 ######################*/
package java06d_01_03;
//die Klasse Sherry
class Sherry {
	//die Instanzvariablen
	int alter;
	int liter;

	//die Methoden
	//der Konstruktor
	Sherry(int alter, int liter) {
		this.alter = alter;
		this.liter = liter;
	}

	//zum Ansehen
	void ansehen() {
		System.out.println("Der Sherry ist " + alter + " Jahre alt.");
		System.out.println("Die Flasche enthält " + liter + " Liter.");
	}

	//der Finalisierer
	protected void finalize() {
		System.out.println("Eine Instanz von " + this.getClass() + " wurde zerstört.");
	}
}

public class Java06d_01_03 {
	public static void main(String[] args) {
		//Instanz flasche1 erzeugen
		//die Werte werden über den Konstruktor gesetzt
		Sherry flasche1 = new Sherry(10, 1);

		//die Werte ausgeben
		flasche1.ansehen();

		//flasche1 auf null setzen, damit sie vom Garbage Collector
		//aufgeräumt wird
		flasche1 = null;
		//den Garbage Collector per Hand aufrufen
		System.gc();
	}
}
