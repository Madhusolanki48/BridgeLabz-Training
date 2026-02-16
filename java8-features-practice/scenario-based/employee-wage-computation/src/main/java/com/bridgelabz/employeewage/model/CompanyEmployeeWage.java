package com.bridgelabz.employeewage.model;
import java.util.ArrayList;
import java.util.List;

//UC-9: Company wage configuration holder
public class CompanyEmployeeWage {
    //attributes
	private String companyName;
	private int wagePerHour;
	private int maxWorkingDays;
	private int maxWorkingHours;
	private int totalWage; // UC-9 storage
	//UC-13: store daily wages along with total wage for each company
	private List<Integer> dailyWages = new ArrayList<>();

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
	//UC-13: store daily wage
	public void addDailyWage(int wage) {
	    dailyWages.add(wage);
	}

	//getter for daily wages
	public List<Integer> getDailyWages() {
	    return dailyWages;
	}

}
