/* ######################################################
Einsendeaufgabe 4
###################################################### */
package java09d_2;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FensterBorder extends JFrame{
	private static final long serialVersionUID = 1084628674629652987L;
	private Dimension bGroesse;
	private int currentWidth;
	private int currentHeight;

	private JButton schaltflaecheHoch, schaltflaecheRunter, schaltflaecheLinks, schaltflaecheRechts;

	// innere Klasse für den WindowListener und den ActionListener
	class MeinKompakterListener extends WindowAdapter implements ActionListener{
		//für das öffnen des Fensters
		@Override
		public void windowOpened(WindowEvent e) {
		}

		//für die Schaltflächen
		@Override
		public void actionPerformed(ActionEvent e) {
			int newX = currentWidth;
			int newY = currentHeight;
			if (e.getActionCommand().equals("Hoch")) {
				if(currentHeight <= 25) {
					newY = 0;
				} else {
					newY = newY - 25;
				}
			}
			if (e.getActionCommand().equals("Runter")) {
				if(currentHeight >= bGroesse.getSize().height - 25) {
					newY = bGroesse.getSize().height;
				} else {
					newY = newY + 25;
				}
			}
			if (e.getActionCommand().equals("Links")) {
				if(currentHeight <= 25) {
					newX = 0;
				} else {
					newX = newX - 25;
				}
			}
			if (e.getActionCommand().equals("Rechts")) {
				if(currentHeight >= bGroesse.getSize().width - 25) {
					newX = bGroesse.getSize().width;
				} else {
					newX = newX + 25;
				}
			}
			
			currentWidth = newX;
			currentHeight = newY;
			setLocation(currentWidth, currentHeight);
		}
	}
	
	public FensterBorder(String titel) {
		super(titel);
		schaltflaecheHoch = new JButton("Hoch");
		schaltflaecheRunter = new JButton("Runter");
		schaltflaecheLinks = new JButton("Links");
		schaltflaecheRechts = new JButton("Rechts");
		
		//ein neues Border-Layout mit je 25 Pixeln Abstand setzen
		setLayout(new BorderLayout(25,25));
		
		//die Schaltflächen einfügen
		add(BorderLayout.NORTH,schaltflaecheHoch);
		add(BorderLayout.SOUTH,schaltflaecheRunter);
		add(BorderLayout.WEST,schaltflaecheLinks);
		add(BorderLayout.EAST,schaltflaecheRechts);

		//den Listener verbinden
		addWindowListener(new MeinKompakterListener());
		schaltflaecheHoch.addActionListener(new MeinKompakterListener());
		schaltflaecheRunter.addActionListener(new MeinKompakterListener());
		schaltflaecheLinks.addActionListener(new MeinKompakterListener());
		schaltflaecheRechts.addActionListener(new MeinKompakterListener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300, 300);
		//das Fenster positionieren
		bGroesse= Toolkit.getDefaultToolkit().getScreenSize();
		currentWidth = (bGroesse.width - getSize().width) / 2;
		currentHeight = (bGroesse.height - getSize().height) / 2;
		
		setLocation(currentWidth, currentHeight);
		setVisible(true);
	}
}
