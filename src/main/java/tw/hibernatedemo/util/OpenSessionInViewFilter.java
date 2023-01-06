package tw.hibernatedemo.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebFilter(urlPatterns="/*")
public class OpenSessionInViewFilter extends HttpFilter implements Filter {
       

	private Session session;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
     try {		
		//response以前
    	 SessionFactory factory = HibernateUtil.getSessionFactory();
    	 this.session = factory.getCurrentSession();
		
    	 session.beginTransaction();
    	 System.out.println("BeginTransaction");
    	 
		chain.doFilter(request, response);
		
		//response做以後
		session.getTransaction().commit();
		System.out.println("Transaction commit OK!");
		
     }catch(Exception e) {
    	 
    	 session.getTransaction().rollback();
    	 System.out.println("rollback");
    	 e.printStackTrace();
    	 
     }finally {
    	 System.out.println("Session close!");
     }
	}


}
