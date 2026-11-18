/* ####################################################
Einsendeaufgabe 3.5
#################################################### */
import javax.swing.*;

public class Aufgabe5 {
	
	/**
	 * Addiert zwei ganze Zahlen und gibt das Ergebnis zurück
	 * @param a die erste Zahl als Integer
	 * @param b die zweite Zahl als Integer
	 * @return Ergebnis der Addition als Integer
	 */
	static int add(int a, int b) {
		return a + b;
	}

	/**
	 * Subtrahiert zwei ganze Zahlen und gibt das Ergebnis zurück
	 * @param a die erste Zahl als Integer
	 * @param b die zweite Zahl als Integer
	 * @return Ergebnis der Subtraktion als Integer
	 */
	static int subtract(int a, int b) {
		return a - b;
	}

	/**
	 * Multipliziert zwei ganze Zahlen und gibt das Ergebnis zurück
	 * @param a die erste Zahl als Integer
	 * @param b die zweite Zahl als Integer
	 * @return Ergebnis der Multiplikation als Integer
	 */
	static int multiply(int a, int b) {
		return a * b;
	}

	/**
	 * Dividiert zwei ganze Zahlen und gibt das Ergebnis als Dezimalzahl (Float) zurück
	 * @param a die erste Zahl als Integer
	 * @param b die zweite Zahl als Integer
	 * @return Ergebnis der Division als Float
	 */
	static float divide(int a, int b) {
		return (float) a / b;
	}

	/**
	 * Potenziert zwei ganze Zahlen und gibt das Ergebnis als Dezimalzahl (Float) zurück für den Fall, dass die zweite ganze Zahl negativ ist.
	 * @param a die erste Zahl als Integer
	 * @param b die zweite Zahl als Integer
	 * @return Ergebnis der Division als Float
	 */
	static float potentiate(int a, int b) {
		float res = a; // Das Ergebnis als Zwischenspeicher, das später mit jedem Schleifendurchgang veränert wird
		if (b == 0) {
			res = 1;
		}
		
		for (int i = 1; i < Math.abs(b); i++) {
			res *= a;
		}
		
		if (b < 0) {
			res = 1 / res;
		}
		
		return res;
	}

	/**
	 * Liest zwei ganze Zahlen ein und einen Operator als String ein und gibt das Ergebnis der jeweiligen Operation als Konsolenausgabe aus.
	 */
	public static void main(String[] args) {
		int num1, num2; // erste und zweite zahl der Operation
		float res = 0; // Zwischenspeicher des Ergebnisses
		String operation; // Die gewünschte Operation als String (kann "+", "-", "*", "/", oder "**" (für Potenzen) sein)

		num1 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die erste Zahl ein."));
		num2 = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die zweite Zahl ein."));
		operation = JOptionPane.showInputDialog("Welche Operation soll ausgeführt werden?\n+ , - , * , / , **").replaceAll("\\s","");

		switch (operation) {
			case "+":
				res = add(num1, num2);
				break;
			case "-":
				res = subtract(num1, num2);
				break;
			case "*":
				res = multiply(num1, num2);
				break;
			case "/":
				res = divide(num1, num2);
				break;
			case "**":
				res = potentiate(num1, num2);
				break;
		}
		System.out.printf("%d %s %d = %f.", num1, operation, num2, res);
	}
}