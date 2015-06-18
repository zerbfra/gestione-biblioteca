package main;

import java.awt.*;
import java.sql.*;
import javax.swing.*;




@SuppressWarnings("serial")

/** Classe per la visualizzazione delle informazioni di un utente **/
public class UserInfo extends JPanel  {

	/** Costruttore per il layout della schermata **/
	public UserInfo(Integer id) {
		
		this.setLayout(new BorderLayout(30,30));

		User u = getInfo(id);
		
		JLabel title=new JLabel(u.getNome()+" "+u.getCognome(),JLabel.CENTER);
		title.setFont(new Font("", Font.BOLD, 14));
		this.add(title,BorderLayout.NORTH);
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(7,1));
		
		JLabel lCf = new JLabel(" Codice fiscale: "+u.getCf());
		JLabel lTel = new JLabel(" Telefono: "+u.getTel());
		JLabel lInd = new JLabel(" Indirizzo: "+u.getIndirizzo());
		JLabel lMail = new JLabel(" Email: "+u.getMail());
		JLabel lUser = new JLabel(" Nome utente: "+u.getUser());
		JLabel lPwd = new JLabel(" Password: "+u.getPwd());

		grid.add(lCf);
		grid.add(lInd);
		grid.add(lTel);
		grid.add(lMail);
		grid.add(lUser);
		grid.add(lPwd);
		
		this.add(grid,BorderLayout.CENTER);
		
		JPanel foot = new JPanel();
		foot.add(Box.createGlue());
		this.add(foot,BorderLayout.SOUTH);
		
	}
	
	/** Restituisce tutte le informazioni su un utente **/
	private User getInfo(Integer id) {

		ResultSet rs;
		User u = new User();
		rs = Database.Query("SELECT * FROM user WHERE id = '"+id+"'",Database.getConn(),false);
		try {
			rs.next();
			
			u.setCf(rs.getString("cf"));
			u.setNome(rs.getString("nome"));
			u.setCognome(rs.getString("cognome"));
			u.setTel(rs.getString("tel"));
			u.setIndirizzo(rs.getString("indirizzo"));
			u.setMail(rs.getString("mail"));
			u.setUser(rs.getString("user"));
			u.setPwd(rs.getString("pwd"));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
}
