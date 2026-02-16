package com.bridgelabz.employeewage;
import java.util.*;
import com.bridgelabz.employeewage.model.Employee;
import com.bridgelabz.employeewage.controller.EmployeeWageController;


public class EmployeeWageApplication {
	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("--------------------------------------------");
		EmployeeWageController controller = new EmployeeWageController();

		//UC-2: calculate daily employee wage
//		Employee emp = service.calculateDailyWage();
//		Employee emp = service.calculateWageWithPartTime();
		
		Employee emp = controller.getWageWithSwitch();

		System.out.println("Employee Present: " + emp.isPresent());
		System.out.println("Employee Type: " + emp.getEmployeeType());
		System.out.println("Working Hours: " + emp.getWorkingHours());
		System.out.println("Daily Wage: " + emp.getDailyWage());
		
		//UC-5: calculate wages for a month assuming 20 working days
		int monthlyWage = controller.getMonthlyWage();
		System.out.println("Monthly Wage (20 days): " + monthlyWage);
		
		//UC-6: calculate wages till max working hours or days reached
//		int totalWage = controller.getWageTillCondition();
//		System.out.println("Total Wage (Max hours or days): " + totalWage);
		
		//UC-7: compute employee wage using class method and class variables
//		int totalWage = controller.getComputedEmployeeWage();
//		System.out.println("Computed Total Employee Wage: " + totalWage);
		
		//UC-8: multiple companies
		int tcsWage = controller.getComputedEmployeeWage("TCS", 20, 20, 100);

		System.out.println("TCS Total Wage: " + tcsWage);

		int infosysWage = controller.getComputedEmployeeWage("Infosys", 25, 22, 120);

		System.out.println("Infosys Total Wage: " + infosysWage);

	}

}
