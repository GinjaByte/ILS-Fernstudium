/*############################
 * Der Zugriff auf eine Klasse
 * in einem eigenen Paket
 #############################*/
package java07d_02_03;

//der Import der Klasse EinAus aus dem Paket einaus
import einaus.EinAus;
//der Import der Klasse EinAusVersion2 aus dem Paket einaus
import einaus.EinAusVersion2;


public class Java07d_02_03 {
	public static void main(String[] args) {
		//eine Instanz für EinAus erstellen
		EinAus ersterVersuch = new EinAus();
		//der Aufruf der beiden Methoden
		ersterVersuch.einlesen();
		ersterVersuch.ausgeben();
		
		//eine Instanz für EinAusVersion2 erstellen
		EinAusVersion2 zweiterVersuch = new EinAusVersion2();
		//der Aufruf der beiden Methoden
		zweiterVersuch.einlesen();
		zweiterVersuch.ausgeben();
		
		System.exit(0);
	}
}
