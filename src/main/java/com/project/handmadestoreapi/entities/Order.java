package com.project.handmadestoreapi.entities;

import java.util.List;

public class Order {
	private String orderId;
	private String orderNumber;
	private String name;
	private String email;
	private String address;
	private String city;
	private List<Item> items;
	private double total;

	public Order() {
	}

	public Order(String orderId, String orderNumber, String name, String email, String address, String city, List<Item> items, double total) {
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.items = items;
		this.total = total;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
