package EmployeeRole;
import java.util.*;

public class Manager extends Employee {

	//constructor
	Manager(String name, double salary) {
		super(name, salary);
	}

	//Manager: 10% of salary
	@Override
	protected double calculateBonus() {
		return getSalary() * 0.10;
	}
}
