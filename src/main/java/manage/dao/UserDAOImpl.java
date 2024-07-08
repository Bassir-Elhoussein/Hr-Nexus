package manage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Employee;
import entities.User;








public class UserDAOImpl implements UserDAO{
	 SessionFactory sf = HibernateUtil.getSessionFactory();
	@Override
	public void addUser(User user) {
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.persist(user);
		ses.getTransaction().commit();
		ses.close();
		
		}
	
		
	/*
	 * public void addUser(User user) { try (Session ses = sf.openSession()) {
	 * ses.beginTransaction(); // Reattach the user object to the session
	 * ses.saveOrUpdate(user); ses.getTransaction().commit(); } catch (Exception e)
	 * { e.printStackTrace(); } }
	 */

	
	

	
	

	@Override
	public User getUserById(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@SuppressWarnings("deprecation")
	public void updateUser(User u) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    ses.update(u);
	    ses.getTransaction().commit();
	    ses.close();
	}
	
	@SuppressWarnings("deprecation")
	public void deleteUser(User u) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    //User u = ses.get(User.class, userID);
	    ses.delete(u);
	    ses.getTransaction().commit();
	    ses.close();
	}

	@Override
	public User getUserByAuthentification(String username, String password) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<User> uu = ses.createQuery("from User u where u.username = ?1 and u.password = ?2", User.class);
        uu.setParameter(1, username);
	    uu.setParameter(2, password);
        User u = uu.uniqueResult(); // Assuming there's only one user with the given credentials
	    ses.getTransaction().commit();
	    ses.close();
	    return u;
	}


	@Override
	public void deleteUser(int userID) {
		// TODO Auto-generated method stub
		
	}


}
