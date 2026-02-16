package com.bridgelabz.employeewage.model;

//POJO for employee attendance
public class Employee {
    //attribute
    private boolean present;
    //constructor
    public Employee(boolean present) {
        this.present = present;
    }

    public boolean isPresent() {
        return present;
    }
}
