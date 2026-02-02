package com.bridgelabz.csv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        //large CSV file path
        String filePath = "src/main/resources/student.csv";

        int batchSize = 100;
        int count = 0;
        int batchCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); 
            String line;

            //read file line by line
            while ((line = br.readLine()) != null) {
                batchCount++;
                count++;

                //process in batches of 100
                if (batchCount == batchSize) {
                    System.out.println("Processed " + count + " records...");
                    batchCount = 0;
                }
            }

            //final count
            System.out.println("Total records processed: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
