package tw.hibernatedemo.action;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToManyActionEx1 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//new BookUsers
			BookUsers user1 = new BookUsers();
			user1.setUsername("王錢錢");
			//new Books
			Books book1 = new Books();
			book1.setBooktitle("王者歸去");
			book1.setPublicYear("2023-01");
			
			//new Books
			Books book2 = new Books();
			book2.setBooktitle("錢錢 100種解法");
			book2.setPublicYear("2022-10");
			
			//book set user
			
			book1.setBookusers(user1);
			book2.setBookusers(user1);
			
			//book 裝到set
			Set<Books> books = new LinkedHashSet<Books>();
			books.add(book1);
			books.add(book2);
			
			//user set book
			user1.setBooks(books);
			
			//save 一邊
			session.save(user1);
			
			
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
