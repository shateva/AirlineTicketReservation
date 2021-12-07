import java.util.Scanner;

public class Airline {
		String Name;
	   //String Sex;
	   // String DOB;
	   // String Email;
	    String password = "admin";
	   // int Payment;
	   // String[] flights;
	    
	    public Airline(String Name, String phoneNumber) {
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

	    public boolean login() {
	    	System.out.println("Login");
        	Scanner scan3 = new Scanner(System.in);
            System.out.println("Please Enter Password:");
            String ans = scan3.nextLine();
            
            if (ans.equals(this.password)) {
            	return true;
            }
			return false;
	    	

	    }

}


//hello
//amir
// beep boop
//lets work on this rn during lecture