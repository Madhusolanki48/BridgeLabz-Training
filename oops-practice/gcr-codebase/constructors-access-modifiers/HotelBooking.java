package constructors_access_modifiers;
// Class to store hotel booking details
public class HotelBooking {
	//attributes
    private String guestName;
    private String roomType;
    private int nights;
   
    //default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }
    //parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    //copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }
    //method to display radius 
  	void display() {
  		System.out.println("Guest Name : "+guestName);
  		System.out.println("Room Type : "+roomType);
  		System.out.println("Nights : " +nights);
  		System.out.println("-----------------------------------------");
  		}
  	public static void main(String[] args) {
  		HotelBooking hotel1=new HotelBooking();
  		HotelBooking hotel2=new HotelBooking("Maxwell","VIP",4);
  		HotelBooking hotel3=new HotelBooking(hotel2);
  		hotel1.display();
  		hotel2.display();
  		hotel3.display();
  	}
}

