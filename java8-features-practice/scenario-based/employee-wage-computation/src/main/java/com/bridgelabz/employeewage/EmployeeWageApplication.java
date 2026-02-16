package com.bridgelabz.employeewage;
import java.util.*;
import com.bridgelabz.employeewage.model.Employee;
import com.bridgelabz.employeewage.service.EmployeeWageService;

public class EmployeeWageApplication {
	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("--------------------------------------------");
		EmployeeWageService service = new EmployeeWageService();
		//UC-2: calculate daily employee wage
//		Employee emp = service.calculateDailyWage();
//		Employee emp = service.calculateWageWithPartTime();
		
		Employee emp = service.calculateWageWithSwitch();

		System.out.println("Employee Present: " + emp.isPresent());
		System.out.println("Working Hours: " + emp.getWorkingHours());
		System.out.println("Daily Wage: " + emp.getDailyWage());
		
		//UC-5: calculate wages for a month assuming 20 working days
		int monthlyWage = service.calculateMonthlyWage();
		System.out.println("Monthly Wage (20 days): " + monthlyWage);
	}


}
