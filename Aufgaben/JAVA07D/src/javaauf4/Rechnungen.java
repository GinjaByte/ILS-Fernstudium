/* ######################################################
Im Paket "javaauf4"
###################################################### */

package javaauf4;

public class Rechnungen {
	/**
	 * Liefert das Quadrat einer Zahl
	 * @param Zahl die zu quadrierende Zahl als int
	 * @return Das Ergebnis als int
	 */
	public int quadrat(int zahl) {
		return zahl * zahl;
	}

	/**
	 * Liefert das Quadrat einer Zahl
	 * @param Zahl die zu quadrierende Zahl als double
	 * @return Das Ergebnis als double
	 */
	public double quadrat(double zahl) {
		return zahl * zahl;
	}
	
	/**
	 * Zieht die Quadratwurzel aus einer Zahl
	 * @param zahl Die Zahl aus der die Wurzel gezogen werden soll als double
	 * @return Das Ergebnis als double
	 */
	public double wurzel(double zahl) {
		return Math.sqrt(zahl);
	}
}