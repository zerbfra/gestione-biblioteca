package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


@SuppressWarnings("serial")

/** Classe che gestisce il pannello per il login degli utenti/amministratori.
 *  Viene invocato da un JFrame separato, che viene poi nascosto al momento del login avvenuto.
 *  Se non vengono inseriti correttamente i dati lancia un messaggio di errore.
 */
public class LoginPanel extends JPanel  implements ActionListener {


	private JTextField user;
	private JPasswordField pwd;
	private JButton btnLogin;
	private JLabel txtUser,txtPwd;
	private int isAdmin; 
	static User logged = new User();

	/** Costruttore che costruisce il pannello **/ 
	public LoginPanel() {

		super();

		this.setLayout(new BorderLayout(30,30));

		JLabel title=new JLabel("<html><br>Inserisci le tue credenziali</html>",JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);

		JPanel grid = new JPanel();

		txtUser = new JLabel("Utente:");
		user = new JTextField(17);
		txtPwd  = new JLabel("Password:");
		pwd= new JPasswordField(17);

		/***** DEBUG *****/
		//user.setText("zerbinati.francesco");
		//pwd.setText("zoedog");
		/****************/


		btnLogin = new JButton("Entra");
		btnLogin.addActionListener(this);


		pwd.setActionCommand("set");
		pwd.addActionListener(this); // Login con invio

		grid.add(txtUser);
		grid.add(user);
		grid.add(txtPwd);
		grid.add(pwd);

		JLabel descr = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><b>" +
				"Benvenuto nel sistema di gestione bibliotecario</b><br>Per effettuare l'accesso devi inserire il tuo username e la tua password<br>" +
				"Se non disponi ancora delle credenziali di accesso devi rivolgerti in segreteria.<br>" +
				"Se sei un amministratore inserisci le tue credenziali.</html>");



		ImageIcon image = new ImageIcon("image/home.png");
		JLabel img = new JLabel("", image, JLabel.CENTER);


		grid.add(descr);
		this.add(img,BorderLayout.WEST);

		grid.add(Box.createGlue());
		this.add(grid,BorderLayout.CENTER);

		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		foot.add(btnLogin);
		this.add(foot,BorderLayout.SOUTH);

	}

	/** Funzione per segnalare gli eventuali errori **/
	private void updatePanel(Boolean succes) {

		JLabel msg= new JLabel("Login errato");
		if(!succes) {
			JOptionPane.showMessageDialog(null,msg,"Login",JOptionPane.ERROR_MESSAGE); 
			user.setText("");
			pwd.setText("");
		}
	}

	/** Metodo per abilitare il login premendo invio una volta nel campo password **/
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
			login();
		}
	}

	/** Gestisce l'azione del pulsante che invia il login **/
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		if (e.getSource() == btnLogin || cmd.equals("set")) {
			login();

		}
	}

	@SuppressWarnings("deprecation")
	/** Metodo che effettua il login **/
	private void login() {

		ResultSet rs;

		try {
			/* Eseguo una query specificando user e password */
			rs = Database.Query("SELECT * FROM user WHERE user = '"+user.getText()+"' AND pwd = '"+pwd.getText()+"'",Database.getConn(),true);

			if(!rs.next()) updatePanel(false);  /* In questo caso non avevo un utente con quello user e pwd */
			else {

				/* Creo utente */
				logged.setId(rs.getInt("id"));
				logged.setNome(rs.getString("nome"));
				logged.setCognome(rs.getString("cognome"));
				isAdmin = rs.getInt("admin");

				if(isAdmin == 1) {
					/* Scelgo, per un amministratore, se vuole entrare come utente o admin */

					Object[] options = {"Amministrazione","Catalogo"};
					int n = JOptionPane.showOptionDialog(null,
							"A che area vuoi accedere?",
							"Selezione pannello",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,    
							options,  
							options[0]); 


					if(n == JOptionPane.YES_OPTION)  Window.openAdminPanel();
					else Window.openUserPanel();

					user.setText("");
					pwd.setText("");
					updatePanel(true);
				} else if(isAdmin == 0) {
					/* Se l'utente non è amministratore va in automatico nel pannello di admin */
					Window.openUserPanel();
					user.setText("");
					pwd.setText("");
					updatePanel(true);
				}  
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}


	/** Ritorna l'utente che ha fatto il login **/
	public static User getUser() {
		return logged;
	}

}
