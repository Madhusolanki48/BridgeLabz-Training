package com.bridgelabz.csv;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv"; //CSV file name

        //data to write
        String[][] employees = {
            {"1", "Maxwell", "Finance", "50000"},
            {"2", "Boblin", "HR", "60000"},
            {"3", "Charlie", "IT", "70000"},
            {"4", "Daniel", "Sales", "55000"},
            {"5", "Eliy", "Marketing", "52000"}
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            //write header
            writer.append("ID,Name,Department,Salary\n");

            //write employee records
            for (String[] emp : employees) {
                writer.append(String.join(",", emp)); // join array elements with comma
                writer.append("\n");
            }

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
