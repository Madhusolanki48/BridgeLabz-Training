package com.bridgelabz.employeewage.service;

import java.util.Random;
import com.bridgelabz.employeewage.model.Employee;

//hanndles attendance logic
public class EmployeeWageService {

    private static final int IS_PRESENT = 1;
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME = 2;
    private static final int PART_TIME_HOUR = 8;
    private static final int FULL_TIME = 1;
    private final Random random = new Random();

    public Employee checkAttendance() {
        int check = new Random().nextInt(2); //random
        return new Employee(check == IS_PRESENT,0,0);
    }
    //UC-2:calculate daily wage for employee
    public Employee calculateDailyWage() {

        Employee emp = checkAttendance();

        int hours = emp.isPresent() ? FULL_DAY_HOUR : 0;
        int wage = hours * WAGE_PER_HOUR;

        return new Employee(emp.isPresent(), hours, wage);
    }
    //UC-3:calculate wage including part-time employee
    public Employee calculateWageWithPartTime() {
        int empCheck = random.nextInt(3); // 0,1,2
        int hours = 0;
        if (empCheck == FULL_TIME) {
            hours = FULL_DAY_HOUR;
        } else if (empCheck == PART_TIME) {
            hours = PART_TIME_HOUR;
        }

        int wage = hours * WAGE_PER_HOUR;
        return new Employee(hours > 0, hours, wage);
    }


}
