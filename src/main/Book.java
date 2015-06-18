package main;

/** Classe per la gestione dei libri, contiene le proprietà del libro e alcuni costruttori **/
public class Book {
	
	private int id;
	private String asin,title, author, publisher, numpages, image,url;

	/** Costruttore di un nuovo libro senza dati **/
	public Book() { }

	/** Costruttore libro dato il solo ISBN **/
	public Book(String asin) {	
		this.asin=asin;
	}

	/** Costruttore del libro dati isbn,titolo,autore,editore,numero pagine,immagine **/
	public Book(String asin,String title, String author, String publisher, String numpages,String image) {		
		this.asin=asin;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.numpages=numpages;
		this.image=image;

	}

	/** Costruttore del libro dati isbn,titolo,autore,editore,numero pagine,immagine,url amazon **/
	public Book(String asin,String title, String author, String publisher, String numpages,String image, String url) {
		this.asin=asin;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.numpages=numpages;
		this.image=image;
		this.url= url;

	}

	/** Funzione per la visualizzazione di un libro in console (solo debug) **/
	public String toString() {
		
		String pub="ASIN:\t\t"+asin+"\n";
		pub+= "Titolo:\t\t"+title+"\n";
		pub+="Autore:\t\t"+author+"\n";
		pub+="Editore:\t"+publisher+"\n";
		pub+="Pagine:\t\t"+numpages+"\n";
		pub+="Immagine:\t"+image+"\n";
		return pub;

	}

	/** Restituisce l'id nel database del libro, id è un autoincrement mysql **/
	public int getId() {
		return id;
	}
	
	/** Restituisce l'id del libro **/
	public void setId(int id) {	
		this.id=id;
	}

	/** Restituisce ISBN libro **/
	public String getAsin() {
		return asin;
	}

	/** Setta l'ISBN di un libro **/
	public void setAsin(String asin) {
		this.asin = asin;
	}

	/** Restituisce il titolo del libro **/
	public String getTitle() {
		return title;
	}

	/** Inserisce titolo del libro **/
	public void setTitle(String title) {
		this.title = title;
	}

	/** Restituisce autore del libro **/
	public String getAuthor() {	
		return author;
	}

	/** Inserisce autore del libro **/
	public void setAuthor(String author) {
		this.author = author;
	}

	/** Restituisce l'editore del libro **/
	public String getPublisher() {
		return publisher;
	}

	/** Setta l'editore del libro **/
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/** Ritorna la stringa dell'url dell'immagine presente su Amazon **/
	public String getImage() {
		return image;
	}

	/** Setta l'url dell'imagine del libro **/
	public void setImage(String image) {
		this.image = image;
	}

	/** Ritorna il numero di pagine del libro **/
	public String getNumpages() {
		return numpages;
	}

	/** Setta il numero di pagine **/
	public void setNumpages(String numpages) {
		this.numpages = numpages;
	}

	/** Restituisce l'url del libro su Amazon **/
	public String getUrl() {
		return url;
	}
	
	/** Setta l'url del libro su Amazon **/
	public void setUrl(String url) {
		this.url = url;
	}

}
