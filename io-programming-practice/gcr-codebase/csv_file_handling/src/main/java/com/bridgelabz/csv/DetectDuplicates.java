package com.bridgelabz.csv;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.csv";

        //set to store unique IDs
        Set<String> ids = new HashSet<>();

        //set to store duplicate records
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // skip header
            String line;

            //read each record
            while ((line = br.readLine()) != null) {
                String id = line.split(",")[0];

                //check for duplicate ID
                if (!ids.add(id)) {
                    duplicates.add(line);
                }
            }

            //print result
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate records:");
                duplicates.forEach(System.out::println);
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
