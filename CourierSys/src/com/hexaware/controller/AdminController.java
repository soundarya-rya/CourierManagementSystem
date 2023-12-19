package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.SystemDao;
import com.hexaware.entity.Employee;

public class AdminController implements ICourierAdminService {
	Scanner scanner = new Scanner(System.in);
	SystemDao dao = new SystemDao();
	public int addCourierStaff() {
			Employee obj = new Employee();
			System.out.println("Enter Employee Id");
			int Empno = scanner.nextInt();
			obj.setEmpno ( Empno);
			
			System.out.println("Enter Employee name");
			String ename = scanner.nextLine();
			obj.setEname(ename);
			
			System.out.println("Enter Employee Email");
			String email = scanner.nextLine();
			obj.setemail(email);
			
			System.out.println("Enter Employee contact number");
			String contactNo = scanner.nextLine();
			obj.setcontactNo(contactNo);
			
			System.out.println("Enter Employee role");
			String role = scanner.nextLine();
			obj.setRole(role);
			
			System.out.println("Enter Employee salary");
			int salary = scanner.nextInt();
			obj.setSal(salary);
			dao.addEmployee(obj);
						
			return obj.getEmpno();
			
				}
	public void getRevenueReport() {
		System.out.println("----Revenue Report----");
		dao.revenueReport();
	}
	
	public void trackingHistoryReport() {
		System.out.print("Enter Courier Id:");
        int courierId = scanner.nextInt();
		String[] trackingHistory = new String[3];
		System.out.println("----Parcel Tracking Report----");
		for (int i = 0; i < trackingHistory.length; i++) {
			trackingHistory[i]=dao.trackParcel(courierId);
			
            if (trackingHistory[i] != null) {
                System.out.println("Update " + (i + 1) + ": " + trackingHistory[i]);
            } 	
		}
	}

}
