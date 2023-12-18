package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.*;

import com.hexaware.entity.*;

public class UserController implements ICourierUserService {
	Scanner scanner = new Scanner(System.in);
	Courier courier;
	Employee employee;
	SystemDao dao= new SystemDao();
	public void placeOrder() {
		courier = new Courier();
		System.out.println("Enter your name");
		String sname= scanner.nextLine();
		courier.setsenderName(sname);
		
		System.out.println("Enter your address");
		String sadd= scanner.nextLine();
		courier.setsenderAddress(sadd);
		
		System.out.println("Enter receiver name");
		String rname= scanner.nextLine();
		courier.setreceiverName(rname);
		
		System.out.println("Enter receiver address");
		String radd= scanner.nextLine();
		courier.setreceiverAddress(radd);
		
		System.out.println("Enter parcel weight");
		float w= scanner.nextFloat();
		courier.setWeight(w);
		
		dao.addOrder(courier);
	}
	public void getOrderStatus() {
		courier = new Courier();
		System.out.println("Enter your Tracking number");
		int t = scanner.nextInt();
		courier.setTrackingNo(t);
		dao.orderstatus(courier);
		
	}
	public void cancelOrder() {
		courier = new Courier();
		System.out.println("Enter your Tracking number");
		int t = scanner.nextInt();
		courier.setTrackingNo(t);
		dao.cancel(courier);
	}
	public void getAssignedOrder() {
		employee = new Employee();
		System.out.println("Enter Employee Id");
		int id = scanner.nextInt();
		employee.setEmpno(id);
		dao.assignedOrder(employee);
		
	}
}
