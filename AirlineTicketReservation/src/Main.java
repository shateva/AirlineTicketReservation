import java.sql.*;

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
            	
           
            	
            	System.out.format("%s, %s\n", firstname1, lastname1, sex1, number1, DOB1, Email1, Password1);
            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.format("%s", friend1.customerId);
        friend1.reserveFlight();
	}

}
