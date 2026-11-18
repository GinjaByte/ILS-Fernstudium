/* ####################################################
Einsendeaufgabe 3.2
#################################################### */
public class Aufgabe2 {
	/**
	 * Gibt als Konsolenausgabe alle Zahlen von 1 bis 50 durch Komma getrennt aus und nutzt dafür eine for-Schleife.
	 */
	public static void main(String[] args) {
		final int MAXNUM = 50; // der Wert zu dem gezählt wird (inklusive)
		int i; // die Schleifenvariable. Außerhalb der Schleife, damit auf sie danach noch zugegriffen werden kann.
		
		for (i = 1; i < MAXNUM; i++) {
			System.out.printf("%d,", i);
		}
		System.out.print(i);
	}
}