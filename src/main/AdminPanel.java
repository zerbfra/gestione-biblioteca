package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")


/** Classe per la gestione del pannello di amministrazione, è il pannello principale
 *  che contiene sia la menubar per le varie funzioni che il pannello content adibito 
 *  all'inserimento dinamico delle varie schermate.
 *  Richiamando una funzione specifica dalla menubar, viene eliminato il contenuto 
 *  presente nel pannello content e viene aggiornato con il nuovo contenuto.
 */
public class AdminPanel extends JPanel implements ActionListener {


	/* Imposto la menubar */
	private JMenuBar b = new JMenuBar();

	/* Dichiaro i menu principali */
	private JMenu utenti = new JMenu("Gestione Utenti");
	private JMenu libri = new JMenu("Gestione Libri");
	private JMenu prestiti = new JMenu("Gestione Prestiti");

	/* Dichiaro i sottomenu, in ordine di menu */

	private JMenuItem nutente = new JMenuItem("Nuovo Utente");
	private JMenuItem eutenti = new JMenuItem("Elenco Utenti");
	private JMenuItem cutenti = new JMenuItem("Cerca Utente");

	private JMenuItem nlibro = new JMenuItem("Inserisci Libro");
	private JMenuItem llibro = new JMenuItem("Elenco Libri");
	private JMenuItem clibro = new JMenuItem("Cerca libro");

	private JMenuItem vplibro = new JMenuItem("Per Libro");
	private JMenuItem vputente = new JMenuItem("Per Utente");

	private JPanel content = new JPanel();

	private JLabel welcome = new JLabel("<html><b>Benvenuto amministratore</b><br>" +
			"Sei nel pannello di amministrazione, seleziona una delle voci dal menu");

	/**Costruttore del pannello di amministratore, aggiunge la menubar e un JPanel per i contenuti **/
	public AdminPanel() {
		
		

		super();
		BorderLayout layout = new BorderLayout();
		layout.setVgap(20);
		setLayout(layout);

		/* 1 menu */
		b.add(utenti);
		utenti.add(nutente);
		utenti.add(eutenti);
		utenti.add(cutenti);

		/* 2 menu */
		b.add(libri);
		libri.add(nlibro);
		libri.add(llibro);
		libri.add(clibro);
			
		
		/* 3 menu */
		b.add(prestiti);
		prestiti.add(vplibro);
		prestiti.add(vputente);

		/* Inserisco gli actionListener */

		nutente.addActionListener(this);
		eutenti.addActionListener(this);
		cutenti.addActionListener(this);

		nlibro.addActionListener(this);
		llibro.addActionListener(this);
		clibro.addActionListener(this);

		vplibro.addActionListener(this);
		vputente.addActionListener(this);

		/* Aggiungo barra e contenuto al pannello principale */
		add(b, BorderLayout.NORTH);

		/* Immagine del pannello */
		ImageIcon image = new ImageIcon("image/admin.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		
		content.add(img);
		content.add(welcome);

		this.add(content,BorderLayout.CENTER);

	}

	/** Ascoltatore degli eventi sulla barra del pannello di amministrazione **/
	public void actionPerformed(ActionEvent e) {
		

		/* Procedura per inserimento nuovo utente */
		if(e.getSource() == this.nutente) {
			content.removeAll();
			content.add(new NewUser());
			this.updateUI();
		}
		/* Mostra la lista utenti */
		if(e.getSource() == this.eutenti) {
			content.removeAll();
			content.add(new UserList());
			this.updateUI();
		}
		/* Inserimento nuovo libro */
		if(e.getSource() == this.nlibro) {
			content.removeAll();
			content.add(new NewBook());
			this.updateUI();
		}
		/* Mostra lista libri*/
		if(e.getSource() == this.llibro) {
			content.removeAll();
			content.add(new BookList());
			this.updateUI();
		}
		/* Ricerca di un libro */
		if(e.getSource() == this.clibro) {
			content.removeAll();
			content.add(new FindBook());
			this.updateUI();
		}
		/* Ricerca utenti */
		if(e.getSource() == this.cutenti) {
			content.removeAll();
			content.add(new FindUser());
			this.updateUI();
		}
		/* Visualizza prestiti per libro */
		if(e.getSource() == this.vplibro) {
			content.removeAll();
			content.add(new FindBookLend());
			this.updateUI();
		}
		/* Prestiti per utente */
		if(e.getSource() == this.vputente) {
			content.removeAll();
			content.add(new FindUserLend());
			this.updateUI();
		}

	}

}
