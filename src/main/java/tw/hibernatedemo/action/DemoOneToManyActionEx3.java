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

public class DemoOneToManyActionEx3 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//知道bookuser id =1,他還一本書 SQL 100種解法
			//new bookusers
			BookUsers user1 = session.get(BookUsers.class, 2);
			Set<Books> books = user1.getBooks();
			Iterator<Books> it = books.iterator();
			while(it.hasNext()) {
				Books oneBook = it.next();
				if(oneBook.getBooktitle().contentEquals("王者歸去")) {
					oneBook.setBookusers(null);
					it.remove();
					session.delete(oneBook);
					System.out.println("success");
				}
			}
//			Books oneBook = session.get
			
			

			
			
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
