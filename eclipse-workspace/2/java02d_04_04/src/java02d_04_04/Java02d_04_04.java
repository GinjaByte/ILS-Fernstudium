/*  ################################################
Die Datentypen String und char
################################################# */
package java02d_04_04;

public class Java02d_04_04 {	
	public static void main(String[] args) {
		//Vereinbarung der Variablen
		char charVariable;
		//Denken Sie die Großschreibung des Typen
		String stringVariable;

		//Werte zuweisen und ausgeben
		charVariable = 'A';
		//DAS KLAPPT NICHT!
		//charVariable = "A";
		stringVariable = "Ich bin eine Zeichenkette";

		System.out.println("Das Zeichen: " + charVariable);
		System.out.println("Die Zeichenkette: " + stringVariable);

		//eine direkte Zuweisung eines nummerischen Wertes geht auch
		charVariable = 64;
		stringVariable = "Auch Zeichenketten lassen sich ändern!";
		System.out.println("Das Zeichen: " +  charVariable);
		System.out.println("Die Zeichenkette: " + stringVariable);

		stringVariable = "Auch das " + "Verketten funktioniert!";
		System.out.println("Die Zeichenkette: " + stringVariable);
	}
}
