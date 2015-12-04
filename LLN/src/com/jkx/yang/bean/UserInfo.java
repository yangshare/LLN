package com.jkx.yang.bean;

public class UserInfo {
	/**
	 * 用户信息管理类
	 */
	private String id;
	private String name;
	private String password;
	private int userNums;//用户数目
	public int getNums() {
		return userNums;
	}
	public void setNums(int nums) {
		this.userNums = nums;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
