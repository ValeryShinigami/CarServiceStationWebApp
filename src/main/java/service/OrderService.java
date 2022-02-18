package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompagny.CrudHibernate.HibernateUtil;
import com.mycompagny.dao.OrderDao;

import model.Order;




public class OrderService implements OrderDao<Order> {

	
	public List<Order> getOrders() {
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Order> query = currentSession.createQuery("from Order order by id DESC", Order.class);
		List<Order> orders = query.getResultList();
		currentSession.getTransaction().commit();
		return orders;
	}

	
	public Order addOrder(Order order) {
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(order);
		currentSession.getTransaction().commit();
		
		return order;
		
	}

	
	public void deleteOrder(int id) {
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Order> query = currentSession.createQuery("Delete from Order where id =: orderId");
		query.setParameter("orderId", id);
		query.executeUpdate();
		currentSession.getTransaction().commit();
		
	}

	
	public Order getOrderById(int id) {
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Order order = currentSession.get(Order.class, id);
		currentSession.getTransaction().commit();
		return order;
	}

}


