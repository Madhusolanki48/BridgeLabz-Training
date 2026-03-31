package oops_pillars;
import java.util.*;

interface Department {  //interface
	void assignDepartment(String departmentName);
	String getDepartmentDetails();
}


abstract class Employee implements Department {  //abstract class
	//encapsulated fields
	private int employeeId;
	private String name;
	protected double baseSalary;
	private String department;
	//constructor
	public Employee(int employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	//abstract method
	public abstract double calculateSalary();
	//concrete method
	public void displayDetails() {
		System.out.println("Employee ID   : " + employeeId);
		System.out.println("Name          : " + name);
		System.out.println("Department    : " + department);
		System.out.println("Salary        : " + calculateSalary());
		System.out.println("------------------------------");
	}

	//getters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}
	//interface methods
	@Override
	public void assignDepartment(String departmentName) {
		this.department = departmentName;
	}
	@Override
	public String getDepartmentDetails() {
		return department;
	}
}
//full-time employee
class FullTimeEmployee extends Employee {
	public FullTimeEmployee(int employeeId, String name, double baseSalary) {
		super(employeeId, name, baseSalary);
	}
	@Override
	public double calculateSalary() {
		return baseSalary;
	}
}
     //part-time employee
class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;
	public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
		super(employeeId, name, 0);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
}
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		List<Employee> employees=new ArrayList<>();
		Employee e1=new FullTimeEmployee(101, "Maxwell", 45637);
		e1.assignDepartment("HR");
		Employee e2=new PartTimeEmployee(102, "Tyren", 56, 476);
		e2.assignDepartment("IT");
		employees.add(e1);
		employees.add(e2);
		//polymorphism
		for (Employee emp : employees) {
			emp.displayDetails();
		}
	}
}
