package dac;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        // Validate login
        if(session == null || session.getAttribute("username") == null){
            resp.sendRedirect("login.html");
            return;
        }
        resp.setContentType("text/html");

        // Fetch values
        String name = (String) session.getAttribute("sname");
        String course = (String) session.getAttribute("scourse");
        String email = (String) session.getAttribute("semail");

        PrintWriter out = resp.getWriter();
        out.println("<h2>Student Details</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Course: " + course + "<br>");
        out.println("Email: " + email + "<br><br>");
        out.println("<a href='logout'>Logout</a>");
    }
}
