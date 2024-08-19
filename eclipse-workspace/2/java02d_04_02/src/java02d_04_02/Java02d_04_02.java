/*  ################################################
Ein provozierter Überlauf
################################################# */
package java02d_04_02;

public class Java02d_04_02 {
	public static void main(String[] args) {
		//Vereinbarung der Variablen
		byte byteVariable = 127;
		System.out.println("Die Variable hat den Wert: " + byteVariable);
		//jetzt erhöhen wir den Wert um 1 über den Inkrementoperator
		byteVariable++;
		System.out.println("127 + 1 ist gleich " + byteVariable + "???");
	}
}
