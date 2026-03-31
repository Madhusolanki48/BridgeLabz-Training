package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();
    //valid password test
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    //less than 8 characters
    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Abc1"));
    }

    //no uppercase letter
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    //no digit
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }
}
