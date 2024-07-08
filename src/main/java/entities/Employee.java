package entities;



import jakarta.persistence.*;
import entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeID;

    
    
  
    private String esiNumber;
    
    private String paymentMode;
    private String position;
    private String accountNumber;
    private long base;
    private long salnet ;
   
    private String code;

    
 

	private String firstName;

   
    private String lastName;
    
    private String dateOfBirth;
    
    private String phoneNumber;
    
    private String address;
    
    private String mail;
    
    private String  photo; 
    
    private String maritalStatus;
    
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Events> events=new ArrayList<Events>();
    
    public String getMail() {
		return mail;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	   public long getBase() {
			return base;
		}

		public void setBase(long salnet) {
			this.base =(salnet-7278)/24;
		}

		public long getSalnet() {
			return salnet;
		}

		public void setSalnet(long salnet) {
			this.salnet = salnet;
		}
    
    public Employee() {
		super();
	}

    public Employee(String esiNumber, String paymentMode, String position, String accountNumber, long base, long salnet,
			String code, String firstName, String lastName, String dateOfBirth, String phoneNumber, String address,
			String mail, String photo, String maritalStatus, User user) {
		super();
		this.esiNumber = esiNumber;
		this.paymentMode = paymentMode;
		this.position = position;
		this.accountNumber = accountNumber;
		this.base = (salnet-7278)/24;
		this.salnet = salnet;
		this.code = "8459523"+code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.mail = mail;
		this.photo = photo;
		this.maritalStatus = maritalStatus;
		this.user = user;
		
	}

	public Employee(String code, String firstName, String lastName, String dateOfBirth, String phoneNumber,
			String address, String mail, String photo, String maritalStatus, User user) {
		super();
		this.code = "8459523"+code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.mail = mail;
		this.photo = photo;
		this.maritalStatus = maritalStatus;
		this.user = user;
		
	}

	public Employee( String code, String firstName, String lastName, String dateOfBirth,
			String phoneNumber, String address, String photo, String maritalStatus, User user) {
		super();
		
		this.code = "8459523"+code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.maritalStatus = maritalStatus;
		this.user = user;
	}

	
    
    @Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", code=" + code + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", photo=" + photo + ", maritalStatus=" + maritalStatus +"-----"+this.events.size()+ "]";
	}



	public Employee(String esiNumber, String paymentMode, String position, String accountNumber, String code,
			String firstName, String lastName, String dateOfBirth, String phoneNumber, String address, String mail,
			String photo, String maritalStatus, User user, List<Events> events) {
		super();
		this.esiNumber = esiNumber;
		this.paymentMode = paymentMode;
		this.position = position;
		this.accountNumber = accountNumber;
		this.code = "8459523"+code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.mail = mail;
		this.photo = photo;
		this.maritalStatus = maritalStatus;
		this.user = user;
		this.events = events;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = "8459523"+code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	
	 public String getEsiNumber() {
		return esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public User getUser() { return user; }
	 
	 public void setUser(User user) { this.user = user; }
	 
	

    
}