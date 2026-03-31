package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();
    //test Celsius to Fahrenheit
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0));
        assertEquals(212.0, converter.celsiusToFahrenheit(100));
    }

    //test Fahrenheit to Celsius
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32));
        assertEquals(100.0, converter.fahrenheitToCelsius(212));
    }
}

