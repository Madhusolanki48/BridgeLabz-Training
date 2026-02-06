package functional_interface;

//vehicle interface
interface Vehicle1 {

	void displaySpeed();

	//default feature for electric vehicles
	default void displayBattery() {
		System.out.println("Battery info not available");
	}
}

//normal vehicle
class Car1 implements Vehicle1 {
	public void displaySpeed() {
		System.out.println("Speed: 60 km/h");
	}
}

//electric vehicle overrides default
class ElectricCar implements Vehicle1 {
	public void displaySpeed() {
		System.out.println("Speed: 70 km/h");
	}

	public void displayBattery() {
		System.out.println("Battery: 80%");
	}
}

public class SmartVehicleDashboard {
	public static void main(String[] args) {
		Vehicle1 car = new Car1();
		Vehicle1 ev = new ElectricCar();

		car.displaySpeed();
		car.displayBattery();

		ev.displaySpeed();
		ev.displayBattery();
	}
}
