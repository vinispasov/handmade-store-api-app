package com.project.handmadestoreapi.entities;

import java.util.List;

public class User {

	private String id;
	private String email;
	private String password;
	private List<Item> itemsInBasket;
	private List<String> itemIdsInBasket;
	private boolean isLoggedIn;

	public User() {
	}

	public User(String id, String email, String password, List<Item> itemsInBasket, boolean isLoggedIn) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.itemsInBasket = itemsInBasket;
		this.isLoggedIn = isLoggedIn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Item> getItemsInBasket() {
		return itemsInBasket;
	}

	public void setItemsInBasket(List<Item> itemsInBasket) {
		this.itemsInBasket = itemsInBasket;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		isLoggedIn = loggedIn;
	}

	public List<String> getItemIdsInBasket() {
		return itemIdsInBasket;
	}

	public void setItemIdsInBasket(List<String> itemIdsInBasket) {
		this.itemIdsInBasket = itemIdsInBasket;
	}
}
