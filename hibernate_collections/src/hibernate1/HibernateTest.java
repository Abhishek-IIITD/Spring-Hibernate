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
		user.setUserName("abc");
		
		Address addr1 = new Address();
		addr1.setStreet("First Street");
		addr1.setCity("First City");
		addr1.setState("First State");
		addr1.setPincode("1111");
		Address addr2 = new Address();
		addr2.setStreet("Second Street");
		addr2.setCity("Second City");
		addr2.setState("Second State");
		addr2.setPincode("2222");
		user.getListOfAddresses().add(addr1);  //Saving Collections
		user.getListOfAddresses().add(addr2);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);  //this would return a proxy object
		session.close();
		System.out.println(user.getListOfAddresses().size()); //because of eager fetch type, we would be
		                                     //able to access the proxy object even after session is closed
			

		

	}

}
