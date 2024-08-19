/* ################################################
Vererbung ohne Standard-Konstruktoren
mit Aufruf des Konstruktors der Basisklasse
über die Methode super()
################################################# */
package java06d_03_03;

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
}

public class Java06d_03_03 {
	public static void main(String[] args) {
		//einen Bären erzeugen
		Baer alterBaer = new Baer(200, 3);
		//einen Papabären erzeugen
		ElternBaer papaBaer = new ElternBaer(500, 5, 20);

		//Werte über die jeweiligen Methoden anzeigen
		System.out.println("Der alte Bär ist " + alterBaer.getAlter() + " Jahre alt und wiegt " + alterBaer.getGewicht() + " Kilo.");
		System.out.println("Der Papabär ist " + papaBaer.getAlter() + " Jahre alt, wiegt " + papaBaer.getGewicht() + " Kilo und hat " + papaBaer.getAnzahlKinder() + " Kinder.");
	}
}
