package com.project.handmadestoreapi.entities;

public class Item {

	private String id;
	private String title;
	private String description;
	private double price;
	private boolean isFavorite;
	private int quantity;
	private String picture;
	private String category;

	public Item() {
	}

	public Item(String id, String title, String description, Double price, Boolean isFavorite, Integer quantity, String picture, String category) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.isFavorite = isFavorite;
		this.quantity = quantity;
		this.picture = picture;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean favorite) {
		isFavorite = favorite;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
