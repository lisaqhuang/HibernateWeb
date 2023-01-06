package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.model.Friend;
import tw.hibernatedemo.model.MyGroup;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoManyToManyActionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//假設只知道work群組id是3
			MyGroup group3 = session.get(MyGroup.class, 3);
			Set<Friend> friends = group3.getFriends();
			
			//從friends 裡面移除 Tina
			Iterator<Friend> it = friends.iterator();
			while(it.hasNext()) {
				Friend oneFriend = it.next();
				String friendName = oneFriend.getFriendName();
				if(friendName.equals("Tina")) {
					it.remove();
				}
				
			}
			
			//新增bill 為friend
			
			Friend friendBill = new Friend();
			friendBill.setFriendName("Bill");
			session.save(friendBill);
			
			
			
			//加bill 到work群組內
			
			friends.add(friendBill);

			
			
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


