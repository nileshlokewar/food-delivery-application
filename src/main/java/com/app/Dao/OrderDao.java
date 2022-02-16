package com.app.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.Util.UtilityClass;
import com.app.model.CustomerOrder;
import com.app.model.OrderInfo;

public class OrderDao {
	public List<OrderInfo> menus() throws Exception {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query<OrderInfo> query = session.createQuery("From OrderInfo");

		return query.list();

	}

	public List<OrderInfo> jagdamba() {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query<OrderInfo> query = session.createQuery("From OrderInfo where restaurantName='jagdamba'");

		return query.list();
	}

	public List<OrderInfo> akansha() {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query<OrderInfo> query = session.createQuery("From OrderInfo where restaurantName='akansha' ");

		return query.list();
	}

	public List<OrderInfo> madhu() {
		Session session = UtilityClass.getSession();
		Transaction tx = session.beginTransaction();
		Query<OrderInfo> query = session.createQuery("From OrderInfo where restaurantName='madhu' ");

		return query.list();
	}

	public List<OrderInfo> orderId(){
		Session session =UtilityClass.getSession();
		Transaction tx =session.beginTransaction();
		Query<OrderInfo> query = session.createQuery("select * from CustomerOrder where orderId = ?");
		return query.list();
	}
	public List<CustomerOrder> placeOrer(List<Map<String, Integer>> orders, String restaurant,String customername) {
		// TODO Auto-generated method stub
		
	
		CustomerOrder customerOrder = new CustomerOrder();

		OrderInfo orderInfo = new OrderInfo();
		List<CustomerOrder> list = new ArrayList();
		for (Map<String, Integer> or : orders) {
			Session session = UtilityClass.getSession();
			Transaction tx = session.beginTransaction();
			for (Entry<String, Integer> s : or.entrySet()) {
				Query<OrderInfo> query = session.createQuery(
						"From OrderInfo where restaurantName='" + restaurant + "' and item='" + s.getKey() + "'");
				orderInfo = query.list().get(0);
				customerOrder.setItemName(orderInfo.getItem());
				customerOrder.setMenutype(orderInfo.getMenutype());
				customerOrder.setPrize(orderInfo.getPrice());
				customerOrder.setBill(orderInfo.getPrice() * s.getValue());
				customerOrder.setCustomerName(customername);
				list.add(customerOrder);
				session.save(customerOrder);
				tx.commit();
				

			}
		}
	
				return list;
	}

}
