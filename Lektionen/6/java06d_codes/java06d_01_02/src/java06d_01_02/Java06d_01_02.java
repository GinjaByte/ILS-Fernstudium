/* ######################################
 * Initialisierung mit einem Konstruktor
 #######################################*/
package java06d_01_02;

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
}

public class Java06d_01_02 {
	public static void main(String[] args) {
		//Instanz flasche1 erzeugen
		//die Werte werden über den Konstruktor gesetzt
		Sherry flasche1 = new Sherry(10, 1);	

		//die Werte ausgeben
		flasche1.ansehen();
	}
}
