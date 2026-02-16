package com.bridgelabz.employeewage.model;

//POJO for employee attendance
public class Employee {
    //attribute
    private boolean present;
    private int workingHours;
    private int dailyWage;
    //constructor
    public Employee(boolean present) {
        this.present = present;
    }
    //UC-2 constructor
    public Employee(boolean present, int workingHours, int dailyWage) {
        this.present = present;
        this.workingHours = workingHours;
        this.dailyWage = dailyWage;
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

}
