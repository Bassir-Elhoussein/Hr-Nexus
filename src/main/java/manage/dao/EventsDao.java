package manage.dao;

import java.util.List;

import entities.Events;
import entities.User;

public interface EventsDao {
	Events addEvent(Events event);
    void updateEvent(Events event);
    void deleteEvent(int eventid);
    User getEventById(int eventid);
    List<Events> getAllUsersforanemp(int empid);
	List<Events> getAllEventsForEmployee(int empid);
	List<Events> getAllAbsentsForEmployee(int empid);
    List<Events> getAllAbsentsForEmployee(int empid,String month,String year);
	
}
