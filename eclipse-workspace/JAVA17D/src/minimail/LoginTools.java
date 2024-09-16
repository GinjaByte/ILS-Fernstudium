package minimail;

import java.io.FileReader;
import java.io.IOException;

// Tools für Aufgabe 1
public class LoginTools {
	// Name der Datei
	private static String dateiName = "Login.txt";
	
	// statische Methode um den Benutzernamen aus der Datei zu lesen. Gibt den Benutzernamen als String zurück.
	public static String getBenutzername() {
		// lese die Datei wie im Heft 15 Zeichen für Zeichen ein
		StringBuilder string = new StringBuilder();
		int zeichen = 0;
		try (FileReader datei = new FileReader(dateiName)) {
			zeichen = datei.read();
			//Das Resultat (Benutzername) steht in der 1. Zeile, daher: lese bis zum ersten Zeilenumbruch
			while (zeichen != -1 && (char) zeichen != '\n') {
				string.append((char) zeichen);
				zeichen = datei.read();
			}
			
			return string.toString();
		}
		catch (IOException e ) {
			System.out.println("Beim Laden der Datei ist ein Problem aufgetreten");
			return "";
	    }
	}
	
	// statische Methode um den Kennwort aus der Datei zu lesen. Gibt das Kennwort als String zurück.
	public static String getKennwort() {
		// lese die Datei wie im Heft 15 Zeichen für Zeichen ein
		StringBuilder string = new StringBuilder();
		int zeichen = 0;
		try (FileReader datei = new FileReader(dateiName)) {
			zeichen = datei.read();
			//Das Resultat (Kennwort) steht in der 2. und letzten Zeile, daher: lese ab dem ersten Zeilenumbruch bis zum Ende
			while (zeichen != -1 && (char) zeichen != '\n') {
				zeichen = datei.read();
			}
			zeichen = datei.read();
			while (zeichen != -1) {
				string.append((char) zeichen);
				zeichen = datei.read();
			}
			
			return string.toString();
		}
		catch (IOException e ) {
			System.out.println("Beim Laden der Datei ist ein Problem aufgetreten");
			return "";
	    }
	}
}
