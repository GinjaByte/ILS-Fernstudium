/* ######################################################
Im Paket "(default package)"
###################################################### */

import javax.swing.JOptionPane;

import javaauf4.Rechnungen;;

public class java07d_4 {
	public static void main(String[] args) {
		int zahlInt = 5;
		double zahlDouble = 5.55;
		Rechnungen rechnungen = new Rechnungen();
		System.out.println("Das Quadrat aus " + zahlInt + " ist " + rechnungen.quadrat(Integer.parseInt(JOptionPane.showInputDialog("asd"))));
		System.out.println("Das Quadrat aus " + zahlDouble + " ist " + rechnungen.quadrat(zahlDouble));
		
	}
}
