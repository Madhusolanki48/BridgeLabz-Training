package com.bridgelabz.csv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScores {
    public static void main(String[] args) {
        String filePath = "src/main/resources/merged.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // skip header
            System.out.println("Students with marks > 80:");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]); 
                if (marks > 80) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
