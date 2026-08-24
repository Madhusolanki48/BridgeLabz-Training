package com.example.fundoonotes.exception;
//custom exception
public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
