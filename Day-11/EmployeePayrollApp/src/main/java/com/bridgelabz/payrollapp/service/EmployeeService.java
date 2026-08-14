package com.bridgelabz.payrollapp.service;

import com.bridgelabz.payrollapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    int getEmployeeCount();
}
