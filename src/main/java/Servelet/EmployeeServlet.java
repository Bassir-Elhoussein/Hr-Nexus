package Servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;

@WebServlet("/Style/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instantiate the DAO class
    	EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

         
        List<Employee> employees = employeeDAO.getAllEmployees();

         // Set the list of employees as an attribute in the request
         request.setAttribute("employees", employees);
			/*
			 * HttpSession session = request.getSession(); Boolean loggedIn= false ;
			 * 
			 * try { loggedIn = (Boolean) session.getAttribute("loggedIn");}catch (Exception
			 * e) { // TODO: handle exception } if(false==loggedIn)
			 * {response.sendRedirect("../Login.jsp");}
			 */
         // Forward the request to the JSP page
         request.getRequestDispatcher("/Style/employees.jsp").forward(request, response);}
	
    	
       
        
    }

