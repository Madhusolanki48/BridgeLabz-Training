package com.bridgelabz.csv;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateITSalary {
    public static void main(String[] args) {
        //input CSV file path
        String inputFile = "src/main/resources/employees.csv";
        //output CSV file path
        String outputFile = "src/main/resources/employees_updated.csv";

        //store updated CSV lines
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            //read and store header
            String header = br.readLine();
            updatedLines.add(header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                //increase salary by 10% for IT department
                if (data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.valueOf((int) salary);
                }
                //add updated record
                updatedLines.add(String.join(",", data));
            }
            //write updated data to new CSV file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                for (String l : updatedLines) {
                    bw.write(l);
                    bw.newLine();
                }
            }
            System.out.println("Updated CSV saved as: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
