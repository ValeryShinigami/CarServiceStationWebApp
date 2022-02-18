package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="acceptance_date")
	private Date acceptanceDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="planned_repair_start_date")
	private Date plannedRepairStartDate;


	@Temporal(TemporalType.DATE)
	@Column(name="actual_repair_start_date")
	private Date actualRepairStartDate;

	@Column(name="cost_employee_hourly_rate")
	private BigDecimal costEmployeeHourlyRate;

	@Column(name="cost_final_to_pay")
	private BigDecimal costFinalToPay;

	@Column(name="cost_used_parts")
	private BigDecimal costUsedParts;

	
	@Lob
	@Column(name="problem_description")
	private String problemDescription;

	@Lob
	@Column(name="repair_description")
	private String repairDescription;

	@Column(name="repair_time_in_hours")
	private BigDecimal repairTimeInHours;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAcceptanceDate() {
		return this.acceptanceDate;
	}

	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public Date getActualRepairStartDate() {
		return this.actualRepairStartDate;
	}

	public void setActualRepairStartDate(Date actualRepairStartDate) {
		this.actualRepairStartDate = actualRepairStartDate;
	}

	public BigDecimal getCostEmployeeHourlyRate() {
		return this.costEmployeeHourlyRate;
	}

	public void setCostEmployeeHourlyRate(BigDecimal costEmployeeHourlyRate) {
		this.costEmployeeHourlyRate = costEmployeeHourlyRate;
	}

	public BigDecimal getCostFinalToPay() {
		return this.costFinalToPay;
	}

	public void setCostFinalToPay(BigDecimal costFinalToPay) {
		this.costFinalToPay = costFinalToPay;
	}

	public BigDecimal getCostUsedParts() {
		return this.costUsedParts;
	}

	public void setCostUsedParts(BigDecimal costUsedParts) {
		this.costUsedParts = costUsedParts;
	}

	public Date getPlannedRepairStartDate() {
		return this.plannedRepairStartDate;
	}

	public void setPlannedRepairStartDate(Date plannedRepairStartDate) {
		this.plannedRepairStartDate = plannedRepairStartDate;
	}

	public String getProblemDescription() {
		return this.problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getRepairDescription() {
		return this.repairDescription;
	}

	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}

	public BigDecimal getRepairTimeInHours() {
		return this.repairTimeInHours;
	}

	public void setRepairTimeInHours(BigDecimal repairTimeInHours) {
		this.repairTimeInHours = repairTimeInHours;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/*public Order(Date acceptanceDate, Date plannedRepairStartDate, Date actualRepairStartDate,
			BigDecimal costFinalToPay, BigDecimal costUsedParts, String problemDescription, String repairDescription,
			BigDecimal repairTimeInHours, Employee employee, Vehicle vehicle, Status status) {
		super();
		this.acceptanceDate = acceptanceDate;
		this.plannedRepairStartDate = plannedRepairStartDate;
		this.actualRepairStartDate = actualRepairStartDate;
		this.costFinalToPay = costFinalToPay;
		this.costUsedParts = costUsedParts;
		this.problemDescription = problemDescription;
		this.repairDescription = repairDescription;
		this.repairTimeInHours = repairTimeInHours;
		this.employee = employee;
		this.vehicle = vehicle;
		this.status = status;
	}*/

	public Order(Date acceptanceDate, Date plannedRepairStartDate, Date actualRepairStartDate,
			BigDecimal costEmployeeHourlyRate, BigDecimal costFinalToPay, BigDecimal costUsedParts,
			String problemDescription, String repairDescription, BigDecimal repairTimeInHours, Employee employee,
			Vehicle vehicle, Status status) {
		super();
		this.acceptanceDate = acceptanceDate;
		this.plannedRepairStartDate = plannedRepairStartDate;
		this.actualRepairStartDate = actualRepairStartDate;
		this.costEmployeeHourlyRate = costEmployeeHourlyRate;
		this.costFinalToPay = costFinalToPay;
		this.costUsedParts = costUsedParts;
		this.problemDescription = problemDescription;
		this.repairDescription = repairDescription;
		this.repairTimeInHours = repairTimeInHours;
		this.employee = employee;
		this.vehicle = vehicle;
		this.status = status;
	}

	
	
	

	

	

	
	
	
	

}