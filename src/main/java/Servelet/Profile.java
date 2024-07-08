package Servelet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Style/Profile")
public class Profile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    /*String pathInfo = request.getPathInfo();
	    if (pathInfo != null && !pathInfo.isEmpty()) {
	    	response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String[] parts = pathInfo.split("/");
	        String parameter = parts[parts.length - 1]; // Assuming the parameter is the last part of the path
	        // You can use this parameter in your logic (e.g., retrieve corresponding data from a database)
*/	       
		String queryParameter = request.getParameter("q");
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

	        
	        //Employee ee= (Employee) employeeDAO.getEmployeeById(e);
		 if (queryParameter != null && !queryParameter.isEmpty()) {
	        // Set the list of employees as an attribute in the request
	        request.setAttribute("int",queryParameter);
	        int e= Integer.parseInt(queryParameter);
	        response.setContentType("image/jpeg");
	        response.setContentType("image/jpg");
	        response.setContentType("image/png");
	        Employee employee= (Employee) employeeDAO.getEmployeeById(e);
	        request.setAttribute("image",employee.getPhoto());

	        // Forward the request to the JSP page
	        request.getRequestDispatcher("/Style/Profile.jsp").forward(request, response);}
			/*
			 * } else { // If no parameter is provided, handle the case appropriately (e.g.,
			 * return an error response)
			 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
			 * "No parameter provided in the URL"); }
			 */
	}
}
