import java.util.Scanner;

public class Customer {
    // this is a test
    Scanner n = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = n.nextLine();
    // template for using scanner class for asking user to input name
        
    String Name;
    char Sex;
    String DOB;
    String Email;
    int phoneNumber;
    int Payment;
    String[] flights;

    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name:");
        this.Name = scan.nextLine();

        System.out.println("Enter Sex (M or F):");
        this.Sex = scan.nextLine();

        System.out.println("Enter Email Address:");
        this.Email = scan.nextLine();

        System.out.println("Enter Phone Number:");
        this.phoneNumber = scan.nextLine();

        
    }

    public void login() {

    }

    public void customerInfo() {

    }

    public static void main (String[] args) {

    }

}
//hello
//amir
// beep boop
//lets work on this rn during lecture