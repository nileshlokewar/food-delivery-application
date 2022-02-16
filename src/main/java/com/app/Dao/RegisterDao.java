package com.app.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.Util.UtilityClass;
import com.app.model.OrderInfo;
import com.app.model.User;

public class RegisterDao {
	public int register(User user) {
		try {
			Session session=UtilityClass.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			
			tx.commit();
			UtilityClass.closeSession();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	public int addOrder(OrderInfo info) {
		try {
			Session session =UtilityClass.getSession();
			Transaction tx =session.beginTransaction();
			session.save(info);
			
			tx.commit();
			UtilityClass.closeSession();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 0;
		
		
		
		
	
	}
	

}
