package com.bridgelabz.payrollapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int countEmployees() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employees", Integer.class);
        return count == null ? 0 : count;
    }
}
