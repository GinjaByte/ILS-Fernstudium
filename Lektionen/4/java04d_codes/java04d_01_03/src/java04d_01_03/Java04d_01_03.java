/* ################################################
Beispiel für zwei lokale Variablen
Auch dieser Code wird nicht übersetzt!
################################################# */
package java04d_01_03;

public class Java04d_01_03 {
	static void gibVarAus(){
		int varA = 4;
		System.out.println("Der Wert der Variablen ist " + varA);
	}

	public static void main(String[] args) {
		int varA;
		gibVarAus();
	    //DAS GEHT NICHT!
	    System.out.println("Der Wert der Variablen ist " + varA);
	}
}
