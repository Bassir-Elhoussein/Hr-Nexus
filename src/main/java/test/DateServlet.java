package test;import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the date parameter from the form
        String dateString = request.getParameter("date");
        
        try {
            // Parse the date string into a Date object
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);

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
        }
    }
}
