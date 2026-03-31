package EmployeeRole;
import java.util.*;

abstract class Employee {
	//attribtes
	private final String name;
	private final double salary;
	protected final double bonus;   //cached bonus

	//constructor
	Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		this.bonus = calculateBonus();
	}

	//getter methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	//polymorphic method
	protected abstract double calculateBonus();

	public double getBonus() {
		return bonus;
	}
}
