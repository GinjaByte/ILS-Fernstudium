/*##################################
 * Zugriff über öffentliche Methoden
 ###################################*/
package java07d_01_02;

class Esel {
	//die Instanzvariablen sind jetzt nur für die Klasse selbst sichtbar
	private boolean stur;
	private int gewicht;
	
	//die öffentlichen Methoden zum Zugriff auf die privaten Instanzvariablen
	//die Methode setzt die Sturheit
	public void setStur(boolean stur) {
		this.stur = stur;
	}

	//die Methode liefert die Sturheit
	public boolean isStur() {
		return stur;
	}

	//die Methode setzt das Gewicht
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	//die Methode liefert das Gewicht
	public int getGewicht() {
		return gewicht;
	}
}

public class Java07d_01_02 {
	public static void main(String[] args) {
		//Instanz erzeugen
		Esel eselchen = new Esel();
		//den Wert von gewicht über die Methode setzen
		eselchen.setGewicht(10);
		//den Wert von gewicht über die Methode abrufen
		System.out.println("Der Esel wiegt " + eselchen.getGewicht() + " Kilo.");
		//die Sturheit über die Methode setzen
		eselchen.setStur(true);
		//den Wert von stur von außen abfragen
		if (eselchen.isStur() == true)
			System.out.println("Der Esel ist stur.");
		else
			System.out.println("Der Esel ist nicht stur.");
	}
}
