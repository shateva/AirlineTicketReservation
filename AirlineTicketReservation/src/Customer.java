import java.util.Scanner;

public class Customer {
    // this is a test
    
    // template for using scanner class for asking user to input name
        
    String Name;
    String Sex;
   // String DOB;
   // String Email;
    //int phoneNumber;
   // int Payment;
   // String[] flights;

   
    
    public Customer(String Name, String Sex) {
		this.Name = Name;		
		this.Sex = Sex;
	}
    
    public String getCustomer(){
		return Name + Sex;
	}
    
    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.Name = scan.nextLine();

        System.out.println("Enter Sex (M or F): ");
        this.Sex = scan.nextLine();

        //System.out.println("Enter Email Address:");
       // this.Email = scan.nextLine();


        
    }

    public void login() {

    }

    public void customerInfo() {

    }

  private static void main (String[] args) {
	 Customer test1 = new Customer("Amir","Male");
	 System.out.println(test1);
  }

}


//hello
//amir
// beep boop
//lets work on this rn during lecture