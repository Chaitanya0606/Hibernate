package com.codegnan.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

public class Demo_01 {

	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
		
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata =  metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		Session session =  sessionFactory.openSession();
		
		Employee employee1 = new Employee("Shyam", "shyam@gmail.com" , "Development");
		Employee employee2 = new Employee("Harsh", "harsh@gmail.com" , "Testing");
		Employee employee3 = new Employee("Sam", "sam@gmail.com" , "Oracle Admin");
		Employee employee4 = new Employee("priya", "priya@gmail.com" , "Administration");
		
		
//		Employee employee = new Employee("rajesh", "rajesh@gmail.com", "Testing");
		
		session.getTransaction().begin();
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		
		
//		Object object = session.save(employee);
//		int id = (Integer)object;
//		System.out.println("Saved Employee ID :"+id);
		
		session.getTransaction().commit();
		session.close();
		

	}

}
