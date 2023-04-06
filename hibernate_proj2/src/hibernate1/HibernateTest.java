package hibernate1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.Address;
import dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		//user.setUserId(1);   //We have made user Id as the surrogate key in the model class by specifying annotation @GeneratedValue
		user.setUserName("abc");
		//UserDetails user2 = new UserDetails();
		//user2.setUserName("xyz");
		Address addr = new Address();
		addr.setStreet("Street Name");
		addr.setCity("City Name");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street Name");
		addr2.setCity("Second City Name");
		
	    user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(user2);
		session.getTransaction().commit();
		session.close();
			

		

	}

}
