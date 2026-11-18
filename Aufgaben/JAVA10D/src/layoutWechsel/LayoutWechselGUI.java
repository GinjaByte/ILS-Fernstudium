package layoutWechsel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class LayoutWechselGUI extends JFrame{
	private static final long serialVersionUID = 4668009235734676602L;
	
	// Panel in welchem sich das Layout ändern wird, die, ComboBox zum auswählen des Layouts und Optionen der Layouts 
	private JPanel panelLayouts;
	JRadioButton button0, button1, button2;
	ButtonGroup gruppe;
	private String[] layoutOptions = {"Border Layout", "Grid Layout", "Flow Layout"};

	// innere Listener Klasse für die Events der RadioButtons
	class MeinListener implements ItemListener {		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (button0.isSelected() == true)
				replacePanel(layoutOptions[0]);
			if (button1.isSelected() == true)
				replacePanel(layoutOptions[1]);
			if (button2.isSelected() == true)
				replacePanel(layoutOptions[2]);
		}
	}
	
	//Konstruktor mit Window Titel als Parameter
	public LayoutWechselGUI(String titel) {
		super(titel);
		
		//Listener für Radio Buttons
		MeinListener listener = new MeinListener();
		// Panel für Radio Buttons
		JPanel controlPanel = new JPanel();

		button0 = new JRadioButton(layoutOptions[0]);
		button1 = new JRadioButton(layoutOptions[1]);
		button2 = new JRadioButton(layoutOptions[2]);
		button0.addItemListener(listener);
		button1.addItemListener(listener);
		button2.addItemListener(listener);
		
		gruppe = new ButtonGroup();
		gruppe.add(button0);
		gruppe.add(button1);
		gruppe.add(button2);

		controlPanel.add(button0);
		controlPanel.add(button1);
		controlPanel.add(button2);

		panelLayouts = makeBorderPanel();
		button1.setSelected(true);

		//default: BorderPanel
		add(controlPanel, BorderLayout.NORTH);
		add(panelLayouts, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}

	//Methode zum ändern des Layouts, type ist ein String der ebstimmt zu welchem Layout gewechselt wird. Kein Rückgabewert
	private void replacePanel(String type) {
		remove(panelLayouts);
		
		switch(type) {
		case "Border Layout":
            panelLayouts = makeBorderPanel();
			break;
        case "Grid Layout":
            panelLayouts = makeGridPanel();
            break;
        case "Flow Layout":
            panelLayouts = makeFlowPanel();
            break;
        }

        add(panelLayouts, BorderLayout.CENTER);
        pack();
        revalidate();
        repaint();
	}

	//Methode zum Erstellen eines Panels mit BorderLayout. Gibt das Panel Objekt zurück
	private JPanel makeBorderPanel() {
		JPanel tempPanel = new JPanel(); // temporäre Variable die als Rückgabewert genutzt wird
		tempPanel.setLayout(new BorderLayout(10, 10));
		
		tempPanel.add(new JLabel("Hier ist das BorderLayout"), BorderLayout.CENTER);
		tempPanel.add(new JLabel("Noch ein Text"), BorderLayout.WEST);
		tempPanel.add(new JLabel("Und noch ein Text"), BorderLayout.EAST);
		
		tempPanel.setBorder(new TitledBorder("BorderLayout"));
		
		return tempPanel;
	}

	//Methode zum Erstellen eines Panels mit GridLayout. Gibt das Panel Objekt zurück
	private JPanel makeGridPanel() {
		JPanel tempPanel = new JPanel(); // temporäre Variable die als Rückgabewert genutzt wird
		tempPanel.setLayout(new GridLayout(0, 2, 10, 10));
		tempPanel.add(new JLabel("Hier ist das GridLayout"));
		tempPanel.add(new JLabel("Noch ein Text"));
		tempPanel.add(new JLabel("Und noch ein Text"));
		
		tempPanel.setBorder(new TitledBorder("GridLayout"));
		
		return tempPanel;
	}

	//Methode zum Erstellen eines Panels mit FlowLayout. Gibt das Panel Objekt zurück
	private JPanel makeFlowPanel() {
		JPanel tempPanel = new JPanel(); // temporäre Variable die als Rückgabewert genutzt wird
		tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		tempPanel.add(new JLabel("Hier ist das FlowLayout"));
		tempPanel.add(new JLabel("Noch ein Text"));
		tempPanel.add(new JLabel("Und noch ein Text"));
		
		tempPanel.setBorder(new TitledBorder("FlowLayout"));
		
		return tempPanel;
	}
	

	public static void main(String[] args) {
		new LayoutWechselGUI("LayoutWechsel");
	}
}
