package mediaplayer;

import java.io.File;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;

public class FXMLController {
	//für die Bühne
	private Stage meineStage;
	//für den Player
	private MediaPlayer mediaplayer;

	//für die MediaView
	@FXML private MediaView mediaview;
	//für die ImageView mit dem Symbol
	@FXML private ImageView symbol;
	//für das Listenfeld
	@FXML private ListView<String> liste;
	
	@FXML private ImageView playPauseImage;
	
	// Aufgabe 2 Switch für die Funktionalität des Buttons und Speichern des Zustands
	private boolean isPlaying = false;
	
	@FXML private Button playPauseButton, stoppButton, muteButton;

	//die Methode setzt die Bühne auf den übergebenen Wert
	public void setMeineStage(Stage meineStage) {
		this.meineStage = meineStage;
	}

	//die Methode zum Laden
	@FXML protected void ladenKlick(ActionEvent event) {
		//eine neue Instanz der Klasse FileChooser erzeugen
		FileChooser oeffnenDialog = new FileChooser();
		//den Titel für den Dialog setzen
		oeffnenDialog.setTitle("Datei öffnen");
		//die Filter setzen
		oeffnenDialog.getExtensionFilters().add(new ExtensionFilter("Audiodateien", "*.mp3"));
		oeffnenDialog.getExtensionFilters().add(new ExtensionFilter("Videodateien", "*.mp4"));

		//den Startordner auf den Benutzerordner setzen
		oeffnenDialog.setInitialDirectory(new File(System.getProperty("user.home")));

		//den Öffnendialog anzeigen und das Ergebnis beschaffen
		File datei = oeffnenDialog.showOpenDialog(meineStage);
		//wurde eine Datei ausgewählt
		if (datei != null)
			//dann über eine eigene Methode laden
			dateiLaden(datei);
	}

	//die Methode zum Stoppen
	@FXML protected void stoppKlick(ActionEvent event) {
		//gibt es überhaupt einen Mediaplayer?
		if (mediaplayer != null)
			//dann anhalten
			mediaplayer.stop();
		
		// Aufgabe 3: deaktiviere auch hier die Buttons
		playPauseButton.setDisable(true);
		stoppButton.setDisable(true);
		muteButton.setDisable(true);
	}
	
	// Aufgabe 2: die geänderte Methode für die Wiedergabe/Pause.
	// Ändert die FUnktionalität zwischen Play und Pause je nach Stand des Programms (=internen Variable isPlaying)
	@FXML protected void playPauseKlick(ActionEvent event) {
		//gibt es überhaupt einen Mediaplayer?
		if (mediaplayer != null) {
			if (isPlaying) { // wenn das Symbol "Pause" zeigt: pausieren und symbol wechseln
				mediaplayer.pause();
				isPlaying = false;
				//das Play Bild erzeugen und anzeigen
				File bilddatei = new File("icons/play.gif");
				Image bild = new Image(bilddatei.toURI().toString());
				playPauseImage.setImage(bild);	
			} else { // wenn das Symbol "Play" zeigt: abspielen und symbol wechseln
				mediaplayer.play();
				isPlaying = true;
				//das Play Bild erzeugen und anzeigen
				File bilddatei = new File("icons/pause.gif");
				Image bild = new Image(bilddatei.toURI().toString());
				playPauseImage.setImage(bild);	
			}
		}
	}

	//die Methode für das Ein- und Ausschalten der Lautstärke
	@FXML protected void lautsprecherKlick(ActionEvent event) {
		//gibt es überhaupt einen Mediaplayer?
		String dateiname;
		if (mediaplayer != null) {
			//ist die Lautstärke 0?
			if (mediaplayer.getVolume() == 0) {
				//dann auf 100 setzen
				mediaplayer.setVolume(100);
				//und das "normale" Symbol setzen
				dateiname = "icons/mute.gif";
			}
			else {
				//sonst auf 0 setzen
				mediaplayer.setVolume(0);
				//und das durchgestrichene Symbol setzen
				dateiname = "icons/mute_off.gif";	
			}
			//das Bild erzeugen und anzeigen
			File bilddatei = new File(dateiname);
			Image bild = new Image(bilddatei.toURI().toString());
			symbol.setImage(bild);	
		}
	}

	// Aufgabe 1: Methode lädt eine Datei erneut bei Klick auf einen Listen Eintrag
	@FXML protected void listeKlick(MouseEvent event) {
		// hole den Dateipfad aus der Liste
		String dateiPfad = liste.getSelectionModel().getSelectedItem();
		if (dateiPfad == null)
			// wenn kein Eintrag ausgewählt wurde (an eine leere Stelle geklickt wurde)
			return;
		// als File laden um es an dateiLaden zu übergeben
		File datei = new File(dateiPfad);
		dateiLaden(datei);
		// lösche die Auswahl, damit beim nächsten Mal auch wieder beim Klick an ein leere Stelle "null" bei getSelectedItem() zurück kommt
		liste.getSelectionModel().clearSelection();
	}


	//die Methode zum Beenden
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}

	//die Methode lädt eine Datei
	public void dateiLaden(File datei) {
		//läuft schon eine Wiedergabe?
		if (mediaplayer != null && mediaplayer.getStatus() == MediaPlayer.Status.PLAYING) {
			//dann anhalten
			mediaplayer.stop();
		}
		//das Medium, den Mediaplayer und die MediaView erzeugen
		try {
			
			Media medium = new Media(datei.toURI().toString());
			mediaplayer = new MediaPlayer(medium);
			mediaview.setMediaPlayer(mediaplayer);
			//die Wiedergabe starten
			mediaplayer.play();
			
			// Aufgabe 2: setze das Bild und die Variable auf Pause für den nächsten Klick auf Play/Pause Button
			File bilddatei = new File("icons/pause.gif");
			Image bild = new Image(bilddatei.toURI().toString());
			playPauseImage.setImage(bild);	
			isPlaying = true;
			
			// Aufgabe 3: aktiviere die Buttons beim Laden einer Datei
			playPauseButton.setDisable(false);
			stoppButton.setDisable(false);
			muteButton.setDisable(false);

			// Aufgabe 3: setze ein Callback, das die Symbole deaktiviert sobald das Ende der Datei erreicht wurde.
			mediaplayer.setOnEndOfMedia(() -> {
				playPauseButton.setDisable(true);
				stoppButton.setDisable(true);
				muteButton.setDisable(true);
	            
	        });

			//den Pfad in das Listenfeld eintragen
			// Aufgabe 1: verhindere mehrfache Einträge der gleichen Datei
			if (! liste.getSelectionModel().getSelectedItems().contains(datei.toString()))
				liste.getItems().add(datei.toString());
			//und die Titelleiste anpassen
			meineStage.setTitle("JavaFX Multimedia-Player " + datei.toString());
		}
		catch(Exception ex) {
			//den Dialog erzeugen und anzeigen
			Alert meinDialog = new Alert(AlertType.INFORMATION, "Beim Laden hat es ein Problem gegeben.\n" + ex.toString());
			//den Text setzen
			meinDialog.setHeaderText("Bitte beachten");
			meinDialog.initOwner(meineStage);
			//den Dialog anzeigen
			meinDialog.showAndWait();
		}
	}
}
