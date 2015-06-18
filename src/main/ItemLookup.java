/**********************************************************************************************
 *
 *  Amazon Product Advertising API
 *  Signed Requests Sample Code
 *
 *  API Version: 2009-03-31
 *  Modificata da Zerbinati Francesco
 *
 */

package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/** Classe derivante dalle API di Amazon, reperisce il libro, collegandosi ai server Amazon **/
public class ItemLookup {
	
	
	/* Your AWS Access Key ID, as taken from the AWS Your Account page. */
	private static final String AWS_ACCESS_KEY_ID = "AKIAIKT6Z5BWQTPWUGOQ";

	/* Your AWS Secret Key corresponding to the above ID, as taken from the AWS Your Account page. */
	private static final String AWS_SECRET_KEY = "BqhPzBBl83zd4w2LEC1oTW4DoxFKp9v017T0pH+u";

	/*
	 * Use one of the following end-points, according to the region you are
	 * interested in:
	 * 
	 *      US: ecs.amazonaws.com 
	 *      CA: ecs.amazonaws.ca 
	 *      UK: ecs.amazonaws.co.uk 
	 *      DE: ecs.amazonaws.de 
	 *      FR: ecs.amazonaws.fr 
	 *      JP: ecs.amazonaws.jp
	 *      IT: webservices.amazon.it
	 * 
	 */
	
	private static final String ENDPOINT = "webservices.amazon.it";

	
	@SuppressWarnings("unused")
	/** Metodo per recuperare un libro dato una keyword o un insieme di keyword sottoforma di stringa.
	 *  Integer page esprime il numero di pagina della ricerca corrispondente sul sito Amazon.
	 *  INUTILIZZATO
	 */
	private static ArrayList<Book> fetchBooks(String keyword,Integer page) {

		
		SignedRequestsHelper helper = null;
	
		try {
			helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Book> books = new ArrayList<Book>();
		String requestUrl = null;

		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", "AWSECommerceService");
		params.put("Operation", "ItemSearch");
		params.put("Version", "2011-08-01");
		params.put("SearchIndex", "Books");
		params.put("Keywords", keyword); 
		// Ulteriore parametro x eseguire ricerca limitata per autore: params.put("Author", "isaacson");
		params.put("ItemPage", page.toString());	
		params.put("AssociateTag", "books0c56-20");
		params.put("ResponseGroup", "Images,Medium,EditorialReview");	
		requestUrl = helper.sign(params);
		

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			doc.getDocumentElement().normalize();				
			
			NodeList asinNode = doc.getElementsByTagName("EAN");  // EAN : ISBN-13, ISBN: ISBN-10
			NodeList titleNode = doc.getElementsByTagName("Title");
			NodeList imageNode = doc.getElementsByTagName("LargeImage");
			NodeList authorNode = doc.getElementsByTagName("ItemAttributes");
			NodeList publisherNode = doc.getElementsByTagName("Manufacturer");
			NodeList urlNode = doc.getElementsByTagName("DetailPageURL");
			NodeList pagesNode = doc.getElementsByTagName("NumberOfPages");
			
		
			/* DISPONIBILE SOLO SU SERVER AMERICANO!
			 * Questo nodo restituirebbe il riassunto del libro, su server italiano è coperta da copyright e non viene fornita.
			 * NodeList descNode = doc.getElementsByTagName("Content");
			 */

			for(int i = 0; i < asinNode.getLength(); i++) {
				
				String numpages = "";
				String asin = "";
				String title = "";
				String image = "";
				String author = "";
				String publisher = "";
				String url = "";
				
				if(asinNode.item(i) != null ) asin=asinNode.item(i).getTextContent();
				if(titleNode.item(i) != null ) title=titleNode.item(i).getTextContent();
				if(imageNode.item(i) != null ) image=imageNode.item(i).getFirstChild().getTextContent();
				if(authorNode.item(i) != null ) author=authorNode.item(i).getFirstChild().getTextContent();
				if(publisherNode.item(i) != null ) publisher=publisherNode.item(i).getTextContent();
				if(pagesNode.item(i) != null ) numpages = pagesNode.item(i).getFirstChild().getTextContent();
				
				if(urlNode.item(i) != null ) url=urlNode.item(i).getTextContent(); // url amazon 

				/* DISPONIBILE SOLO SU SERVER AMERICANO!
				 * Idem come sopra.
				 * 
				 * String desc=descNode.item(i).getLastChild().getTextContent();
				 * System.out.println(desc);
				 */
				
				/* Creo l'elemento libro con i contenuti recuperati */
				Book b = new Book(asin,title,author,publisher,numpages,image);
				books.add(b);			
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	/** Metodo per la ricerca di un libro dato un ISBN, utilizzata dalla classe NewBook per inserire i libri **/
	public static Book findBook(String asin) {
		
		/* Creo un oggetto SignedRequestHelper proveniente dalle API Amazon */
		SignedRequestsHelper helper = null;
		try {
			/* Inserisco i dati in helper */
			helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		/* Creo un istanza di libro dato l'isbn fornito */
		Book b = new Book(asin);
		
		String requestUrl = null;
		
		/* Creo l'hashmap per la ricerca, in questo modo fornisco la richiesta e formulo l'url da passare al server amazon */
		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", "AWSECommerceService");
		params.put("Operation", "ItemLookup");
		params.put("Version", "2011-08-01");
		params.put("ItemId", asin);
		params.put("IdType", "EAN");
		params.put("SearchIndex", "Books");
		params.put("AssociateTag", "books0c56-20");
		params.put("ResponseGroup", "Images,Medium,EditorialReview");
		
		/* Chiamo il server, requestUrl diventa un url con all'interno i parametri per la ricerca */
		requestUrl = helper.sign(params);
	
		//System.out.println(requestUrl);


		try {
			/* Genero il documento XML proveniente dall'url requestUrl */
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			doc.getDocumentElement().normalize();

			/* Ricerco i dati nell'XML */
			NodeList titleNode = doc.getElementsByTagName("Title");
			NodeList imageNode = doc.getElementsByTagName("MediumImage");
			NodeList authorNode = doc.getElementsByTagName("ItemAttributes");
			NodeList publisherNode = doc.getElementsByTagName("Manufacturer");
			NodeList pagesNode = doc.getElementsByTagName("NumberOfPages");
			NodeList urlNode = doc.getElementsByTagName("DetailPageURL");
			
			/* Inizializzo a contenuto nullo le variabili per non avere problemi successivi se
			 * non dovessi trovare nel documento XML le voci specificate.
			 */
			String numpages = "";
			String title = "";
			String image = "";
			String author = "";
			String publisher = "";
			String url = "";
				
			/* Se non trovo il libro corrispondente all'ISBN indicato restituisco un libro di titolo "Non trovato" */
			if(titleNode.item(0) != null ) title=titleNode.item(0).getTextContent();
			else title="Non trovato";
			
			/* Controllo che non siano nulli i valori dell'XML e successivamente li inserisco nelle variabili rispettive */
			if(imageNode.item(0) != null ) image=imageNode.item(0).getFirstChild().getTextContent();
			if(authorNode.item(0) != null ) author=authorNode.item(0).getFirstChild().getTextContent();
			if(publisherNode.item(0) != null ) publisher=publisherNode.item(0).getTextContent();
			if(pagesNode.item(0) != null ) numpages = pagesNode.item(0).getFirstChild().getTextContent();
			if(urlNode.item(0) != null ) url=urlNode.item(0).getTextContent(); // url amazon 
			
			/* Inserisco le variabili nell'oggetto book istanziato */
			b.setTitle(title);
			b.setAuthor(author);
			b.setPublisher(publisher);
			b.setImage(image);
			b.setNumpages(numpages);
			b.setUrl(url);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return b;

	}


}
