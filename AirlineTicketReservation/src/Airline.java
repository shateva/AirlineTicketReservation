import java.util.Scanner;

public class Airline {
	String Name;
	   //String Sex;
	   // String DOB;
	   // String Email;
	    String password;
	   // int Payment;
	   // String[] flights;
	    
	    public Airline(String Name, String phoneNumber, String password) {
			this.Name = Name;		
			this.password = password;
		}
	    
	    public String getAirline(){
			return Name + password;
		}
	    
	    public void register() {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter Name: ");
	        this.Name = scan.nextLine();
	        
	        System.out.println("Enter new password: ");
	        this.password = scan.nextLine();

	        //System.out.println("Enter Email Address:");
	       // this.Email = scan.nextLine();


	        
	    }

	    public void login() {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Enter Name: ");
	    	String name = scan.nextLine();
//	    	if this.Name not in database{
//	    		print('no user in data with that name')
//	    	else{
	    	System.out.println("Enter Password: ");
	    	String password = scan.nextLine();
//	    	if this.Password not = password{
//	    		print('invalid password')
//	    	else{
//	    		allow login
	    	

	    }

}


//hello
//amir
// beep boop
//lets work on this rn during lecture