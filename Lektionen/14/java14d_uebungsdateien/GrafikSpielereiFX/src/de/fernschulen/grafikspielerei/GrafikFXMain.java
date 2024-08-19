package de.fernschulen.grafikspielerei;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GrafikFXMain extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		//den obersten Knoten erzeugen
		//hier verwenden wir ein FlowPane
		FlowPane rootNode = new FlowPane();
		
		//Canvas erzeugen
		Canvas meinCanvas = new Canvas(400, 400);
		//den Grafikkontext beschaffen
		GraphicsContext gc = meinCanvas.getGraphicsContext2D();
		//die Zeichenfläche hinzufügen
		rootNode.getChildren().add(meinCanvas);
		//ein Rechteck zeichnen
		//Rechteck1.zeichne(gc);
		//ein Rechteck bis zum Rand zeichen
		//Rechteck1.zeichneMax(gc, meinCanvas);
		//ein erster Effekt
		//Rechteck2.zeichne(gc, meinCanvas);
		
		//ein Gitternetz zeichnen
		//Linie1.zeichne(gc, meinCanvas);
		
		//mehrere Objekte übereinander
		//Linie2.zeichne(gc, meinCanvas);
		
		//Kreise und Ellipsen
		//Kreis.zeichne(gc);
		
		//ein Polygon
		//Polygon.zeichne(gc);
		
		//einige Spielereien mit Farbe
		//Farbe1.zeichne(gc, meinCanvas);
		//Farbe2.zeichne(gc, meinCanvas);
		
		//breitere Linien
		Linie3.zeichne(gc, meinCanvas);
		
		//die Szene erzeugen
		//an den Konstruktor werden der oberste Knoten und die Größe übergeben
		Scene meineScene = new Scene(rootNode, 400, 400);
		
		//den Titel über stage setzen
		meineStage.setTitle("Grafikspielereien");
		//die Szene setzen
		meineStage.setScene(meineScene);
		//und anzeigen
		meineStage.show();
	}
	
	public static void main(String[] args) {
		//der Start
		launch(args);
	}
}
