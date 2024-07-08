package Servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Employee;
import manage.dao.EmployeeDAOImpl;
import manage.dao.UserDAOImpl;

/**
 * Servlet implementation class Payslip
 */
@WebServlet("/Style/Payslip")
public class Payslip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryParameter = request.getParameter("ps");
		
        
		HttpSession session = request.getSession();
		 session.setAttribute("idpsylip",queryParameter);
		
		request.getRequestDispatcher("./payslip.jsp").forward(request, response);
	}

	

}
