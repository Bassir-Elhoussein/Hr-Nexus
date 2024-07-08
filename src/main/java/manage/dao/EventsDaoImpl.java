package manage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.CommonQueryContract;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Employee;
import entities.Events;
import entities.User;

public class EventsDaoImpl implements EventsDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public Events addEvent(Events event) {
		Session ses = sf.openSession();
		Query<Events> query = ses.createQuery("from Events e where e.DateTitle = :empid", Events.class);
	    query.setParameter("empid", event.getDateTitle());
	    List<Events> events = query.list();
	    
	    
	    try {
			if (events.size()==0) {
				ses.beginTransaction();
				ses.persist(event);
				ses.getTransaction().commit();
				ses.close();
			    return event;}
			 
					} catch (Exception e) {
						// TODO: handle exception
					}
	    ses.close();
		return event;
		
	}

	@Override
	public void updateEvent(Events event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(int eventid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getEventById(int eventid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Events> getAllEventsForEmployee(int empid) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<Events> query = ses.createQuery("from Events e where e.emp.employeeID = :empid", Events.class);
	    query.setParameter("empid", empid);
	    List<Events> events = query.list();
	    ses.getTransaction().commit();
	    ses.close();
	    return events;
	    
	   
	}
	@Override
	public List<Events> getAllAbsentsForEmployee(int empid ,String month,String year) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<Events> query = ses.createQuery("from Events e where e.emp.employeeID = ?1 and e.Title = ?2 and e.Year = ?3 and e.Month = ?4", Events.class);
	    
	    query.setParameter(1,empid);
	    query.setParameter(2,"Absent");
	    query.setParameter(3,year);
	    query.setParameter(4,month);
	    List<Events> events = query.list();
	    ses.getTransaction().commit();
	    ses.close();
	    return events;
	    
	   
	}
	@Override
	public List<Events> getAllAbsentsForEmployee(int empid) {
	    Session ses = sf.openSession();
	    ses.beginTransaction();
	    Query<Events> query = ses.createQuery("from Events e where e.emp.employeeID = ?1 ", Events.class);
	    
	    
	    query.setParameter(1,empid);
	   
	    List<Events> events = query.list();
	    ses.getTransaction().commit();
	    ses.close();
	    return events;
	    
	   
	}

	@Override
	public List<Events> getAllUsersforanemp(int empid) {
		// TODO Auto-generated method stub
		return null;
	}


}
