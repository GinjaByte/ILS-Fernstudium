package hangman;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Score extends Stage{
	private Stage owner;
	private GridPane rootNode;
	
	private int punkte;

	private Listenelement [] bestenliste;
	private int anzahl;
	
	private String dateiName;
	
	class Listenelement implements Comparable<Listenelement> {
		private int listePunkte;
		private String listeName;
		
		public Listenelement(int listePunkte, String listeName) {
			setzeEintrag(listePunkte, listeName);
		}

		@Override
		public int compareTo(Listenelement tempEintrag) {
			if (this.listePunkte < tempEintrag.listePunkte)
				return 1;
			if (this.listePunkte > tempEintrag.listePunkte)
				return -1;
			else
				return 0;
		}
		
		public void setzeEintrag(int listePunkte, String listeName) {
			this.listeName = listeName;
			this.listePunkte = listePunkte;
		}
		
		public int getListePunkte() {
			return listePunkte;
		}
		
		public String getListeName() {
			return listeName;
		}
	}
	
	public Score(Stage fenster) {
		super();
		owner = fenster;
		initOwner(fenster);
		rootNode = new GridPane();
		Scene meineScene = new Scene(rootNode, 300, 300);
		setScene(meineScene);
		initModality(Modality.WINDOW_MODAL);
		initStyle(StageStyle.UTILITY);
		
		loeschePunkte();
		
		anzahl = 10;
		
		bestenliste = new Listenelement[anzahl];
		for (int index = 0; index < anzahl; index++)
			bestenliste[index] = new Listenelement(0,"Nobody");
		
		dateiName = "score.dat";

		File dateiTest = new File(dateiName);
		if (dateiTest.exists() == true)
			datenLesen();
		
	}

	public int veraenderePunkte(int punkte) {
		this.punkte = this.punkte + punkte;
		return this.punkte;
	}
	
	public void loeschePunkte() {
		punkte = 0;
	}
	
	public boolean neuerEintrag() {
		String tempName;
		if (punkte > bestenliste[anzahl-1].getListePunkte()){
			TextInputDialog meinDialog = new TextInputDialog();
			meinDialog.setTitle("Gewonnen");
			meinDialog.setHeaderText("Herzlichen Glückwunsch");
			meinDialog.setContentText("Bitte geben Sie Ihren Namen ein: ");
			meinDialog.initOwner(owner);
			Optional<String> dialogEingabe = meinDialog.showAndWait();
			if (dialogEingabe.isPresent())
				tempName = dialogEingabe.get();
			else
				tempName = "Max Mustermann";
			bestenliste[anzahl-1].setzeEintrag(punkte, tempName);
			Arrays.sort(bestenliste);
			datenSchreiben();
			return true;
		}
		else
			return false;
	}
	
	public void listeZeigen() {
		setTitle("Bestenliste");
		rootNode.add(new Label("Punkte"), 0, 0);
		rootNode.add(new Label("Name"), 1, 0);
		for (int index = 0; index < anzahl; index++) {
			rootNode.add(new Label(Integer.toString(bestenliste[index].getListePunkte())), 0, index + 1);
			rootNode.add(new Label(bestenliste[index].getListeName()), 1, index + 1);
		}
		showAndWait();
	}
	
	public void datenSchreiben() {
		try (RandomAccessFile datei = new RandomAccessFile(dateiName,"rw")){
			for (int index = 0; index < anzahl; index++) {
				datei.writeInt(bestenliste[index].getListePunkte());
				datei.writeUTF(bestenliste[index].getListeName());
			}
		} 
		catch (IOException e) {
				System.out.println("Beim Schreiben der Bestenliste ist ein Problem aufgetreten");
		}
	}

	public void datenLesen() {
		String tempName;
		int tempPunkte;
		try (RandomAccessFile datei = new RandomAccessFile(dateiName,"r")){
			for (int index = 0; index < anzahl; index++) {
				tempPunkte = datei.readInt();
				tempName = datei.readUTF();
				bestenliste[index].setzeEintrag(tempPunkte, tempName);
			}
		}
		catch (IOException e) {
			System.out.println("Beim Laden der Bestenliste ist ein Problem aufgetreten");
		}
	}
}
