package com.real.estate.model;

public class Order {
	private int id;
	private int userId;
	private int propertyId;
	private String message;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int userId, int propertyId, String message) {
		super();
		this.userId = userId;
		this.propertyId = propertyId;
		this.message = message;
	}
	
	public Order(int id, int userId, int propertyId, String message) {
		super();
		this.id = id;
		this.userId = userId;
		this.propertyId = propertyId;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", propertyId=" + propertyId + ", message=" + message + "]";
	}
	
	

}
