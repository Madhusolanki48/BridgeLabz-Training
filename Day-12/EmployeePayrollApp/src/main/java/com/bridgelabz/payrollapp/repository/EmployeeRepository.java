package com.bridgelabz.payrollapp.repository;

import com.bridgelabz.payrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
