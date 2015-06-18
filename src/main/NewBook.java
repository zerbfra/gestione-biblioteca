package main;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")

/** Classe del pannello per l'inserimento di un nuovo libro **/
public class NewBook extends JPanel implements ActionListener {

	private JTextField isbn,booktitle,author,numpages,publisher;
	private String imgSource, itemUrl;
	private JLabel txtIsbn, txtBooktitle, txtAuthor, txtNumpages,txtPublisher,cover;
	private JButton btnAdd,btnSrc;

	private JPanel image = new JPanel();
	
	/** Costruttore della classe che inserisce gli elementi grafici **/
	public NewBook() {
		
		
		this.setLayout(new BorderLayout(30,30));
		
		JLabel title=new JLabel("Inserisci nuovo libro",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
			
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(7,2));
		
		isbn = new JTextField(40);
		booktitle = new JTextField(40);
		author = new JTextField(40);
		publisher = new JTextField(40);
		numpages = new JTextField(10);		
		
		txtIsbn = new JLabel("ISBN:");
		txtBooktitle = new JLabel("Titolo:");
		txtAuthor = new JLabel("Autore:");
		txtPublisher = new JLabel("Editore:");
		txtNumpages = new JLabel("Numero Pagine:");
		
		btnAdd = new JButton("Inserisci");
		btnSrc = new JButton("Importa dati...");
		
		grid.add(txtIsbn);
		grid.add(isbn);
		
		grid.add(Box.createGlue());
		
		grid.add(btnSrc);
		
		grid.add(Box.createGlue());
		grid.add(Box.createGlue());
		
		grid.add(txtBooktitle);
		grid.add(booktitle);
		
		grid.add(txtAuthor);
		grid.add(author);
		
		grid.add(txtPublisher);
		grid.add(publisher);
		
		grid.add(txtNumpages);
		grid.add(numpages);

		grid.setPreferredSize(new Dimension(500,200));
		image.setPreferredSize(new Dimension(300,200));
		this.add(grid,BorderLayout.CENTER);
		
		ImageIcon imag = new ImageIcon("image/add.png");
		JLabel img = new JLabel("", imag, JLabel.CENTER);
		image.add(img);
		
		this.add(image,BorderLayout.EAST);
		

		
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnAdd);
		this.add(foot,BorderLayout.SOUTH);
		
		btnSrc.addActionListener(this);
		btnAdd.addActionListener(this);
		
	}
	
	/** Metodo per la restituzione dell'oggetto immagine data l'url  **/
	protected ImageIcon createImageIcon(String path) {
		
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
	
	/** Metodo per gestire le azioni associate ai pulsanti:
	 *  btnSrc si occupa di recuperare le informazioni da Amazon, tramite isbn
	 *  btnAdd aggiunge l'oggetto libro al database sql
	 */
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.btnSrc) {
			
			Book b=ItemLookup.findBook(isbn.getText());
			booktitle.setText(b.getTitle());
			author.setText(b.getAuthor());
			numpages.setText(b.getNumpages());
			publisher.setText(b.getPublisher());
			
			/* Controllo di aver recuperato l'immagine */
			if(b.getImage() != "") {
				ImageIcon img = createImageIcon(b.getImage());
				imgSource = b.getImage();
				cover = new JLabel(img);
			}
			
			itemUrl = b.getUrl();
			image.removeAll();
			
			LineBorder line = new LineBorder(Color.black, 3, true);
			cover.setBorder(line);
			image.add(cover);
			this.updateUI();		
			
		}
		
		if(e.getSource() == this.btnAdd) {
			
			
			String tIsbn = isbn.getText();
			String tBooktitle = booktitle.getText();
			String tAuthor = author.getText();
			String tPublisher = publisher.getText();
			String tNumpages = numpages.getText();
			
			// Inserisco slash davanti agli apostrofi per evitare errori SQL
			tBooktitle = tBooktitle.replace("'", "\\\'");
			tAuthor = tAuthor.replace("'", "\\\'");
			
			/* Eseguo la query */

			Database.Query("INSERT INTO book (isbn, title, author, publisher, img, url, numpages) " +
					"VALUES ('"+tIsbn+"', '"+tBooktitle+"', '"+tAuthor+"', '"+tPublisher+"', '"+imgSource+"', '"+itemUrl+"' , '"+tNumpages+"')",Database.getConn(),false);

			
			/* Dopo l'inserimento rimuovo i dati precedenti, ora non più utili */
			image.remove(cover);
			isbn.setText("");
			booktitle.setText("");
			author.setText("");
			publisher.setText("");
			numpages.setText("");
			
			/* Aggiorno il pannello con le nuove informazioni vuote */
			this.updateUI();
			
		}
	
	}
	
}
