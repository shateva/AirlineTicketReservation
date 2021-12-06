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
    
    
    public void reserveFlight() {
    	
		String flightHold = null;
		String departHold = null;
		String chosenFlight = null;
	    	
        
        
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
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 // TODO Auto-generated method stub
		
		
    	
		
		try {
			Statement z=conn.createStatement();
			ResultSet rz = z.executeQuery("SELECT destination FROM flights");
		
        	while (rz.next()) {
        		String destination = rz.getString("destination");
         
            	System.out.format("%s\n", destination);
	       	
            	
        	}
            Scanner scan2 = new Scanner(System.in);
    	    System.out.println("Enter destination (available destinations are printed above): ");
    	    flightHold = scan2.nextLine();
    	    
    	    Statement y=conn.createStatement();
			ResultSet ry = y.executeQuery("SELECT departureLoc FROM flights WHERE destination = '"+flightHold+"' ");
			
		
        	while (ry.next()) {
        		String depart = ry.getString("departureLoc");
         
            	System.out.format("%s\n", depart);
        	}
        	
        	
	        Scanner scan3 = new Scanner(System.in);
	        System.out.println("Enter departure location (available departure locations are printed above): ");
	        departHold = scan3.nextLine();
			
			
        	Statement s=conn.createStatement();
  
        	ResultSet rs = s.executeQuery("SELECT * FROM flights WHERE destination = '"+flightHold+"' AND departureLoc = '"+departHold+"'");
        	
        	while (rs.next()) {
        		int id_flights = rs.getInt("id_flights");
        		String destination2 = rs.getString("destination");
            	String departureLoc = rs.getString("departureLoc");
            	String departureTime = rs.getString("departureTime");
            	String arrivalTime = rs.getString("arrivalTime");
            	String duration = rs.getString("duration");
            	String date = rs.getString("date");
            	String seats = rs.getString("seats");
            	
            	System.out.format("%d, %s, %s, %s, %s, %s, %s, %s\n", id_flights, destination2, departureLoc, departureTime, arrivalTime, duration, date, seats);

        	}
        	
      
        	
        	Scanner scan4 = new Scanner(System.in);
            System.out.println("Enter the number of the flight you want to reserve a seat for:  ");
            chosenFlight = scan4.nextLine();
            
            
            s.executeUpdate("INSERT INTO `orders`() VALUE (default, '"+this.customerId+"', '"+chosenFlight+"')");
            s.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    
        
    	System.out.println("Your flight has been reserved");
    }
    
    
    public String getCustomer(){
		return firstName + lastName + phoneNumber;//+ password;
	}
    
    public void register() {
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


//hello
//amir
// beep boop
//lets work on this rn during lecture