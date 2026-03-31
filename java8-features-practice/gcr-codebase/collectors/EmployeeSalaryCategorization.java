package collectors;
import java.util.*;
import java.util.stream.*;

class Employee {
	String department;
	double salary;
    //constructor
	Employee(String department, double salary) {
		this.department = department;
		this.salary = salary;
	}
    //getter method
	String getDepartment() {
		return department;
	}

	double getSalary() {
		return salary;
	}
}
//main class
public class EmployeeSalaryCategorization {
	public static void main(String[] args) {

		List<Employee> employees = List.of(new Employee("IT", 60000), new Employee("IT", 80000),
				new Employee("HR", 50000));

		//average salary by department
		Map<String, Double> avgSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryByDept);
	}
}
