package editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Editor extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
		Parent root = meinLoader.load();
		FXMLController meinController = meinLoader.getController();
		
		Scene meineScene = new Scene(root, 600, 450);
		
		meineStage.setTitle("Hangman");
		meineStage.setScene(meineScene);
		meineStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
