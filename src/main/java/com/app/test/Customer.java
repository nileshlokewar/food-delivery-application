package com.app.test;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.Dao.LogInDao;
import com.app.Dao.OrderDao;
import com.app.Dao.RegisterDao;
import com.app.dto.LoginDto;
import com.app.dto.RequestDto;
import com.app.dto.UserProfile;
import com.app.model.CustomerOrder;
import com.app.model.OrderInfo;
import com.app.model.User;

public class Customer {
	public static void main(String[] args) throws Exception {

		Scanner sn = new Scanner(System.in);
		RequestDto request = new RequestDto();
		RegisterDao dao = new RegisterDao();
		String CustomerName = "";
		String choice = "";
		do {
			System.out.println("Welcome to my swiggy application");
			System.out.println("press 1.Register");
			System.out.println("press 2.LogIn");
			System.out.println("--------------------------");
			System.out.println("Enter your choice");
			int key = sn.nextInt();
			switch (key) {
			case 1:
				User user = request.registerRequest();
				int i = dao.register(user);
				if (i == 1) {
					System.out.println("Data register successfully.......!");

				} else {
					System.out.println("sorry user not register....!");

				}

				break;
			case 2:
				LoginDto dto = request.loginRequest();
				LogInDao logInDao = new LogInDao();
				UserProfile profile = logInDao.login(dto);
				CustomerName = profile.getName();
				if (profile != null && profile.getRole().equalsIgnoreCase("admin")) {
					OrderInfo info = request.addOrder();
					if (info != null) {
						int res = dao.addOrder(info);
						if (res == 1) {
							System.out.println("menu added successfully:");

						} else {
							System.out.println("sorry menu not added something went wrong...!");

						}
					}
					System.out.println(info);

				} else {
					OrderDao orderDao = new OrderDao();
					List<OrderInfo> menus = orderDao.menus();
					System.out.println("Restaurant Name\t Menu id\t Menu Type\t Item\t price");
					for (OrderInfo menu : menus) {
						System.out.println(menu.getRestaurantName() + "\t" + menu.getMenuId() + "\t"
								+ menu.getMenutype() + "\t" + menu.getItem() + "\t" + menu.getPrice() + "\t");
					}
					System.out.println("------------------Select  Restaurant--------------------");
					System.out.println("Enter your Restaurant Name : ");
					String restaurant = new Scanner(System.in).next().toLowerCase();
					switch (restaurant) {
					case "jagdamba":
						String order;
						Map<String, Integer> orders = new HashMap<String, Integer>();
						List<Map<String, Integer>> listOrder = new ArrayList<Map<String, Integer>>();
						do {
							orders = custOrder(orderDao);
							listOrder.add(orders);
							System.out.println("Thank you..! You want more iterm please enter (order):");
							order = sn.next();
						} while (order.equalsIgnoreCase("order"));
						List<CustomerOrder> customerOrders = new OrderDao().placeOrer(listOrder, restaurant,
								CustomerName);
						String msg=ReciptPrint(customerOrders);
						System.out.println();
						System.out.println(customerOrders);
						break;
					case "akansha":
						List<OrderInfo> akanshamenu = orderDao.akansha();
						System.out.println("Menu Name\t Restaurant Name\t Menu Type\t price\t Item");
						for (OrderInfo menu : akanshamenu) {
							System.out.println(menu.getRestaurantName() + "\t" + menu.getMenuId() + "\t"
									+ menu.getMenutype() + "\t" + menu.getPrice() + "\t" + menu.getItem() + "\t");
						}
						break;
					case "madhu":
						List<OrderInfo> madhumenu = orderDao.madhu();
						System.out.println("Menu Name\t Restaurant Name\t Menu Type\t price\t Item");
						for (OrderInfo menu : madhumenu) {
							System.out.println(menu.getRestaurantName() + "\t" + menu.getMenuId() + "\t"
									+ menu.getMenutype() + "\t" + menu.getPrice() + "\t" + menu.getItem() + "\t");
						}
						break;

					}
				}

			default:
				System.out.println("Invalid Request");
				break;
			}
			System.out.println("Do you want to continue ?(Y/N)");
			choice = sn.next();

		} while (choice.equalsIgnoreCase("y"));

	}

	private static Map<String, Integer> custOrder(OrderDao orderDao) {
		Scanner sn = new Scanner(System.in);
		List<OrderInfo> jagdamba = orderDao.jagdamba();
		System.out.println("Menu Name\t Restaurant Name\t Menu Type\t price\t Item");
		Map<String, Integer> order = new HashMap<String, Integer>();
		for (OrderInfo menu : jagdamba) {
			System.out.println(menu.getRestaurantName() + "\t" + menu.getMenuId() + "\t" + menu.getMenutype() + "\t"
					+ menu.getPrice() + "\t" + menu.getItem() + "\t");
		}
		System.out.println("Enter your ItemName:");
		String itString = sn.next();
		System.out.println("Enter your Quantity:");
		int qty = sn.nextInt();
		order.put(itString, qty);
		return order;
		
		
	}

	private static String ReciptPrint(List<CustomerOrder> customerOrders ) throws Exception{
		File file = new File("D:\\payment\\order.txt");
		FileWriter fw = new FileWriter(file,true);
		fw.write("Welcome to Food Deliver application\n");
		fw.append("\t\t\t\t\t"+LocalDate.now());
		fw.append("Customer Name:"+customerOrders.get(1).getCustomerName());
		fw.append("\n-------------------------------------------------------\n");
		fw.append("Order id\tMenu Type\tItem Name\tPrize\t TotalBill");
		for(CustomerOrder c:customerOrders) {
			
			fw.append("\n"+c.getOrderid()+"\t"+c.getMenutype()+"\t"+c.getItemName()+"\t"+c.getPrize()+"\t"+c.getBill());
		}
		
		fw.close();
		return "success";
	}
}
