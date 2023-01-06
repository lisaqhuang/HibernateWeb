package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneActionEx4 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//2號離職刪除detail,但保留instructor
			
			Instructor ins2 = session.get(Instructor.class, 2);
			//先在InstructorDetail中找到
			InstructorDetail detail2 = ins2.getInstructorDetail();
			//再段開關連
			ins2.setInstructorDetail(null);
			session.delete(detail2);
			
															
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
