package com.hexaware.controller;
import java.security.SecureRandom;

import java.util.Scanner;
import com.hexaware.dao.CourierDao;
import com.hexaware.entity.*;

public class CourierController implements CourierInterface {
	Employee employee;
	Customer customer;
	Courier courier;
	CourierService service;
	Location location;
	Payment payment;
	
	Scanner scanner = new Scanner(System.in);
	CourierDao dao = new CourierDao();
	 // TASK 01
	public void checkOrderDeliveryStatus() {
		System.out.print("Enter order Id:");
        int OrderId = scanner.nextInt();
        dao.checkStatus(OrderId);
	}
	 // TASK 02
	public void categorizeParcelsBasedOnWeight() {
		System.out.print("Enter order Id:");
        int OrderId = scanner.nextInt();
        dao.checkWeight(OrderId);
	}
	 // TASK 03
	public void userAuthentication() {
			employee = new Employee();
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();
	        dao.Authentication(username,password);		
	}
	 // TASK 04
	public void courierAssignmentLogic() {
		System.out.print("Enter courier weight");
        int n = scanner.nextInt();
        //int a=service.getLoadCapacity();
       	if(n>200){
				//service.setload(n+service.getload());
				System.out.print("Courier assigned to courier ");
			}
			else 
				System.out.print("Courier cannot be  assigned ");
				
		}
	 // TASK 05
	public void displayOrdersForCustomer() {
		System.out.print("Enter customer Id:");
        int CustId = scanner.nextInt();
        dao.checkOrders(CustId);
		
	}
	 // TASK 06
	public void trackCourierLocation() {
		System.out.print("Enter Courier Id:");
        int courierId = scanner.nextInt();
        dao.trackLocation(courierId);
		
	}
	 // TASK 07
	public void storeParcelTrackingHistory() {
		System.out.print("Enter Courier Id:");
        int courierId = scanner.nextInt();
		String[] trackingHistory = new String[3];
		for (int i = 0; i < trackingHistory.length; i++) {
			trackingHistory[i]=dao.parcelTracking(courierId);
			
            if (trackingHistory[i] != null) {
                System.out.println("Update " + (i + 1) + ": " + trackingHistory[i]);
            } 	
		}
	}
	 // TASK 08
	public void findNearestAvailableCourier() {
		
		
	}
	 // TASK 09
    public void ParcelTracking() {
	       String[][] trackingArray = {
	            {"101", "In transit"},
	            {"102", "Out for delivery"},
	            {"103", "Delivered"}
	        };

	        System.out.print("Enter parcel tracking number: ");
	        String TrackingNo = scanner.nextLine();

	        for (String[] tracking : trackingArray) {
	            if (tracking[0].equals(TrackingNo)) {
	                switch (tracking[1]) {
	                    case "In transit":
	                        System.out.println("Parcel with tracking number " + TrackingNo + " is in transit.");
	                        break;
	                    case "Out for delivery":
	                        System.out.println("Parcel with tracking number " + TrackingNo + " is out for delivery.");
	                        break;
	                    case "Delivered":
	                        System.out.println("Parcel with tracking number " + TrackingNo + " has been delivered.");
	                        break;
	                    default:
	                        System.out.println("Unknown status for tracking number " + TrackingNo);
	                        break;
	                }
	              }
	        }
    	}
    // TASK 10
    public void CustomerDataValidation() {
    	customer = new Customer();
    	System.out.print("Enter username: ");
    	customer.setCname(scanner.nextLine());
        System.out.print("Enter detail: ");
        customer.setaddress(scanner.nextLine());
        if(customer.getCname().matches("[A-Z]//[a-z]+")&& customer.getaddress().matches("[A-Za-z0-9\\s] + ")) {
			System.out.println("Validate Customer");
		}
		else {
            System.out.println("Invalid Customer");
		} 
    }
    //TASK 11
    public void AddressFormatting() {
    	System.out.println("Enter street");
    	String street = scanner.nextLine();
    	System.out.println("Enter city");
    	String city = scanner.nextLine();
    	System.out.println("Enter state");
    	String state = scanner.nextLine();
    	System.out.println("Enter zipcode");
    	String zipcode = scanner.nextLine();
    	street = capitalizeFirstLetter(street);
        city = capitalizeFirstLetter(city);
        state = capitalizeFirstLetter(state);
        zipcode = formatZipCode(zipcode);
        System.out.println(street + ", " + city + ", " + state + " " + zipcode);
        
    }
    public String capitalizeFirstLetter(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }
    private static String formatZipCode(String zipcode) {
        if (zipcode.length() > 6) {
        	zipcode = zipcode.substring(0, 6);
        } else if (zipcode.length() < 6) {
        	zipcode = String.format("%6s", zipcode).replace(' ', '0');
        }
        return zipcode;
    }
 
    // TASK 12
    public void OrderConfirmationEmail() {
    	
    	
    }
    // TASK 13
    public void CalculateShippingCosts() {
    	
    }
    // TASK 14
    public void PasswordGenerator() {
    	SecureRandom random = new SecureRandom();
    	System.out.println("Enter length(above 8)");
    	int length = scanner.nextInt();
    	        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
    	        String numbers = "0123456789";
    	        String specialChars = "!@#$%^&*()_+-=[]{};:,.<>?";

    	        String allChars = uppercaseChars + lowercaseChars + numbers + specialChars;
    	        StringBuilder password = new StringBuilder();

    	        for (int i = 0; i < length; i++) {
    	            int randomIndex = random.nextInt(allChars.length());
    	            password.append(allChars.charAt(randomIndex));
    	        }

    	        System.out.println( password.toString());
    	    }
    	
    // TASK 15
    public void FindSimilarAddresses() {
    	System.out.println("Enter zipcode of 2 address");
    	int zip1 = scanner.nextInt();
    	int zip2 = scanner.nextInt();
    	int n=zip1-zip2;
    	if(n==0){
    		System.out.println("At same location");    		
    	}
    	else if(n<10 || n>-10) {
    		System.out.println("At nearby location");    
    	}
    	else {
    		System.out.println("Different location");    
    	}
     }
    	
   	 
}