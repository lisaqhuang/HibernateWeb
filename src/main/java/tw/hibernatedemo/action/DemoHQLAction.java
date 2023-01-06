package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Employee;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoHQLAction {

	public void hqlselectAll() {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Query<Employee> query1 = session.createQuery("from Employee");//Employee 對應entity
			
			List<Employee> result = query1.getResultList();
//			query1.list();
			
			for(Employee oneEmp:result) {
				
				System.out.println(oneEmp);
			}
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			
			System.out.println("rollback");
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		}finally {
		
		   HibernateUtil.closeSessionFactory();
		}
	}
	
	public void hqlselectBySalary() {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
//			Query<Employee> query1 = session.createQuery("from Employee e where e.salary > 30000 and e.vacation >10",Employee.class);//Employee 對應entity
			
			Query<Employee> query1 = session.createQuery("from Employee e where e.salary > 30000 and e.vacation >10",Employee.class);
			List<Employee> result = query1.getResultList();
//			query1.list();
			
			for(Employee oneEmp:result) {
				
				System.out.println(oneEmp);
			}
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			
			System.out.println("rollback");
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		}finally {
		
		   HibernateUtil.closeSessionFactory();
		}
	}
	
public void hqlselectBySalaryAndVacation(Integer salary,Integer vacation) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			Query<Employee> query1 = session.createQuery("from Employee e where e.salary > :ss and e.vacation > :vv",Employee.class)//Employee 對應entity
					.setParameter("ss",salary)
					.setParameter("vv",vacation)
					.setFirstResult(1)
					.setMaxResults(2);
					
			List<Employee> result = query1.getResultList();
//			query1.list();
			
			for(Employee oneEmp:result) {
				
				System.out.println(oneEmp);
			}
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			
			System.out.println("rollback");
			
			session.getTransaction().rollback();
			
			e.printStackTrace();
			
		}finally {
		
		   HibernateUtil.closeSessionFactory();
		}
	}
	
	
public void hqlselectUpdateSalaryByName(Integer salary,String name) {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		
		
		int query1 = session.createQuery("update  Employee  e set e.salary = :ss where e.name = :name ")//Employee 對應entity
				.setParameter("ss",salary)
				.setParameter("name",name)
				.executeUpdate();
				
					
		session.getTransaction().commit();
		
		
	} catch (Exception e) {
		
		System.out.println("rollback");
		
		session.getTransaction().rollback();
		
		e.printStackTrace();
		
	}finally {
	
	   HibernateUtil.closeSessionFactory();
	}
}

public void hqlselectByName(String name) {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		
		//模糊搜尋
		Query<Employee> query1 = session.createQuery("from Employee e where e.name like :pname",Employee.class)//Employee 對應entity
				.setParameter("pname","%"+ name +"%");
				
				
		List<Employee> result = query1.getResultList();
//		query1.list();
		
		for(Employee oneEmp:result) {
			
			System.out.println(oneEmp);
		}
		
		session.getTransaction().commit();
		
		
	} catch (Exception e) {
		
		System.out.println("rollback");
		
		session.getTransaction().rollback();
		
		e.printStackTrace();
		
	}finally {
	
	   HibernateUtil.closeSessionFactory();
	}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
       DemoHQLAction hqlAction = new DemoHQLAction();
       hqlAction.hqlselectByName("o");
	}

}
