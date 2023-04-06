package hibernate1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.Address;
import dto.UserDetails;
import dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		user.setUserName("abc");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		//vehicle.getUserList().add(user);
		//vehicle2.getUserList().add(user);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save(user);
		//session.save(vehicle);
		//session.save(vehicle2);
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}

}
