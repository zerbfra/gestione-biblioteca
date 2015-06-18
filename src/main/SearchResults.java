package main;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")

/** Classe che esegue le ricerche: apre un pannello con i risultati.
 *  Possono essere eseguiti più tipi di ricerca.
 */
public class SearchResults extends JPanel  {


	JTable table;
	JLabel title=new JLabel("Risultati Ricerca",JLabel.CENTER);

	/** Costruttore: si occupa di gestire il tipo di ricerca e smistarla al corretto metodo **/
	public SearchResults(String type,String data) {

		/* Ricerca di un utente */
		if(type.equals("user")) {
			SearchUser(data);
		}

		/* Ricerca di un prestito libro per libro*/
		if(type.equals("booklend")) {
			SearchBookLending(data);
		}

		/* Ricerca di un prestito libro per utente */
		if(type.equals("userlend")) {
			SearchUserLending(data);
		}

		/* Ricerca di un libro */
		if(type.equals("book")) {
			SearchBook(data);
		}

		this.setLayout(new BorderLayout(30,30));

		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		JPanel grid = new JPanel();
		grid.setLayout(new FlowLayout());

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(550,250));

		grid.add(scrollPane);

		this.add(grid,BorderLayout.CENTER);

		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		this.add(foot,BorderLayout.SOUTH);

	}

	/** Metodo per la ricerca di un utente */
	private void SearchUser(String data) {
		ResultSet rs;

		if(data.contains("@")) { //mail
			rs = Database.Query("SELECT * FROM user WHERE mail = '"+data+"'",Database.getConn(),false);
		} else {
			rs = Database.Query("SELECT * FROM user WHERE cf = '"+data+"'",Database.getConn(),false);
		}

		/* Creo il modello della tabella */
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Cognome");
		model.addColumn("Codice fiscale");
		model.addColumn("E-mail");
		model.addColumn("Telefono");
		model.addColumn("Indirizzo");

		/* Aggiungo i dati alla tabella */
		try {
			while (rs.next()) {	
				model.insertRow(model.getRowCount(), new Object[]{ rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getString("cf"), rs.getString("mail"), rs.getString("tel"), rs.getString("indirizzo") });
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(model);		
		table.getSelectionModel().addListSelectionListener(new TableListener(table,"user"));
	}

	/** Metodo per la ricerca di un prestito dato l'utente */
	private void SearchUserLending(String data) {

		ResultSet rs;
		rs = Database.Query("SELECT isbn,title,startdate,enddate,returndate FROM lending_view WHERE user = '"+data+"' AND returndate = '0000-00-00'",Database.getConn(),false);
		
		/* Modello per la JTable, a cui vengono aggiunte le varie colonne */
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ISBN");
		model.addColumn("Titolo");
		model.addColumn("Data Inizio");
		model.addColumn("Data Fine");
	
		/* Esecuzione query */
		try {
			while (rs.next()) {	
				model.insertRow(model.getRowCount(), new Object[]{ rs.getString("isbn"), rs.getString("title"), rs.getString("startdate"), rs.getString("enddate")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(model);
	}

	/** Cerca un prestito dato il libro **/
	private void SearchBookLending(String data) {

		/* Controllo se è un isbn vedendo se la stringa è di soli numeri */
		boolean isISBN = data.matches ("\\d+");
		ResultSet rs;

		if(isISBN) {
			/* La query restituisce un array di libri, vengono selezionati secondo clausola where */
			rs = Database.Query("SELECT isbn,title,user,startdate,enddate,returndate FROM lending_view WHERE isbn = '"+data+"' AND returndate = '0000-00-00'",Database.getConn(),false);
		} else {
			/* La query restituisce un array di libri, vengono selezionati secondo clausola where */
			rs = Database.Query("SELECT isbn,user,startdate,enddate,returndate,title FROM lending_view WHERE title LIKE '%"+data+"%' AND returndate = '0000-00-00'",Database.getConn(),false);
		}
		
		/* Modello per la JTable, a cui vengono aggiunte le varie colonne */
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ISBN");
		model.addColumn("Titolo");
		model.addColumn("Utente");
		model.addColumn("Data Inizio");
		model.addColumn("Data Fine");
		
		/* Inserisco i dati nella tabella */
		try {
			while (rs.next()) {	
				model.insertRow(model.getRowCount(), new Object[]{ rs.getString("isbn"), rs.getString("title"), rs.getString("user"), rs.getString("startdate"), rs.getString("enddate")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(model);	
	}

	/** Metodo per la ricerca di libri dato isbn o keyword */
	private void SearchBook(String data) {
		/* Controllo se isbn */
		boolean isISBN = data.matches ("\\d+");

		ResultSet rs;
		if(isISBN) {
			/* La query restituisce un array di libri, vengono selezionati secondo clausola where */
			rs = Database.Query("SELECT * FROM book WHERE isbn = '"+data+"'",Database.getConn(),false);

		} else {
			/* La query restituisce un array di libri, vengono selezionati secondo clausola where */
			rs = Database.Query("SELECT * FROM book WHERE title LIKE '%"+data+"%' OR author LIKE '%"+data+"%' OR publisher LIKE '%"+data+"%'",Database.getConn(),false);
		}

		/* Modello per la JTable, a cui vengono aggiunte le varie colonne */
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("ISBN");
		model.addColumn("Titolo");
		model.addColumn("Autore");
		model.addColumn("Editore");
		model.addColumn("Pag.");

		/* Inserisco i dati nella tabella */
		try {
			while (rs.next()) {	
				model.insertRow(model.getRowCount(), new Object[]{ rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("numpages") });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table = new JTable(model);
		/* Aggiungo il Listener, che fornisce ulteriori informazioni sul libro */
		table.getSelectionModel().addListSelectionListener(new TableListener(table,"book"));
	}

}
