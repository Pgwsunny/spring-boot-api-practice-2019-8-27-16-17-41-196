package com.tw.apistackbase.model;

public class Employees {
	private int id;
	private String name;
	private int sex;
	
	public Employees() {
		
	}
	public Employees(int id, String name, int sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}
