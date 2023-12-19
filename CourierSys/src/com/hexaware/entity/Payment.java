package com.hexaware.entity;

public class Payment {
	private int PayId;
	private float Amount;
	private String PayDate;
	
	public int getPayId() {
		return PayId;
	}
	public float getAmount() {
		return Amount;
	}
	public String getPayDate() {
		return PayDate;
	}
	public void setPayId(int PayId) {
		this.PayId = PayId;
	}
	public void setPayDate(String PayDate) {
		this.PayDate = PayDate;
	}
	public void setAmount(int Amount) {
		this.Amount = Amount;
	}
	
	public String toString() {
		return "Payment [Payment Id" + PayId + ", Amount=" + Amount +" , Payment Date" + PayDate+ " ]";
	}
}
