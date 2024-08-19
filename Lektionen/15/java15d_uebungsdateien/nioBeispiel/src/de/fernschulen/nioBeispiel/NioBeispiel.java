package de.fernschulen.nioBeispiel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NioBeispiel {
	public static void main(String[] args) {
		//den Namen für die Datei setzen
		String dateiName = "score.dat";
		//den Pfad der Quelle beschaffen
		Path quelle = Paths.get(dateiName);
		//den Pfad für das Ziel setzen
		//Sie müssen ihn unter Umständen an Ihr Betriebssystem anpassen
		Path ziel = Paths.get("C:/test/" + dateiName);

		//die Datei kopieren
		//wenn sie bereits vorhanden ist, wird sie überschrieben
		try {
			Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
		} 
		catch (IOException e) {
			System.out.println("Beim Kopieren hat es ein Problem gegeben");
		}
	}
}
