package entities;

import javax.servlet.jsp.tagext.TryCatchFinally;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Events {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idEvent;

   
    private String  Title;
    
    private String  Day;
    private String  Month;
    private String  Year;
    @Column(unique = true)
    private String  DateTitle;
 

	
	@ManyToOne
    private Employee emp;
    @Override
	public String toString() {
		return "Events [idEvent=" + idEvent + ", Title=" + Title + ", Day=" + Day + ", Month=" + Month + ", Year="
				+ Year + ", emp=" + emp + "]";
	}
	public Events() {
		super();
	}
	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public String getMonth() {
		return Month;
	}
	public String getDateTitle() {
		return DateTitle;
	}
	public void setDateTitle(String dateTitle) {
		DateTitle = dateTitle;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Events(String title, String Date, Employee emp) {
		super();
		this.DateTitle=Date+"--"+title;
		this.Title = title;
		splitDate(Date);
		this.emp = emp;
	}
	public Events(String title, String Date) {
		super();
		this.DateTitle=Date+"--"+title;
		this.Title = title;
		splitDate(Date);
		
	}
    public void splitDate(String date) {
        // Split the date string using the "-" separator
        String[] parts = date.split("-");
        
        // Extract year, month, and day
        this.Year = parts[0];
        this.Month = parts[1];
        int i=Integer.parseInt( parts[2])+1;
        this.Day = ""+i;
        
        
    }

}
