package hangman;

import java.io.FileReader;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLController {
	@FXML private ComboBox<String> auswahl;
    @FXML private Label ausgabeText;
    @FXML private Label anzVersuche;	
    @FXML private Label punktAusgabe;
    @FXML private Canvas zeichenflaeche;    
	
  	private String [] zeichen = new String[26];
  	private StringBuilder anzeige;
  	private String suchwort;
  	private int restDurchlauefe;
  	private int fehler;
  	private GraphicsContext gc;
  	private Score spielpunkte;
  	private Stage meineStage;
  	

	@FXML protected void auswahlNeu(ActionEvent event) {
		pruefen(auswahl.getSelectionModel().getSelectedItem().toString());
		gewinnerOderNicht();
	}

	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
    @FXML void initialize() {
		int tempIndex = 0;
		restDurchlauefe = 9;
		anzVersuche.setText(Integer.toString(restDurchlauefe));
		
		for (char temp = 'a'; temp <= 'z'; temp++) {
			zeichen[tempIndex] = Character.toString(temp);
			tempIndex++;
		}
		
		auswahl.getItems().addAll(zeichen);
		neuesWort();    	
    	
		gc = zeichenflaeche.getGraphicsContext2D();
		spielpunkte = new Score(meineStage);
    }	
    
	private void neuesWort() {
		int zufall = 0;
		String[] woerter;
		
		// Die Wörter-Datei wird als Array eingelesen
		try (FileReader datei = new FileReader("woerter.txt")) {
			int zeichen = datei.read();
			// Für den ersten Schritt: lese die Zahl in der ersten Zeile (=Anzahl der Wörter) ein und initialisiere damit das Array
			StringBuilder anzahlString = new StringBuilder();
			while ((char) zeichen != '\n') {
				anzahlString.append((char) zeichen);
				zeichen = datei.read();
			}
			// Wörter Array wird mit der Anzahl der Wörter initilisiert
			woerter = new String[Integer.parseInt(anzahlString.toString())];
			// Index im Array, an welcher Stelle das nächste Wort eingefügt wird
			int woerterIndex = 0;
			
			// lese die restlichen Zeilen (=Wörter) ein und füge diese ins Array ein
			StringBuilder wort = new StringBuilder();
			while (zeichen != -1) {
				if ((char) zeichen == '\n') {
					// lege das Wort ins Array, resette den StringBuilder und erhöhe den Index fürs nächste Wort
					woerter[woerterIndex] = wort.toString();
					wort.setLength(0);
					woerterIndex++;
				} else {
					// lese das Wort weiter ein
					wort.append((char) zeichen);
				}
				zeichen = datei.read();
			}

			// der Rest bleibt gleich
			zufall = (int)(Math.random() * woerter.length);
			
			suchwort = new String(woerter[zufall]);
			anzeige = new StringBuilder(suchwort);
			
			for (int i = 0; i < suchwort.length(); i++)
				anzeige.setCharAt(i, '*');

			ausgabeText.setText(anzeige.toString());
		}
		catch (IOException e ) {
			System.out.println("Beim Laden ist ein Problem aufgetreten");
	    }
	}
    
	private void pruefen(Object auswahlZeichen) {
		char zeichen;
		int treffer = 0;
		zeichen = auswahlZeichen.toString().charAt(0);
		treffer = suchwort.toLowerCase().indexOf(zeichen);
		if (treffer < 0) {
			restDurchlauefe--;
			anzVersuche.setText(Integer.toString(restDurchlauefe));
			erhoeheFehler();
			punktAusgabe.setText(Integer.toString(spielpunkte.veraenderePunkte(-1)));
		}
		else {
			while (treffer >= 0) {
				anzeige.setCharAt(treffer, suchwort.charAt(treffer));
				treffer++;
				treffer = suchwort.toLowerCase().indexOf(zeichen,treffer);
				punktAusgabe.setText(Integer.toString(spielpunkte.veraenderePunkte(5)));
			}
			ausgabeText.setText(anzeige.toString());
		}
	}
	
	private void gewinnerOderNicht() {
		boolean ende = false;
		gc.setLineWidth(1);
		if (restDurchlauefe == 0) {
			gc.strokeText("Das gesuchte Wort war: " + suchwort, 20, 100);
			ende = true;
		}
		if (anzeige.toString().equals(suchwort)) {
			spielpunkte.veraenderePunkte(restDurchlauefe * 10);
			gc.strokeText("Hurra! Sie haben gewonnen!", 20, 100);
			ende = true;
		}
		if (ende == true) {
			if (spielpunkte.neuerEintrag() == true)
				spielpunkte.listeZeigen();
			Platform.exit();
		}
	}
	
	private void erhoeheFehler() {
		fehler = fehler + 1;
		gc.setLineWidth(4);
		
		switch (fehler) {
		case 1:
			gc.strokeLine(10,10,10,200);
			break;
		case 2:
			gc.strokeLine(10,10,100,10);
			break;
		case 3:
			gc.strokeLine(40,10,10,40);
			break;
		case 4:
			gc.strokeLine(100,10,100,50);
			break;
		case 5:
			gc.strokeLine(70,50,130,50);
			break;
		case 6:
			gc.strokeLine(130,50,130,110);
			break;
		case 7:
			gc.strokeLine(130,110,70,110);
			break;
		case 8:
			gc.strokeLine(70,110,70,50);
			break;
		case 9:
			gc.strokeLine(0,200,20,200);
			break;
		}
	}
	
	public void setStage(Stage meineStage) {
		this.meineStage = meineStage;
		spielpunkte = new Score(meineStage);
	}
}
