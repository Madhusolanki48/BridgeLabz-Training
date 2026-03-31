package com.bridgelabz.employeewage.model;

//POJO for employee attendance
public class Employee {
    //attribute
    private boolean present;
    private int workingHours;
    private int dailyWage;
    private String employeeType;
    //constructor
    public Employee(boolean present) {
        this.present = present;
    }
    //UC-2 constructor
    public Employee(boolean present, int workingHours, int dailyWage, String employeeType) {
        this.present = present;
        this.workingHours = workingHours;
        this.dailyWage = dailyWage;
        this.employeeType = employeeType;
    }

    //getter method
    public boolean isPresent() {
        return present;
    }
    public int getWorkingHours() {
        return workingHours;
    }

    public int getDailyWage() {
        return dailyWage;
    }
    public String getEmployeeType() {
        return employeeType;
    }


}
