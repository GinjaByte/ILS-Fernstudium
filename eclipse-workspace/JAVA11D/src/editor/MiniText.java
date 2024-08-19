package editor;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
// DefaultEditorKit für Teilaufgabe 2 einbinden
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;


public class MiniText extends JFrame {

	private static final long serialVersionUID = -4622810145518216095L;
	private JEditorPane eingabeFeld;
	private HTMLEditorKit htmlFormat;
	
	// hilfe Aktion hinzugefügt (Teilaufgabe 1)
	private MeineAktionen 	oeffnenAct, speichernAct, beendenAct, neuAct, druckenAct, 
							speichernUnterAct, webOeffnenAct, infoAct;
	
	private File datei;
	
	private JPopupMenu kontext;

	class MeineAktionen extends AbstractAction {
		private static final long serialVersionUID = 5736947176597361976L;

		public MeineAktionen(String text, ImageIcon icon, String bildschirmtipp, KeyStroke shortcut, String actionText) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, bildschirmtipp);
			putValue(ACCELERATOR_KEY, shortcut);
			putValue(ACTION_COMMAND_KEY, actionText);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("neu"))
				dateiNeu();
			if (e.getActionCommand().equals("laden"))
				dateiLaden();
			if (e.getActionCommand().equals("speichern"))
				dateiSpeichern();
			if (e.getActionCommand().equals("beenden"))
				beenden();
			if (e.getActionCommand().equals("drucken")) {
				if (e.getSource() instanceof JButton) 
					drucken(false);
				if (e.getSource() instanceof JMenuItem) 
					drucken(true);
			}
			if (e.getActionCommand().equals("speichernUnter"))
				dateiSpeichernUnter();
			if (e.getActionCommand().equals("webladen"))
				webLaden();
			// zeige Infos (Teilaufgabe 1)
			if (e.getActionCommand().equals("info"))
				info();
		}
	}
	
	class MeinKontextMenuListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
			if (e.isPopupTrigger()) 
				kontext.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
	public MiniText(String text) {
		super(text);
		addToTitle(null);
		setLayout(new BorderLayout());
		
		neuAct = new MeineAktionen("Neu...", new ImageIcon("icons/new24.gif"), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N',InputEvent.CTRL_DOWN_MASK), "neu");
		oeffnenAct = new MeineAktionen("öffnen...", new ImageIcon("icons/open24.gif"), "öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O',InputEvent.CTRL_DOWN_MASK),"laden");
		speichernAct = new MeineAktionen("Speichern", new ImageIcon("icons/save24.gif"), "Speichert das aktuelle Dokument", KeyStroke.getKeyStroke('S',InputEvent.CTRL_DOWN_MASK), "speichern");
		beendenAct = new MeineAktionen("Beenden", null, "", null, "beenden");
		druckenAct = new MeineAktionen("Drucken...", new ImageIcon("icons/print24.gif"), "Druckt das aktuelle Dokument", KeyStroke.getKeyStroke('P',InputEvent.CTRL_DOWN_MASK), "drucken");
		speichernUnterAct = new MeineAktionen("Speichern unter...", null, "", null, "speichernUnter");
		webOeffnenAct = new MeineAktionen("Webseite...", new ImageIcon("icons/webComponent24.gif"), "öffnet eine Webseite", null, "webladen");
		infoAct = new MeineAktionen("Info", new ImageIcon("icons/information24.gif"), "Zeigt Infos über das Programm an", KeyStroke.getKeyStroke('I', InputEvent.CTRL_DOWN_MASK), "info");

		menu();
		add(symbolleiste(), BorderLayout.NORTH);
		kontextMenu();

		eingabeFeld = new JEditorPane();
		htmlFormat = new HTMLEditorKit();
		eingabeFeld.setEditorKit(htmlFormat);
		eingabeFeld.addMouseListener(new MeinKontextMenuListener());

		add(new JScrollPane(eingabeFeld), BorderLayout.CENTER);
		
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		eingabeFeld.requestFocus();
	}
	
	private void menu() {
		JMenuBar menue = new JMenuBar();
		JMenu dateiMenue = new JMenu("Datei");
		// das Menü Hilfe (Teilaufgabe 1)
		JMenu hilfeMenue = new JMenu("Hilfe");
		
		JMenu dateiOeffnen = new JMenu("öffnen");
		dateiOeffnen.add(oeffnenAct);
		dateiOeffnen.add(webOeffnenAct);
		
		dateiMenue.add(neuAct);
		dateiMenue.add(dateiOeffnen);
		
		dateiMenue.add(speichernAct);
		dateiMenue.add(speichernUnterAct);
		
		dateiMenue.addSeparator();
		dateiMenue.add(druckenAct);
		
		dateiMenue.addSeparator();
		dateiMenue.add(beendenAct);
		
		menue.add(dateiMenue);
		
		// die Info Aktion und Hilfe Menü hinzufügen (Teilaufgabe 1)
		hilfeMenue.add(infoAct);
		menue.add(hilfeMenue);
		
		this.setJMenuBar(menue);
	}
	
	private JToolBar symbolleiste() {
		JToolBar leiste = new JToolBar();

		leiste.add(neuAct);
		leiste.add(oeffnenAct);
		leiste.add(webOeffnenAct);
		leiste.add(speichernAct);
		leiste.add(druckenAct);
		// das Info Symbol info(Teilaufgabe 1)
		leiste.add(infoAct);

		leiste.addSeparator();

		//Aktionen kopieren zur Leiste hinzufügen (Teilaufgabe 2)
		Action kopierAction = new DefaultEditorKit.CopyAction();
		kopierAction.putValue(Action.SHORT_DESCRIPTION, "Text kopieren");
		kopierAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/copy24.gif"));
		leiste.add(kopierAction);

		//Aktionen ausschneiden zur Leiste hinzufügen (Teilaufgabe 2)
		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.SHORT_DESCRIPTION, "Text ausschneiden");
		cutAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/cut24.gif"));
		leiste.add(cutAction);

		//Aktionen einfügen zur Leiste hinzufügen (Teilaufgabe 2)
		Action einfuegenAction = new DefaultEditorKit.PasteAction();
		einfuegenAction.putValue(Action.SHORT_DESCRIPTION, "Text einfügen");
		einfuegenAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/paste24.gif"));
		leiste.add(einfuegenAction);
		
		leiste.addSeparator();
		Action fettFormat = new StyledEditorKit.BoldAction();
		fettFormat.putValue(Action.SHORT_DESCRIPTION, "Fett formatieren");
		fettFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/bold24.gif"));
		leiste.add(fettFormat);
		
		Action kursivFormat = new StyledEditorKit.ItalicAction();
		kursivFormat.putValue(Action.SHORT_DESCRIPTION, "Kursiv formatieren");
		kursivFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/italic24.gif"));
		leiste.add(kursivFormat);
		
		Action unterstrichenFormat = new StyledEditorKit.UnderlineAction();
		unterstrichenFormat.putValue(Action.SHORT_DESCRIPTION, "Unterstrichen formatieren");
		unterstrichenFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/underline24.gif"));
		leiste.add(unterstrichenFormat);
		
		leiste.addSeparator();
		
		Action linksAbsatz = new StyledEditorKit.AlignmentAction("Linksbündig", StyleConstants.ALIGN_LEFT);
		linksAbsatz.putValue(Action.SHORT_DESCRIPTION, "Linksbündig ausrichten");
		linksAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignLeft24.gif"));
		leiste.add(linksAbsatz);

		Action zentriertAbsatz = new StyledEditorKit.AlignmentAction("Zentriert", StyleConstants.ALIGN_CENTER);
		zentriertAbsatz.putValue(Action.SHORT_DESCRIPTION, "Zentriert ausrichten");
		zentriertAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignCenter24.gif"));
		leiste.add(zentriertAbsatz);

		Action rechtsAbsatz = new StyledEditorKit.AlignmentAction("Rechts", StyleConstants.ALIGN_RIGHT);
		rechtsAbsatz.putValue(Action.SHORT_DESCRIPTION, "Rechtsbündig ausrichten");
		rechtsAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignRight24.gif"));
		leiste.add(rechtsAbsatz);
		
		Action blockAbsatz = new StyledEditorKit.AlignmentAction("Blocksatz", StyleConstants.ALIGN_JUSTIFIED);
		blockAbsatz.putValue(Action.SHORT_DESCRIPTION, "Im Blocksatz ausrichten");
		blockAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignJustify24.gif"));
		leiste.add(blockAbsatz); 
		
		return (leiste);
	}
	
	private void kontextMenu() {
		kontext = new JPopupMenu();
		kontext.add(neuAct);
		kontext.add(oeffnenAct);
		kontext.add(webOeffnenAct);
	}

	private void dateiNeu() {
		if(JOptionPane.showConfirmDialog(this, "Wollen Sie wirklich ein neues Dokument anlegen?","Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			eingabeFeld.setText("");
			datei = null;
			// den Titel ändern (Teilaufgabe 3)
			addToTitle(null);
		}
	}

	private void dateiLaden() {
		MiniTextDialoge dialog = new MiniTextDialoge();
		
		File dateiLokal = dialog.oeffnenDialogZeigen();
		
		if (dateiLokal != null) {
			try {
				eingabeFeld.read(new FileReader(dateiLokal), null);
				datei = dateiLokal;
				// den Titel ändern (Teilaufgabe 3)
				addToTitle(dateiLokal.getAbsolutePath());
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Beim Laden hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void dateiSpeichern() {
		if (datei == null) {
			MiniTextDialoge dialog = new MiniTextDialoge();
			datei = dialog.speichernDialogZeigen();
		}
		if (datei != null) {
			try {
				OutputStream output = new FileOutputStream(datei);
				htmlFormat.write(output, eingabeFeld.getDocument(), 0, eingabeFeld.getDocument().getLength());
				// den Titel ändern (Teilaufgabe 3)
				addToTitle(datei.getAbsolutePath());
			}
			catch (IOException | BadLocationException e) {
				JOptionPane.showMessageDialog(this, "Beim Speichern hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void dateiSpeichernUnter() {
		MiniTextDialoge dialog = new MiniTextDialoge();
		File dateiLokal = dialog.speichernDialogZeigen();
		if (dateiLokal != null) {
			datei = dateiLokal;
			dateiSpeichern();
		}
	}
	
	
	private void beenden() {
		if(JOptionPane.showConfirmDialog(this, "Sind Sie sicher?","Anwendung schließen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	private void drucken(boolean dialogZeigen) {
		try {
			if (dialogZeigen == true)
				eingabeFeld.print();
			else
				eingabeFeld.print(null, null, false, null, null, true);
			}
		catch (PrinterException e) {
			JOptionPane.showMessageDialog(this, "Beim Drucken hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void webLaden() {
		String adresse;
		adresse = JOptionPane.showInputDialog(this, "Bitte geben Sie die URL der Seite ein:");
		if (adresse != null) {
			eingabeFeld.setText("");
			try {
				eingabeFeld.setPage(adresse);
				datei = null;
				// den Titel ändern (Teilaufgabe 3)
				addToTitle(adresse);
			} 
			catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Beim Laden ist ein Problem aufgetreten.");
				// zu Teilaufgabe 3: Bug / "Feature":  
				//	- beim fehlgeschlagenen Laden einer Webseite wird der Text gelöscht, aber die hinterlegte datei bleibt, daher wird der Titel hier nicht geändert, da die Datei noch "geöffnet ist" obwohl der Text gelöscht wurde.
			}
		}
	}
	
	/**
	 * Zeigt Informationen zum Programm an ohne Rückgabewert.
	 * (Teilaufgabe 1)
	 */
	private void info() {
		JOptionPane.showMessageDialog(this,  "MiniText Version 5.0.\nProgrammiert von Nicolas Pusch et al. 2024.");
	}
	
	/**
	 * ändert den Titel der Textverarbeitung. Ohne Rückgabewert
	 * (Teilaufgabe 3)
	 * @param addition Pfad oder URL des geöffneten Odkuments als Text, der hinter den Titel angehängt werden soll. Kann null sein 
	 */
	private void addToTitle(String addition) {
		// neuer Titel des Programms (Teilaufgabe 3)
		String newTitle = "MiniText";
		if (addition == null) {
			newTitle += " - ohneName";
		} else {
			newTitle += " - " + addition;
		}
		
		this.setTitle(newTitle);
	}
	
}

