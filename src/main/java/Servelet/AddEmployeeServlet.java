package Servelet;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.Employee;
import entities.User;
import manage.dao.EmployeeDAOImpl;
import manage.dao.UserDAOImpl;

@WebServlet("/addEmployee") 
@MultipartConfig(fileSizeThreshold=1024*1024*2,     // 2MB
maxFileSize=1024*1024*10,        // 10MB
maxRequestSize=1024*1024*50)     // 50MB
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 // Retrieve form data
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
        User newUser = new User(email, password); // Create a new user for each employee
        Employee newEmployee = new Employee(code, firstName, lastName, null, phoneNumber,
                address, email, null, maritalStatus, newUser);
        // Set additional attributes
        newEmployee.setEsiNumber(ESI);
        newEmployee.setPosition(position);
        newEmployee.setAccountNumber(accountNumber);
        try {
        	 newEmployee.setSalnet(Long.parseLong(salnet));
		} catch (Exception e) {
			// TODO: handle exception
		}
       
        newEmployee.setPaymentMode(paymentMode);
        
        
        String dateString = request.getParameter("date");

        
        String uploadPath = "C:\\Users\\pc\\eclipse-workspace1\\HR_NEXUS\\src\\main\\webapp\\Content\\uploads\\";
        // Get the Part corresponding to the file input field 'photo'
        
        try {Part filePart = request.getPart("file");
			 
      if (filePart != null && filePart.getSize() > 0)
				        {String fileName = getFileName(filePart);
				          filePart.write(uploadPath + File.separator + fileName);
								       newEmployee.setPhoto("../Content/uploads/"+ fileName) ;
								       //response.getWriter().print("File uploaded successfully!"+uploadPath + File.separator + fileName);
						}
      else {newEmployee.setPhoto("../Content/uploads/"+ "LG.png") ;
    	  response.getWriter().print("File uploaded successfully!"+uploadPath + File.separator + "LG.png");}
		} catch (Exception e) {
			// TODO: handle exception
		}
        
       
        // Sending a response back to the client
        
        try {
            // Parse the date string into a Date object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           // Date date = sdf.parse();
            newEmployee.setDateOfBirth(dateString);
           
            // Here, you can store the date into a database or perform any other processing
            // For this example, let's just print it out
            
        } catch (Exception e) {
           
        }
      
     // Directory where the uploaded files will be stored
        
        
        

       
        
        
    
    

   
    

        
        
        
        
        
      
        
        
        
        
        userDAO.addUser(newUser);
        Employee employe=employeeDAO.addEmployee(newEmployee);
        // Save employee data to database or perform any other necessary actions

        // Redirect to a success page
        response.sendRedirect("./Style/Profile?q=" +employe.getEmployeeID());
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

