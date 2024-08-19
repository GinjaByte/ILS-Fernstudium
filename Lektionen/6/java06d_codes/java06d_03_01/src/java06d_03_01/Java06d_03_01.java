package java06d_03_01;
/* ################################################
Vererbung
################################################# */

//die Basisklasse Baer
class Baer {
	int gewicht;
	int alter;

	//der Standardkonstruktor für Baer
	Baer() {
		gewicht = 100;
		alter = 5;
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

	//der Standardkonstruktor für ElternBaer
	ElternBaer() {
		anzahlKinder = 2;
	}

	//die Methode liefert die Anzahl der Kinder
	int getAnzahlKinder() {
		return anzahlKinder;
	}
}

public class Java06d_03_01 {
	public static void main(String[] args) {
		//einen Bären mit dem Standardkonstruktor erzeugen
		Baer alterBaer = new Baer();
		//einen Papabären mit dem Standardkonstruktor erzeugen
		ElternBaer papaBaer = new ElternBaer();

		//Werte über die jeweiligen Methoden anzeigen
		System.out.println("Der alte Bär ist " + alterBaer.getAlter() + " Jahre alt und wiegt " + alterBaer.getGewicht() + " Kilo.");
		System.out.println("Der Papabär ist " + papaBaer.getAlter() + " Jahre alt, wiegt " + papaBaer.getGewicht() + " Kilo und hat " + papaBaer.getAnzahlKinder() + " Kinder.");
	}
}
