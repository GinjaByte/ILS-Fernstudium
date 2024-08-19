/*##############################
 * Eine Division durch 0 führt 
 * zum abrupten Ende
 ###############################*/
package java08d_05_01;

//für den Dialog
import javax.swing.JOptionPane;

public class Java08d_05_01 {

	public static void main(String[] args) {
		int zahl1, zahl2, ergebnis;
		zahl1 = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die erste Zahl ein."));
		zahl2 = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die zweite Zahl ein."));
		ergebnis = zahl1 / zahl2;
		System.out.println("Das Ergebnis ist " + ergebnis);
	}
}
