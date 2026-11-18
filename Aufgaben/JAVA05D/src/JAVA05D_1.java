/* ######################################################
Einsendeaufgabe 5.1
###################################################### */
class Fernseher {
	private int lautstarke;
	private String programm;
	private boolean istAn = false;
	
	void initialisiere() {
		this.istAn = false;
	}
	
	void aendereLautstarke(int lautstarke) {
		if (this.istAn) {
			this.lautstarke = lautstarke;
			System.out.printf("Lautstärke auf %d geändert.\n", this.lautstarke);
		}
	}
	
	void an() {
		this.istAn = true;
		System.out.println("Fernseher eingeschaltet");
	}
	
	void aus() {
		this.istAn = false;
		System.out.println("Fernseher ausgeschaltet");
	}
	
	void aendereProgramm(String neuesProgramm) {
		this.programm = neuesProgramm;
		System.out.printf("%s wird jetzt geguckt...\n", this.programm);
	}
}

public class JAVA05D_1 {
	public static void main(String[] args) {
		Fernseher fernseher = new Fernseher();
		fernseher.an();
		fernseher.aendereLautstarke(10);
		fernseher.aendereProgramm("rtl");
		fernseher.aendereProgramm("rtl2");
		fernseher.aendereProgramm("kika");
		fernseher.aus();
	}

}
