package com.example.fundoonotes.exception;

public class LabelNotFoundException extends RuntimeException {
    public LabelNotFoundException(String message) {
        super(message);
    }
}
