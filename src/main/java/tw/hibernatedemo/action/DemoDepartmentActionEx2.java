package tw.hibernatedemo.action;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.Department;

public class DemoDepartmentActionEx2 {

	// 新增一筆資料
	public static void main(String[] args) {

//		
		try (StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

			 SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			 Session session = factory.openSession();) {

			session.beginTransaction();

			Department dept2 = new Department("ACCOUNT");

			session.save(dept2);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		session.close();

//		factory.close();

	}

}
