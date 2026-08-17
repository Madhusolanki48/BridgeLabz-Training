package com.bridgelabz.payrollapp.service;

import com.bridgelabz.payrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.payrollapp.dto.EmployeeResponseDTO;
import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO);

    void deleteEmployee(Long id);

    int getEmployeeCount();
}
