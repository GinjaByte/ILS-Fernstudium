package taschenrechner;

import java.text.NumberFormat;
import java.util.Locale;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TaschenrechnerFXController {
	// das Label für die Ausagbe
	@FXML private Label ausgabe;
	// die Textbox für den Input für zahl1
	@FXML private TextField zahl1;
	// die Textbox für den Input für zahl2
	@FXML private TextField zahl2;
	// Radio Buttons für die jeweiligen Rechenoperationen und die RadioButton Gruppe
	@FXML private RadioButton radioAddition;
	@FXML private RadioButton radioSubtraktion;
	@FXML private RadioButton radioMultiplikation;
	@FXML private RadioButton radioDivision;
	private ToggleGroup radioGroup;

	// die Methode für den "Beenden" Button
	@FXML protected void beenden(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML protected void showResult(ActionEvent event) {
		RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
		ausgabe.setText(berechnen(zahl1.getText(), zahl2.getText(), selectedRadio.getId()));
	}
	
	/**
	 * Versucht die Zahlen als Double zu parsen und das Ergebnis abhängig von der Rechenoperation zu berechnen.
	 * @param zahl1String	Zahl 1 als String
	 * @param zahl2String	Zahl 2 als String
	 * @param radioOperation	Rechenoperation als ID des Radio Buttons("radioAddition", "radioSubtraktion", "radioMultiplikation", "radioDivision")
	 * @return Das Ergebnis als String
	 */
	private String berechnen(String zahl1String, String zahl2String, String radioOperation) {
		// Variabel für die geparsten Zahlen
		double zahl1, zahl2, ergebnis = 0;
		// Fehler Flag zum meken von Fehlern
		boolean fehlerFlag = false;
		
		try {
			zahl1 = NumberFormat.getNumberInstance(Locale.GERMANY).parse(zahl1String).doubleValue();
		}
		catch (Exception ParseException) {
			zahl1 = 0;
		}
		try {
			zahl2 = NumberFormat.getNumberInstance(Locale.GERMANY).parse(zahl2String).doubleValue();
		}
		catch (Exception ParseException) {
			zahl2 = 0;
		}

		if (radioOperation.equals("radioAddition"))
			ergebnis = zahl1 + zahl2;
		if (radioOperation.equals("radioSubtraktion"))
			ergebnis = zahl1 - zahl2;
		if (radioOperation.equals("radioMultiplikation"))
			ergebnis = zahl1 * zahl2;
		if (radioOperation.equals("radioDivision")) {
			if (zahl2 != 0)
				ergebnis = zahl1 / zahl2;
			else 
				fehlerFlag = true;
		}
		if (fehlerFlag == false) {
			return (Double.toString(ergebnis));
		}
		else
			return ("n. def.");
	}
	
	//die Methode wird nach dem Verarbeiten der FXML-Anweisungen ausgefÃ¼hrt
    @FXML void initialize() {
    	radioGroup = new ToggleGroup();
    	radioAddition.setToggleGroup(radioGroup);
    	radioSubtraktion.setToggleGroup(radioGroup);
    	radioMultiplikation.setToggleGroup(radioGroup);
    	radioDivision.setToggleGroup(radioGroup);
    	
    	radioAddition.setSelected(true);
    }
}
