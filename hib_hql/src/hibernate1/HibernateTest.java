package hibernate1;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String minUserId = " 5 or 1 = 1";
		//Query query = session.createQuery("select userName from UserDetails");
		Query query = session.createQuery("from UserDetails where userId > " + minUserId);
		//query.setFirstResult(5);  //leaving top 5 records
		//query.setMaxResults(4);
		
		//List<String> unames = (List<String>)query.list();
		List<UserDetails> unames = (List<UserDetails>)query.list();		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
	*/
		/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String minUserId = "5";
		String userName = "User 9";
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		List<UserDetails> unames = (List<UserDetails>)query.list();		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
		*/
		
		//Named Queries----
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("UserDetails.byName");
		//query.setInteger(0, 2);
		query.setString(0, "User 9");
		
		
		List<UserDetails> unames = (List<UserDetails>)query.list();		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
		
	}

}
