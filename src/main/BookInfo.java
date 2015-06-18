package main;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;





@SuppressWarnings("serial")

/** Classe per la creazione del pannello di informazione libro.
 *  Gestisce l'inserimento del prestito e visualizza informazioni
 *  e copertina del libro 
**/
public class BookInfo extends JPanel implements ActionListener  {

	private JButton btnLend;
	private Book b = new Book();

	/** Costruttore per il layout della schermata **/
	protected BookInfo(Integer id) {

		this.setLayout(new BorderLayout(30,30));

		Book b = getInfo(id);

		JLabel title=new JLabel(b.getTitle(),JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(4,1));

		JLabel lIsbn = new JLabel(" ISBN: "+b.getAsin());
		JLabel lAuthor = new JLabel(" Autore: "+b.getAuthor());
		JLabel lPublisher = new JLabel(" Editore: "+b.getPublisher());
		JLabel lNumpages = new JLabel(" Pagine: "+b.getNumpages());

		grid.add(lIsbn);
		grid.add(lAuthor);
		grid.add(lPublisher);
		grid.add(lNumpages);

		this.add(grid,BorderLayout.CENTER);

		/* Gestione copertina del libro */

		ImageIcon image = createImageIcon(b.getImage());
		JLabel img = new JLabel("", image, JLabel.CENTER);

		JPanel east = new JPanel(new GridLayout(1,2));
		east.add(Box.createGlue());
		east.add(img);

		this.add(east,BorderLayout.WEST);

		/* Bottone per il prestito del libro */		
		JPanel foot = new JPanel();
		btnLend = new JButton("Prestito");
		btnLend.addActionListener(this);
		foot.add(btnLend);
		foot.add(Box.createGlue());
		this.add(foot,BorderLayout.SOUTH);

	}

	/** Metodo per il reperimento delle informazioni sul singolo libro **/
	private Book getInfo(Integer id) {

		/* Query al database */
		ResultSet rs;
		rs = Database.Query("SELECT * FROM book WHERE id = '"+id+"'",Database.getConn(),false);
		try {
			rs.next();
			b.setId(id);
			b.setAsin(rs.getString("isbn"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setImage(rs.getString("img"));
			b.setNumpages(rs.getString("numpages"));
			b.setPublisher(rs.getString("publisher"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* Mando in output l'oggetto libro generato */
		return b;

	}


	/** Metodo per la restituzione dell'oggetto immagine data l'url  **/
	private ImageIcon createImageIcon(String path) {

		java.net.URL imgURL = null;
		try {
			imgURL = new URL(path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ImageIcon icon =  new ImageIcon(imgURL);

		// ISTRUZIONI PER UN EVENTUALE RESIZE DELL'IMMAGINE
		//Image img = icon.getImage();
		//Image newimg = img.getScaledInstance( 100, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
		//icon = new ImageIcon( newimg );
		return icon;
	}

	/** Metodo per la gestione dell'inserimento prestiti **/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnLend) {
			User u = LoginPanel.getUser();
			/* Generazione data di ora e fine prestito */
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(now);
			c.add(Calendar.DATE, 30);  // data fine prestito = data attuale + 30 giorni

			ResultSet rs = Database.Query("SELECT * from lend WHERE returndate = '0000-00-00' AND id_book ='"+b.getId()+"'", Database.getConn(),true);

			try {
				if(Database.isEmpty(rs)) {
					
					// Creo un nuovo prestito
					Lend l = new Lend();
					l.setId_book(b.getId());
					l.setId_user(u.getId());
					l.setStartdate(sdf.format(now));
					l.setEnddate(sdf.format(c.getTime()));
					
					// Inserisco il prestito nel database con la funzione disponibile
					l.insertLend();
				} else {
					JLabel msg= new JLabel("Libro non disponibile");
					JOptionPane.showMessageDialog(null,msg,"Errore",JOptionPane.ERROR_MESSAGE); 
				}
			} catch (SQLException e1) { }

		}


	}


}
