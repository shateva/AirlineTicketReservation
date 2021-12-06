import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    	
    	Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter destination: ");
        flightHold = scan2.nextLine();
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Enter departure location: ");
        departHold = scan3.nextLine();
    	
        
        
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
        try {
            
        	Statement s=conn.createStatement();
  
        	ResultSet rs = s.executeQuery("SELECT * FROM flights WHERE destination = '"+flightHold+"' AND departureLoc = '"+departHold+"'");
        	
        	while (rs.next()) {
        		int id_flights = rs.getInt("id_flights");
        		String destination = rs.getString("destination");
            	String departureLoc = rs.getString("departureLoc");
            	String departureTime = rs.getString("departureTime");
            	String arrivalTime = rs.getString("arrivalTime");
            	String duration = rs.getString("duration");
            	String date = rs.getString("date");
            	String seats = rs.getString("seats");
            	
            	System.out.format("%d, %s, %s, %s, %s, %s, %s, %s\n", id_flights, destination, departureLoc, departureTime, arrivalTime, duration, date, seats);

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

// s.executeQuery("select Name, phoneNumber, password from customers")
        // String CustomerQuery = (SELECT Name, phoneNumber,from customers;
       // s.executeQuery(CustomerQuery);
    }

    public void login() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter Name: ");
    	String name = scan.nextLine();
//    	if this.Name not in database{
//    		print('no user in data with that name')
//    	else{
    	System.out.println("Enter Password: ");
    	String password = scan.nextLine();
//    	if this.Password not = password{
//    		print('invalid password')
//    	else{
//    		allow login
    	

    }

}


//hello
//amir
// beep boop
//lets work on this rn during lecture