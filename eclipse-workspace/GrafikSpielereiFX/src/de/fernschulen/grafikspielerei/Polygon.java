package de.fernschulen.grafikspielerei;

import javafx.scene.canvas.GraphicsContext;

public class Polygon {
	public static void zeichne(GraphicsContext gc) {
		//ein Array für die X-Koordinaten
		double[] xPunkte = {10, 60, 110, 270, 200};
		//ein Array für die X-Koordinaten
		double[] yPunkte = {10, 20, 90, 150, 20};
		
		//ein Polygon
		gc.strokePolygon(xPunkte, yPunkte, 5);
		//eine Linie über mehrere Punkte
		//gc.strokePolyline(xPunkte, yPunkte, 5);
	}
}
