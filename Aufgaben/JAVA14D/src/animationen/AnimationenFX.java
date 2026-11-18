package animationen;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationenFX extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		// root-Pane und Szene der Oberfläche
		FlowPane rootNode = new FlowPane();
		Scene meineScene = new Scene(rootNode, 400, 400);

		// Szene in die Stage einbinden
		meineStage.setTitle("Aufgabe 4: Animationen");
		meineStage.setScene(meineScene);
		
		// Kreis als Shape (Circle) erzeugen und alle nötigen Eigenschaften setzen
		Circle kreis= new Circle(100);
		kreis.setStroke(Color.BLACK);
		kreis.setStrokeWidth(3);
		kreis.setFill(Color.LIGHTYELLOW);

		// Quadrat als Shape (Rectangle) erzeugen und alle nötigen Eigenschaften setzen
		Rectangle quadrat = new Rectangle(100, 100);
		quadrat.setStroke(Color.BLACK);
		quadrat.setStrokeWidth(3);
		quadrat.setFill(Color.LIGHTYELLOW);
		
		// Kreis und Quadrat zur Oberfläche hinzufügen
		rootNode.getChildren().add(kreis);
		rootNode.getChildren().add(quadrat);
		
		// Zoom Transitions/Animationen des Kreises erzeugen, 10 Mal durchlaufen und zurücklaufen lassen
		ScaleTransition zoomKreis = new ScaleTransition(Duration.millis(500), kreis);
		zoomKreis.setByY(0.5);
		zoomKreis.setByX(0.5);
		// den Count setze ist auf 20, da ich annehme "Die Animationen sollen jeweils 10-mal wiederholt werden" gilt für BEIDE Richtungen (größer und dann zurück), sonst wäre es hier 10
		zoomKreis.setCycleCount(20);
		zoomKreis.setAutoReverse(true);
		zoomKreis.play(); 
		
		// Zoom Transitions/Animationen des Quadrats erzeugen und 10 Mal durchlaufen und zurücklaufen lassen
		ScaleTransition zoomQuadrat = new ScaleTransition(Duration.millis(500), quadrat);
		zoomQuadrat.setByY(-0.5);
		zoomQuadrat.setByX(-0.5);
		// den Count setze ist auf 20, da ich annehme "Die Animationen sollen jeweils 10-mal wiederholt werden" gilt für BEIDE Richtungen (kleiner und dann zurück), sonst wäre es hier 10
		zoomQuadrat.setCycleCount(20);
		zoomQuadrat.setAutoReverse(true);
		zoomQuadrat.play(); 
		

		meineStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
