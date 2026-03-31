package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    StringUtils utils = new StringUtils();
    //methods to check tests
    @Test
    void testReverse() {  //reverse check
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    void testPalindrome() {  // palindrome check
        assertTrue(utils.isPalindrome("java")); 
    }

    @Test 
    void testUpperCase() {   // uppercase check
        assertEquals("HELLO", utils.toUpperCase("hello")); 
    }
}
