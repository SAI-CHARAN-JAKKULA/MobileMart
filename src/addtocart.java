

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
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.print("charan");
	

	String sql ="insert into cart values(1)";
 	try 
      {
         Class.forName("org.postgresql.Driver");
         Connection c  = DriverManager .getConnection("jdbc:postgresql://localhost:5432/Charan",
		            "postgres", "charan");
           PreparedStatement st = c.prepareStatement(sql);
           
           
           int count=st.executeUpdate();
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
