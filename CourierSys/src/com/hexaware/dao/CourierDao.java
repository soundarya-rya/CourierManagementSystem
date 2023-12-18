package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.util.MyDBConnection;

public class CourierDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	
	public void checkStatus(int OrderId) {
		String query = "SELECT Status FROM courier WHERE CourierID = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,OrderId);
			rs = ps.executeQuery();
			if (rs.next()) {
                String status = rs.getString("Status");
                System.out.println("Order Status: " + status);
            } else {
                System.out.println("Order Id not found");
            }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void checkWeight(int OrderId) {
		String query = "SELECT Weight FROM courier WHERE CourierID = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,OrderId);
			rs = ps.executeQuery();
			if (rs.next()) {
                int weight = rs.getInt("Weight");
                String Category;
                if(weight>1 && weight<50)
                	Category="Light";
                else if(weight>50 && weight<100)
                	Category="Medium";
                else 
                	Category="Heavy";
                System.out.println("Category of product: " + Category);
			}
            else {
                System.out.println("Order Id not found");
            }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void trackLocation(int id) {
		String query = "SELECT L.Locationname FROM Location L JOIN Payment P ON L.LocationId=P.LocationId WHERE CourierID = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if (rs.next()) {
                String location = rs.getString("Locationname");
                System.out.println("Current Location: " + location);
            } else {
                System.out.println("Location not found");
            }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public String parcelTracking(int id) {
		String l = null;
		String query = "SELECT L.Locationname FROM Location L JOIN Payment P ON L.LocationId=P.LocationId WHERE CourierID = ?";
		
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if (rs.next()) {
                String location = rs.getString("Locationname");
                l=location; }
			} 
		catch (SQLException e) {
			e.printStackTrace();
			}
		return l;
		
	}
	
	public void Authentication(String username, String password) {
		String query = "SELECT * FROM customers WHERE name = ? AND password = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if (rs.next()) {            
                System.out.println("Authentication successfull");
			}
            else {
                System.out.println("Invalid User found");
            }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void checkOrders(int CustId) {
		String query = "SELECT orderId FROM orders WHERE customerId=?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,CustId);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("orderId"));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
		
}
