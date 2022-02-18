package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="customer")
	private List<Vehicle> vehicles;

	public Customer() {
	}
	
	

	public Customer(Date birthDate, String firstName, String lastName, List<Vehicle> vehicles) {
		super();
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicles = vehicles;
	}



	public Customer(Date birthDate, String firstName, String lastName) {
		super();
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Customer(int id, Date birthDate, String firstName, String lastName, List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicles = vehicles;
	}



	public Customer(int id, Date birthDate, String firstName, String lastName) {
		super();
		this.id = id;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setCustomer(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setCustomer(null);

		return vehicle;
	}

}