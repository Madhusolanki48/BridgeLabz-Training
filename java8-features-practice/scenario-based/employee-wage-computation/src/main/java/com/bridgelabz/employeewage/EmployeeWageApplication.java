package com.bridgelabz.employeewage;
import java.util.*;
import com.bridgelabz.employeewage.model.Employee;
import com.bridgelabz.employeewage.controller.EmployeeWageController;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;



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
		
		
		//UC-10: manage multiple companies via builder
		CompanyEmployeeWage tcs = new CompanyEmployeeWage("TCS", 20, 20, 100);
		CompanyEmployeeWage infosys = new CompanyEmployeeWage("Infosys", 25, 22, 120);
		
		controller.addCompany(tcs);
        controller.addCompany(infosys);

        controller.computeAllWages();

        // print results
        CompanyEmployeeWage[] companies = controller.getCompanies();
        int count = controller.getCompanyCount();

        for (int i = 0; i < count; i++) {
        	System.out.println("\n--------------------------------------");
        	System.out.println("Computing Wage for: " + companies[i].getCompanyName());
        	System.out.println("----------------------------------------");
        	System.out.println("Total Wage: " + companies[i].getTotalWage());
        }
	}
}
