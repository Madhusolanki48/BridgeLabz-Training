package com.bridgelabz.junit;
public class StringUtils {
    //method to return the reverse of a given string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    //method to return true if the string is a palindrome
    public boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }
    //method to convert a string to uppercase
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

