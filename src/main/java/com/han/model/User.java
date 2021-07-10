package com.han.model;


public class User {

	private int user_id;
	private String id;
	private String password;
	private String name;
	private String email;
	private Boolean admin;
	public User(int user_id, String id, String password, String name, String email, Boolean admin) {
		super();
		this.user_id = user_id;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.admin = admin;
	}
	public User(String id, String password, String name, String email, Boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.admin = admin;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", id=" + id + ", password=" + password + ", name=" + name + ", email="
				+ email + ", admin=" + admin + "]";
	}

	
	


	
	
}
