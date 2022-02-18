package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="first_name")
	private String firstName;

	@Column(name="hourly_rate")
	private BigDecimal hourlyRate;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_number")
	private String phoneNumber;

	@Lob
	private String remarks;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="employee")
	private List<Order> orders;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigDecimal getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setEmployee(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setEmployee(null);

		return order;
	}

	

	public Employee(String address, String firstName, BigDecimal hourlyRate, String lastName, String phoneNumber,
			String remarks) {
		super();
		this.address = address;
		this.firstName = firstName;
		this.hourlyRate = hourlyRate;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.remarks = remarks;
	}

	public Employee(String address, String firstName, BigDecimal hourlyRate, String lastName, String phoneNumber,
			String remarks, List<Order> orders) {
		super();
		this.address = address;
		this.firstName = firstName;
		this.hourlyRate = hourlyRate;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.remarks = remarks;
		this.orders = orders;
	}

	public Employee(int id, String address, String firstName, BigDecimal hourlyRate, String lastName,
			String phoneNumber, String remarks, List<Order> orders) {
		super();
		this.id = id;
		this.address = address;
		this.firstName = firstName;
		this.hourlyRate = hourlyRate;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.remarks = remarks;
		this.orders = orders;
	}
	
	

}