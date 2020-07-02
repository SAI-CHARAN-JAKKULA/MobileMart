

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import wtproject.logindao;


@WebServlet("/login")
public class login extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String username=request.getParameter("email");
		String password=request.getParameter("psw");
		
		logindao dao = new logindao();	
		if(dao.check(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("loggedin.html");
		}
		else {
		response.sendRedirect("signup.html");
		}
		
		
	}

	
}
 	