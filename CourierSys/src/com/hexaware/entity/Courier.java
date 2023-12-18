package com.hexaware.entity;

public class Courier {
	private int CourierId;
	private float Weight;
	private String Status;
	private int TrackingNo;
	private String senderName;
	private String senderAddress;
	private String receiverName;
	private String receiverAddress;
	
	
	public int getCourierId() {
		return CourierId;
	}
	
	public float getWeight() {
		return Weight;
	}
	public int getTrackingNo() {
		return TrackingNo;
	}
	public String getsenderName() {
		return senderName;
	}
	public String getsenderAddress() {
		return senderAddress;
	}
	public String getreceiverName() {
		return receiverName;
	}
	public String getreceiverAddress() {
		return receiverAddress;
	}

	public String getStatus() {
		return Status;
	}
	public void setCourierId(int CourierId) {
		this.CourierId = CourierId;
	}
	public void setWeight(float w) {
		this.Weight = w;
	}
	public void setTrackingNo(int TrackingNo) {
		this.TrackingNo = TrackingNo;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	public void setsenderName(String senderName) {
		this.senderName = senderName;
	}
	public void setsenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public void setreceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public void setreceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String toString() {
		return "Courier [CourierId=" + CourierId + ", Weight" + Weight + ", TrackingNumber=" + TrackingNo + ",Status=" + Status +"]";
	}

}
