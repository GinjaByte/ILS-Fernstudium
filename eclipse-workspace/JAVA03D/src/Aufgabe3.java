/* ####################################################
Einsendeaufgabe 3.3
#################################################### */
public class Aufgabe3 {
	/**
	 * Gibt das Doppelte aller Zahlen von 1 bis 100 durch Komma getrennt als Konsolenausgabe aus und nutzt dafür eine while-Schleife.
	 */
	public static void main(String[] args) {
		final int MAXNUM = 100; // der Wert zu dem gezählt wird (inklusive)
		int i = 1; // die Schleifenvariable
		
		while (i <= MAXNUM) {
			System.out.printf("%d", i*2);
			if (i < MAXNUM) {
				System.out.print(",");
			}
			i++;
		}
	}
}