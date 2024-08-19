/*##############################################
 * bei negativen Werten gibt es Schwierigkeiten
 ###############################################*/ 
package java08d_01_04;

public class Java08d_01_04 {
	public static void main(String[] args) {
		//eine neue Instanz für den Wein erzeugen
		Wein flasche1 = new Wein(10,20.5);
		//den Preis ausgeben
		System.out.println(flasche1.getPreisProFlasche());
		
		//eine neue Instanz mit unsinnigen Werten erzeugen
		Wein flasche2 = new Wein(-10,20.5);
		//den Preis ausgeben
		System.out.println(flasche2.getPreisProFlasche());
	}
}
