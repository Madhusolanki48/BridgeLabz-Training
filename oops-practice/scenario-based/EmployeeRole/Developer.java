package EmployeeRole;
import java.util.*;

public class Developer extends Employee {

	//constructor
	Developer(String name, double salary) {
		super(name, salary);
	}

	//Developer: 5% if salary > 50000
	@Override
	protected double calculateBonus() {
		if (getSalary() > 50000)
			return getSalary() * 0.05;
		return 0.0;
	}
}
