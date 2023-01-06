package tw.hibernatedemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	
	private static SessionFactory factory = creatSessionFactory();
	
	private static final SessionFactory creatSessionFactory() {
		
		
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		return factory;		
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
		
	}
	public static void closeSessionFactory() {
		//singelton模式
		if(factory != null) {
			
			factory.close();
		}
	}

}
