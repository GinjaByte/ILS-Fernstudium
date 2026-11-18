package taschenrechner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaschenrechnerFX extends Application {
	/**
	 * Lädt die GUI. Wirft möglicherweise eine Exception.
	 */
	@Override
	public void start(Stage meineStage) throws Exception {
		//die fxmlDatei laden
		Parent root = FXMLLoader.load(getClass().getResource("TaschenrechnerFXGUI.fxml"));		

		//die Szene erzeugen
		Scene meineScene = new Scene(root, 400, 100);
		
		//den Titel über stage setzen
		meineStage.setTitle("Taschenrechner V12");
		meineStage.setScene(meineScene);
		meineStage.show();
		
		meineStage.setResizable(false);
	}
	
	// main methode startet die GUI
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
