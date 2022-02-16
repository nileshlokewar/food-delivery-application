package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	private String menutype;
	private String itemName;
	private String customerName;
	private double prize;
	private double bill;
	private double totalbill;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	public CustomerOrder(int orderid, String menutype, String itemName, String customerName, double prize, double bill,
			double totalbill) {
		super();
		this.orderid = orderid;
		this.menutype = menutype;
		this.itemName = itemName;
		this.customerName = customerName;
		this.prize = prize;
		this.bill = bill;
		this.totalbill = totalbill;
	}
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerOrder [orderid=" + orderid + ", menutype=" + menutype + ", itemName=" + itemName
				+ ", customerName=" + customerName + ", prize=" + prize + ", bill=" + bill + ", totalbill=" + totalbill
				+ "]";
	}
	
}
