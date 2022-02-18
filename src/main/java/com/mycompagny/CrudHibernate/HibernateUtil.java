package com.mycompagny.CrudHibernate;

import java.io.ObjectInputFilter.Status;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import model.Customer;
import model.Employee;
import model.Vehicle;

public class HibernateUtil {
	//il représente l'ouverture des nouvelles sessions
	//une sesssion représente une unité de travail

	private static SessionFactory factory;

	//constructeur en privé singleton design pattern
    private HibernateUtil() {}

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Status.class)
                    .addAnnotatedClass(Vehicle.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}
	


