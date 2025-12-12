package dac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String pass  = request.getParameter("pass");
		//simple validation (you can validate from database)
		if(uname.equals("admin") && pass.equals("993450")) {
			HttpSession session = request.getSession(); //create new session
			session.setAttribute("username", uname);
			
			response.sendRedirect("Register.html");		
			
		}else {
			response.getWriter().println("Invalid login <a href ='login.html'>Try again </a>");
		}
		
	}
		
	


}
