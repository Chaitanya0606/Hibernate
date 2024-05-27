package com.codegnan.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

public class Demo_04 {

	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
		
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata =  metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		Session session =  sessionFactory.openSession();
		Employee employee = session.get(Employee.class, 4);
		session.getTransaction().begin();
		if (employee != null) {
            session.delete(employee);
            session.getTransaction().commit();
        } else {
            System.out.println("Employee not found with ID: 4");
            session.getTransaction().rollback();
        }
		session.close();

	}

}
