package com.codegnan.app;

import java.util.Scanner;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import com.codegnan.entity.Employee;

public class Demo_02 {

	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
		
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata =  metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		Session session =  sessionFactory.openSession();
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int id = sc.nextInt();
		Employee employee = session.get(Employee.class, id);
		if(employee != null) {
			System.out.println("Employee with id "+id+" is "+employee);
		}
		else {
			System.out.println("There is no employee existing with "+id);
		}
		*/
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		List<Employee> employees = query.list();
		for(Employee employee : employees) {
			System.out.println(employee);
		}
		session.close();

	}

}
