package com.bridgelabz.csv;
import java.io.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {

        //read CSV file
        BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/student.csv"));

        String line;
        br.readLine(); //skip header

        //read each record
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println(
                "ID: " + data[0] +
                ", Name: " + data[1] +
                ", Age: " + data[2] +
                ", Marks: " + data[3]
            );
        }
        br.close(); 
    }
}
