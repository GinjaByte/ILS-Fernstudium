/* ################################################
Beispiel für zwei lokale Variablen
Jetzt läuft das Programm...
################################################# */
package java04d_01_04;

public class Java04d_01_04 {
	static void gibVarAus(){
		int varA = 4;
		System.out.println("Der Wert der Variablen ist " + varA);
	}

	public static void main(String[] args) {
		int varA = 10;
		gibVarAus();
	    System.out.println("Der Wert der Variablen ist " + varA);
	}
}
