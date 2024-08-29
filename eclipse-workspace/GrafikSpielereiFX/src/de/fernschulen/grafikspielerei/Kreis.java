package de.fernschulen.grafikspielerei;

import javafx.scene.canvas.GraphicsContext;

public class Kreis {
	public static void zeichne(GraphicsContext gc) {
		//ein Kreis
		gc.strokeOval(10, 10, 100, 100);
		//eine Ellipse
		gc.strokeOval(150, 150, 50, 100);
		//ein Kreis in einem Quadrat
		gc.strokeRect(150, 50, 100, 100);
		gc.strokeOval(150, 50, 100, 100);
	}
}
