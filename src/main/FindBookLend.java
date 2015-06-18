package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




@SuppressWarnings("serial")

/** Classe per il pannello di ricerca prestiti secondo libro.
 *  Si occupa solamente del layout e dell'inserimento dati, non effettua la query di ricerca
 **/
public class FindBookLend extends JPanel implements ActionListener {

	
	/* Inizializzo variabili bottone, campi di testo e etichette */
	private JButton btnFind;
	private JTextField isbn,booktitle;
	private JLabel txtIsbn, txtBooktitle,txtO;
	
	/** Costruttore per il layout **/
	protected FindBookLend() {
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Trova libro in prestito",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,2));
		
		isbn = new JTextField(20);
		booktitle = new JTextField(20);
		
		txtIsbn = new JLabel("ISBN:");
		txtO = new JLabel("- o -");
		txtBooktitle = new JLabel("Titolo:");
		
		btnFind = new JButton("Cerca...");
		btnFind.addActionListener(this);
		
		grid.add(txtIsbn);
		grid.add(isbn);
		grid.add(txtO);
		grid.add(Box.createGlue());
		grid.add(txtBooktitle);
		grid.add(booktitle);

		this.add(grid,BorderLayout.CENTER);
		
		ImageIcon image = new ImageIcon("image/prestito.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);
		this.add(img,BorderLayout.EAST);
		
	
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnFind);
		this.add(foot,BorderLayout.SOUTH);
		
	}
	
	/** Metodo per le azioni **/
	public void actionPerformed(ActionEvent e) {		
		
		if (e.getSource() == btnFind) {
			/* Pressione pulsante di ricerca */
			
			/* Ricerco cosa ha compilato l'utente, e opto per le varie scelte possibili */
			if (isbn.getText().equals("") && booktitle.getText().equals("")) 
			{
				/* Nessun campo compilato */
				JLabel msg= new JLabel("Inserire ISBN o nome del libro per ricercarlo");
				JOptionPane.showMessageDialog(null,msg); 
				
			} else if (isbn.getText().equals("")) {
				/* Compilato solo il titolo del libro */
				Window.openFind("booklend",booktitle.getText());
			} else if (booktitle.getText().equals("")) {
				/* Compilato solo l'isbn del libro */
				Window.openFind("booklend",isbn.getText());
			} else Window.openFind("booklend",isbn.getText());  /* Entrambi compilati, adotto l'isbn */
		}
	}
	
}
