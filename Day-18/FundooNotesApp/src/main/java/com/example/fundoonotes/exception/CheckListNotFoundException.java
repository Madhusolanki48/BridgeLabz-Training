package com.example.fundoonotes.exception;

public class CheckListNotFoundException extends RuntimeException {
    public CheckListNotFoundException(String message) {
        super(message);
    }
}
