/***************************************************************
 * Eine Klasse für Eingaben über einen grafischen Dialog
 * **************************************************************
 * Das Einlesen erfolgt über eine überladene statische Funktion
 * einlesen()
 * Wenn das Einlesen abgebrochen wird, wird eine selbst
 * definierte Ausnahme ausgelöst
 * **************************************************************
 * Beschreibung der Methode einlesen()
 * 
 * Die Methode liest über die Methode lesen() einen Wert
 * ein und versucht, diesen Wert in den passenden Typ
 * umzuwandeln.
 * Die Ausnahme für den Abbruch wird an den Aufrufer
 * zurückgeliefert.
 * Die Ausnahme für eine ungültige Eingabe wird intern behandelt.
 * 
 * Parameter: 	wert für den Typ, der verarbeitet werden soll
 * Rückgabe: 	Der Wert, der umgewandelt wurde
 * 				Der Typ hängt dabei vom übergebenen Parameter ab
 * 
 * Die Methode ist drei Mal vorhanden (für int, float und double)
 * **************************************************************
 * Beschreibung der Methode lesen()
 * 
 * Die Methode wird zum Einlesen der Werte über den Dialog benutzt.
 * Sie löst außerdem die selbst definierte Ausnahme aus.
 * 
 * Parameter:	text als Zeichenkette für die Ausgabe im Dialog
 * Rückgabe:	Der eingelesene Wert als Zeichenkette
 * **************************************************************
 * */
//die Klasse befindet sich im Package eindialogV2
package eindialogV2;

//für den Eingabedialog
import javax.swing.JOptionPane;

public class EingabeDialogV2 {
	//die Hilfsmethode zum Einlesen der Daten über den Dialog
	//Beschreibung siehe oben
	private static String lesen(String text) throws AbbruchException {
		String eingabeTemp;
		eingabeTemp = JOptionPane.showInputDialog("Bitte geben Sie einen " + text + " Wert ein:");
		//Wenn die Eingabe abgebrochen wurde, wird eine selbst definierte Ausnahme ausgelöst
		if (eingabeTemp == null)
			throw new AbbruchException("Die Eingabe für " + text + " wurde abgebrochen");
		
		return (eingabeTemp);
	}
	
	//die überladene Methode einlesen() für den Typ int
	//Beschreibung siehe oben
	public static int einlesen(int wert) throws AbbruchException {
		int wertTemp = 0;
		String eingabeTemp;
		boolean gelungen = false;
		//solange Werte einlesen, bis die Konvertierung gelingt
		//der Abbruch wird in der Methoden lesen() behandelt
		while (gelungen == false) {
			eingabeTemp = lesen("int");
			try {
				wertTemp = Integer.parseInt(eingabeTemp);
				gelungen = true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Ihre Eingabe war nicht gültig. Bitte wiederholen...");
			}
		}
		
		return wertTemp;
	}
	
	//die überladene Methode einlesen() für den Typ double
	//Beschreibung siehe oben bzw. bei der Methode für den int-Typ
	public static double einlesen(double wert) throws AbbruchException {
		double wertTemp = 0;
		String eingabeTemp;
		boolean gelungen = false;
		while (gelungen == false) {
			eingabeTemp = lesen("double");
			try {
				wertTemp = Double.parseDouble(eingabeTemp);
				gelungen = true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Ihre Eingabe war nicht gültig. Bitte wiederholen...");
			}
		}
		
		return wertTemp;
	}
		
	//die überladene Methode einlesen() für den Typ float
	//Beschreibung siehe oben bzw. bei der Methode für den int-Typ
	public static float einlesen(float wert) throws AbbruchException {
		float wertTemp = 0F;
		boolean gelungen = false;
		String eingabeTemp;
		while (gelungen == false) {
			eingabeTemp = lesen("float");
			try {
				wertTemp = Float.parseFloat(eingabeTemp);
				gelungen = true;
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Ihre Eingabe war nicht gültig. Bitte wiederholen...");
			}
		}
		
		return wertTemp;
	}
}
