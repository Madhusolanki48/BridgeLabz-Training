package EmployeeLeaveManagementSystem;

public class LeaveRequest {
	//attributes
    int empId;
    int days;
    String status; // PENDING, APPROVED, REJECTED
    //constructor
    LeaveRequest(int empId, int days) {
        this.empId = empId;
        this.days = days;
        this.status = "PENDING";
    }
}

