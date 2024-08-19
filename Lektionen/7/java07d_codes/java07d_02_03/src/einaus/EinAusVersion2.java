/*#################################
 * Eine weitere öffentliche Klasse
 * im Paket einaus
 ##################################*/
//die Vereinbarung des Pakets
package einaus;

//der Import für den Dialog
import javax.swing.JOptionPane;

public class EinAusVersion2 {
	//eine private Instanzvariable
	private String eingabe;
	
	//die beiden öffentlichen Methoden
	//zum Einlesen
	public void einlesen() {
		eingabe = JOptionPane.showInputDialog("Bitte machen Sie Ihre Eingabe in der Version 2.");
	}
	
	public void ausgeben() {
		System.out.println("Ihre Eingabe in der Version 2 war: " + eingabe);
	}

}
