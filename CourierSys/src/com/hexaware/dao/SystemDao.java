package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Courier;
import com.hexaware.entity.Employee;
import com.hexaware.util.MyDBConnection;

public class SystemDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	int courierid=5;
	int tno=789;
	String sta="Processing";
	public void addOrder(Courier courier) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into courier values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,courierid);
			ps.setString(2, courier.getsenderName());
			ps.setString(3,courier.getsenderAddress());
			ps.setString(4,courier.getreceiverName());
			ps.setString(5,courier.getreceiverAddress());
			ps.setFloat(6,courier.getWeight());
			ps.setString(7,sta);
			ps.setInt(8,tno);
			ps.setString(9,null);
			ps.setInt(10, 1);
			ps.setInt(11,1);
			courierid++;
			tno=tno+7;
			int noofrows = ps.executeUpdate();
			
			System.out.println(noofrows + " inserted successfully !!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void orderstatus(Courier courier) {
		String query = "SELECT Status FROM courier WHERE TrackingNumber = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,courier.getTrackingNo());
			rs = ps.executeQuery();
			if (rs.next()) {
                String status = rs.getString("Status");
                System.out.println("Order Status: " + status);
            } else {
                System.out.println("Tracking Id not found");
            }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void cancel(Courier courier) {
		boolean flag=false;
		String query = "DELETE FROM courier WHERE TrackingNumber= ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,courier.getTrackingNo());
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0)
				flag=true;
			System.out.println("Status "+flag+" Deleted successfully");
		    
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void assignedOrder(Employee employee) {
		String query = "SELECT * FROM courier WHERE EmployeeId = ?";
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement(query);
			ps.setInt(1,employee.getEmpno());
			rs = ps.executeQuery();
			
			while(rs.next()){
				int orderid= rs.getInt("courierid");
				String status = rs.getString("Status");
				String trackingNumber = rs.getString("TrackingNumber");
			    System.out.println("Courier Id:"+orderid+ "Tracking Number: " + trackingNumber + ", Status: " + status);
                
            } //else {
                //System.out.println("Employee Id not found");
           // }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void addEmployee(Employee obj) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
			ps.setInt(1,obj.getEmpno());
			ps.setString(2, obj.getEname());
			ps.setString(3,obj.getemail());
			ps.setString(4,obj.getcontactNo());
			ps.setString(5,obj.getrole());
			ps.setInt(6,obj.getSalary());
			int rs = ps.executeUpdate();
							
			System.out.println( rs+" rows inserted successfully !!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
			
	}
	
