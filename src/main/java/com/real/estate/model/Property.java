package com.real.estate.model;

import java.sql.Blob;

public class Property {
	
	private int propertyId;
	private String propertyName;
	private String description;
	private int price;
	private String propertyStatus;
	private String address;
	private String base64Image;
	private Blob propertyImg;
	private int area;
	private int roomNumber;
	private int bedRoomNumber;
	private String propertyType;
	
	
	public Property(int propertyId, String propertyName, String description, int price, String propertyStatus,
			String address, Blob propertyImg, int area, int roomNumber, int bedRoomNumber,
			String propertyType) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.description = description;
		this.price = price;
		this.propertyStatus = propertyStatus;
		this.address = address;
		this.propertyImg = propertyImg;
		this.area = area;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.propertyType = propertyType;
	}
	
	public Property(String propertyName, String description, int price, String propertyStatus, String address,
			Blob propertyImg, int area, int roomNumber, int bedRoomNumber, String propertyType) {
		super();
		this.propertyName = propertyName;
		this.description = description;
		this.price = price;
		this.propertyStatus = propertyStatus;
		this.address = address;
		this.propertyImg = propertyImg;
		this.area = area;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.propertyType = propertyType;
	}
	
	

	public Property(int propertyId, String propertyName, String description, int price, String propertyStatus,
			String address, int area, int roomNumber, int bedRoomNumber, String propertyType) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.description = description;
		this.price = price;
		this.propertyStatus = propertyStatus;
		this.address = address;
		this.area = area;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.propertyType = propertyType;
	}

	public Property(int propertyId, String propertyName, String description, int price, String propertyStatus, String address,
			String base64Image, int area, int roomNumber, int bedRoomNumber, String propertyType) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.description = description;
		this.price = price;
		this.propertyStatus = propertyStatus;
		this.address = address;
		this.base64Image = base64Image;
		this.area = area;
		this.roomNumber = roomNumber;
		this.bedRoomNumber = bedRoomNumber;
		this.propertyType = propertyType;
	}

	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Blob getPropertyImg() {
		return propertyImg;
	}
	public void setPropertyImg(Blob propertyImg) {
		this.propertyImg = propertyImg;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public int getBedRoomNumber() {
		return bedRoomNumber;
	}
	public void setBedRoomNumber(int bedRoomNumber) {
		this.bedRoomNumber = bedRoomNumber;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyName=" + propertyName + ", description=" + description
				+ ", price=" + price + ", propertyStatus=" + propertyStatus + ", address=" + address + ", base64Image="
				+ base64Image + ", propertyImg=" + propertyImg + ", area=" + area + ", roomNumber=" + roomNumber
				+ ", bedRoomNumber=" + bedRoomNumber + ", propertyType=" + propertyType + "]";
	}
	
		
}
