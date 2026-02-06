package functional_interface;
//interface
interface Vehicle{
	void rent();
	void returnVehicle();
	
}
//car implemenatation
class Car implements Vehicle{
	public void rent() {
		System.out.println("Car rented!");
	}
	public void returnVehicle() {
		System.out.println("Car returned!");
	}	
}
//bike implementation
class Bike implements Vehicle{
	public void rent() {
		System.out.println("Bike rented!");
	}
	public void returnVehicle() {
		System.out.println("Bike returned!");
	}	
}
//bus implementation
class Bus implements Vehicle{
	public void rent() {
		System.out.println("Bus rented!");
	}
	public void returnVehicle() {
		System.out.println("Bus returned!");
	}	
}
//main class
public class MultiVehicleRentalSystem {
	public static void main(String[] args) {
		Vehicle car=new Car();
		Vehicle bike=new Bike();
		Vehicle bus=new Bus();
		
		car.rent();
		bike.rent();
		bus.rent();
		
		car.returnVehicle();
		bike.returnVehicle();
		bus.returnVehicle();
	}

}
