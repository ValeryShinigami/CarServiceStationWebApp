package service;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompagny.CrudHibernate.HibernateUtil;
import com.mycompagny.dao.StatusDao;

import model.Status;

public class StatusService implements StatusDao<Status>  {


	
	public List<Status>  getAllStatus() {
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query<Status> query = currentSession.createQuery("from Status", Status.class);
        List<Status> status = query.getResultList();
        currentSession.getTransaction().commit();
        return status;
	}
	

	public Status getStatusById(int id) {
		
		Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Status status = currentSession.get(Status.class, id);
        currentSession.getTransaction().commit();
        return status;
	}


	


	
}
