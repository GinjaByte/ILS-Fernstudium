import javax.swing.JOptionPane;

public class Wein {
	private int alter;
	private double grundpreis;
	private double preisProFlasche;

	public Wein() {
		throw new IllegalArgumentException();
	}

	public Wein(int alter) {
		throw new IllegalArgumentException();
	}

	public Wein(double grundpreis) {
		throw new IllegalArgumentException();
	}

	public Wein(int alter, double grundpreis) {
		if (alter > 0)
			this.alter = alter;
		else
			this.alter = 1;
		if (grundpreis > 9)
			this.grundpreis = grundpreis;
		else
			this.grundpreis = 10;
	}
	
	public static void main(String[] args) {
		try {
			Wein wein = new Wein();
		} catch(IllegalArgumentException e) {
			System.out.println("Aufruf über Konstruktor new Wein() fehlgeschlagen.");
		}
		
		try {
			Wein wein = new Wein(1);
		} catch(IllegalArgumentException e) {
			System.out.println("Aufruf über Konstruktor new Wein(1) fehlgeschlagen.");
		}
		
		try {
			Wein wein = new Wein(1.5);
		} catch(IllegalArgumentException e) {
			System.out.println("Aufruf über Konstruktor new Wein(1.5) fehlgeschlagen.");
		}
		
		try {
			Wein wein = new Wein(1, 1.5);
		} catch(IllegalArgumentException e) {
			System.out.println("Aufruf über Konstruktor new Wein(1, 1.5) fehlgeschlagen.");
		}
		
		try {
			int i = Integer.parseInt(JOptionPane.showInputDialog("Bitte eine Zahl eingeben: "));
		} catch(NullPointerException e) {
			System.out.println("ungültige Eingabe");
		}
	}

}