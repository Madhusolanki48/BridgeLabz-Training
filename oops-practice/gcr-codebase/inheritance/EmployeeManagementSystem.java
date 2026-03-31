package inheritance;

class Employee{  //super class
	//attributes
	String name;
	int id;
	int salary;
	Employee(){
		name="Maren Davis";
		id=1;
		salary=250000;
	}
	void displayDetails() {   //method to display details
		System.out.println("Employee ID : "+id);
		System.out.println("Employee salary : "+salary);
		System.out.println("Employee name : "+name);
	}
}
//subclasses Manager, Developer,Intern 
class Manager extends Employee{
	int id;
	String name;
	int teamSize;
	Manager(){
		id=2;
		name="Jammy Smith";
		teamSize=34;
	}
	void displayDetails() {
		System.out.println("Manager ID: "+id);
		System.out.println("Manager Name : "+name);
		System.out.println("Team size :"+teamSize);
	}
}
class Developer extends Employee{
	int id;
	String name;
	String programmingLanguage;
	Developer(){
		id=3;
		name="Cloin Faren";
		programmingLanguage="Java";
	}
	void displayDetails() {
		System.out.println("Developer id : "+id);
		System.out.println("Developer name : "+name);
		System.out.println("Programming Language : "+programmingLanguage);
	}
	
}
class Intern extends Employee{
	int id;
	String name;
	String role;
	Intern(){
		id=34;
		name="Tren Walker";
		role="Developer";
	}
	void displayDetails() {
		System.out.println("Intern id : "+id);
		System.out.println("Intern name :"+name);
		System.out.println("Intern role : "+role);
	}
}



public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee employee1=new Employee();
		Manager manager1=new Manager();
		Developer developer1= new Developer();
		Intern intern1=new Intern();
		employee1.displayDetails();
		System.out.println("-------------------------------");
		manager1.displayDetails();
		System.out.println("-------------------------------");
		developer1.displayDetails();
		System.out.println("-------------------------------");
		intern1.displayDetails();
	}	
}