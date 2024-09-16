module hangmanVerteilen {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens de.fernschulen.hangman to javafx.fxml;
	exports de.fernschulen.hangman;
}