package editor;

import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	// die FXML Elemente auf die Zugriff benötigt wird
	@FXML private TextArea wortListe;
    @FXML private TextField neuesWortField; 
    
    //Name der Datei
    private String dateiName = "Woerter.txt";

    // das Wort im TextField wird zur Liste (TextArea) am Ende hinzugefügt, und die Anzahl der Wörter geupdated 
	@FXML protected void hinzufuegenKlick(ActionEvent event) {
		// TODO
	}
	
	// Der Inhalt von der TextArea wird in der Datei gespeichert
	@FXML protected void dateiSpeichernKlick(ActionEvent event) {
		// TODO
	}
	
	// beendet das Programm
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
	// initialisiere - Datei wird eingelesen und in der TextArea angezeigt
    @FXML void initialize() {
    	// TODO read in and display file at start
    	String wortListe = leseWoerterListe();
    }
    
	private void neuesWort() {
		// TODO
	}
	
	// liest die ganze Datei ein und gibt sie zurück.
	// Falls keine existiert, wird ein String mit 0 (für die Anzahl der Wörter) und anschließend leere Liste zurückgegeben und beim Speichern eine neue Datei erstellt
	private String leseWoerterListe() {
		StringBuilder string = new StringBuilder();
		int zeichen = 0;
		// öffnet die Datei und liest/speichert jedes Zeichen (als int) einzeln
		try (FileReader datei = new FileReader(dateiName)) {
			zeichen = datei.read();
			while (zeichen != -1) {
				// zeichen wird in den Typ char umgewandelt
				string.append((char) zeichen);
				zeichen = datei.read();
			}
			return string.toString();
		}
		catch (IOException e ) {
			System.out.println("Beim Laden ist ein Problem aufgetreten");
	    }
		return "0";
	}
	
	
}
