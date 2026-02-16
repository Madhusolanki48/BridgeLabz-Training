package com.bridgelabz.employeewage.model;
//UC-9: Company wage configuration holder
public class CompanyEmployeeWage {
    //attributes
	private String companyName;
	private int wagePerHour;
	private int maxWorkingDays;
	private int maxWorkingHours;
	private int totalWage; // UC-9 storage
    //constructor
	public CompanyEmployeeWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
	}

	//getter method
	public String getCompanyName() {
		return companyName;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getMaxWorkingDays() {
		return maxWorkingDays;
	}

	public int getMaxWorkingHours() {
		return maxWorkingHours;
	}

	public int getTotalWage() {
		return totalWage;
	}

	//UC-9 setter
	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}
}
