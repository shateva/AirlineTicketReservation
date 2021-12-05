import java.sql.*;

public class Main {

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
		Customer friend1 = new Customer("Null", "000");
        friend1.register();
        System.out.println(friend1.getCustomer());
        String name = friend1.Name;
        String number = friend1.phoneNumber;
        try {
            
            Statement s=conn.createStatement();
            s.executeUpdate("INSERT INTO `customers`(firstName, phoneNumber) VALUE ('"+name+"','"+number+"')");
            
            
//            String CustomerQuery = ("SELECT (Name, phoneNumber) from 'customers'");
//            s.executeQuery(CustomerQuery);
            String sql = "select * from customers";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
            	String name1 = rs.getString("firstName");
            	String number1 = rs.getString("phoneNumber");
            	
            	System.out.format("%s, %s\n", name1, number1);
            }
            s.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

}
