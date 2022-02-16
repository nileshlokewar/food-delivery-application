package com.app.dto;

import java.util.Scanner;

import com.app.model.OrderInfo;
import com.app.model.User;

public class RequestDto {
	Scanner sn = new Scanner(System.in);

	public User registerRequest() {
		System.out.println("enter your userName:");
		String uname = sn.next();
		System.out.println("enter your email:");
		String email = sn.next();
		System.out.println("enter your password:");
		String password = sn.next();
		System.out.println("enter your mobile:");
		long mobile = sn.nextLong();
		System.out.println("enter your address:");
		String address = sn.next();
		System.out.println("enter your role");
		String role = sn.next();
		return new User(uname, email, password, address, mobile, role);
	}

	public LoginDto loginRequest() {
		System.out.println("enter your username:");
		String uname = sn.next();
		System.out.println("enter your password:");
		String password = sn.next();
		System.out.println("enter your role");
		String role = sn.next();
		return new LoginDto(uname, password, role);

	}

	public OrderInfo addOrder() {
		System.out.println("Enter your menuId:");
		int menuid = sn.nextInt();
		System.out.println("enter your restaurantName:");
		String restaurantname = sn.next();
		System.out.println("enter your price:");
		double price = sn.nextDouble();
		System.out.println("enter your menuType: ");
		String menutype = sn.next();
		System.out.println("enter your Item:");
		String item = sn.next();
		return new OrderInfo(menuid, restaurantname, price, menutype, item);

	}

}
