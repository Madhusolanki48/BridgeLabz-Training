package com.example.fundoonotes.exception;
//custom exception
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}