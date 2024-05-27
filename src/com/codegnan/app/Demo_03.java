package com.codegnan.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

public class Demo_03 {

	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
		
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata =  metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		Session session =  sessionFactory.openSession();
		Employee employee = session.get(Employee.class, 3);
		session.getTransaction().begin();
		
		employee.setDepartment("Web Development");
		employee.setEmail("harsh@aol.com");
		employee.setDepartment("Web Development");
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();

	}

}
