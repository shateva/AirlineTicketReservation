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
                
                System.out.println(enteredEmail);
                System.out.println(enteredPassword);
                
                try {
                	Statement s=conn.createStatement();
                	String sql = "select * from customers";
                    ResultSet rs = s.executeQuery(sql);
                    
                    while(rs.next()) {
                    	System.out.println(rs.getString("Email"));
                    	System.out.println(rs.getString("password"));
                    	if (rs.getString("Email") == enteredEmail + "\n") {
                    		if (rs.getString("password") == enteredPassword + "\n") {
                    			System.out.println("logged in");
                    		}
                    	}
                    }
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                      
            }
            else if (customerChoice == 2) {
            	Customer friend1 = new Customer("Null","Null", "000", "Null", "Null", "Null", "Null");
                friend1.register();
                System.out.println(friend1.getCustomer());
                firstName = friend1.firstName;
                lastName = friend1.lastName;
                Sex = friend1.Sex;
                number = friend1.phoneNumber;
                DOB = friend1.DOB;
                Email = friend1.Email;
                password = friend1.password;
            }
        }else {
        	System.out.println("working");
        }

        try {
            
            Statement s=conn.createStatement();
            s.executeUpdate("INSERT INTO `customers`() VALUE (default, '"+firstName+"','"+lastName+"','"+Sex+"','"+number+"','"+DOB+"','"+Email+"','"+password+"')");
            
            
//            String CustomerQuery = ("SELECT (Name, phoneNumber) from 'customers'");
//            s.executeQuery(CustomerQuery);
//            String sql = "select * from customers";
//            ResultSet rs = s.executeQuery(sql);
//            
//            while(rs.next()) {
//            	String firstname1 = rs.getString("firstName");
//            	String lastname1 = rs.getString("lastName");
//            	String sex1 = rs.getString("Sex");
//            	String number1 = rs.getString("phoneNumber");
//            	String DOB1 = rs.getString("DOB");
//            	String Email1 = rs.getString("Email");
//            	String Password1 = rs.getString("password");
//            	
//            	System.out.format("%s, %s\n", firstname1, lastname1, sex1, number1, DOB1, Email1, Password1);
//            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

}
