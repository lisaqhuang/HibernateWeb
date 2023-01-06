package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.util.HibernateUtil;

public class TestCompanyDaoAction {

	public static void main(String[] args) {
		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			CompanyDao comDao = new CompanyDao(session);
//			CompanyBean com1 = new CompanyBean(1004,"CloudFlare");
//			comDao.updateOne(1004,"CloudFlare");
			
			CompanyBean result = comDao.select(2408);
			if(result !=null) {
				System.out.println("Name:"+ result.getCompanyName());
			}else {
				System.out.println("沒有這筆資料");
			}
			
			//test updateone
//			CompanyBean result = comDao.updateOne(1002, "Alphabet");
//			if(result != null) {
//				System.out.println("更新成功");
//			}else {
//				System.out.println("更新失敗");
//			}
			
			
			
			//test delete
//			boolean booResult = comDao.deleteOne(1002);
//			if(booResult) {
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("沒有這筆資料，刪除失敗");
//			}
			
			//test select all
//             List<CompanyBean> resultList = comDao.selectAll();
//			
//			for(CompanyBean oneBean:resultList) {
//				System.out.println("id: " + oneBean.getCompanyId() + " Name: " + oneBean.getCompanyName());
//			}
			
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
