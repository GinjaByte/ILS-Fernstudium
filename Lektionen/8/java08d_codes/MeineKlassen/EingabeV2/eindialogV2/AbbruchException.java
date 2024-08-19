/* ###########################################################
 * Eine Klasse für die selbst definierte Ausnahme
 * ###########################################################
 * Sie erbt von der Klasse Exception
 * und erstellt lediglich den Standardkonstruktor und 
 * einen Konstruktor für die Übergabe der Meldung    
 #############################################################*/
package eindialogV2;

public class AbbruchException extends Exception {
	/**
	 * automatisch über Eclipse ergänzt
	 */
	private static final long serialVersionUID = 1790155766626408529L;

	//der Standard-Konstruktor
	AbbruchException() {
		super();
	}
	
	//der Konstruktor zur Übergabe einer Meldung
	//er ruft über super den Konstruktor der Basisklasse auf
	AbbruchException(String meldung) {
		super(meldung);
	}
}
