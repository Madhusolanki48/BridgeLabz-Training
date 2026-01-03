package inheritance;
class Vehicle{   //super class
	//attributes
	int maxSpeed;
	String fuelType;
	Vehicle(int maxSpeed,String fuelType) {
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }
	void displayInfo() {  //method to display details
		System.out.println("Max Speed : "+maxSpeed);
		System.out.println("Fuel type : "+fuelType);
	}
}
//subclasses Car, Truck,Motorcycle
class Car extends Vehicle{
	int seatCapacity;
	Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
	void displayInfo() {
		System.out.println("Vehicle Type: Car");
        super.displayInfo();
		System.out.println("Seat Capacity : "+seatCapacity);
	}
}
class Truck extends Vehicle{
    int loadCapacity;
	Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
	void displayInfo() {
        System.out.println("Vehicle Type: Truck");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println();
    }
}
class Motorcycle extends Vehicle{
    boolean hasGear;
    Motorcycle(int maxSpeed,String fuelType,boolean hasGear) {
        super(maxSpeed,fuelType);
        this.hasGear=hasGear;
    }
    void displayInfo() {
        System.out.println("Vehicle Type: Motorcycle");
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
        System.out.println();
    }
}
public class VehicleAndTransportSystem {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
        vehicles[0]=new Car(180,"Petrol", 5);
        vehicles[1]=new Truck(120,"Diesel", 10);
        vehicles[2]=new Motorcycle(160, "Petrol", true);
        for (Vehicle v : vehicles) {
            v.displayInfo();//dynamic method dispatch
            System.out.println("-----------------------------");
        }
	}

}