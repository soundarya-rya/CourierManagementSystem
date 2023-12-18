package com.hexaware.entity;

public class Customer {
	private int custid;
	private String cname;
	private String password;
	private String address;
	
	public int getCustid() {
		return custid;
	}

	public String getCname() {
		return cname;
	}
	public String getPassword() {
		return password;
	}
	public String getaddress() {
		return address;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "Customer [custid=" + custid + ", cname=" + cname +"address"+ address+"]";
	}
}

