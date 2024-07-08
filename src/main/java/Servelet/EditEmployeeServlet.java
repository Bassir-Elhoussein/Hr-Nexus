package Servelet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.Employee;
import entities.User;
import manage.dao.EmployeeDAOImpl;
import manage.dao.UserDAOImpl;


@WebServlet("/Style/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String queryParameter = request.getParameter("e");
        if (queryParameter != null && !queryParameter.isEmpty()) {
            request.setAttribute("intedit", queryParameter);
        }
        request.getRequestDispatcher("/Style/editEmp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String queryParameter = request.getParameter("upd");
        String i=(String)  request.getAttribute("intedit");
        int id = Integer.parseInt(queryParameter);

        String code = request.getParameter("code");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String maritalStatus = request.getParameter("maritalStatus");
        String ESI = request.getParameter("ESI");
        String position = request.getParameter("position");
        String accountNumber = request.getParameter("accountNumber");
        String salnet = request.getParameter("salnet");
        String paymentMode = request.getParameter("paymentMode");

        UserDAOImpl userDAO = new UserDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee newEmployee = employeeDAO.getEmployeeById(id);
        User newUser = newEmployee.getUser();

        if (address != null && !address.isEmpty()) newEmployee.setAddress(address);
        if (code != null && !code.isEmpty())newEmployee.setCode(code);
        if (phoneNumber != null && !phoneNumber.isEmpty()) newEmployee.setPhoneNumber(phoneNumber);
        if (firstName != null && !firstName.isEmpty()) newEmployee.setFirstName(firstName);
        if (lastName != null && !lastName.isEmpty()) newEmployee.setLastName(lastName);
        if (email != null && !email.isEmpty()) newEmployee.setMail(email);
        if (maritalStatus != null && !maritalStatus.isEmpty()) newEmployee.setMaritalStatus(maritalStatus);

        try {Long ll =Long.parseLong(salnet);
        if (salnet != null && !salnet.isEmpty()) { newEmployee.setSalnet(ll); newEmployee.setBase(ll);}
               
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        if (ESI != null && !ESI.isEmpty()) newEmployee.setEsiNumber(ESI);;
        if (position != null && !position.isEmpty()) newEmployee.setPosition(position);
        if (accountNumber != null && !accountNumber.isEmpty()) newEmployee.setAccountNumber(accountNumber);
        
        if (paymentMode != null && !paymentMode.isEmpty()) newEmployee.setPaymentMode(paymentMode);
        
        if (password != null && !password.isEmpty()) newUser.setPassword(password);
        if (email != null && !email.isEmpty()) newUser.setUsername(email);
        newEmployee.setUser(newUser);

        // Handling file upload
        String uploadPath = "C:\\Users\\pc\\eclipse-workspace1\\HR_NEXUS\\src\\main\\webapp\\Content\\uploads\\";
       
        try {
        	Part filePart=request.getPart("file");
		
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = getFileName(filePart);
            if (fileName != null && !fileName.isEmpty()) {
                filePart.write(uploadPath + File.separator + fileName);
                newEmployee.setPhoto("../Content/uploads/" + fileName);
            }
        }} catch (Exception e) {
			// TODO: handle exception
		}

        // Handling date of birth
        String dateString = request.getParameter("date");
        if (dateString != null && !dateString.isEmpty()) {
		        try {
		            
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		           // Date date = sdf.parse();
		            newEmployee.setDateOfBirth(dateString);
		           
		           
		            
		        } catch (Exception e) {
		           
		        }}

        // Update user and employee
        userDAO.updateUser(newUser);
        Employee updatedEmployee = employeeDAO.updateEmployee(newEmployee);

        // Redirect to profile page
        response.sendRedirect("./Profile?q=" + updatedEmployee.getEmployeeID());
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                // Extracting just the filename and its extension
                String fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                // Some browsers may provide the full path, so we need to extract just the filename
                return fileName.substring(fileName.lastIndexOf(File.separator) + 1);
            }
        }
        return null;
    }
}
