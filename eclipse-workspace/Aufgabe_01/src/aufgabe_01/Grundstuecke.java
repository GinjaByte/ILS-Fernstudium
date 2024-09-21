package aufgabe_01;

import javax.swing.JOptionPane;

public class Grundstuecke {
	// berechnet den Preis eines Grundstücks nach Eingaben und gibt ihn aus.
	public static void main(String args[]) {
		// symbolische Konstanten für Aufschläge
		final double PROVISION = 0.05;
		final double MWST = 0.19;
		
		// Eingaben mit Punkt/Komma möglich
		double laenge = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie die Länge des Grundstücks in Metern an.").replace(',', '.'));
		double breite = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie die Breite des Grundstücks in Metern an.").replace(',', '.'));
		double preisProQm = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie den Preis pro Quadratmeter an.").replace(',', '.'));
		
		// Bereichnungs des Grundpreises
		double preis = laenge * breite * preisProQm;

		// Ausgaben und Berechnung der Preise mit Aufschlägen
		System.out.printf("Preis des Grundstücks ohne Aufschläge: %.2f.\n", preis);
		preis += preis * PROVISION;
		System.out.printf("Preis des Grundstücks mit Provision: %.2f.\n", preis);
		preis += preis * MWST;
		System.out.printf("Preis des Grundstücks mit Provision und Mehrwertsteuer: %.2f.\n", preis);

	}
}
