package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
		    session.beginTransaction();
		    
		    Department dept = new Department("Sales");
		    
		    session.save(dept);
		
		    session.getTransaction().commit();
		
		}catch(Exception e) {
			
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
