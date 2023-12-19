package com.hexaware.entity;

public class CourierService {
	public int ServiceId;
	String ServiceName;
	float Cost;
	public int load=100;
	protected int LoadCapacity=200;
	
	public int getServiceId() {
		return ServiceId;
	}
	public int getload() {
		return load;
	}
	public int getLoadCapacity() {
		return LoadCapacity;
	}
	public void setload(int load) {
		this.load = load;
	}
	
	@Override
	public String toString() {
		return "Courier Services [ServiceId=" + ServiceId + ", ServiceName=" + ServiceName + ", Cost=" + Cost + "]";
	}
}
