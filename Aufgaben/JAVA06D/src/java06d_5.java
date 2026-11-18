class Insekt {
	int laenge;
	int gewicht;
	
	//der Konstruktor
	Insekt(int laenge, int gewicht) {
		this.laenge = laenge;
		this.gewicht = gewicht;
	}
	
	//die Methode zum Essen
	void essen() {
		laenge = laenge + 1;
		gewicht = gewicht + 1;
	}
	
	//die Methode zur Ausgabe
	void ausgabe() {
		System.out.println("Das Insekt ist " + laenge + " cm lang und wiegt " + gewicht + " Gramm.");
	}
}

class Biene extends Insekt {
	int geschwindigkeit;
	
	Biene(int laenge, int gewicht, int geschwindigkeit) {
		super(laenge, gewicht);
		this.geschwindigkeit = geschwindigkeit;
	}
	
	@Override
	void ausgabe() {
		System.out.println("Die Biene ist " + laenge + " cm lang, wiegt " + gewicht + " Gramm und ist " + geschwindigkeit + " km/h schnell.");
	}
}


public class java06d_5 {
	public static void main(String[] args) {
		Insekt insekt = new Insekt(1,2);
		Biene biene = new Biene(4,5,6);
		
		insekt.ausgabe();
		biene.ausgabe();
	}
}
