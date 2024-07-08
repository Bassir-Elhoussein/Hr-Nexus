package manage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import dao.util.HibernateUtil;
import entities.Employee;
import entities.User;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
   

	SessionFactory sf = HibernateUtil.getSessionFactory();

	
    public EmployeeDAOImpl() {}

	public Employee addEmployee(Employee employee) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.persist(employee);
		ses.getTransaction().commit();
		ses.close();
		return employee;
		
	}

	public void addEmp(Employee employee) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.persist(employee);
		ses.getTransaction().commit();
		ses.close();
		
		
	}
	@SuppressWarnings("deprecation")
	public Employee updateEmployee(Employee employee) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    ses.update(employee);
	    ses.getTransaction().commit();
	    ses.close();
	    return employee;
	}

	@SuppressWarnings("deprecation")
	public void deleteEmployee(int employeeID) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    Employee employee = ses.get(Employee.class, employeeID);
	    ses.delete(employee);
	    ses.getTransaction().commit();
	    ses.close();
	}


	public Employee getEmployeeById(int employeeID) {
		Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<Employee> uu = ses.createQuery("from Employee u where u.employeeID = ?1 ", Employee.class);
        uu.setParameter(1, employeeID);
	    Employee u = uu.uniqueResult(); // Assuming there's only one user with the given credentials
	    ses.getTransaction().commit();
	    ses.close();
	    return u;
	}
	

	public List<Employee> getAllEmployees() {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    List<Employee> employees = ses.createQuery("from Employee", Employee.class).list();
	    ses.getTransaction().commit();
	    ses.close();
	    return employees;
	}


	@Override
	public void addEmployee(Employee e,User u) {
	    	Session ses = sf.openSession();
			ses.beginTransaction();
			User user = ses.find(User.class, u);
			//cpt.setClient(u);
			///e.setUser(user);
			ses.persist(u);
			ses.getTransaction().commit();
			ses.close();
	    }

	@Override
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeByUser(User u) {
		Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<Employee> uu = ses.createQuery("from Employee u where u.user = ?1 ", Employee.class);
        uu.setParameter(1, u);
	    Employee emp = uu.uniqueResult(); // Assuming there's only one user with the given credentials
	    ses.getTransaction().commit();
	    ses.close();
	    return emp;
	}
		
	}

    
   


