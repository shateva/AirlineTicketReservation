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
		
		
		
		 // TODO Auto-generated method stub

		
		String firstName = "null";
        String lastName = "null";
        String Sex = "null";
        String number = "null";
        String DOB = "null";
        String Email = "null";
        String password = "null";
        
        int loggedIn = 0;
        Customer friend1 = new Customer("Null","Null", "000", "Null", "Null", "Null", "Null", 0);
        
		Scanner scan = new Scanner(System.in);
        System.out.println("Customer or Admin (1 or 2)");
        int choice = scan.nextInt();
        
        if (choice == 1) {
        	System.out.println("Login or Register (1 or 2)");
            int customerChoice = scan.nextInt();
            
            if (customerChoice == 1) {
            	Scanner scans = new Scanner(System.in);
            	
            	System.out.println("Enter Email");
                String enteredEmail = scans.nextLine();
                
                System.out.println("Enter Password");
                String enteredPassword = scans.nextLine();
                
                String userEmail = "null";
                String userPassword = "null";
                String id = "null";
                
                try {
                	Statement s=conn.createStatement();
                	String sql = "SELECT * FROM customers WHERE email =  '"+enteredEmail+"'";
                    ResultSet rs = s.executeQuery(sql);
                    
                    while(rs.next()) {
                		if (rs.getString("password").equals(enteredPassword)) {
                			System.out.println("logged in");
                			loggedIn = 1;
                		}
                    }
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (loggedIn == 1){
                    System.out.println("Type '1' to reserve a flight | Type '2' to cancel a flight | Type '3' to see all flights:  ");
                    int answer = scans.nextInt();
                	if (answer == 1){
                    	friend1.reserveFlight();
                    } else if (answer == 2) {
                    	System.out.println("Cancel Flight");
                    } else if (answer == 3) {
                    	System.out.println("Enter Destination");
                        String enteredDestination = scans.nextLine();
                        
                        try {
                        	Statement s=conn.createStatement();
                        	String sql = "SELECT * FROM flights";
                            ResultSet rs = s.executeQuery(sql);
                            
                            while(rs.next()) {
                        		String flightId = rs.getString("id_flights");
                        		String flightDestination = rs.getString("destination");
                        		String flightDeparture = rs.getString("departureLoc");
                        		String flightDepartureTime = rs.getString("departureTime");
                        		String flightArrivalTime = rs.getString("arrivalTime");
                        		String flightDuration = rs.getString("duration");
                        		String flightDate = rs.getString("date");
                        		String flightSeats = rs.getString("seats");
                        		
                        		System.out.println("ID | Destination | Departure | Departure | Time | Arrival | Time | Duration | Date | Seats");
                        		System.out.format("%s | %s | %s | %s | %s | %s | %s | %s\n", flightId, flightDestination, flightDeparture, flightDepartureTime, flightArrivalTime, flightDuration, flightDate, flightSeats);
                   
                            }
                            s.close();
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    	
                    }else {
                    	System.out.println("Invalid Choice");
                    }
                }
                      
            }
            else if (customerChoice == 2) {
                friend1.register();
                System.out.println(friend1.getCustomer());
                firstName = friend1.firstName;
                lastName = friend1.lastName;
                Sex = friend1.Sex;
                number = friend1.phoneNumber;
                DOB = friend1.DOB;
                Email = friend1.Email;
                password = friend1.password;
                
                try {
                    
                    Statement s=conn.createStatement();
                    s.executeUpdate("INSERT INTO `customers`() VALUE (default, '"+firstName+"','"+lastName+"','"+Sex+"','"+number+"','"+DOB+"','"+Email+"','"+password+"')");
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }    
            }
        }else if (choice == 2){
        	System.out.println("working");
        }
        
	}

}
