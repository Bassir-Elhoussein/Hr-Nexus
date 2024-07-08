package Servelet;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import entities.*;
import manage.dao.EmployeeDAOImpl;
import manage.dao.EventsDaoImpl;
import manage.dao.UserDAOImpl;

@WebServlet("/Style/EventServlet")
public class EventServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	   protected void  doGet() {
		// TODO Auto-generated method stub

	}
	 public static String extractDate(String timestamp) {
	        // Parse the timestamp into a LocalDateTime object
	        LocalDateTime dateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_DATE_TIME);
	        // Format the LocalDateTime object to extract the date
	        String date = dateTime.format(DateTimeFormatter.ISO_DATE);
	        return date;
	    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the JSON data from the hidden input field
        String jsonData = request.getParameter("events-data");
        EventsDaoImpl eventdao= new EventsDaoImpl();
        String queryParameter = request.getParameter("idce"); 
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        int employeeID =Integer.parseInt(queryParameter);
        // Call the deleteEmployee method
		Employee em=employeeDAO.getEmployeeById(employeeID);
        // Parse JSON data into a list of events
        List<Events> events = parseEvents(jsonData);

        // Process the events as needed
        for (Events event : events) {
			/*
			 * Events ev = new Events(event.getTitle(), String Date, Employee emp); ev.set
			 */
        	event.setEmp(em);
        	eventdao.addEvent(event);
            System.out.println("Title: " + event.getTitle());
            System.out.println("Start Date: " + event);
            System.out.println("End Date: " + event);
            // Perform database operations or other business logic with the event data
        }

        // Optionally, you can send a response back to the client
        response.sendRedirect("./EventServlet?c="+queryParameter);
       // request.getRequestDispatcher("./calendartest.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Get the employee ID from the request parameter
    	
		/*
		 * HttpSession session = request.getSession(); session.setAttribute("idc",
		 * queryParameter);
		 */
		
        
        
        
    	request.getRequestDispatcher("./calendartest.jsp").forward(request, response);
    	
    }
    
    
    
    
    private List<Events> parseEvents(String jsonData) {
        List<Events> events = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String title = jsonObject.getString("title");
            String start = jsonObject.getString("start");
            String date = extractDate(start);
            System.out.println(date);
            String end = jsonObject.optString("end", null); // Get end if available
            Events event = new Events(title, date);
            events.add(event);
        }
        return events;
    }
    
}





