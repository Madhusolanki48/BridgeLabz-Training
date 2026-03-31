package functional_interface;
//interface
interface SmartDevice{
	void turnOn();
	void turnOff();
}
//light implementation
class Light implements SmartDevice{
	public void turnOn() {
		System.out.println("Light turned ON!");
	}
	public void turnOff(){
		System.out.println("Light turned OFF!");
		
	}
}
//AC implementation
class AC implements SmartDevice{
	public void turnOn() {
		System.out.println("AC turned ON!");
	}
	public void turnOff(){
		System.out.println("AC turned OFF!");
		
	}
}
//TV implementation
class TV implements SmartDevice{
	public void turnOn() {
		System.out.println("TV turned ON!");
	}
	public void turnOff(){
		System.out.println("TV turned OFF!");
	}
}
//main class
public class SmartHome {
	public static void main(String[] args) {
		SmartDevice light=new Light();
		SmartDevice ac=new AC();
		SmartDevice tv=new TV();
		
		light.turnOn();
		ac.turnOn();
		tv.turnOn();
		
		light.turnOff();
		ac.turnOff();
		tv.turnOff();
	}

}
