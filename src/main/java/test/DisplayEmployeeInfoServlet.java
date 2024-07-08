package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayEmployeeInfoServlet")
public class DisplayEmployeeInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        String queryParameter = request.getParameter("upd");
       
       // int id = Integer.parseInt(queryParameter); 
        // Retrieve form parameters
        String code = request.getParameter("code");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("date");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String maritalStatus = request.getParameter("maritalStatus");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Assuming you're also passing user information
        String confirmPassword = request.getParameter("confirmPassword");

        // Display the submitted information
        out.println("<html><head><title>Employee Information</title></head><body>");
        out.println("<h2>Employee Information</h2>");
        //out.println("<p><b>Employee upd id:</b> " + id + "</p>");
        out.println("<p><b>Employee Code:</b> " + code + "</p>");
        out.println("<p><b>First Name:</b> " + firstName + "</p>");
        out.println("<p><b>Last Name:</b> " + lastName + "</p>");
        out.println("<p><b>Date of Birth:</b> " + dateOfBirth + "</p>");
        out.println("<p><b>Phone Number:</b> " + phoneNumber + "</p>");
        out.println("<p><b>Address:</b> " + address + "</p>");
        out.println("<p><b>Marital Status:</b> " + maritalStatus + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Password:</b> " + password + "</p>");
        out.println("<p><b>Confirm Password:</b> " + confirmPassword + "</p>");
        out.println("</body></html>");
    }
}
