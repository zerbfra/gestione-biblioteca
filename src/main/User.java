package main;

/** Classe per la gestione degli utenti **/
public class User {
	
	
	int id;
	String cf,nome,cognome,tel,indirizzo,mail,user,pwd;
	Boolean admin;
	
	/** Costruttore vuoto **/
	public User() { }
	
	/** Costruttore dato il solo codice fiscale **/
	public User(String cf) {		
		this.cf=cf;
	}

	/** Costruzione di un oggetto utente NON ADMIN, non si specifica nemmeno il campo, è false di default **/		
	public User(String cf,String nome,String cognome,String tel,String indirizzo,String mail,String user,String pwd) {
		this.cf=cf;
		this.nome=nome;
		this.cognome=cognome;
		this.tel=tel;
		this.indirizzo=indirizzo;
		this.mail=mail;
		this.user=user;
		this.pwd=pwd;
		this.admin=false;
	}
	
	/** Costruzione di un utente amministratore, usato con Boolean admin true **/
	public User(String cf,String nome,String cognome,String tel,String indirizzo,String mail,String user,String pwd,Boolean admin) {
		this.cf=cf;
		this.nome=nome;
		this.cognome=cognome;
		this.tel=tel;
		this.indirizzo=indirizzo;
		this.mail=mail;
		this.user=user;
		this.pwd=pwd;
		this.admin=admin;
	}

	/* Seguono setters e getters */
	
	/** Ritorna id nel database dell'utente **/
	public int getId() {
		return id;
	}

	/** Setta l'id del database **/
	public void setId(int id) {
		this.id = id;
	}

	/** Ritorna codice fiscale **/
	public String getCf() {
		return cf;
	}

	/** Setta il codice fiscale **/
	public void setCf(String cf) {
		this.cf = cf;
	}

	/** Ritorna il nome **/
	public String getNome() {
		return nome;
	}

	/** Setta il nome **/
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Ritorna il cognome **/
	public String getCognome() {
		return cognome;
	}

	/** Setta il cognome **/
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/** Ritorna il telefono **/
	public String getTel() {
		return tel;
	}

	/** Setta il numero di telefono **/
	public void setTel(String tel) {
		this.tel = tel;
	}

	/** Ritorna indirizzo **/
	public String getIndirizzo() {
		return indirizzo;
	}

	/** Setta l'indirizzo dell'utente **/
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/** Ritorna l'indirizzo email **/
	public String getMail() {
		return mail;
	}

	/** Setta l'indirizzo email **/
	public void setMail(String mail) {
		this.mail = mail;
	}

	/** Ritorna il nome utente **/
	public String getUser() {
		return user;
	}

	/** Setta il nome utente **/
	public void setUser(String user) {
		this.user = user;
	}

	/** Ritorna la password **/
	public String getPwd() {
		return pwd;
	}

	/** Setta la password **/
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/** Ritorna true se l'utente è amministratore **/
	public Boolean getAdmin() {
		return admin;
	}

	/** Setta un utente come amministratore **/
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	/** Metodo toString solo per debug **/
	public String toString() {
		return this.getNome()+" "+this.getCognome();
	}

}
