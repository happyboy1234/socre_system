package com.irats.pojo;

public class User{
	private int id;
	private String username;
	private String password;
	private int power;
	
	public long getId() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int i) {
		this.power = i;
	}
	
}
