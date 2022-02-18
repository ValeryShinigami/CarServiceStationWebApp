package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompagny.CrudHibernate.HibernateUtil;

import model.Customer;

import com.mycompagny.dao.*;

public class CustomerService implements CustomerDao<Customer> {
		

	
	public void addCustomer(Customer customer) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(customer);
		currentSession.getTransaction().commit();
   }

	
	public void deleteCustomer(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Customer> query = currentSession.createQuery("Delete from Customer where id =: customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		currentSession.getTransaction().commit();
      
	}

	

	
	public Customer getCustomerById(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Customer customer = currentSession.get(Customer.class, id);
		currentSession.getTransaction().commit();
		return customer;
		

	}

	
	public List<Customer> getCustomers() {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		currentSession.getTransaction().commit();
		return customers;
	}

	

}