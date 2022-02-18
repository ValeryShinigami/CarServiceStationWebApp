package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompagny.CrudHibernate.HibernateUtil;
import com.mycompagny.dao.EmployeeDao;

import model.Customer;
import model.Employee;

public class EmployeeService implements EmployeeDao<Employee> {
	

	public void addEmployee(Employee employee) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(employee);
		currentSession.getTransaction().commit();
   }

	
	public void deleteEmployee(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Customer> query = currentSession.createQuery("Delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		currentSession.getTransaction().commit();
      
	}

	

	
	public Employee getEmployeeById(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Employee employee = currentSession.get(Employee.class, id);
		currentSession.getTransaction().commit();
		return employee;
		

	}

	
	public List<Employee> getEmployees() {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Employee> query = currentSession.createQuery("from Employee order by lastName", Employee.class);
		List<Employee> employees = query.getResultList();
		currentSession.getTransaction().commit();
		return employees;
	}


	

}
