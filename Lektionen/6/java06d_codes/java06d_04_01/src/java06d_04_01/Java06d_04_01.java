/* ################################################
Eine überschriebene Methode
################################################# */
package java06d_04_01;

//die Basisklasse Baer
class Baer {
	int gewicht;
	int alter;

	//ein eigener Konstruktor
	Baer(int gewicht, int alter) {
		this.gewicht = gewicht;
		this.alter = alter;
	}

	//die Methode liefert das Gewicht
	int getGewicht() {
		return gewicht;
	}

	//die Methode liefert das Alter
	int getAlter() {
		return alter;
	}

	//die Methode zur Ausgabe der Werte
	void ausgeben() {
		System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
		System.out.println("Der Bär ist " + alter + " Jahre alt und wiegt " + gewicht + " Kilo.");
	}
}

//die Klasse ElternBaer erbt von der Klasse Baer
class ElternBaer extends Baer {
	int anzahlKinder;

	//ein eigener Konstruktor
	ElternBaer(int gewicht, int alter, int anzahlKinder) {
		//der Aufruf des Konstruktors der übergeordneten Klasse Baer
		//gewicht und alter werden "durchgereicht"
		super(gewicht, alter);
		this.anzahlKinder = anzahlKinder;
	}

	//die Methode liefert die Anzahl der Kinder
	int getAnzahlKinder() {
		return anzahlKinder;
	}

	//die Methode zur Ausgabe der Werte
	//Sie überschreibt die gleichnamige Methode der Basisklasse
	void ausgeben() {
		System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
		System.out.println("Der Bär ist " + alter + " Jahre alt,wiegt " + gewicht + " Kilo und hat " + anzahlKinder + " Kinder.");
	}
}

public class Java06d_04_01 {
	public static void main(String[] args) {
		//einen Bären erzeugen
		Baer alterBaer = new Baer(200,3);
		//einen Papabären erzeugen
		ElternBaer papaBaer = new ElternBaer(500,5,20);

		//Werte über die Methoden ausgeben() anzeigen
		alterBaer.ausgeben();
		papaBaer.ausgeben();
	}
}
