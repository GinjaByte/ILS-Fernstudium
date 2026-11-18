package editor;

import java.io.FileReader;
import java.io.FileWriter;
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
    private String dateiName = "woerter.txt";

    // das Wort im TextField wird zur Liste (TextArea) am Ende hinzugefügt, und die Anzahl der Wörter geupdated 
	@FXML protected void hinzufuegenKlick(ActionEvent event) {
		// lese das neue Wort ein und entferne Whitespaces
		String wort = neuesWortField.getText().trim();
		neuesWort(wort);
	}
	
	// Der Inhalt von der TextArea wird in der Datei gespeichert
	@FXML protected void dateiSpeichernKlick(ActionEvent event) {
		// oeffne eine Instanz der Woerter-Datei und schreibe den String der TextArea hinein
		try (FileWriter datei = new FileWriter(dateiName)){
			datei.write(wortListe.getText());
		}
		catch (IOException e ) {
			System.out.println("Beim Schreiben ist ein Problem aufgetreten");
	    }
	}
	
	// beendet das Programm
	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
	// initialisiere - Datei wird eingelesen und in der TextArea angezeigt
    @FXML void initialize() {
    	// TODO read in and display file at start
    	wortListe.setText(leseWoerterListe());
    	
    }
    
	private void neuesWort(String wort) {
		// lese die aktuelle Liste aus der TextArea ein
		StringBuilder string = new StringBuilder(wortListe.getText());
		// checke, ob das Wort nur Buchstaben enthält. Sonst: überspringe das Wort
		if (! wort.matches("[a-zA-Z]+")) {
			return;
		}

		// Füge das Wort in einer neues Zeile hinzu
		string.append("\n" + wort);
		
		// Finde das erste \n (Newline) um die erste Zeile der Datei - welche die ANzahl der Wörter enthält - zu lesen und später zu ändern
		int newlineIndex = string.indexOf("\n");
		// Errechne die Anzahl der Wörter in der Liste (= Anzahl der Zeilen - 1)
		int anzahlWoerter = string.toString().split("\n").length - 1;
		// ersetze die erste Zeile mit der Anzahl an Wörtern
		string.replace(0, newlineIndex, Integer.toString(anzahlWoerter));
		
		// update die TextArea mit dem neuen String
		wortListe.setText(string.toString());
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
