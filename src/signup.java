

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("email");
		String password=request.getParameter("psw");
		 String sql ="insert into users values(?,?)";
		 	try 
		      {
		         Class.forName("org.postgresql.Driver");
		         Connection c  = DriverManager .getConnection("jdbc:postgresql://localhost:5432/Charan",
				            "postgres", "charan");
		           PreparedStatement st = c.prepareStatement(sql);
		           st.setString(1,username);
		           st.setString(2,password);
		           int count= st.executeUpdate();
		           if(count>0) {
		        	   response.sendRedirect("signedup.html");
		           }
		           else {
		        	   response.sendRedirect("signup.html");
		           }
		      }
		      	catch (Exception e) 
		      {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		  

	}

	
}
