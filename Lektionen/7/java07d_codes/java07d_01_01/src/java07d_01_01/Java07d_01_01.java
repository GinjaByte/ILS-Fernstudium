/*################################
 * Ein direkter Zugriff von außen
 ################################*/
package java07d_01_01;

class Esel {
	boolean stur;
	int gewicht;
}

public class Java07d_01_01 {
	public static void main(String[] args) {
		//Instanz erzeugen
		Esel eselchen = new Esel();
		//den Wert von gewicht von außen setzen
		eselchen.gewicht = 10;
		//den Wert von gewicht von außen abrufen
		System.out.println("Der Esel wiegt " + eselchen.gewicht + " Kilo.");
		//stur von außen setzen
		eselchen.stur = true;
		//den Wert von stur von außen abfragen
		if (eselchen.stur == true)
			System.out.println("Der Esel ist stur.");
		else
			System.out.println("Der Esel ist nicht stur.");
	}
}
