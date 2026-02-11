package EmployeeLeaveManagementSystem;
//custom exception
public class InsufficientLeaveBalanceException extends Exception {
    InsufficientLeaveBalanceException(String msg) {
        super(msg);
    }
}

