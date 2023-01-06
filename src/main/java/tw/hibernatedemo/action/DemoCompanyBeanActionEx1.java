package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeanActionEx1 {

	public static void main(String[] args) {

		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session =factory.openSession();
		session.beginTransaction();
		CompanyBean con1=new CompanyBean();
		con1.setCompanyId(2330);
		con1.setCompanyName("TSMC");
		
		session.save(con1);
		
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
	}

}
