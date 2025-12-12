package dac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	HttpSession session = request.getSession(false);
	//check login 
	if(session ==null ||session.getAttribute("username")==null) {
		response.sendRedirect("logout");
		return;
	}
	String name = request.getParameter("name");
	String course = request.getParameter("course");
	String email = request.getParameter("email");
	
	//store in session
	session.setAttribute("sname", name);
	session.setAttribute("scourse", course);
	session.setAttribute("semail", email);
	
	response.sendRedirect("view");
}
}
