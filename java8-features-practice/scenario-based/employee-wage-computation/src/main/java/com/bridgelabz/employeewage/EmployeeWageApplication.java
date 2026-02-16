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
		Employee emp = service.checkAttendance();
        //UC-1: check employee present or absent using random
		if (emp.isPresent()) {
		    System.out.println("Employee is PRESENT!");
		} else {
		    System.out.println("Employee is ABSENT!");
		}
	}

}
