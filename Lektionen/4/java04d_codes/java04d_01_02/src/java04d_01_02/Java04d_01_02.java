/* ################################################
Beispiel für einen nicht erlaubten Zugriff
Der Code wird nicht übersetzt!
################################################# */
package java04d_01_02;

public class Java04d_01_02 {
	static void gibVarAus(){
		int varA = 4;
		System.out.println("Der Wert der Variablen ist " + varA);
	}

	public static void main(String[] args) {
	    gibVarAus();
	    //DAS GEHT NICHT!
	    System.out.println("Der Wert der Variablen ist " + varA);
	}
}
