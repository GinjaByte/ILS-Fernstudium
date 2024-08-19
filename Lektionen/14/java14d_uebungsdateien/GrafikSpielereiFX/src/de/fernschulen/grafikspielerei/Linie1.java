package de.fernschulen.grafikspielerei;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Linie1 {
	public static void zeichne(GraphicsContext gc, Canvas meinCanvas) {
		//zum Wandern
		int xPos = 1;
		int yPos = 1;
		//für die maximalen Koordinaten
		int xMax = (int)meinCanvas.getWidth() - 1;
		int yMax = (int)meinCanvas.getHeight() - 1;

		//Linien von links nach rechts bis zum unteren Rand des Panels
		while (yPos < yMax) {
			gc.strokeLine(0, yPos, xMax, yPos);
			yPos = yPos + 10;
		}
		
		//Linien von oben nach unten bis zum rechten Rand des Panels
		while (xPos < xMax) {
			gc.strokeLine(xPos, 0, xPos, yMax);
			xPos = xPos + 10;
		}
	}
}
