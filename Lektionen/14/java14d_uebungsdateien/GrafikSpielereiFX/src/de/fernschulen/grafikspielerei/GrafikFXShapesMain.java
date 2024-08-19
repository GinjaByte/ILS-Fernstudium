package de.fernschulen.grafikspielerei;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GrafikFXShapesMain extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		//den obersten Knoten erzeugen
		//hier verwenden wir ein FlowPane
		FlowPane rootNode = new FlowPane();
	
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Größe übergeben
		Scene meineScene = new Scene(rootNode, 400, 400);
		
		//den Titel über stage setzen
		meineStage.setTitle("Einfache Grafiken mit Shapes");
		//die Szene setzen
		meineStage.setScene(meineScene);

		//ein Rechteck zeichnen
		Rectangle rechteck = new Rectangle(100, 100);
		//das Rechteck erhält eine dickere Linie in Rot
		//und eine Füllung in Blau
		rechteck.setStroke(Color.RED);
		rechteck.setStrokeWidth(10);
		rechteck.setFill(Color.BLUE);
		
		//einen Kreis zeichen
		//hier wird der Radius angegeben
		Circle kreis= new Circle(100);
		//die Farbe ist gelb
		kreis.setStroke(Color.YELLOW);
		//und die Linie ein wenig dünner
		kreis.setStrokeWidth(3);
		
		//die Shapes werden hinzugefügt
		rootNode.getChildren().add(rechteck);
		rootNode.getChildren().add(kreis);
		
		//eine Animation 
		//Sie soll zehn Sekunden dauern
		ScaleTransition zoom = new ScaleTransition(Duration.millis(10000), rechteck);
		//die Vergrößerung soll in Y-Richtung um den Faktor 2 erfolgen 
		zoom.setByY(2);
		//die Animation soll fünfmal wiederholt werden
		zoom.setCycleCount(5);
		//und automatisch rückwärts laufen
		zoom.setAutoReverse(true);
		//los geht es
		zoom.play(); 
		
		//ein Würfel
		Box wuerfel = new Box (100, 100, 100);
		//damit der 3D-Effekt sichtbar, verdrehen wir den Würfel
		wuerfel.setRotationAxis(new Point3D(90,90,0));
		wuerfel.setRotate(45);
		
		//eine Kugel
		Sphere kugel = new Sphere(100);
		
		rootNode.getChildren().add(wuerfel);
		rootNode.getChildren().add(kugel);

		//und anzeigen
		meineStage.show();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
