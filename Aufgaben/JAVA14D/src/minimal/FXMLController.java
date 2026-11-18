package minimal;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FXMLController {
    @FXML private Canvas zeichenflaeche;
    @FXML private ColorPicker farbauswahl;    

  	private GraphicsContext gc;
	private int xPos, yPos;
	private int werkzeug;
	private Color farbe;

	@FXML protected void beendenKlick(ActionEvent event) {
		Platform.exit();
	}
	
    @FXML void initialize() {
		farbe = Color.BLACK;
		farbauswahl.setValue(farbe);
		werkzeug = 1;
		gc = zeichenflaeche.getGraphicsContext2D();
    }

    @FXML protected void linieKlick(ActionEvent event) {
    	werkzeug = 1;
    }

    @FXML protected void kreisKlick(ActionEvent event) {
    	werkzeug = 2;
    }
    
    @FXML protected void rechteckKlick(ActionEvent event) {
    	werkzeug = 3;
    }
    
    // Aufgabe 3: Button für gefüllte Kreise setzt Werkzeug auf 4
    @FXML protected void kreisFilledKlick(ActionEvent event) {
    	werkzeug = 4;
    }
    
	@FXML protected void mausGedrueckt(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) {
			xPos = (int)e.getX();
			yPos = (int)e.getY();
		}
	}

	@FXML protected void mausLos(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) {
			if (werkzeug == 1)
				linie((int)e.getX(), (int)e.getY());
			if (werkzeug == 2)
				kreis((int)(e.getX()-xPos), (int)(e.getY() - yPos));
			if (werkzeug == 3)
				rechteck((int)(e.getX()-xPos), (int)(e.getY() - yPos));
			
			// Aufgabe 3: bei Werkzeug 4 wird ein ausgefüllter Kreis gezeichnet
			if (werkzeug == 4)
				kreisFilled((int)(e.getX()-xPos), (int)(e.getY() - yPos));
		}
	}
	
	@FXML protected void farbAuswahlZeigen() {
		farbe = farbauswahl.getValue();
		gc.setStroke(farbe);
	}

	protected void rechteck(int breite, int hoehe) {
		gc.strokeRect(xPos, yPos, breite, hoehe);
	}

	protected void kreis(int breite, int hoehe) {
		gc.strokeOval(xPos, yPos, breite, hoehe);
	}
	
	protected void linie(int x2, int y2) {
		gc.strokeLine(xPos, yPos, x2, y2);
	}
	
	// Aufgabe 3: Methode zum Zeichnen eines gefüllten Kreises mit der bereits ausgewählten Farbe
	protected void kreisFilled(int breite, int hoehe) {
		gc.setFill(farbe);
		gc.fillOval(xPos, yPos, breite, hoehe);
	}

}
