package test;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session object
        HttpSession session = request.getSession();
        
		/*
		 * // Set some session attributes session.setAttribute("username", "JohnDoe");
		 * session.setAttribute("loggedIn", true);
		 * 
		 * // Set session timeout (optional) session.setMaxInactiveInterval(30 * 60); //
		 * 30 minutes
		 */        
        // Send a response
        response.getWriter().println("Session created and attributes set!");
    }
}
