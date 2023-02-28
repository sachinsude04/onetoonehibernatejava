package com.demo.onetoonehibernate.OneToOneHibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.demo.onetoonehibernate.OneToOneHibernate.model.Address;
import com.demo.onetoonehibernate.OneToOneHibernate.model.Employee;
import com.demo.onetoonehibernate.OneToOneHibernate.model.Pancard;
import com.demo.onetoonehibernate.OneToOneHibernate.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Scanner sc=new Scanner(System.in);
	
	public void insertData()
	{
		Person person=new Person();
		System.out.println("Enter the name : ");
		String name=sc.next();
		person.setName(name);
		
		Pancard pancard=new Pancard();
		System.out.println("Enter the pan no : ");
		String panno=sc.next();
		pancard.setPanNo(panno);
		
		person.setPancard(pancard);
		pancard.setPerson(person);
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(person);
		transaction.commit();
		
		TransactionStatus status = transaction.getStatus();
		/* status==TransactionStatus.ROLLED_BACK */
		if(status==TransactionStatus.COMMITTED)
		{
			System.out.println("Successful data inserted ");
			
		}
		else
		{
			System.out.println("Failure in data insertion ");
		}
	}
	
	public void Display()
	{
		List<Person> list=factory.openSession().createCriteria(Person.class).list();
		for (Person person : list) {
			System.out.println(person.getId()+"\t"+person.getName()+"\t"+person.getPancard().getPanNo());
		}
	}
	
	public void UpdateData()
	{
		Display();
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Enter the id u wanna update the record : ");
		int id=sc.nextInt();
		Person person=(Person)session.load(Person.class, id);
		System.out.println(person.getId()+"\t"+person.getName()+"\t"+person.getPancard().getPanNo());
		//Person person=new Person();
		System.out.println("Enter the name u wanna change : ");
		String name=sc.next();
		//person.setId(id);
		person.setName(name);
		Pancard pancard=person.getPancard(); 
		System.out.println("Enter the pan no u wanna change if u want");
		String panno=sc.next();
		pancard.setPanNo(panno);
		
		person.setPancard(pancard);
		pancard.setPerson(person);
		
		session.update(pancard);
		transaction.commit();
		//boolean b=transaction.wasCommitted();
		TransactionStatus status = transaction.getStatus();
		if(status==TransactionStatus.COMMITTED)	
		{
			System.out.println("Successful data Update ");
		}
		else
		{
			System.out.println("Failure in update");
		}
	}
	
	public void  DeleteRecord()
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Display();
		System.out.println("Enter the id u wanna delete from the table");
		Person person=new Person();
		person.setId(sc.nextInt());
		session.delete(person);
		transaction.commit();
		//boolean b=transaction.wasCommitted();
		TransactionStatus status = transaction.getStatus();
		if(status==TransactionStatus.COMMITTED)	
		{
			System.out.println("deleted successfully");
		}
		else 
		{
			System.out.println("failure in deletion");
		}
	}

	public static void main(String[] args) {
		
		App test=new App();
		System.out.println("App started");
		//Need to add Switch case here 
		test.insertData();

		test.Display();
		//test.UpdateData();
		//test.DeleteRecord();
	}
	
	
	
	
	/*
	 * public static void main( String[] args ) { System.out.println( "Hello World!"
	 * );
	 * 
	 * Configuration cfg=new Configuration(); cfg.configure("hibernate.cfg.xml");
	 * 
	 * SessionFactory sessionFactory = cfg.buildSessionFactory();
	 * System.out.println("SessionFactory created"); Session session =
	 * sessionFactory.openSession(); System.out.println("session slso created");
	 * Transaction beginTransaction = session.beginTransaction();
	 * 
	 * Employee employee= new Employee();
	 * 
	 * employee.setName("sachin"); employee.setEmail("sac@gmail.com"); Address
	 * address=new Address(); address.setCity("Latur");
	 * address.setAddressLine("Near Shivaji chowk"); address.setState("Mah");
	 * address.setCountry("India"); address.setPincode(123456);
	 * address.setEmployee(employee); employee.setAddress(address);
	 * 
	 * session.save(employee);
	 * 
	 * beginTransaction.commit();
	 * 
	 * session.close(); sessionFactory.close();
	 * 
	 * 
	 * }
	 */   
}
