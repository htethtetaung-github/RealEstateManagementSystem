package com.real.estate.model;

public class Admin {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String address;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Admin(String username, String email, String password, String phone, String address, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}
	public Admin(int id, String username, String email, String password, String phone, String address, String role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", address=" + address + ", role=" + role + "]";
	}
	
	

}
