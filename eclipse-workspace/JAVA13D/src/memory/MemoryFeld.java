package memory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class MemoryFeld {
	class TimerHandler implements EventHandler<ActionEvent> {
		// Für Aufgabe 1: Variable damit der TimerHandler eine beliebige Aktion ausführen kann
	    private Runnable task;
	    // Konstruktor speichert die auszuführende Aktion zwischen um sie nach Ablauf des Timers auszuführen
	    public TimerHandler(Runnable task) {
	        this.task = task;
	    }
	    
		@Override
		// Die Methode führt die zuvor gespeicherte Aktion aus
		public void handle(ActionEvent event) {
	        task.run();
		}
	}

	private MemoryKarte[] karten;
	
	private String[] bilder = {"grafiken/apfel.jpg", "grafiken/birne.jpg", "grafiken/blume.jpg", "grafiken/blume2.jpg",
			"grafiken/ente.jpg", "grafiken/fisch.jpg", "grafiken/fuchs.jpg", "grafiken/igel.jpg",
			"grafiken/kaenguruh.jpg", "grafiken/katze.jpg", "grafiken/kuh.jpg", "grafiken/maus1.jpg",
			"grafiken/maus2.jpg", "grafiken/maus3.jpg", "grafiken/melone.jpg", "grafiken/pilz.jpg",
			"grafiken/ronny.jpg", "grafiken/schmetterling.jpg","grafiken/sonne.jpg",
			"grafiken/wolke.jpg", "grafiken/maus4.jpg"};
	
	private int menschPunkte, computerPunkte;
	
	// Aufgabe 2: neues Label für Spieler
	private Label menschPunkteLabel, computerPunkteLabel, spielerLabel, gewinnerLabel;
	
	//Aufgabe 3: Schummel Button
	private Button schummelButton;	
	
	private int umgedrehteKarten;
	
	private MemoryKarte[] paar;
	
	private int spieler;
	
	private int[][] gemerkteKarten;
	
	private int spielstaerke;
	
	private Timeline timer;
	
	// Aufgabe 1: Variable zum prüfen, ob das Spiel zu Ende ist
	private boolean spielEnde;

	// Aufgabe 3: Variable zum deaktivieren der KarteOeffnen Funktion während des Schummelns
	private boolean amSchummeln; 
	
	public MemoryFeld() {
		karten = new MemoryKarte[42];

		paar = new MemoryKarte[2];

		gemerkteKarten = new int[2][21];
		
		menschPunkte = 0;
		computerPunkte = 0;
		
		umgedrehteKarten = 0;
		
		spieler = 0;
		
		spielstaerke = 10;
		
		// Spiel startet
		spielEnde = false;
		
		for (int aussen = 0; aussen < 2; aussen++)
			for (int innen = 0; innen < 21; innen++)
				gemerkteKarten[aussen][innen] = -1;
	}
	
	public FlowPane initGUI(FlowPane feld) {
		kartenZeichnen(feld);
		menschPunkteLabel = new Label();
		computerPunkteLabel = new Label();
		menschPunkteLabel.setText(Integer.toString(menschPunkte));
		computerPunkteLabel.setText(Integer.toString(computerPunkte));
		
		// Aufgabe 1: init neues Label für Gewinner
		gewinnerLabel = new Label();
		// Aufgabe 3: init und Ändern des neuen Labels für den ziehenden Spieler
		spielerLabel = new Label();
		setzeSpielerLabel();
		
		GridPane tempGrid = new GridPane();
		tempGrid.add(new Label("Mensch: "), 0 , 0 );
		tempGrid.add(menschPunkteLabel, 1, 0);
		tempGrid.add(new Label("Computer: "), 0, 1);
		tempGrid.add(computerPunkteLabel, 1 ,1);
		
		// Aufgabe 2: neue Label einbinden
		tempGrid.add(new Label("Es zieht: "), 0, 2);
		tempGrid.add(spielerLabel, 1, 2);
		
		// Aufgabe 1: neue Label einbinden
		tempGrid.add(new Label("Gewinner: "), 0, 3);
		tempGrid.add(gewinnerLabel, 1, 3);
		
		// Aufgabe 3: Schummeln Button, der je nach Spielzustand aktiviert oder deaktiviert wird
		schummelButton = new Button("Schummeln");
		schummelButton.setOnAction(e -> schummeln());
		tempGrid.add(schummelButton, 1, 4);
		
		feld.getChildren().add(tempGrid);
		return feld;
	}
	
	private void kartenZeichnen(FlowPane feld) {
		int count = 0;
		for (int i = 0; i <= 41; i++) {
			karten[i] = new MemoryKarte(bilder[count], count, this);
			if ((i + 1) % 2 == 0)
				count++;
		}
		Collections.shuffle(Arrays.asList(karten));

		for (int i = 0; i <= 41; i++) {
			feld.getChildren().add(karten[i]);
			karten[i].setBildPos(i);
		}
	}
	
	public void karteOeffnen(MemoryKarte karte) {
		if (amSchummeln) {
			// Aufgabe 3: mache nichts hier, wenn gerade geschummelt wird 
			return;
		} else {
			// Aufgabe 3: wenn nicht geschummelt wird und eine Karte geöffnet wird, deaktiviere den Schummel Button immer (auch wenn der Button bereits deaktiviert ist)  
			schummelButton.setDisable(true);
		}
		
		int kartenID, kartenPos;

		paar[umgedrehteKarten]=karte;
		
		kartenID = karte.getBildID();
		kartenPos = karte.getBildPos();
		if ((gemerkteKarten[0][kartenID] == -1)) 
			gemerkteKarten[0][kartenID] = kartenPos;
			if (gemerkteKarten[0][kartenID] != kartenPos) 
				gemerkteKarten[1][kartenID] = kartenPos;
		umgedrehteKarten++;
		
		if (umgedrehteKarten == 2) {
			paarPruefen(kartenID);
			timer = new Timeline(new KeyFrame(Duration.millis(2000), new TimerHandler(() -> karteSchliessen())));
			timer.play();
		}
		if (computerPunkte + menschPunkte == 21) {
			// Aufgabe 1: setze das Spiel auf "zu Ende" und zeige den Gewinner an
			spielEnde = true;
			zeigeGewinner(computerPunkte > menschPunkte ? "Computer" : "Mensch");
			Timeline endTimer = new Timeline(new KeyFrame(Duration.millis(10000), new TimerHandler(() -> Platform.exit())));
			endTimer.play();
		}
	}
	
	private void karteSchliessen() {
		boolean raus = false;
		if (paar[0].getBildID() == paar[1].getBildID()) 
			raus = true;
		paar[0].rueckseiteZeigen(raus);
		paar[1].rueckseiteZeigen(raus);
		umgedrehteKarten = 0;
		if (raus == false) 
			spielerWechseln();
		else
			if (spieler == 1)
				computerZug();
		
		// Aufgabe 3: Wenn der Spieler ein Paar gefunden hat, kann er wieder schummeln
		if (spieler == 0 && raus == true) {
			schummelButton.setDisable(false);
		}
	}
	
	private void paarPruefen(int kartenID) {
		if (paar[0].getBildID() == paar[1].getBildID()) {
			paarGefunden();
			gemerkteKarten[0][kartenID]=-2;
			gemerkteKarten[1][kartenID]=-2;
		}
	}

	private void paarGefunden() {
		if (spieler == 0) {
			menschPunkte++;
			menschPunkteLabel.setText(Integer.toString(menschPunkte));
		}
		else {
			computerPunkte++;
			computerPunkteLabel.setText(Integer.toString(computerPunkte));
		}
	}
	
	private void spielerWechseln() {
		if (spieler == 0) {
			spieler = 1;
			computerZug();
		}
		else  {
			spieler = 0;
			// Aufgabe 3: aktiviere den Schummeln Button wenn der Spieler den Zug startet
			schummelButton.setDisable(false);
		}
			
		// update Spieler Label
		setzeSpielerLabel();
	}
	
	private void computerZug() {
		// Aufgabe 1: wenn das Spiel zu Ende ist, spielt der Computer nicht mehr und gibt den Zug an den Spieler ab
		if (spielEnde) {
			return;
		}
		
		int kartenZaehler = 0;
		int zufall = 0;
		boolean treffer = false;
		if ((int)(Math.random() * spielstaerke) == 0) {
			while ((kartenZaehler < 21) && (treffer == false)) {
				if ((gemerkteKarten[0][kartenZaehler] >=0) &&  (gemerkteKarten[1][kartenZaehler] >=0)) {
					treffer = true;
					karten[gemerkteKarten[0][kartenZaehler]].vorderseiteZeigen();
					karteOeffnen(karten[gemerkteKarten[0][kartenZaehler]]);
					karten[gemerkteKarten[1][kartenZaehler]].vorderseiteZeigen();
					karteOeffnen(karten[gemerkteKarten[1][kartenZaehler]]);
				}
				kartenZaehler++;
			}
		}
		if (treffer == false) {
			do {
				zufall = (int)(Math.random() * karten.length);
			} while (karten[zufall].isNochImSpiel() == false);
			karten[zufall].vorderseiteZeigen();
			karteOeffnen(karten[zufall]);
			do {
				zufall = (int)(Math.random() * karten.length);
			} while ((karten[zufall].isNochImSpiel() == false) || (karten[zufall].isUmgedreht() == true));
			karten[zufall].vorderseiteZeigen();
			karteOeffnen(karten[zufall]);
		}
	}
	
	public boolean zugErlaubt() {
		boolean erlaubt = true;
		if (spieler == 1)
			erlaubt = false;
		if (umgedrehteKarten == 2)
			erlaubt = false;
		return erlaubt;
	}
	
	// Aufgabe 1: Setzt den Text des Labels auf den gewinnenden Spieler
	private void zeigeGewinner(String gewinner) {
		gewinnerLabel.setText(gewinner);
	}
	
	// Aufgabe 2: Ändert den Text des Labels für den ziehenden Spieler
	private void setzeSpielerLabel() {
		if (spieler == 0) {
			spielerLabel.setText("Der Mensch");
		} else {
			spielerLabel.setText("Der Computer");
		}
	}
	
	// Aufgabe 3: schummeln Funktion, die durch den Button aufgerufen wird und alle Karten im Spiel für 2 Sekunden anzeigt und dann wieder umdreht
	private void schummeln() {
		// Aufgabe 3: Schummel Button wird während des Schummelns deaktiviert und danach wieder aktiviert
		schummelButton.setDisable(true);
		amSchummeln = true;

		// erstelle eine Liste aller Karten, die noch im Spiel sind
		ArrayList<MemoryKarte> schummelListe = new ArrayList<MemoryKarte>();
		for (MemoryKarte karte : karten) {
			if (karte.isNochImSpiel()) {
				schummelListe.add(karte);
			}
		}
		
		schummelnStart(schummelListe);
		
		Timeline schummelTimer = new Timeline(new KeyFrame(Duration.millis(2000), new TimerHandler(() -> schummelnEmde(schummelListe))));
		schummelTimer.play();
	}
	
	// Aufgabe 3: Zeige die Vorderseite aller übergebenen Karten
	private void schummelnStart(ArrayList<MemoryKarte> schummelListe) {
		for (MemoryKarte karte : schummelListe) {
			karte.vorderseiteZeigen();
		}
	}

	// Aufgabe 3: Drehe alle übergebenen Karten um
	private void schummelnEmde(ArrayList<MemoryKarte> schummelListe) {
		boolean raus = false;
		for (MemoryKarte karte : schummelListe) {
			karte.rueckseiteZeigen(raus);
		}
		amSchummeln = false;
		schummelButton.setDisable(false);
	}
}
