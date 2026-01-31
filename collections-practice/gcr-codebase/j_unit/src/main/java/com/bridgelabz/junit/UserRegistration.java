package com.bridgelabz.junit;

public class UserRegistration {
    //method to register user after validating inputs
    public boolean registerUser(String username, String email, String password) {

        //basic validations
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException("Invalid username");

        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");

        if (password == null || password.length() < 8)
            throw new IllegalArgumentException("Invalid password");

        //user is registered successfully
        return true;
    }
}
