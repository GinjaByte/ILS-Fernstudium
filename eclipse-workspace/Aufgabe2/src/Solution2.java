/* ####################################################
Einsendeaufgabe 2.2
#################################################### */

import javax.swing.*;

public class Solution2 {
	public static void main(String[] args) {
		int num1, num2;
		String input1, input2;
		input1 = JOptionPane.showInputDialog("Bitte geben Sie den ersten Integer ein.");
		input2 = JOptionPane.showInputDialog("Bitte geben Sie den zweiten Integer ein.");
		num1 = Integer.parseInt(input1);
		num2 = Integer.parseInt(input2);
		
		double result = (double) num1 / num2;
		System.out.printf("%d / %d = %f", num1, num2, result);
	}
}