package com.bridgelabz.payrollapp.exception;

public class DuplicateEmployeeEmailException extends RuntimeException {

    public DuplicateEmployeeEmailException(String message) {
        super(message);
    }
}
