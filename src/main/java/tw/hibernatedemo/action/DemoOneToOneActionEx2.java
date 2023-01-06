package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneActionEx2 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			Instructor ins1 = session.get(Instructor.class, 1);
			if(ins1 != null) {
				session.delete(ins1);
			}
																	
			
			
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
