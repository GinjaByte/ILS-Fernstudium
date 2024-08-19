/* ################################################
Das sieht gut aus...
Klappt aber nicht
################################################# */
package java04d_01_06;

public class Java04d_01_06 {
	static void erhoeheA(int a) {
		a = a + 1;
	}
	
	public static void main(String[] args) {
		int a = 10;
		System.out.println("Die Variable hat den Wert " + a);
		erhoeheA(a);
		System.out.println("Die Variable hat den Wert " + a);
	}

}
