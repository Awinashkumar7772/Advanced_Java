
<%
    session = request.getSession(false);

    // Check login - double protection
    if(session == null || session.getAttribute("username") == null){
        response.sendRedirect("login.html");
        return;
    }

    String name = (String) session.getAttribute("sname");
    String course = (String) session.getAttribute("scourse");
    String email = (String) session.getAttribute("semail");
%>

<!DOCTYPE html>
<html>
<body>

<h2>Student Registration Details</h2>

<table border="1" cellpadding="8">
    <tr><th>Name</th><td><%= name %></td></tr>
    <tr><th>Course</th><td><%= course %></td></tr>
    <tr><th>Email</th><td><%= email %></td></tr>
</table>

<br><br>
<a href="logout">Logout</a>

</body>
</html>
