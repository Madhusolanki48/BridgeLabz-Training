package com.bridgelabz.employeewage.service;

import java.util.Random;
import com.bridgelabz.employeewage.model.Employee;

//hanndles attendance logic
public class EmployeeWageService {

    private static final int IS_PRESENT = 1;

    public Employee checkAttendance() {
        int check = new Random().nextInt(2); //random
        return new Employee(check == IS_PRESENT);
    }
}
