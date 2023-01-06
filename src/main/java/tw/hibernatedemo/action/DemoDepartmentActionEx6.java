package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;
/*
 * CRUD
 */
public class DemoDepartmentActionEx6 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//1.獲取資料
//			Department dept1 = session.get(Department.class, 1);
//			System.out.println("id:"+ dept1.getId());
//			System.out.println("name:"+ dept1.getName());
			
			//2.刪除資料
//			Department dept1 = session.get(Department.class, 1);
//			session.delete(dept1);
			
			//3.修改資料
			Department dept1 = session.get(Department.class, 2);
			dept1.setName("人資");
			
			
			
			session.getTransaction().commit();					
			
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
		
		   HibernateUtil.closeSessionFactory();
		}
	}

}
