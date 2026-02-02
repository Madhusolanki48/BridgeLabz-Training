package com.bridgelabz.csv;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) {

        //input CSV files
        String file1 = "src/main/resources/student1.csv"; // ID,Name,Age
        String file2 = "src/main/resources/student2.csv"; // ID,Marks,Grade

        //output merged CSV file
        String outputFile = "src/main/resources/merged.csv";

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // read headers
            String header1 = br1.readLine();
            String header2 = br2.readLine();

            //write merged header
            bw.write(header1 + "," + header2.substring(3));
            bw.newLine();

            //store second CSV data (ID -> Marks, Grade)
            Map<String, String[]> map = new HashMap<>();
            String line;

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                map.put(data[0], new String[]{data[1], data[2]});
            }

            //merge records based on ID
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                if (map.containsKey(data[0])) {
                    String[] extra = map.get(data[0]);
                    bw.write(String.join(",", data) + "," +
                             String.join(",", extra));
                    bw.newLine();
                }
            }

            System.out.println("Merged CSV created: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
