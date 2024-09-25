package aufgabe_07;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class TaschenrechnerStart extends JFrame{
	// nötige globale Variablen
	private JLabel labelZahl;
	private JButton btnAddition, btnSubtraktion, btnMultiplikation, btnDivision;
	
	// bestimmt, ob bei Klick auf eine zahl angehängt oder eine neue Zahl erstellt wird
	private boolean concatMode;
	// die letzte Zahl vor einer Rechenoperation wird hier vermerkt
	float carryOver;
	
	
	// die innere Klasse für den ActionListener
	class MeinListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("0"))
				klickZahl(0);
			if (e.getActionCommand().equals("1"))
				klickZahl(1);
			if (e.getActionCommand().equals("2"))
				klickZahl(2);
			if (e.getActionCommand().equals("3"))
				klickZahl(3);
			if (e.getActionCommand().equals("4"))
				klickZahl(4);
			if (e.getActionCommand().equals("5"))
				klickZahl(5);
			if (e.getActionCommand().equals("6"))
				klickZahl(6);
			if (e.getActionCommand().equals("7"))
				klickZahl(7);
			if (e.getActionCommand().equals("8"))
				klickZahl(8);
			if (e.getActionCommand().equals("9"))
				klickZahl(9);
			if (e.getActionCommand().equals("Ergebnis"))
				klickErgebnis();
			if (e.getActionCommand().equals("Komma"))
				klickKomma();
			if (e.getActionCommand().equals("Addition"))
				klickOperation("Addition");
			if (e.getActionCommand().equals("Subtraktion"))
				klickOperation("Subtraktion");
			if (e.getActionCommand().equals("Multiplikation"))
				klickOperation("Multiplikation");
			if (e.getActionCommand().equals("Division"))
				klickOperation("Division");
		}
	}
	
	
	// der Konstruktor
	public TaschenrechnerStart(String titel) {
		super(titel);
		
		initGUI();
		setZahl(0);
		concatMode = false;
	
		// Größe setzen, Standardverhalten festlegen und anzeigen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	// erzeugt die ganze GUI
	private void initGUI() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(320, 290));
		
		// Label für Ein-/Ausgabe
		JPanel panelLabel = new JPanel();
		labelZahl = new JLabel();
		labelZahl.setFont(new Font("SansSerif", Font.PLAIN, 25));
		labelZahl.setHorizontalAlignment(SwingConstants.RIGHT);
		labelZahl.setPreferredSize(new Dimension(300, 40));
		panelLabel.add(labelZahl);
		
		// Buttons für die Eingabe
		JPanel panelEingabe = new JPanel();
		panelEingabe.setLayout(new GridLayout(4,4));
		JButton btn0 = new JButton("0");
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btnErgebnis = new JButton("=");
		JButton btnKomma = new JButton(",");
		btnAddition = new JButton("+");
		btnSubtraktion = new JButton("-");
		btnMultiplikation = new JButton("×");
		btnDivision = new JButton("÷");
		
		// Füge Funktionalität zu Buttons hinzu
		MeinListener listener = new MeinListener();
		btn0.setActionCommand("0");
		btn0.addActionListener(listener);
		btn1.setActionCommand("1");
		btn1.addActionListener(listener);
		btn2.setActionCommand("2");
		btn2.addActionListener(listener);
		btn3.setActionCommand("3");
		btn3.addActionListener(listener);
		btn4.setActionCommand("4");
		btn4.addActionListener(listener);
		btn5.setActionCommand("5");
		btn5.addActionListener(listener);
		btn6.setActionCommand("6");
		btn6.addActionListener(listener);
		btn7.setActionCommand("7");
		btn7.addActionListener(listener);
		btn8.setActionCommand("8");
		btn8.addActionListener(listener);
		btn9.setActionCommand("9");
		btn9.addActionListener(listener);
		btnErgebnis.setActionCommand("Ergebnis");
		btnErgebnis.addActionListener(listener);
		btnKomma.setActionCommand("Komma");
		btnKomma.addActionListener(listener);
		btnAddition.setActionCommand("Addition");
		btnAddition.addActionListener(listener);
		btnSubtraktion.setActionCommand("Subtraktion");
		btnSubtraktion.addActionListener(listener);
		btnMultiplikation.setActionCommand("Multiplikation");
		btnMultiplikation.addActionListener(listener);
		btnDivision.setActionCommand("Division");
		btnDivision.addActionListener(listener);

		panelEingabe.add(btn7);
		panelEingabe.add(btn8);
		panelEingabe.add(btn9);
		panelEingabe.add(btnDivision);
		panelEingabe.add(btn4);
		panelEingabe.add(btn5);
		panelEingabe.add(btn6);
		panelEingabe.add(btnMultiplikation);
		panelEingabe.add(btn1);
		panelEingabe.add(btn2);
		panelEingabe.add(btn3);
		panelEingabe.add(btnSubtraktion);
		panelEingabe.add(btnKomma);
		panelEingabe.add(btn0);
		panelEingabe.add(btnErgebnis);
		panelEingabe.add(btnAddition);
		
		// Panels zur root hinzufügen
		add(panelLabel, BorderLayout.NORTH);
		add(panelEingabe, BorderLayout.CENTER);
	}
	
	
	private void klickOperation(String operation) {
		
		concatMode = false;
	}
	
	private void klickZahl(int zahl) {
		
		concatMode = true;
	}
	
	private void klickKomma() {
		
	}
	
	private void klickErgebnis() {
		
	}
	
	
	// Hilfsmethode zum schnellen Holen einer Zahl
	private float getZahl() {
		return Float.parseFloat(labelZahl.getText());
	}

	// Hilfsmethode zum schnellen Hinzufügen einer Ziffer
	private void concatZiffer(int ziffer) {
		setZahl(Float.parseFloat(Float.toString(getZahl()) + ziffer));
	}

	// Hilfsmethode zum schnellen Setzen einer Zahl
	private void setZahl(float zahl) {
		labelZahl.setText(Float.toString(zahl));
	}

	// Hilfsmethode zum schnellen Setzen einer Zahl
	private void setString(String string) {
		labelZahl.setText(string);
	}
}
