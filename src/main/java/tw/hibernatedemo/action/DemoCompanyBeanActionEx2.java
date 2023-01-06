package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeanActionEx2 {

	public static void main(String[] args) {

		StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		CompanyBean con1 = new CompanyBean(2408,"南亞科");
		session.save(con1);
		session.getTransaction().commit();
		session.close();
		factory.close();

		}

}
