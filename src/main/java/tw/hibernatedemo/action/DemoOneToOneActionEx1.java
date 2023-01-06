package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneActionEx1 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor ins1 = new Instructor();
			ins1.setName("Jerry");
			
			InstructorDetail detail = new InstructorDetail();
			
			detail.setEmail("jerry666@gmail.com");
			detail.setPhone("09918555666");
			
			ins1.setInstructorDetail(detail);
			session.save(ins1);
			
			
			
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
