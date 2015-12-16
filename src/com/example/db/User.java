package com.example.db;

import org.litepal.crud.DataSupport;

public class User extends DataSupport{

	private int id;
	private int Number;
	private String Name;
	private int PhoneNum;
	private String sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		PhoneNum = phoneNum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
