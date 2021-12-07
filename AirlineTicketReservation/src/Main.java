import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
	    
        Customer friend1 = new Customer("Null", "Null", "000", "Null", "Null", "Null", "Null", 0);
        Flight flight1 = new Flight("Null", "Null", "Null", "Null", "Null", "Null", "Null", 0);
        Airline airline1 = new Airline("Null", "Null");
        
		Scanner scan = new Scanner(System.in);
        System.out.println("Customer or Admin (1 or 2)");
        int choice = scan.nextInt();
        
        if (choice == 1) {
        	System.out.println("Login or Register (1 or 2)");
            int customerChoice = scan.nextInt();
            
            if (customerChoice == 1) {
            	boolean login = friend1.login();
                while (login){
                	Scanner scans = new Scanner(System.in);
                    System.out.println("Type '1' to reserve a flight | Type '2' to cancel a flight | Type '3' to see all flights | Press Enter to Log Out ");
                    int answer = scans.nextInt();
                	if (answer == 1){
                    	friend1.reserveFlight();
                    } else if (answer == 2) {
                    	friend1.cancelFlight();
                    	System.out.println("Cancel Flight");
                    } else if (answer == 3) {
                    	System.out.println("All flights");
                    	flight1.getAllFlights(friend1.customerId);
                    }else {
                    	System.out.println("Invalid Choice");
                    }
                }
                System.out.println("You have logged out!");
                      
            }
            else if (customerChoice == 2) {
                friend1.register();
//                System.out.println(friend1.getCustomer());
            }
        }else if (choice == 2){
        	boolean login = airline1.login();
        	while (login) {
        		Scanner scans = new Scanner(System.in); 
        		System.out.println("Type '1' to add flight to database | Type '2' to remove flight from database | Type '3' to remove a customer | Press Enter to Log Out "); 
        		int answer = scans.nextInt(); 

        		if (answer== 1) { 
        			flight1.createFlight(); 
        		}else if (answer == 2) { 
        			flight1.deleteFlight(); 
        		}else if (answer == 3) { 
//        			airline1.removeCustomer(); 
        		}else { 
        			System.out.println("Invalid selection, try again"); 
        		} 
        	}
        	System.out.println("You have logged out!");
        }
        
	}

}
