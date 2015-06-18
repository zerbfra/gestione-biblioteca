package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


@SuppressWarnings("serial")

/** Classe del pannello che mostra la lista dei libri presenti del database.
 *  Si avvale di una JTable che mostra i vari libri recuperati con una query SQL
 */
public class BookIndex extends JPanel implements KeyListener,ActionListener {

	JScrollPane scrollPane = new JScrollPane();
	JPanel index = null;
	
	JLabel label = new JLabel("Ricerca dinamica: ");
	JTextField letter = new JTextField(10);
	JButton btnView;


	/** Costruttore del pannello, si occupa di inserire i vari elementi e formulare la query al database **/
	public BookIndex() {
		
		/* Inserisco un layout BorderLayout */
		this.setLayout(new BorderLayout(30,30));

		/* Titolo del pannello */
		JLabel title=new JLabel("Catalogo dei libri",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));

		/* Aggiunto il listener per il campo di ricerca */
		letter.addKeyListener(this);
		 
		JPanel top = new JPanel(new GridLayout(3,1));
		
		top.add(title);
		top.add(label);
		top.add(letter);


		this.add(top,BorderLayout.NORTH);
		
		index = getBooks("");

		/* Aggiungo lo scroller alla tabella e ne assegno una dimensione di default */
		scrollPane.getViewport().add(index);
		scrollPane.setPreferredSize(new Dimension(800,415));


		this.add(scrollPane,BorderLayout.CENTER);

	}
	
	/** Reperisce i libri da inserire nel catalogo, invocato dalla ricerca dinamica **/
	private JPanel getBooks(String C) {

		JPanel grid = new JPanel();
		
		/* Eseguo la query */
		ResultSet rs = Database.Query("SELECT id, title, author, publisher, numpages, conta FROM book, (SELECT COUNT(*) conta FROM book WHERE SUBSTR(title,1,"+C.length()+") LIKE '"+C+"') contatore  WHERE SUBSTR(title,1,"+C.length()+") LIKE '"+C+"' ORDER BY title",Database.getConn(),true);
		
		int counter = 0 ; // utilizzo un contatore per impostare correttamente il layout


		try {
			if(Database.isEmpty(rs)) {
				return grid;
			}
			rs.next();
			counter = rs.getInt("conta");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/* Imposta il gridlayout in base ai contenuti reperiti */
		GridLayout g;
		if(counter > 6) g = new GridLayout(counter,1);
		else g= new GridLayout(6,1);
		
		g.setVgap(5);
		grid.setLayout(g);
		

		try {
			do {	
				
				JPanel element = new JPanel();
				BorderLayout list = new BorderLayout();
				list.setHgap(25);
				element.setLayout(list);
				element.setPreferredSize(new Dimension(700,65)); // per non far scomparire lo scroller, motivi estetici
				btnView = new JButton("Visualizza Scheda");
				btnView.addActionListener(this);
				btnView.setActionCommand(rs.getString("id"));
				
				/* Accorcia il titolo del libro in base alla sua lunghezza */
				String truncTitle = rs.getString("title");
				if(truncTitle.length() > 80) truncTitle = truncTitle.substring(0,80)+"...";

				/* Label che descrive il libro nell'elenco */
				JLabel book = new JLabel("<html><b>"+truncTitle+"</b><br>Autore: "+rs.getString("author")+"<br>Editore: "+rs.getString("publisher")+"<br>Pagine: "+rs.getString("numpages"));
				
				element.add(book,BorderLayout.CENTER);
				element.add(btnView,BorderLayout.EAST);
				element.setBackground(Color.white);
				
				grid.add(element);

			} while (rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return grid;
	}

	@Override
	public void keyTyped(KeyEvent e)  {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		/* Ricerca dinamica: ad ogni lettera inserita eseguo una query e aggiorno il pannello con i libri che corrispondono */
		if(e.getKeyChar()!=KeyEvent.VK_ENTER) {
			index = getBooks(letter.getText());
			scrollPane.getViewport().add(index);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
			/* Reperisco l'id del libro e ne apro il pannello informazioni */
			Integer id = Integer.parseInt(e.getActionCommand());
			Window.openBookInfo(id);					
	}
}
