package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx3 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Department dept1 = new Department("衛服部");
		
		session.save(dept1);
		
		session.getTransaction().commit();
		
		session.clear();
		
		HibernateUtil.closeSessionFactory();
	}

}
