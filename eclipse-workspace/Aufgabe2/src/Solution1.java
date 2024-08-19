/* ####################################################
Einsendeaufgabe 2.1
#################################################### */

public class Solution1 {
	public static void main(String[] args) {
		final String quoteString = "\t\"\n";
		final String hashString = "#\t\t#\n";

		System.out.print(quoteString.repeat(2));
		System.out.print(hashString.repeat(5));
		System.out.print(quoteString.repeat(2));
		System.out.print(hashString.repeat(5));
		System.out.print(quoteString.repeat(2));
	}
}