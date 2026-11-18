package texteditor;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Die neue Klasse Für Aufgabe 2. Erweitert Alert um im Konstruktor zusätzliche Felder zu setzen und die "anzeigen" Methode
public class DialogUniversell extends Alert {

	/**
	 * Konstruktor setzt übliche Felder von der Klasse Alert sowie den Text und Header.
	 * @param title Titel des Dialogs
	 * @param header Header/Frage des Dialogs
	 * @param content Content/Frage des Dialogs
	 */
	public DialogUniversell(String title, String header, String content) {
		super(AlertType.CONFIRMATION, content, ButtonType.YES, ButtonType.NO);
		setHeaderText(header);
		setTitle(title);
	}
	
	/**
	 * neue "showAndWait" Methode zum anzeigen des Dialogs und stellen der Frage
	 * @return Gibt einen boolean Wert zurück: True, wenn mit "Ja" beantowrtet wurde, False sonst
	 */
	public boolean anzeigen() {
        showAndWait();
        return getResult() == ButtonType.YES;
	}
	
}
