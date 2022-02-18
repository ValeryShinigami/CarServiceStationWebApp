package com.mycompagny.dao;

import java.util.List;

public interface EmployeeDao<Employee> {
	
	List<Employee> getEmployees();
	void addEmployee (Employee employee);
	void deleteEmployee(int id);
	Employee getEmployeeById(int id);

}


