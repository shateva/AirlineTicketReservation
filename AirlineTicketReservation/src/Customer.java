import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    // this is a test
    
    // template for using scanner class for asking user to input name
        
    String firstName;
    String lastName;
    String Sex;
    String DOB;
    String Email;
    String phoneNumber;
    String password;
    int customerId;
    
   // int Payment;
   // String[] flights;

   
    
    public Customer(String firstName, String lastName, String phoneNumber, String Sex, String DOB, String Email, String password /*String password*/, int customerId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.DOB = DOB;
		this.Email = Email;
		this.Sex = Sex;
		this.password = password;
		this.customerId = customerId;
		
	}
    
  
    
    public void cancelFlight() {
 
		String flightHold = null;
		    	
		Connection conn = null;
		String url = "jdbc:mysql://remotemysql.com:3306/";
		String dbname = "ZX9ytPMHo0";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "ZX9ytPMHo0"; 
		String pass = "4HkTydGmHY";
		
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, pass);
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // TODO Auto-generated method stub

        	
            Scanner scan2 = new Scanner(System.in);
    	    System.out.println("Enter the flight id of the flight you want to cancel: ");
    	    flightHold = scan2.nextLine();
    	   
			try {
				 
	    	    Statement y=conn.createStatement();
				y = conn.createStatement();
				y.executeUpdate("DELETE FROM `orders` WHERE id_flights = '"+flightHold+"' AND id_customers = '"+this.customerId+"'");
				y.executeUpdate("UPDATE flights SET seats = seats + 1  WHERE id_flights ='"+flightHold+"'");

				  
	            y.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
            
 
    
    public void reserveFlight() {
    	
		String flightHold = null;
		String departHold = null;
		String chosenFlight = null;
		    	
       
		Connection conn = null;
		String url = "jdbc:mysql://remotemysql.com:3306/";
		String dbname = "ZX9ytPMHo0";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "ZX9ytPMHo0"; 
		String pass = "4HkTydGmHY";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, pass);
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // TODO Auto-generated method stub
		
		
    	
		
		try {
			 Statement z=conn.createStatement();
             ResultSet rz = z.executeQuery("SELECT destination FROM flights WHERE seats > 0");
         
             String holdCurrDest = "";
             
            while (rz.next()) {
                String destination = rz.getString("destination");
                if (holdCurrDest.contains(destination) == false) {
                    holdCurrDest += destination;
                    System.out.format(" %s |", destination);
                }
            }
            
            
            Scanner scan2 = new Scanner(System.in);
            System.out.println("\nEnter destination (available destinations are printed above): ");
            flightHold = scan2.nextLine();
            
            
            String holdCurrDepart = "";
            
            Statement t=conn.createStatement();
            ResultSet tz = t.executeQuery("SELECT departureLoc FROM flights WHERE destination = '"+flightHold+"' AND seats > 0");
            
            while (tz.next()) {
                String departureLoc = tz.getString("departureLoc");
                if (holdCurrDepart.contains(departureLoc) == false && departureLoc != flightHold) {
                    holdCurrDepart += departureLoc;
                    System.out.format(" %s | ", departureLoc);
                }
   
            }
            
          
             Scanner scan3 = new Scanner(System.in);
             System.out.println("\nEnter departure location (available departure locations are printed above): ");
             departHold = scan3.nextLine();
             
			
			
        	Statement s=conn.createStatement();
        	Statement n = conn.createStatement();
  
        	ResultSet rs = s.executeQuery("SELECT * FROM flights WHERE destination = '"+flightHold+"' AND departureLoc = '"+departHold+"' AND seats > 0");
        	int continueFunc = 0;
        	
        	while (rs.next()) {
        		int id_flights = rs.getInt("id_flights");
        		String destination2 = rs.getString("destination");
            	String departureLoc = rs.getString("departureLoc");
            	String departureTime = rs.getString("departureTime");
            	String arrivalTime = rs.getString("arrivalTime");
            	String duration = rs.getString("duration");
            	String date = rs.getString("date");
            	String seats = rs.getString("seats");
            	
            	System.out.println("ID | Destination | Departure | Departure | Time | Arrival | Time | Duration | Date | Seats");
            	System.out.format("%d | %s | %s | %s | %s | %s | %s | %s\n", id_flights, destination2, departureLoc, departureTime, arrivalTime, duration, date, seats);
            	
            	
            	String sql2 = "SELECT * FROM orders";
            	ResultSet nrs = n.executeQuery(sql2);
            	
            	while (nrs.next()) {
            		if (nrs.getInt("id_flights") == (id_flights) && nrs.getInt("id_customers") == (this.customerId)) {
            			System.out.println("You have already booked this flight.");
            			continueFunc = 1;
            		}
            	}
            	
            	

        	}
        	
      
        	if (continueFunc == 0) {
	        	Scanner scan4 = new Scanner(System.in);
	            System.out.println("Enter the ID number of the flight you want to reserve a seat for:  ");
	            chosenFlight = scan4.nextLine();
	            
	            s.executeUpdate("UPDATE flights SET seats = seats - 1 WHERE id_flights ='"+chosenFlight+"'");
	            s.executeUpdate("INSERT INTO `orders`() VALUE (default, '"+this.customerId+"', '"+chosenFlight+"')");
	            System.out.println("Your flight has been reserved");
        	}
            n.close();         
            s.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public String getCustomer(){
		return firstName + lastName + phoneNumber;//+ password;
	}
    
    public void register() {
		Connection conn = null;
		String url = "jdbc:mysql://remotemysql.com:3306/";
		String dbname = "ZX9ytPMHo0";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "ZX9ytPMHo0"; 
		String pass = "4HkTydGmHY";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, pass);
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // TODO Auto-generated method stub
		
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        this.firstName = scan.nextLine();

        System.out.println("Enter Last Name: ");
        this.lastName = scan.nextLine();
        
        System.out.println("Enter Sex: ");
        this.Sex = scan.nextLine();
        
        System.out.println("Enter Phone Number: ");
        this.phoneNumber = scan.nextLine();
        
        System.out.println("Enter Date of Birth: ");
        this.DOB = scan.nextLine();

        System.out.println("Enter Email Address:");
        this.Email = scan.nextLine();
        
        System.out.println("Enter new password: ");
        this.password = scan.nextLine();
        
        try {

            Statement s=conn.createStatement();
            s.executeUpdate("INSERT INTO `customers`() VALUE (default, '"+this.firstName+"','"+this.lastName+"','"+this.Sex+"','"+this.phoneNumber+"','"+this.DOB+"','"+this.Email+"','"+this.password+"')");
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
        
        
    

    public boolean login() {
		Connection conn = null;
		String url = "jdbc:mysql://remotemysql.com:3306/";
		String dbname = "ZX9ytPMHo0";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "ZX9ytPMHo0"; 
		String pass = "4HkTydGmHY";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, pass);
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // TODO Auto-generated method stub
		
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
        	        this.firstName = rs.getString("firstName");
        	        this.lastName = rs.getString("lastName");
        	        this.Sex = rs.getString("sex");
        	        this.phoneNumber = rs.getString("phoneNumber");
        	        this.DOB = rs.getString("DOB");
        	        this.Email = rs.getString("email");
        	        this.password = rs.getString("password");
        	        this.customerId = rs.getInt("id_customers");
        	        return true;
        		}
            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
    	

    }

}