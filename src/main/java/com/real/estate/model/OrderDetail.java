package com.real.estate.model;

public class OrderDetail {
	
	private int orderId;
	private String userName;
	private String email;
	private String propertyName;
	private String description;
	private int area;
	private int price;
	private int roomNumber;
	private int bedRoomNumber;
	private String message;
	public OrderDetail(int orderId, String userName, String email, String propertyName, String description, int area,
			int price, int roomNumber, int bedRoomNumber, String message) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.propertyName = propertyName;
		this.description = description;
		this.area = area;
		this.price = price;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.message = message;
	}
	public OrderDetail(String userName, String email, String propertyName, String description, int area, int price,
			int roomNumber, int bedRoomNumber, String message) {
		super();
		this.userName = userName;
		this.email = email;
		this.propertyName = propertyName;
		this.description = description;
		this.area = area;
		this.price = price;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.message = message;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getBedRoomNumber() {
		return bedRoomNumber;
	}
	public void setBedRoomNumber(int bedRoomNumber) {
		this.bedRoomNumber = bedRoomNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
