package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Lend {
	
	private int id;
	private int id_book;
	private int id_user;
	private String startdate,enddate,returndate;

	/** Costruttore vuoto **/
	public Lend() {	
	}
	
	
	/* Seguono getters e setters */
	
	/** Restituisce l'id del prestito **/
	public int getId() {
		return id;
	}

	/** Setta l'id del prestito **/
	public void setId(int id) {
		this.id = id;
	}

	/** Restituisce l'id del libro del prestito **/
	public int getId_book() {
		return id_book;
	}

	/** Setta l'id del libro del prestito **/
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	/** Restituisce l'id utente prestito **/
	public int getId_user() {
		return id_user;
	}

	/** Setta l'id dell'utente del prestito **/
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/** Restituisce la data inizio prestito **/
	public String getStartdate() {
		return startdate;
	}

	/** Setta la data di inizio prestito **/
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/** Restituisce data fine prestito **/
	public String getEnddate() {
		return enddate;
	}

	/** Setta la data di fine prestito **/
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/** Restitusce la data di ritorno effettivo **/
	public String getReturndate() {
		return returndate;
	}

	/** Setta la data di rientro effettiva **/
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	/** Inserisce un prestito nel database **/
	public void insertLend() {
		Database.Query("INSERT INTO lend (id_book,id_user,startdate,enddate) VALUES ('"+this.getId_book()+"', '"+this.getId_user()+"', '"+this.getStartdate()+"', '"+this.getEnddate()+"')",Database.getConn(),false);
	}
	
	/** Funzione per il rientro di un libro **/
	public void returnLend() {
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Database.Query("UPDATE lending_view  SET returndate = '"+dateFormatter.format(now)+"'  WHERE id_lend = '"+this.getId()+"'",Database.getConn(),true);
		
		
		JLabel msg1= new JLabel("<html>Libro numero: "+this.getId_book()+"<br>Preso il: "+this.getStartdate()+" restituito in data odierna</html>");
		JOptionPane.showMessageDialog(null,msg1); 
	}

}
