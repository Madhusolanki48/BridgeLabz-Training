package com.example.college_management.repository;

import com.example.college_management.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository
        extends JpaRepository<Faculty, Integer> {

    // maximum salary from each department
    @Query("""
            SELECT f
            FROM Faculty f
            WHERE f.salary = (
                SELECT MAX(f2.salary)
                FROM Faculty f2
                WHERE f2.department = f.department
            )
            """)
    List<Faculty> findHighestPaidFacultyByDepartment();

    // faculty whose salary is greater than avg salary of their own department
    @Query("""
            SELECT f
            FROM Faculty f
            WHERE f.salary > (
                SELECT AVG(f2.salary)
                FROM Faculty f2
                WHERE f2.department = f.department
            )
            """)
    List<Faculty> findFacultyAboveDepartmentAverage();
}
