package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;





@SuppressWarnings("serial")

/** Classe che implementa il pannello di visualizzazione in modalitˆ utente.
 *  Vi si accede tramite user e password dal pannello di login 
 **/
public class UserPanel extends JPanel implements ActionListener {
	
	private JMenuBar b = new JMenuBar();
	private JMenu catalogo = new JMenu("Catalogo");

	private JMenuItem sfoglia = new JMenuItem("Sfoglia catalogo");
	private JMenuItem cerca = new JMenuItem("Cerca nel catalogo");

	private JMenu prestiti = new JMenu("Prestiti");

	private JMenuItem incorso = new JMenuItem("I tuoi prestiti");
	private JMenuItem restituisci = new JMenuItem("Restituisci libro");
	private JMenuItem cronologia = new JMenuItem("Cronologia");
	
	private JLabel welcome = new JLabel("<html><b>Benvenuto "+LoginPanel.getUser()+"</b><br>" +
			"Puoi selezionare una delle voci del menu!");
	
	private JPanel content = new JPanel();

	/** Costruttore che disegna l'interfaccia del pannello catalogo **/
	public UserPanel() {
		super();
		
		
		setLayout(new BorderLayout());

		b.add(catalogo);
		catalogo.add(sfoglia);
		catalogo.add(cerca);

		b.add(prestiti);
		prestiti.add(incorso);
		prestiti.add(restituisci);
		prestiti.add(cronologia);
		
		sfoglia.addActionListener(this);
		cerca.addActionListener(this);
		incorso.addActionListener(this);
		restituisci.addActionListener(this);
		cronologia.addActionListener(this);

		BorderLayout layout = new BorderLayout();
		layout.setVgap(20);
		setLayout(layout);
		
		add(b, BorderLayout.NORTH);
		
		ImageIcon image = new ImageIcon("image/user.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		
		content.add(img);
		content.add(welcome);

		this.add(content,BorderLayout.CENTER);

	}

	/** Ascoltatore degli eventi sulla barra del pannello utenti **/
	public void actionPerformed(ActionEvent e) {
		
		/* Sfoglia catalogo */
		if(e.getSource() == this.sfoglia) {
			content.removeAll();
			content.add(new BookIndex());
			this.updateUI();
		}
		
		/* Cerca libro */
		if(e.getSource() == this.cerca) {
			content.removeAll();
			content.add(new FindBook());
			this.updateUI();
		}
		
		/* Visualizza prestiti in corso */
		if(e.getSource() == this.incorso) {
			content.removeAll();
			content.add(new ShowLend());
			this.updateUI();
		}
		
		/* Visualizza pannello restituzioni */
		if(e.getSource() == this.restituisci) {
			content.removeAll();
			content.add(new ReturnBook());
			this.updateUI();
		}
		
		/* Cronologia prestiti effettuati */
		if(e.getSource() == this.cronologia) {
			content.removeAll();
			content.add(new History());
			this.updateUI();
		}

	}
}
