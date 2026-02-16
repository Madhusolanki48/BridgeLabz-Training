package com.bridgelabz.employeewage.controller;
import com.bridgelabz.employeewage.model.Employee;
import com.bridgelabz.employeewage.service.EmployeeWageService;

public class EmployeeWageController {
    private final EmployeeWageService service = new EmployeeWageService();

    // UC-1
    public Employee checkEmployeeAttendance() {
        return service.checkAttendance();
    }

    // UC-2
    public Employee getDailyWage() {
        return service.calculateDailyWage();
    }

    // UC-4
    public Employee getWageWithSwitch() {
        return service.calculateWageWithSwitch();
    }

    // UC-5
    public int getMonthlyWage() {
        return service.calculateMonthlyWage();
    }

    // UC-6
    public int getWageTillCondition() {
        return service.calculateWageTillCondition();
    }
    // UC-7
    public int getComputedEmployeeWage() {
        return service.computeEmployeeWage();
    }
}
