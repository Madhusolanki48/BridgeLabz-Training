package com.bridgelabz.payrollapp.service;

import com.bridgelabz.payrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.payrollapp.dto.EmployeeResponseDTO;
import com.bridgelabz.payrollapp.exception.DuplicateEmployeeEmailException;
import com.bridgelabz.payrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.payrollapp.model.Employee;
import com.bridgelabz.payrollapp.repository.EmployeeJdbcRepository;
import com.bridgelabz.payrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        validateEmployee(employeeRequestDTO);

        if (employeeRepository.existsByEmail(employeeRequestDTO.getEmail())) {
            throw new DuplicateEmployeeEmailException(
                    "Employee email already exists: " + employeeRequestDTO.getEmail());
        }

        Employee employee = mapToEmployee(employeeRequestDTO);
        return mapToResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        return mapToResponseDTO(findEmployeeById(id));
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {
        validateEmployee(employeeRequestDTO);
        Employee existingEmployee = findEmployeeById(id);

        if (employeeRepository.existsByEmailAndIdNot(employeeRequestDTO.getEmail(), id)) {
            throw new DuplicateEmployeeEmailException(
                    "Employee email already exists: " + employeeRequestDTO.getEmail());
        }

        existingEmployee.setName(employeeRequestDTO.getName());
        existingEmployee.setEmail(employeeRequestDTO.getEmail());
        existingEmployee.setDepartment(employeeRequestDTO.getDepartment());
        existingEmployee.setSalary(employeeRequestDTO.getSalary());

        return mapToResponseDTO(employeeRepository.save(existingEmployee));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.delete(findEmployeeById(id));
    }

    @Override
    public int getEmployeeCount() {
        return employeeJdbcRepository.countEmployees();
    }

    private Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    private Employee mapToEmployee(EmployeeRequestDTO employeeRequestDTO) {
        return Employee.builder()
                .name(employeeRequestDTO.getName())
                .email(employeeRequestDTO.getEmail())
                .department(employeeRequestDTO.getDepartment())
                .salary(employeeRequestDTO.getSalary())
                .build();
    }

    private EmployeeResponseDTO mapToResponseDTO(Employee employee) {
        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }

    private void validateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        if (employeeRequestDTO.getName() == null || employeeRequestDTO.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name is required");
        }
        if (employeeRequestDTO.getEmail() == null || employeeRequestDTO.getEmail().isBlank()) {
            throw new IllegalArgumentException("Employee email is required");
        }
        if (employeeRequestDTO.getDepartment() == null || employeeRequestDTO.getDepartment().isBlank()) {
            throw new IllegalArgumentException("Employee department is required");
        }
        if (employeeRequestDTO.getSalary() == null
                || employeeRequestDTO.getSalary().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Employee salary must be greater than zero");
        }
    }
}
