package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import entities.Employee;
import entities.User;
import manage.dao.EmployeeDAOImpl;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,     // 2MB
                 maxFileSize=1024*1024*10,        // 10MB
                 maxRequestSize=1024*1024*50)     // 50MB
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	 String dateString = request.getParameter("date");
         EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
         
         Employee newEmployee = new Employee();
        
    	
    	
    	
    	
    	// Directory where the uploaded files will be stored
        String uploadPath = "C:\\Users\\pc\\eclipse-workspace1\\HR_NEXUS\\src\\main\\Content\\uploads";
        
        // Create the directory if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Use mkdirs() to create parent directories if they don't exist
        }

        // Get the Part corresponding to the file input field 'photo'
        Part filePart = request.getPart("file");
        
        // Extracting file name from the Part
        String fileName = getFileName(filePart);
        
        // Writing the uploaded file to the server
        filePart.write(uploadPath + File.separator + fileName);
       newEmployee.setPhoto(uploadPath +"/"+ fileName) ;
       
        // Sending a response back to the client
        response.getWriter().print("File uploaded successfully!"+uploadPath + File.separator + fileName);
        try {
            // Parse the date string into a Date object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            newEmployee.setDateOfBirth(date.toString());
           
            // Here, you can store the date into a database or perform any other processing
            // For this example, let's just print it out
            out.println("<html><body>");
            out.println("<h2>Date Stored Successfully!</h2>");
            out.println("<p>Date: " + date.toString() + "</p>");
            out.println("</body></html>");
        } catch (ParseException e) {
            out.println("<html><body>");
            out.println("<h2>Error Parsing Date!</h2>");
            out.println("<p>Please enter the date in the correct format (yyyy-MM-dd).</p>");
            out.println("</body></html>");
        }employeeDAO.addEmployee(newEmployee);
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


