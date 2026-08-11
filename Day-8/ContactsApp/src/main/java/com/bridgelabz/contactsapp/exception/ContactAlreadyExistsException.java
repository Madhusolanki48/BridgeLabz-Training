package com.bridgelabz.contactsapp.exception;
//custom exception
public class ContactAlreadyExistsException extends RuntimeException {

    public ContactAlreadyExistsException(String message) {
        super(message);
    }
}
