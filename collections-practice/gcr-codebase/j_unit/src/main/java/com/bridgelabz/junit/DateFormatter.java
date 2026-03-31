package com.bridgelabz.junit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    //method to convert yyyy-MM-dd to dd-MM-yyyy
    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate); //parse input
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return date.format(formatter); //format output
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}

