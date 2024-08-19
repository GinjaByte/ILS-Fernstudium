/*  ################################################
Arithmetische Operationen mit verkürztem Quelltext
################################################# */
package java02d_03_02;

public class Java02d_03_02 {
	public static void main(String[] args) {
		System.out.printf("5 + 9\t\t= %d\n", 5 + 9);
		System.out.printf("5 - 9\t\t= %d\n", 5 - 9);
		System.out.printf("5 * 9\t\t= %d\n", 5 * 9);
		//Ausgabe mit zwei Platzhaltern
		System.out.printf("9 / 5\t\t= %d Rest %d\n", 9 / 5, 9 % 5);
		System.out.printf("10 + 8 / 2\t= %d\n", 10 + 8 / 2);
		//Geänderte Reihenfolge durch Klammern
		System.out.printf("(10 + 8) / 2\t= %d\n", (10 + 8) / 2);
	}
}
