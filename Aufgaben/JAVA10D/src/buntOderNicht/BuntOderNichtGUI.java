package buntOderNicht;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BuntOderNichtGUI extends JFrame{
	private static final long serialVersionUID = 2007237315429965675L;

	// Änderung der Reihenfolge
	private String[] farbAuswahl = {"Schwarz", "Rot", "Gelb", "Blau", "Grün"};
	
	private JRadioButton bunt, nichtBunt;
	private ButtonGroup gruppe;
	private JCheckBox gross;
	private JComboBox <String> auswahl;
	private JButton schaltflaecheBeenden;
	private JLabel anzeige;
	
	class MeinListener implements ActionListener, ItemListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object ausloeser = e.getSource();
			if (ausloeser instanceof JComboBox) {
				if (auswahl.getSelectedItem().toString().equals("Rot"))
					anzeige.setForeground(Color.RED);
				if (auswahl.getSelectedItem().toString().equals("Gelb"))
					anzeige.setForeground(Color.YELLOW);
				if (auswahl.getSelectedItem().toString().equals("Blau"))
					anzeige.setForeground(Color.BLUE);
				if (auswahl.getSelectedItem().toString().equals("Grün"))
					anzeige.setForeground(Color.GREEN);
				if (auswahl.getSelectedItem().toString().equals("Schwarz"))
					anzeige.setForeground(Color.BLACK);
			}
			if (ausloeser instanceof JButton) {
				if (e.getActionCommand().equals("Beenden"))
					System.exit(0);
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object ausloeser = e.getSource();
			if (ausloeser instanceof JCheckBox) {
				if (gross.isSelected() == true)
					anzeige.setFont(new Font("Arial", Font.PLAIN,30));
				else
					anzeige.setFont(new Font("Arial", Font.PLAIN,14));
			}
			if (ausloeser instanceof JRadioButton) {	
				if (bunt.isSelected() == true)
					auswahl.setEnabled(true);
				else
					auswahl.setEnabled(false);
			}
		}
	}
	
	public BuntOderNichtGUI(String titel) {
		super(titel);
		
		gross = new JCheckBox("Größer darstellen");
		auswahl = new JComboBox<String> (farbAuswahl);
		auswahl.setEnabled(false);
		
		schaltflaecheBeenden = new JButton("Beenden");
		bunt = new JRadioButton("bunt");
		nichtBunt = new JRadioButton("einfarbig");
		nichtBunt.setSelected(true);

		gruppe = new ButtonGroup();
		gruppe.add(bunt);
		gruppe.add(nichtBunt);
		
		anzeige = new JLabel("Der Text");
		anzeige.setFont(new Font("Arial", Font.PLAIN,14));
		
		setLayout(new GridLayout(0,2,10,10));
		add(anzeige);
		add(gross);
		add(bunt);
		add(auswahl);
		add(nichtBunt);
		add(schaltflaecheBeenden);
		
		MeinListener listener = new MeinListener();
		schaltflaecheBeenden.addActionListener(listener);
		gross.addItemListener(listener);
		bunt.addItemListener(listener);
		nichtBunt.addItemListener(listener);
		auswahl.addActionListener(listener);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}
}
