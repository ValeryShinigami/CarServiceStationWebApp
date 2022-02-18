package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicles database table.
 * 
 */
@Entity
@Table(name="vehicles")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String brand;

	private String model;

	@Temporal(TemporalType.DATE)
	@Column(name="next_review_date")
	private Date nextReviewDate;

	@Column(name="production_year")
	private int productionYear;

	@Column(name="registration_number")
	private String registrationNumber;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="vehicle")
	private List<Order> orders;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	public Vehicle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getNextReviewDate() {
		return this.nextReviewDate;
	}

	public void setNextReviewDate(Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}

	public int getProductionYear() {
		return this.productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setVehicle(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setVehicle(null);

		return order;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle(String brand, String model, Date nextReviewDate, int productionYear, String registrationNumber) {
		super();
		this.brand = brand;
		this.model = model;
		this.nextReviewDate = nextReviewDate;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
	}

	public Vehicle(int id, String brand, String model, Date nextReviewDate, int productionYear,
			String registrationNumber, List<Order> orders, Customer customer) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.nextReviewDate = nextReviewDate;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.orders = orders;
		this.customer = customer;
	}

	
}