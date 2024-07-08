<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Data</title>
</head>
<body>
    <h1>Session Data</h1>
    
    <%
        // Retrieve session object
        //HttpSession session = request.getSession();
        
        // Retrieve session attributes
        String username = (String) session.getAttribute("username");
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        // Display session data
        if(username != null && loggedIn != null && loggedIn) {
    %>
            <p>Welcome, <%= username %>!</p>
            <p>You are logged in.</p>
    <%
        } else {
    %>
            <p>No session data found.</p>
    <%
        }
    %>
</body>
</html>