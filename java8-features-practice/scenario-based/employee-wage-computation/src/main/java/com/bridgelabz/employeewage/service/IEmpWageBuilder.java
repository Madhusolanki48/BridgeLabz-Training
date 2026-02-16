package com.bridgelabz.employeewage.service;

import com.bridgelabz.employeewage.model.CompanyEmployeeWage;

//UC-11: Interface for managing employee wage

public interface IEmpWageBuilder {

	void addCompany(CompanyEmployeeWage company);

	void computeAllWages();

	CompanyEmployeeWage[] getCompanies();

	int getCompanyCount();
}
