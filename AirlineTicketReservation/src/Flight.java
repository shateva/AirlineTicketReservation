import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
		String number;
		String departure;
		String destination;
		String duration;
		String date;
		String departureTime;
		String arrivalTime;
	    int seats;
	    
	    public Flight(String number, String departure, String destination, String duration, String date, String departureTime, String arrivalTime, int seats) {
			this.number = number;		
			this.departure = departure;
			this.destination = destination;
			this.duration = duration;
			this.date = date;
			this.departureTime = departureTime;
			this.seats = seats;
			this.arrivalTime = arrivalTime;
		}
	    
	    public String getFlight(){
			return number + departure + destination + duration + date + departureTime + seats;
		}
	    
	    public void createFlight() {
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
	        
	        System.out.println("Enter Destination Location: ");
	        this.destination = scan.nextLine();
	        
	        System.out.println("Enter Departure Location: ");
	        this.departure = scan.nextLine();
	        
	        System.out.println("Enter Flight Departure Time: ");
	        this.departureTime = scan.nextLine();
	        
	        System.out.println("Enter Flight Arrival Time: ");
	        this.arrivalTime = scan.nextLine();
	        
	        System.out.println("Enter Flight Duration: ");
	        this.duration = scan.nextLine();
	        
	        System.out.println("Enter Flight Date: ");
	        this.date = scan.nextLine();
	        
	        System.out.println("Enter Flight Seats: ");
	        this.seats = scan.nextInt();
	        
	        try {

	            Statement s=conn.createStatement();
	            s.executeUpdate("INSERT INTO `flights`() VALUE (default, '"+this.destination+"','"+this.departure+"','"+this.departureTime+"','"+this.arrivalTime+"','"+this.duration+"','"+this.date+"','"+this.seats+"')");
	            s.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    
	    public void deleteFlight() {
//	    	remove flight from database
	        
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
	    	    
	    	    Scanner scan2 = new Scanner(System.in);
	    	    System.out.println("Enter the flight id of the flight you want to delete (flights are listed above): ");
	    	    flightHold = scan2.nextLine();
	    	   
	    	    
	    	    
				try {
					 
		    	    Statement y=conn.createStatement();
					y = conn.createStatement();
					y.executeUpdate("DELETE FROM `flights` WHERE id_flights = '"+flightHold+"' ");

					System.out.println("This flight has been deleted");
		            y.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    
	        
	    	
	    }
	    
	    
	    public void delayFlight() {
	    //	System.out.println("Enter new Flight Departure Time: ");
	    //    this.departureTime = scan.nextLine();
//	    	update departure time in database
	    }
	    
	    public void getAllFlights(int customerId) {
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
            
            try {
            	Statement s=conn.createStatement();
            	Statement n = conn.createStatement();
            	String sql = "SELECT * FROM orders WHERE id_customers =  '"+customerId+"'"; 
                ResultSet rs = s.executeQuery(sql);
                
                System.out.println("ID | Destination | Departure | Departure | Time | Arrival | Time | Duration | Date | Seats");
                
                while(rs.next()) {
                	String flight = rs.getString("id_flights");
                	
                	String sql2 = "SELECT * FROM flights WHERE id_flights =  '"+flight+"'";
                	ResultSet nrs = n.executeQuery(sql2);
                	
                	while(nrs.next()) {
                		System.out.format("%s | %s | %s | %s | %s | %s | %s | %s\n", nrs.getString("id_flights"), nrs.getString("destination"), nrs.getString("departureLoc"), nrs.getString("departureTime"), nrs.getString("arrivalTime"), nrs.getString("duration"), nrs.getString("date"), nrs.getString("seats"));
                	}
                	
                }
                n.close();
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
	    }
}