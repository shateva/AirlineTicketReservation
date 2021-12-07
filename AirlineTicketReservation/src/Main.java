import java.sql.*;
import java.util.Scanner;

public class Main {
	public void login() {
    	
    }

	public static void main(String[] args) {	
		System.out.println("MySQL connect example.");
		Connection conn = null;
		String url = "jdbc:mysql://remotemysql.com:3306/";
		String dbname = "ZX9ytPMHo0";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "ZX9ytPMHo0"; 
		String pass = "4HkTydGmHY";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, pass);
			System.out.println("Connected to the database");
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        int loggedIn = 0;
        Customer friend1 = new Customer("Null","Null", "000", "Null", "Null", "Null", "Null", 0);
        Flight flight1 = new Flight("Null", "Null", "Null", "Null", "Null", "Null", "Null", 0);
//        Airline airline1 = new Airline("Null", "Null", "Null");
        
		Scanner scan = new Scanner(System.in);
        System.out.println("Customer or Admin (1 or 2)");
        int choice = scan.nextInt();
        
        if (choice == 1) {
        	System.out.println("Login or Register (1 or 2)");
            int customerChoice = scan.nextInt();
            
            if (customerChoice == 1) {
                if (friend1.login()){
                	Scanner scans = new Scanner(System.in);
                    System.out.println("Type '1' to reserve a flight | Type '2' to cancel a flight | Type '3' to see all flights:  ");
                    int answer = scans.nextInt();
                	if (answer == 1){
                    	friend1.reserveFlight();
                    } else if (answer == 2) {
                    	System.out.println("Cancel Flight");
                    } else if (answer == 3) {
                    	System.out.println("All flights");
                    	flight1.getAllFlights(friend1.customerId);
                    }else {
                    	System.out.println("Invalid Choice");
                    }
                }
                      
            }
            else if (customerChoice == 2) {
                friend1.register();
//                System.out.println(friend1.getCustomer());
            }
        }else if (choice == 2){
        	System.out.println("working");
        }
        
	}

}
