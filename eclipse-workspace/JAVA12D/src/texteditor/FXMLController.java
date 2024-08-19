package texteditor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FXMLController {
	@FXML private TextArea editor;
	private Stage meineStage;
	
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML protected void ladenKlick(ActionEvent event) {
		FileChooser oeffnenDialog = new FileChooser();
		oeffnenDialog.setTitle("Datei öffnen");
		oeffnenDialog.setInitialDirectory(new File(System.getProperty("user.home")));
		oeffnenDialog.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
		File datei = oeffnenDialog.showOpenDialog(meineStage);
		if (datei != null)
			editor.setText(datenLesen(datei));
	}
	
	@FXML protected void neuKlick(ActionEvent event) {
		Alert meinDialog = new Alert(AlertType.INFORMATION, "Die Daten werden gelöscht.");
		meinDialog.setHeaderText("Bitte beachten");
		meinDialog.showAndWait();
		editor.clear();
	}
	
	@FXML protected void speichernKlick(ActionEvent event) {
		FileChooser speichernDialog = new FileChooser();
		speichernDialog.setTitle("Datei speichern");
		speichernDialog.setInitialDirectory(new File(System.getProperty("user.home")));
		speichernDialog.getExtensionFilters().add(new ExtensionFilter("Textdateien", "*.txt"));
		File datei = speichernDialog.showSaveDialog(meineStage);
		if (datei != null)
			datenSchreiben(datei);
	}
	
	// neue Methode zum Zeigen des Dialogs aus Aufgabe 2
	@FXML protected void zeigeAlert(ActionEvent event) {
		// Erstellen des neuen Dialogs (aus Aufgabe 2)
		DialogUniversell newAlert = new DialogUniversell("Frage", "Bitte entscheiden Sie", "Ist die richtige Antwort auf diese Frage Nein?");
		// speichern des Rückgabewerts (Ja/Nein)
		boolean res = newAlert.anzeigen();
		// zeige das Resultat in einem neuen Alert an.
		DialogUniversell resultAlert = new DialogUniversell(
				"Ergebnis", 
				"(eigentlich nur eine Anzeige, dass man sieht wie universell der\n Dialog ist und dass das Ergebnis gespeichert werden kann)", 
				"War Ihre Antwort nicht " + (res ? "Nein" : "Ja") + "?");
		resultAlert.showAndWait();
	}
	
	// Neue Methode zu Aufgabe 3
	@FXML protected void cut(ActionEvent event) {
		editor.cut();
	}
	
	// Neue Methode zu Aufgabe 3
	@FXML protected void copy(ActionEvent event) {
		editor.copy();
	}
	
	// Neue Methode zu Aufgabe 3
	@FXML protected void paste(ActionEvent event) {
		editor.paste();
	}

	
	private String datenLesen(File dateiLesen) {
		int zeichen = 0;
		StringBuilder text = new StringBuilder();
		try (FileReader tempDatei = new FileReader(dateiLesen)) {
			zeichen = tempDatei.read();
			while (zeichen != -1) {
				text.append((char)zeichen);
				zeichen = tempDatei.read();
			}
		}
		catch (IOException e) {
			Alert meinDialog = new Alert(AlertType.INFORMATION, "Beim Laden ist ein Problem aufgetreten");
			meinDialog.setHeaderText("Bitte beachten");
			meinDialog.showAndWait();
		}
		return (text.toString());
	}
	
	private void datenSchreiben(File dateiSchreiben) {
		try (FileWriter tempDatei = new	FileWriter(dateiSchreiben)) {
			tempDatei.write(editor.getText());
		}
		catch (IOException e) {
			Alert meinDialog = new Alert(AlertType.INFORMATION, "Beim Schreiben ist ein Problem aufgetreten");
			meinDialog.setHeaderText("Bitte beachten");
			meinDialog.showAndWait();
		}
	}
	
	public void setMeineStage(Stage meineStage) {
		this.meineStage = meineStage;
	}	
}
