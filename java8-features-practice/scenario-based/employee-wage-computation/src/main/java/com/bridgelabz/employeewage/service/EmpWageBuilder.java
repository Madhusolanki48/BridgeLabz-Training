package com.bridgelabz.employeewage.service;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
import com.bridgelabz.employeewage.service.IEmpWageBuilder;


//UC-10: Manages multiple companies

public class EmpWageBuilder implements IEmpWageBuilder {

	private static final int MAX_COMPANIES = 10;
	private final CompanyEmployeeWage[] companies = new CompanyEmployeeWage[MAX_COMPANIES];
	private int companyCount = 0;

	private final EmployeeWageService service = new EmployeeWageService();

	// UC-10: add company
	public void addCompany(CompanyEmployeeWage company) {
		companies[companyCount++] = company;
	}

	// UC-10: compute wages for all companies
	public void computeAllWages() {
		for (int i = 0; i < companyCount; i++) {
			service.computeEmployeeWage(companies[i]);
		}
	}

	// helper for main
	public CompanyEmployeeWage[] getCompanies() {
		return companies;
	}

	public int getCompanyCount() {
		return companyCount;
	}
}
