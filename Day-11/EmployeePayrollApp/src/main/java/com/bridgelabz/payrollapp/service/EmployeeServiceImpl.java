package com.bridgelabz.payrollapp.service;

import com.bridgelabz.payrollapp.model.Employee;
import com.bridgelabz.payrollapp.repository.EmployeeJdbcRepository;
import com.bridgelabz.payrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeJdbcRepository employeeJdbcRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeJdbcRepository employeeJdbcRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeJdbcRepository = employeeJdbcRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public int getEmployeeCount() {
        return employeeJdbcRepository.countEmployees();
    }
}
