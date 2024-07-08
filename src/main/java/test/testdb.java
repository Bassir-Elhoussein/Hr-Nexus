package test;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Part;

import entities.Employee;
import entities.Events;
import entities.User;
import manage.dao.EmployeeDAOImpl;
import manage.dao.EventsDaoImpl;
import manage.dao.UserDAO;
import manage.dao.UserDAOImpl;
public class testdb {
   
    public static void main(String[] args) {
        // Instantiate DAO classes with EntityManager
    	 String uploadPath = "C:\\Users\\pc\\eclipse-workspace1\\HR_NEXUS\\src\\main\\webapp\\Content\\uploads\\";
         // Get the Part corresponding to the file input field 'photo'
         
       
 			 
       
        UserDAOImpl userDAO = new UserDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        EventsDaoImpl eventDao =new EventsDaoImpl();
        
        // Create a user
        User user = new User("bassir", "11");
        userDAO.addUser(user);
    // Create an employee associated with the user
        Employee employee = new Employee("00","Bassir", null, null, null, null, null, null, user);
        Employee emp= employeeDAO.addEmployee(employee);
        //employeeDAO.addEmployee(employee);
        Events ev= new Events("Absent","2024-05-12",emp);
        Events eiv= new Events("Absent","2024-06-12",emp);
       
        eventDao.addEvent(ev);
        eventDao.addEvent(eiv);

        // Generate and persist 20 random employees
        String[] firstNames = {"Ahmed", "Fatima", "Mohammed", "Aisha", "Ali", "Layla", "Youssef", "Nour", "Khaled", "Sara", "Abdullah", "Reem", "Omar", "Salma", "Hassan", "Nadia", "Tarek", "Hala", "Emad", "Safa"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            String id = String.format("%03d", i);
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String dateOfBirth = "1988-04-29"; // Set date of birth to null
            String phoneNumber = "0625262428"; // Function to generate random phone numbers
            String address = "123 Palm Street"; // Example address
            String photo = "photo" + id + ".jpg"; // Example photo name
            String maritalStatus = (i % 2 == 0) ? "Married" : "Single";
            String mail = firstName + lastName + i + "@gmail.com";

            // Additional attributes
            String esiNumber = "8815189158915448" + id;
            String paymentMode = "Bank Transfer" ;
            String position = "Software Engineer" ;
            String accountNumber = "7532 856398 456381 1" + id;
            long base = random.nextInt(10000);
            long salnet = random.nextInt(10000)+10000;
            String code = "" + id;

            User newUser = new User(id, id+"pwd"); // Create a new user for each employee
            userDAO.addUser(newUser);

            Employee newEmployee = new Employee(esiNumber, paymentMode, position, accountNumber, base, salnet, code,
                    firstName, lastName, dateOfBirth, phoneNumber, address, mail, photo, maritalStatus, newUser);
            employeeDAO.addEmployee(newEmployee);
        }

        List<Events> evlist =eventDao.getAllEventsForEmployee(1);
        List<Events> evlistemp =emp.getEvents();
        
        List<Employee> allEmployees = employeeDAO.getAllEmployees();

        // Output the first employee from the list
        if (!allEmployees.isEmpty()) {
            System.out.println("First employee: " + allEmployees.get(0).toString());
            Employee ee=employeeDAO.getEmployeeById(15);
             
            System.out.println("employee: " + ee.toString());
            ee.setFirstName("fati5a");
            Employee e1=employeeDAO.updateEmployee(ee);
            System.out.println("employee: " + e1.toString());
            Employee e2=employeeDAO.getEmployeeByUser(user);
            System.out.println("employeee e2: " + e2.toString());
        }
        
        System.out.println("First event: " + evlist.get(0).toString());
        Employee emp1= employeeDAO.getEmployeeById(1);
        List<Events> evlist1 =eventDao.getAllEventsForEmployee(1);
        List<Events> evlistemp1 =emp1.getEvents();
        List<Events> evlistemp2 = eventDao.getAllAbsentsForEmployee(1);
        List<Events> evlistemp3 = eventDao.getAllAbsentsForEmployee(1,"06","2024");
        System.out.println("First event: " + evlist1.get(0).toString());
        System.out.println("First event: " + evlistemp1.get(0).toString());
        System.out.println("First event EMP	: " + evlistemp1.size());
        System.out.println("First event EMP	: " + evlistemp2.size());
        System.out.println("First event EMP	: " + evlistemp3.size());
        
        
        
       
    }
}
