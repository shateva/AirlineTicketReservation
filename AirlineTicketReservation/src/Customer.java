import java.util.Scanner;

public class Customer {
    // this is a test
    
    // template for using scanner class for asking user to input name
        
    String Name;
   //String Sex;
   // String DOB;
   // String Email;
    String phoneNumber;
   // int Payment;
   // String[] flights;

    
    public Customer(String Name, String phoneNumber) {
		this.Name = Name;		
		this.phoneNumber = phoneNumber;
	}
    
    public String getCustomer(){
		return Name + phoneNumber;
	}
    
    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.Name = scan.nextLine();

        System.out.println("Enter phone number: ");
        this.phoneNumber = scan.nextLine();

        //System.out.println("Enter Email Address:");
       // this.Email = scan.nextLine();


        
    }

    public void login() {

    }

    public void customerInfo() {

    }

  

}
//hello
//amir
// beep boop
//lets work on this rn during lecture