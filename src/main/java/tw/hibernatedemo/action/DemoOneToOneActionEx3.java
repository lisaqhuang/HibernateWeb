package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneActionEx3 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			InstructorDetail detail = session.get(InstructorDetail.class, 102);
																	
			Instructor ins = detail.getInstructor();
			System.out.println("Instructor Name"+ ins.getName());
			
			//知道instructor id為2,請找出相對應email 及phone
			
			
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
