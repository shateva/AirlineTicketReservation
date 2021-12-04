import java.util.Scanner;

public class Flight {
		String number;
		String departure;
		String destination;
		String duration;
		String date;
		String departureTime;
	    int seats;
	    
	    public Flight(String number, String departure, String destination, String duration, String date, String departureTime, int seats) {
			this.number = number;		
			this.departure = departure;
			this.destination = destination;
			this.duration = duration;
			this.date = date;
			this.departureTime = departureTime;
			this.seats = seats;
		}
	    
	    public String getFlight(){
			return number + departure + destination + duration + date + departureTime + seats;
		}
	    
	    public void createFlight() {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter Number: ");
	        this.number = scan.nextLine();
	        
	        System.out.println("Enter Departure Location: ");
	        this.departure = scan.nextLine();
	        
	        System.out.println("Enter Destination Location: ");
	        this.destination = scan.nextLine();
	        
	        System.out.println("Enter Flight Duration: ");
	        this.duration = scan.nextLine();
	        
	        System.out.println("Enter Flight Date: ");
	        this.date = scan.nextLine();
	        
	        System.out.println("Enter Flight Departure Time: ");
	        this.departureTime = scan.nextLine();

	        this.seats = 50;
	        //System.out.println("Enter Email Address:");
	       // this.Email = scan.nextLine();
	    }
	    
	    public void deleteFlight() {
//	    	remove flight from database
	    }
	    
	    public void delayFlight() {
	    	System.out.println("Enter new Flight Departure Time: ");
	        this.departureTime = scan.nextLine();
//	    	update departure time in database
	    }
}


//hello
//amir
// beep boop
//lets work on this rn during lecture