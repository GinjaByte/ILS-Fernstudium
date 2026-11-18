package taschenrechner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class TaschenrechnerGUI extends JFrame{
	private static final long serialVersionUID = 4668009235734676602L;
	
	private JFormattedTextField eingabe1, eingabe2;
	// neues String Array für die Auswahlen der Kombobox
	private String[] operationenAuswahl = {"addition", "subtraktion", "multiplikation", "division"};
	// neue Kombobox Variable
	private JComboBox <String> auswahlOperation;
	private JButton schaltflaecheBeenden;
	private JLabel ausgabe;

	class MeinListener implements ActionListener {
		
		//neue Bedingung falls der Sender (Kombobox) den ActionCommand "operationAusgewaehlt" gesendet hat. 
		//Dann wird der Index der gerade ausgewählten Option ermittelt und der String an berechnen übergeben
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("ende")) 
				System.exit(0);
			if (e.getActionCommand().equals("operationAusgewaehlt")) {
				int index = auswahlOperation.getSelectedIndex();
				ausgabe.setText(berechnen(operationenAuswahl[index]));
			}
		}
	}
	
	public TaschenrechnerGUI(String titel) {
		super(titel);
		
		// listener auch im Konstruktor deklariert zur späteren Zuweisung
		MeinListener listener = new MeinListener(); 
		JPanel panelEinAus, panelButtons, gross;
		
		panelEinAus = panelEinAusErzeugen();
		panelButtons = panelButtonErzeugen();
		
		// Kombobox initialisieren
		auswahlOperation = new JComboBox<String>(operationenAuswahl);
		auswahlOperation.addActionListener(listener);
		auswahlOperation.setActionCommand("operationAusgewaehlt");

		//default: BorderPanel
		gross = new JPanel();
		gross.add(panelEinAus);
		gross.add(auswahlOperation);
		
		add(gross,BorderLayout.CENTER);
		add(panelButtons, BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
		setResizable(false);
	}

	private JPanel panelEinAusErzeugen() {
		JPanel tempPanel = new JPanel();
		eingabe1 = new JFormattedTextField(new DecimalFormat("#.##"));
		eingabe2 = new JFormattedTextField(new DecimalFormat("#.##"));
		ausgabe = new JLabel("");
		
		tempPanel.setLayout(new GridLayout(0, 2, 10, 10));
		tempPanel.add(new JLabel("Zahl 1:"));
		tempPanel.add(eingabe1);
		
		tempPanel.add(new JLabel("Zahl 2: "));
		tempPanel.add(eingabe2);
		
		tempPanel.add(new JLabel("Ergebnis: "));
		tempPanel.add(ausgabe);
		
		tempPanel.setBorder(new TitledBorder("Ein- und Ausgabe"));
		
		return tempPanel;
	}
	
	private JPanel panelButtonErzeugen() {
		JPanel tempPanel = new JPanel();

		schaltflaecheBeenden = new JButton(" Beenden ");
		schaltflaecheBeenden.setActionCommand("ende");
		
		tempPanel.add(new JLabel());
		tempPanel.add(schaltflaecheBeenden);
		
		MeinListener listener = new MeinListener();
		schaltflaecheBeenden.addActionListener(listener);
		
		return tempPanel;
	}
	
	// neu: String der jeweiligen Rechenoperation wird jetzt mitgegeben, Rückgabewert bleibt
	private String berechnen(String operation) {
		double zahl1, zahl2, ergebnis = 0;
		boolean fehlerFlag = false;
		
		try {
			Number wert = NumberFormat.getNumberInstance(Locale.GERMANY).parse(eingabe1.getText());
			zahl1 = wert.doubleValue();
		}
		catch (Exception ParseException) {
			zahl1 = 0;
		}
		
		try {
			Number wert = NumberFormat.getNumberInstance(Locale.GERMANY).parse(eingabe2.getText());
			zahl2 = wert.doubleValue();
		}
		catch (Exception ParseException) {
			zahl2 = 0;
		}
	
		if (operation == "addition")
			ergebnis = zahl1 + zahl2;
		if (operation == "subtraktion")
			ergebnis = zahl1 - zahl2;
		if (operation == "multiplikation")
			ergebnis = zahl1 * zahl2;
		if (operation == "division") {
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
}
