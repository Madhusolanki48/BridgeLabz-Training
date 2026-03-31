package constructors_access_modifiers;

public class Circle {
	//attribute
	private double radius;
	//default constructor
	Circle(){
		radius=4.5;
	}
	//parameterized constructor
	Circle(double radius){
		this.radius=radius;
	}
	//method to display radius
	void display() {
		System.out.println("The Radius of Circle is : "+radius+" unit");
		System.out.println("-------------------------------------");
		}
	
	public static void main(String[] args) {
		Circle circle1=new Circle();
		Circle circle2=new Circle(6.28);
		circle1.display();
		circle2.display();
	}
}
