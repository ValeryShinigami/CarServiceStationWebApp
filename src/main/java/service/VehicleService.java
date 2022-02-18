package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompagny.CrudHibernate.HibernateUtil;
import com.mycompagny.dao.VehicleDao;

import model.Customer;
import model.Vehicle;

public class VehicleService implements VehicleDao<Vehicle> {

	public List<Vehicle> getVehicles() {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Vehicle> query = currentSession.createQuery("from Vehicle order by model", Vehicle.class);
		List<Vehicle> vehicles = query.getResultList();
		currentSession.getTransaction().commit();
		return vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		currentSession.saveOrUpdate(vehicle);
		currentSession.getTransaction().commit();
		
	}

	public void deleteVehicle(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Query<Vehicle> query = currentSession.createQuery("Delete from Vehicle where id =: vehicleId");
		query.setParameter("vehicleId", id);
		query.executeUpdate();
		currentSession.getTransaction().commit();
	}

	public Vehicle getVehicleById(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
		currentSession.beginTransaction();
		Vehicle vehicle = currentSession.get(Vehicle.class, id);
		currentSession.getTransaction().commit();
		return vehicle;
	}

}
