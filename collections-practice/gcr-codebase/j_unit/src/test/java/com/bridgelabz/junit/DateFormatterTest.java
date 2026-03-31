package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();
    //valid date conversion
    @Test
    void testValidDate() {
        assertEquals("31-01-2025",
                formatter.formatDate("2025-01-31"));
    }

    //invalid date format
    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("31-01-2025");
        });
    }

    //invalid date value
    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2025-02-30");
        });
    }
}
