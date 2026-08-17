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
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);

        if (existingEmployee == null) {
            return null;
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }

    @Override
    public int getEmployeeCount() {
        return employeeJdbcRepository.countEmployees();
    }
}
