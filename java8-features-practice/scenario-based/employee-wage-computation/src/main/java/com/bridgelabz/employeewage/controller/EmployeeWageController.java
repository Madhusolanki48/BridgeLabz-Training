package com.bridgelabz.employeewage.controller;
import com.bridgelabz.employeewage.model.Employee;
import com.bridgelabz.employeewage.service.EmployeeWageService;
import com.bridgelabz.employeewage.service.EmpWageBuilder;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
import com.bridgelabz.employeewage.service.IEmpWageBuilder;
import com.bridgelabz.employeewage.service.IEmpWageBuilder;


public class EmployeeWageController {
    private final EmployeeWageService service = new EmployeeWageService();
//    private final EmpWageBuilder builder = new EmpWageBuilder();
    private final IEmpWageBuilder builder = new EmpWageBuilder();



    // UC-1
    public Employee checkEmployeeAttendance() {
        return service.checkAttendance();
    }

    // UC-2
    public Employee getDailyWage() {
        return service.calculateDailyWage();
    }

    // UC-4
    public Employee getWageWithSwitch() {
        return service.calculateWageWithSwitch();
    }

    // UC-5
    public int getMonthlyWage() {
        return service.calculateMonthlyWage();
    }

    // UC-6
    public int getWageTillCondition() {
        return service.calculateWageTillCondition();
    }
    // UC-7
    public int getComputedEmployeeWage() {
        return service.computeEmployeeWage();
    }

	//UC-8
	public int getComputedEmployeeWage(String companyName, int wagePerHour, int maxDays, int maxHours) {
		return service.computeEmployeeWage(companyName, wagePerHour, maxDays, maxHours);
	}
	//UC-9
	public void computeEmployeeWage(com.bridgelabz.employeewage.model.CompanyEmployeeWage company) {
		service.computeEmployeeWage(company);
	}
	//UC-10: add company to builder
	public void addCompany(CompanyEmployeeWage company) {
	    builder.addCompany(company);
	}

	//UC-10: compute all companies
	public void computeAllWages() {
	    builder.computeAllWages();
	}

	//UC-10: getters for results
	public CompanyEmployeeWage[] getCompanies() {
	    return builder.getCompanies();
	}

	public int getCompanyCount() {
	    return builder.getCompanyCount();
	}
	//UC-14
	public int getTotalWageByCompany(String companyName) {
	    return builder.getTotalWageByCompany(companyName);
	}


}
