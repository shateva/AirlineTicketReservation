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
		//	conn.close();
		//	System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* // TODO Auto-generated method stub
		Customer friend1 = new Customer("Mickey", "Female");
		friend1.register();
		System.out.println(friend1.getCustomer());
		*/
	}

}
