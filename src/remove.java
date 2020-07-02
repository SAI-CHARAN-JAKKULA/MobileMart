

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class remove
 */
@WebServlet("/remove")
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String sql ="delete from cart where itemid=1";
		String sql1 ="insert into cart values(1)";
	 	try 
	      {
	         Class.forName("org.postgresql.Driver");
	         Connection c  = DriverManager .getConnection("jdbc:postgresql://localhost:5432/Charan",
			            "postgres", "charan");
	           PreparedStatement st = c.prepareStatement(sql);
	           PreparedStatement st1 = c.prepareStatement(sql1);
	           
	           int count= st.executeUpdate();
	           int count1=count-1;
	           while(count1>0)
	           {
	        	   st1.executeUpdate();
	        	   count1--;
	           }
	           
	           if(count>0) {
	        	   response.sendRedirect("cart.jsp");
	           }
	           else {
	        	   response.sendRedirect("noitems.html");
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
