//Dieses Projekt setzt die Kommunikation zwischen
//dem Fenster-Listener und der Klasse für die grafische
//Oberfläche mit einer anderen Technik um.
//Die Funktionalität entspricht exakt dem Projekt java09_03
package de.fernschulen.j09d_03a;

public class HalloWeltGUIDemoProgramm {
	public static void main(String[] args) {
		//ein neues Fenster erstellen
		//da wir keine Variable für die weitere Verarbeitung brauchen,
		//erzeugen wir nur eine neue Instanz der Klasse HalloWelt
		new HalloWeltGUI("Hallo Welt mit ein wenig Leben");
	}
}
