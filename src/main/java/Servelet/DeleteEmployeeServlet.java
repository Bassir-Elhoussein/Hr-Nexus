package Servelet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;
import manage.dao.UserDAOImpl;

@SuppressWarnings("deprecation")
@WebServlet("/Style/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the employee ID from the request parameter
    	String queryParameter = request.getParameter("a");
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        int employeeID =Integer.parseInt(queryParameter);
        // Call the deleteEmployee method
        Employee em=employeeDAO.getEmployeeById(employeeID);
        
        employeeDAO.deleteEmployee(employeeID);
        udao.deleteUser(em.getUser());
        // Redirect back to some page after deletion (you can change this URL)
        response.sendRedirect("./EmployeeServlet");
    }

    
}
