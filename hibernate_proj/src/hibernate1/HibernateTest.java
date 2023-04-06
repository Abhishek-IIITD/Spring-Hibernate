package hibernate1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("abc");
		user.setAddress("abc address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of user");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			// Fetch the object saved in the database
			user = null;
			session = sessionFactory.openSession();
			session.beginTransaction();
			user = (UserDetails)session.get(UserDetails.class, 1);  //session.get would 
						      //retrieve the object - first argument would be the model class name 
							//and second argument would specify the value of P.K. so that 
							//we could fetch a specific object which we want
			System.out.println("User name retrieved is " + user.getUserName());
			

		

	}

}
