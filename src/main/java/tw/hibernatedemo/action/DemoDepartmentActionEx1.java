package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.Department;

public class DemoDepartmentActionEx1 {

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Department dept1 = new Department("HR");
		Serializable id = session.save(dept1);
		System.out.println("id:"+ id);
		
//		session.save(dept1);
		
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
	}

}
