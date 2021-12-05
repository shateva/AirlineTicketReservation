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
   // int Payment;
   // String[] flights;

   
    
    public Customer(String firstName, String lastName, String phoneNumber, String Sex, String DOB, String Email, String password /*String password*/) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.DOB = DOB;
		this.Email = Email;
		this.Sex = Sex;
		this.password = password;
		
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