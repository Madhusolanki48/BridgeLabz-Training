package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {
    UserRegistration registration = new UserRegistration();

    //valid user registration
    @Test
    void testValidRegistration() {
        assertTrue(registration.registerUser(
                "maxwell123", "maxwell@gmail.com", "Password1"));
    }

    //invalid username
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "maxwell@gmail.com", "Password1");
        });
    }

    //invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("maxwell123", "maxwellgmail.com", "Password1");
        });
    }

    //invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("maxwell123", "maxwell@gmail.com", "pass");
        });
    }
}
