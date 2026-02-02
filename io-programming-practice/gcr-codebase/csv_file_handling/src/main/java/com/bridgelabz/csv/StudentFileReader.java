package com.bridgelabz.csv;
import java.io.*;

public class StudentFileReader {
    public static void main(String[] args) throws Exception {

        //open CSV file
        BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/student.csv"));

        int count = 0;
        br.readLine(); //skip header

        //count records
        while (br.readLine() != null) {
            count++;
        }

        System.out.println("Total Records: " + count);
        br.close();
    }
}
