package com.demo.onetoonehibernate.OneToOneHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.onetoonehibernate.OneToOneHibernate.model.Address;
import com.demo.onetoonehibernate.OneToOneHibernate.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
    
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        System.out.println("SessionFactory created");
        Session session = sessionFactory.openSession();
        System.out.println("session slso created");
        Transaction beginTransaction = session.beginTransaction();
        
        Employee employee= new Employee();
        
        employee.setName("sachin");
        employee.setEmail("sac@gmail.com");
        Address address=new Address();
        address.setCity("Latur");
        address.setAddressLine("Near Shivaji chowk");
        address.setState("Mah");
        address.setCountry("India");
        address.setPincode(123456);
        address.setEmployee(employee);
        employee.setAddress(address);
        
        session.save(employee);
        
        beginTransaction.commit();
        
        session.close();
        sessionFactory.close();
        
        
    }
    
}
