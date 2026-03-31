package EmployeeLeaveManagementSystem;

public class Employee {
	//attributes
    int empId;
    String name;
    int leaveBalance;
    //constructor
    Employee(int empId, String name, int leaveBalance) {
        this.empId = empId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }
}

