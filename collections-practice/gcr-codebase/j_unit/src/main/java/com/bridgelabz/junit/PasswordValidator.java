package com.bridgelabz.junit;

public class PasswordValidator {
    //method to check password strength rules
    public boolean isValid(String password) {

        //minimum length check
        if (password.length() < 8) return false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        //check for uppercase letter and digit
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
            	hasUpper = true;
            if (Character.isDigit(ch))
            	hasDigit = true;
        }
        return hasUpper && hasDigit;
    }
}
