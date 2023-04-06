package hibernate1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.Address;
import dto.FourWheeler;
import dto.TwoWheeler;
import dto.UserDetails;
import dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//  Creating Objects (C of CRUD)
		// for (int i = 0; i < 10; i++) {
		//	UserDetails user = new UserDetails();
		//	user.setUserName("User " + i);
		//	session.save(user);
		//	}
		UserDetails user = (UserDetails)session.get(UserDetails.class, 5);  //Fetching (R of CRUD - Read the object depending on the primary key)
		//Update
		user.setUserName("Updated User");
		session.update(user);
		//session.delete(user); //Deleting the object
		//System.out.println("User Name : " +user.getUserName());
		session.getTransaction().commit();
		session.close();
	*/
		//Persisting detached objects - tutorial
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails)session.get(UserDetails.class, 1);  //Fetching (R of CRUD - Read the object depending on the primary key)
		session.getTransaction().commit();
		session.close();
		user.setUserName("Updated username after session close...");
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
