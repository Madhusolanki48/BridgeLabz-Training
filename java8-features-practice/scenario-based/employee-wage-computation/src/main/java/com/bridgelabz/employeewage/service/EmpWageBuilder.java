package com.bridgelabz.employeewage.service;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
import com.bridgelabz.employeewage.service.IEmpWageBuilder;
import java.util.ArrayList;
import java.util.List;


//UC-10: Manages multiple companies

public class EmpWageBuilder implements IEmpWageBuilder {

//	private static final int MAX_COMPANIES = 10;
//	private final CompanyEmployeeWage[] companies = new CompanyEmployeeWage[MAX_COMPANIES];
//	private int companyCount = 0;
	
	//UC12: refactor EmpWageBuilder to use ArrayList instead of array
	private final List<CompanyEmployeeWage> companies = new ArrayList<>();

	private final EmployeeWageService service = new EmployeeWageService();

	@Override
	public void addCompany(CompanyEmployeeWage company) {
	    companies.add(company);
	}

	@Override
	public void computeAllWages() {
	    for (CompanyEmployeeWage company : companies) {
	        service.computeEmployeeWage(company);
	    }
	}


	@Override
	public CompanyEmployeeWage[] getCompanies() {
	    return companies.toArray(new CompanyEmployeeWage[0]);
	}

	@Override
	public int getCompanyCount() {
	    return companies.size();
	}
	//UC-14: search and return total wage
	@Override
	public int getTotalWageByCompany(String companyName) {

	    for (CompanyEmployeeWage company : companies) {
	        if (company.getCompanyName().equalsIgnoreCase(companyName)) {
	            return company.getTotalWage();
	        }
	    }

	    return -1; // company not found
	}


}
