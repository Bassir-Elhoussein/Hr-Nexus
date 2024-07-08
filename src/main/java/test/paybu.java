package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class paybu
 */
@WebServlet("/Style/paybu")
public class paybu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        
        List<Employee> employees = employeeDAO.getAllEmployees();

         
         request.setAttribute("employees", employees);
			
         request.getRequestDispatcher("./payslips.jsp").forward(request, response);
	}


}

