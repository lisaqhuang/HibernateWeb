package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneActionEx5 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//2號離職重新回來 detail加回去,但保留instructor
			
			Instructor ins2 = session.get(Instructor.class, 2);
			
			InstructorDetail detail2 = new InstructorDetail();
			detail2.setEmail("jerry@gmail.com");
			detail2.setPhone("000000000");
			
			session.save(detail2);
			
			ins2.setInstructorDetail(detail2);
			
															
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
				
		HibernateUtil.closeSessionFactory();
	}
	

}
