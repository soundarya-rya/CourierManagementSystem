package com.hexaware.view;
import com.hexaware.util.*;
import com.hexaware.controller.*;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
	  	CourierInterface ci = new CourierController();
	  	ICourierUserService cu= new UserController();
	  	ICourierAdminService ca= new AdminController();
	  	
        Scanner scanner = new Scanner(System.in);
        String ch = null;
        System.out.println(MyDBConnection.getMyDbConnection());
        System.out.println("Select an option:");
        System.out.println("1. Project tasks");
        System.out.println("2. Assignment tasks");
        System.out.print("Enter your choice: ");
        
        int c = scanner.nextInt();
        switch (c) {
        case 1:{
        	System.out.println("Select an option:");
            System.out.println("1. Place order");
            System.out.println("2. Get Order Status");
            System.out.println("3. Cancel Order");
            System.out.println("4. Get Assigned Order");
            System.out.println("5. Add Courier Staff(Only by Admin)");
            System.out.println("6. View Revenue by Location(Only by Admin)");
            System.out.println("7. View Parcel Tracking(Only by Admin)");
            System.out.print("Enter your choice: ");
            
            int cn = scanner.nextInt();
	            
            switch (cn) {
                case 1:
                    cu.placeOrder();
                    break;
                    
                case 2:
                    cu.getOrderStatus();
                    break;
                case 3:
                    cu.cancelOrder();
                    break;
                case 4:
                    cu.getAssignedOrder();
                    break;
                case 5:
                    ca.addCourierStaff();
                    break;
                case 6:
                	ca.getRevenueReport();
                	break;
                case 7:
                	ca.trackingHistoryReport();
                	break;
                default:
                	System.out.println("Invalid choice");
                	break;
            }
	        break;
	        }
	        	        
        case 2: {
	        	do {
	            System.out.println("Select an option:");
	            System.out.println("1. Check order delivery status");
	            System.out.println("2. Categorize parcels based on weight");
	            System.out.println("3. User Authentication");
	            System.out.println("4. Courier Assignment Logic");
	            System.out.println("5. Display orders for a specific customer");
	            System.out.println("6. Track real-time location of a courier");
	            System.out.println("7. Store tracking history of a parcel");
	            System.out.println("8. Find nearest available courier for a new order");
	            System.out.println("9. ParcelTracking");
	            System.out.println("10. Customer validation");
	            System.out.println("11. Address Formatting");
	            System.out.println("12. Order Confirmation Email");
	            System.out.println("13. Calculate Shipping Costs");
	            System.out.println("14. Password Generator");
	            System.out.println("15. Find Similar Addresses");
	            System.out.print("Enter your choice: ");
	            
	           int choice = scanner.nextInt();
	           	            
	            switch (choice) {
	                case 1:
	                    ci.checkOrderDeliveryStatus();
	                    break;
	                    
	                case 2:
	                    ci.categorizeParcelsBasedOnWeight();
	                    break;
	                case 3:
	                    ci.userAuthentication();
	                    break;
	                case 4:
	                    ci.courierAssignmentLogic();
	                    break;
	                case 5:
	                    ci.displayOrdersForCustomer();
	                    break;
	                case 6:
	                    ci.trackCourierLocation();
	                    break;
	                case 7:
	                    ci.storeParcelTrackingHistory();
	                    break;
	                case 8:
	                    ci.findNearestAvailableCourier();
	                    break;
	                case 9:
	                	ci.ParcelTracking();
	                	break;
	                case 10:
	                	ci.CustomerDataValidation();
	                	break;
	                case 11:
	                	ci.AddressFormatting();
	                	break;
	                case 12:
	                	ci.OrderConfirmationEmail();
	                	break;
	                case 13:
	                	ci.CalculateShippingCosts();
	                	break;
	                case 14:
	                	ci.PasswordGenerator();
	                	break;
	                case 15:
	                	ci.FindSimilarAddresses();
	                	break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	                    break;
	            }
	            System.out.println("Do you want to continue? (Y/y)");
	            ch=scanner.nextLine();
	        }
	       while(ch.equals("Y") || ch.equals("y"));
	       break;
	        }
           
	default:{
        System.out.println("Invalid choice. Please enter a valid option.");
        break;
	}
        }
	        
	 scanner.close();
	     }
	 }
