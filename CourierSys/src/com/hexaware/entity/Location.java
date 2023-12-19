package com.hexaware.entity;

public class Location {
	int LocationId;
	String LocationName;
	int pathid;
	
	public int getLocationId(){ 
		return LocationId;
	}

	public String getLocationName() {
		return LocationName;
	}
	public void setLocationId(int LocationId) {
		this.LocationId = LocationId;
	}

	public void setLocationName(String LocationName) {
		this.LocationName = LocationName;
	}
	@Override
	public String toString() {
		return "Location [LocationId=" + LocationId + ", Location=" + LocationName + "]";
	}
}
