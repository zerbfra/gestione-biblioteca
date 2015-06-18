package main;

import java.awt.event.*;

import javax.swing.*;






@SuppressWarnings("serial")

/** Classe "principale" del programma, si occupa di gestire le varie finestre
 *  invocate via via dai metodi delle altre classi.
 *  Si occupa in primo luogo di istanziare la classe per l'apertura del pannello di login.
 *  In base al tipo di login effettuato apre poi le finestre di amministrazione o utente.
 *  NON si occupa della gestione dei pannelli che viene effettuata dalle singole classi, istanzia solo i JFrame.
 *  Crea la connessione al database e la passa ai vari pannelli (e loro funzioni)
 */
public class Window extends JFrame {

	private static Database db = new Database();
	 
	private static LoginPanel loginPanel = new LoginPanel();
	private static AdminPanel adminPanel;
	private static UserPanel userPanel;
	
	private static Window loginFrame= new Window();
	private static Window adminFrame;
	private static Window userFrame;

	/** Costruttore di default, apre la prima finestra (login) **/
	public Window() {
		super("Biblioteca");		
		setBounds(100,100,900,600);
		getContentPane().add(loginPanel);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		/* Listener per la chiusura della finestra -> chiude il programma e la connessione al db */
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {	

				int n = JOptionPane.showConfirmDialog(
						null,
						"Sicuro di voler uscire?",
						"Uscire?",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

				if(n == JOptionPane.YES_OPTION) {
					db.Close();
					System.exit(0);
				}
			}
		});
		
		
	}
	
	/** Costruttore dati parametri come dimensioni, nome JFrame, usato per tutte le finestre
	 *  eccetto quella di login.
	 */
	public Window(int x,int y, int w,int h, String panelName, JPanel panel,Boolean exit) {

		super(panelName);
		setBounds(x,y,w, h);
		/* Non posso uscire da queste finestre, mi devo ricondurre alla finestra di login */
		
		getContentPane().add(panel);

		if(exit) {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {			

					if(adminFrame != null) adminFrame.dispose();
					if(userFrame != null) userFrame.dispose();
						
					loginFrame.setVisible(true);
				}

			});
		}
		
	}
	
	/** Metodo main, avvia il costruttore della classe stessa, generando una finestra di login **/
	public static void main(String args[]) {
		loginFrame.setVisible(true);
	}
	
	

	/** Metodo per l'apertura della finestra di amministrazione **/
	public static void openAdminPanel() {	
		adminPanel = new AdminPanel();
		adminFrame = new Window(100,100,900,600,"Amministrazione",adminPanel,true);
		adminFrame.setVisible(true);
		loginFrame.dispose();
	}
	
	/** Metodo per l'apertura della finestra degli utenti **/
	public static void openUserPanel() {	
		
		userPanel = new UserPanel();
		userFrame = new Window(100,100,900,600,"Catalogo Biblioteca",userPanel,true);
		loginFrame.dispose();
		userFrame.setVisible(true);
		
	}
	
	/** Apre la finestra che mostra i risultati di ricerca, invocato dai pannelli di ricerca, 
	  * ricevo int type che esprime il TIPO di ricerca 
	 **/
	public static void openFind(String type, String data) {
		SearchResults searchResults = new SearchResults(type,data);
		Window searchFrame = new Window(1010,100,600,300,"Risultati",searchResults,false);
		searchFrame.setVisible(true);
		
	}
	
	/** Apre la finestra che mostra il dettaglio libro **/
	public static void openBookInfo(Integer id) {
		BookInfo bookInfo = new BookInfo(id);
		Window bookInfoFrame = new Window(1010,100,500,300,"Informazioni Libro",bookInfo,false);
		bookInfoFrame.setVisible(true);
		
	}
	
	/** Apre la finestra che mostra il dettaglio utente **/
	public static void openUserInfo(Integer id) {
		UserInfo userInfo = new UserInfo(id);
		Window userInfoFrame = new Window(1010,100,300,300,"Informazioni Utente",userInfo,false);
		userInfoFrame.setVisible(true);
		
	}
	
	/** Apre la finestra che mostra il dettaglio prestito **/
	public static void openLendInfo(Integer id) {
		LendInfo lendInfo = new LendInfo(id);
		Window lendInfoFrame = new Window(1010,100,300,300,"Informazioni prestito",lendInfo,false);
		lendInfoFrame.setVisible(true);
		
	}

}
