package hibernate1;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;





import dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(UserDetails.class);
		//criteria.add(Restrictions.eq("userName", "User 8"))
		//			.add(Restrictions.gt("userId", 5));
		//criteria.add(Restrictions.like("userName", "%User 1%"))
		//.add(Restrictions.between("userId", 5, 50));
		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 7, 10)));

		List<UserDetails> unames = (List<UserDetails>)criteria.list();		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
		
	*/
		
/*	//Projections
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Criteria criteria = session.createCriteria(UserDetails.class)  //will return list of user ids and not the list of UserDetails(in case of aggregation functions also)
		//		.setProjection(Projections.property("userId"));
		Criteria criteria = session.createCriteria(UserDetails.class)
						.addOrder(Order.desc("userId"));
				
		List<UserDetails> unames = (List<UserDetails>)criteria.list();		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
	*/	
		//Query By Example
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserName("User 1%");
		Example example = Example.create(exampleUser).enableLike();
		Criteria criteria = session.createCriteria(UserDetails.class)
						.add(example);
				
		List<UserDetails> unames = (List<UserDetails>)criteria.list();		
		session.getTransaction().commit();
		session.close();
		for(UserDetails user : unames){
			System.out.println(user.getUserName());
		}
	}

}
