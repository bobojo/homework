package com.maven.domain;


public class Account { 
	private String id; 
	private String name; 
	private int money; 
	private String createtime; 
	private String updatetime; 
	
	public Account() {}
	public Account(String id,String name,int money,String createtime,String updatetime) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.createtime = createtime;
		this.updatetime = updatetime;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getCreateTime() {
		return createtime;
	}
	public void setCreateTime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdateTime() {
		return updatetime;
	}
	public void setUpdateTime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + "]";
	}
	
	
	
}