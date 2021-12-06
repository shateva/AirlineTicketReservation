import java.sql.*;
import java.util.Scanner;

public class Main {
	
	

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
		Customer friend1 = new Customer("Null","Null", "000", "Null", "Null", "Null", "Null", 0);
		
		
		
        friend1.register();
        System.out.println(friend1.getCustomer());
        String firstName = friend1.firstName;
        String lastName = friend1.lastName;
        String Sex = friend1.Sex;
        String number = friend1.phoneNumber;
        String DOB = friend1.DOB;
        String Email = friend1.Email;
        String password = friend1.password;
        
        try {
            
            Statement s=conn.createStatement();
            s.executeUpdate("INSERT INTO `customers`() VALUE (default, '"+firstName+"','"+lastName+"','"+Sex+"','"+number+"','"+DOB+"','"+Email+"','"+password+"')");
            
            
      	  
        	ResultSet rs = s.executeQuery("SELECT * FROM customers WHERE firstName = 'Shateva'");
        	
      
            
            while(rs.next()) {
            	int id_customer1 = rs.getInt("id_customers");
            	friend1.customerId = id_customer1;
            	String firstname1 = rs.getString("firstName");
            	String lastname1 = rs.getString("lastName");
            	String sex1 = rs.getString("Sex");
            	String number1 = rs.getString("phoneNumber");
            	String DOB1 = rs.getString("DOB");
            	String Email1 = rs.getString("Email");
            	String Password1 = rs.getString("password");
            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
        Scanner scan6 = new Scanner(System.in);
        System.out.println("Type '1' to reserve a flight | Type '2' to cancel a flight | Type '3' to see all flights:  ");
        int answer = scan6.nextInt();
        if (answer == 1){
        	friend1.reserveFlight();
        } else if (answer == 2) {
        	System.out.println("Cancel Flight");
        } else if (answer == 3) {
        	System.out.println("See all flights");
        }else {
        	System.out.println("Invalid Choice");
        }
        
        
        
	}

}
