package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyActionEx2 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//知道bookuser id =1,請印出他借的書名
			//new bookusers
			BookUsers user1 = session.get(BookUsers.class, 1);
			
			
			Set<Books> books = user1.getBooks();
			//way1
			for(Books oneBook:books) {
				System.out.println("booktitle:"+ oneBook.getBooktitle());
			}
			
			
			//way2
//			user1.getBooks().forEach(b -> System.out.println("booktitle:"+ b.getBooktitle()));
			
			//way3
//			Iterator<Books> it = books.iterator();
//			while(it.hasNext()) {
//				Books oneBook = it.next();
//				System.out.println("booktitle:"+ oneBook.getBooktitle());
//			}
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			
			System.out.println("rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
						
		    HibernateUtil.closeSessionFactory();
		}
	}

}
