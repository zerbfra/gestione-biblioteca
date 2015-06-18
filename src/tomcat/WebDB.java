package tomcat;


import java.sql.*;



public class WebDB {
	
	public WebDB() {}
	
	public ResultSet query(String query) {
  
    Connection dbconn; 
    ResultSet rs = null; 
    PreparedStatement sql;
    
    try 
    { 

        Class.forName("com.mysql.jdbc.Driver"); 
        try 
        { 
            
           
          
            dbconn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","root"); 
            sql = dbconn.prepareStatement(query); 
            rs = sql.executeQuery(); 
            
             
           
        } 
        catch (SQLException s) 
        { 
       
        } 
    } 
    catch (ClassNotFoundException err) 
    { 
   
    }
	return rs; 
}

}
