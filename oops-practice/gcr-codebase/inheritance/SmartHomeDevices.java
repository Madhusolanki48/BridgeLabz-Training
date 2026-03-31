package inheritance;
//Single Inheritance
//Sample Problem 2: Smart Home Devices

class Device { //superclass
	//attributes
	String deviceId;
	String status;

	Device(String deviceId,String status){
		this.deviceId=deviceId;
		this.status=status;
	}
}

class Thermostat extends Device { //subclass
	int temperatureSetting; 

	Thermostat(String deviceId,String status,int temperatureSetting){
		super(deviceId,status);
		this.temperatureSetting=temperatureSetting;
	}

	void displayStatus(){ //method to show each device's current settings.
		System.out.println("Device ID : "+deviceId);
		System.out.println("Status : "+status);
		System.out.println("Temperature : "+temperatureSetting+" Celsius");
	}
}

public class SmartHomeDevices {
	public static void main(String[] args) {
		Thermostat t=new Thermostat("TH001","ON",24);
		t.displayStatus();
	}
}
