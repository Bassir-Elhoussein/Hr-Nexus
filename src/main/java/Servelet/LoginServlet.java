package Servelet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.dao.UserDAO;
import manage.dao.*;
import entities.Employee;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        User user = userDAO.getUserByAuthentification(username,password);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful, redirect to a success page
        	
            
            // Set some session attributes
        	Employee e=employeeDAO.getEmployeeByUser(user);
        	session.setAttribute("Emp", e);
        	String emp=e.getEmployeeID()+"";
            session.setAttribute("idEmp",emp);
            session.setAttribute("photo", e.getPhoto());
            session.setAttribute("fullname", e.getLastName()+"  "+e.getFirstName());
            session.setAttribute("loggedIn", true);
            
            // Set session timeout (optional)
            session.setMaxInactiveInterval(30 * 60); // 30 minutes
            response.sendRedirect("./Style/dashboard.jsp");
        } else {
            // Authentication failed, redirect back to login page with an error message
        	
            request.setAttribute("error", "Invalid username or password");
            session.setAttribute("loggedIn", false);
            response.sendRedirect("./Login.jsp");
           // request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
