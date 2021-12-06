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
		String password = "4HkTydGmHY";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(url+dbname, username, password);
			System.out.println("Connected to the database");
			//conn.close();
			//System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 // TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        System.out.println("Customer or Admin");
        String choice = scan.nextLine();
        
        String name = "null";
        String number = "null";
        
        if (choice == "1") {
        	System.out.println("Login or Register");
            String customerChoice = scan.nextLine();
            
            if (customerChoice == "1") {
            	System.out.println("email");
                String enteredEmail = scan.nextLine();
                System.out.println("password");
                String enteredPassword = scan.nextLine();
                
                String userEmail = "null";
                String userPassword = "null";
                String id = "null";
                
                try {
                    
                    Statement s=conn.createStatement();                    
             
                    userEmail = "select email from customers where email=" + enteredEmail;
                    userPassword = "select password from customers where email=" + enteredPassword;
                    System.out.println(userEmail + userPassword);
//                    ResultSet rs = s.executeQuery(sql);
                    
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                      
            }
            else if (customerChoice == "2") {
            	Customer friend1 = new Customer("Null", "000");
                friend1.register();
                System.out.println(friend1.getCustomer());
                name = friend1.Name;
                number = friend1.phoneNumber;
            }
        }
        
        try {
            
            Statement s=conn.createStatement();
            s.executeUpdate("INSERT INTO `customers`(firstName, phoneNumber) VALUE ('"+name+"','"+number+"')");
            
            
//            String CustomerQuery = ("SELECT (Name, phoneNumber) from 'customers'");
//            s.executeQuery(CustomerQuery);
            String sql = "select * from customers";
            ResultSet rs = s.executeQuery(sql);
            
//            while(rs.next()) {
//            	String name1 = rs.getString("firstName");
//            	String number1 = rs.getString("phoneNumber");
//            	
//            	System.out.format("%s, %s\n", name1, number1);
//            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

}
