package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menuId;
	private String restaurantName;
	private double price;
	private String menutype;
	private String item;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMenutype() {
		return menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public OrderInfo(int menuId, String restaurantName, double price, String menutype, String item) {
		super();
		this.menuId = menuId;
		this.restaurantName = restaurantName;
		this.price = price;
		this.menutype = menutype;
		this.item = item;
	}

	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderInfo [menuId=" + menuId + ", restaurantName=" + restaurantName + ", price=" + price + ", menutype="
				+ menutype + ", item=" + item + "]";
	}

}
