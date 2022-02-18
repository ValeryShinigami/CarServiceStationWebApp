package com.mycompagny.dao;

import java.util.List;

import model.Customer;

public interface CustomerDao<CustomerT> {
	
	List<Customer> getCustomers();
	void addCustomer (Customer customer);
	void deleteCustomer(int id);
	Customer getCustomerById(int id);
}
