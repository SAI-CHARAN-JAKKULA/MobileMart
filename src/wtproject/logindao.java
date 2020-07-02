package wtproject;

import java.sql.*;

public class logindao 
{
	String sql ="select * from users where emaill=? and passwords=?";

 public boolean check(String username,String password) 
 		{
	 String sql ="select * from users where emaill=? and passwords=?";
				      	try 
				      {
				         Class.forName("org.postgresql.Driver");
				         Connection c  = DriverManager .getConnection("jdbc:postgresql://localhost:5432/Charan",
						            "postgres", "charan");
				           PreparedStatement st = c.prepareStatement(sql);
				           st.setString(1,username);
				           st.setString(2,password);
				           ResultSet rs= st.executeQuery();
				           if(rs.next()) {
				        	   return true;
				           }
				      }
				      	catch (Exception e) 
				      {
				         e.printStackTrace();
				         System.err.println(e.getClass().getName()+": "+e.getMessage());
				         System.exit(0);
				      }
				  return false;
         }
 public void charan(){
	 System.out.print("charan");
 }
}	     
	   


