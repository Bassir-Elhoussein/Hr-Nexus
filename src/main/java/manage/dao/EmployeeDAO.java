package manage.dao;

import java.util.List;

import entities.Employee;
import entities.User;

public interface EmployeeDAO {
    
    void updateEmp(Employee employee);
    Employee updateEmployee(Employee employee);
    public Employee addEmployee(Employee employee);
    public void addEmp(Employee employee);
    void deleteEmployee(int employeeID);
    Employee getEmployeeById(int employeeID);
    Employee getEmployeeByUser(User u);
    List<Employee> getAllEmployees();
	void addEmployee(Employee e, User u);
}
