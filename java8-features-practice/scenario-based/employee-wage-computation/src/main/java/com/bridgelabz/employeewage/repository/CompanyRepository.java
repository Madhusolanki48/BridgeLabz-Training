package com.bridgelabz.employeewage.repository;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
//Repository layer for storing companies

public class CompanyRepository {

    private static final int MAX_COMPANIES = 10;
    private final CompanyEmployeeWage[] companies = new CompanyEmployeeWage[MAX_COMPANIES];
    private int count = 0;

    //save company
    public void save(CompanyEmployeeWage company) {
        companies[count++] = company;
    }

    public CompanyEmployeeWage[] findAll() {
        return companies;
    }

    public int getCount() {
        return count;
    }
}
