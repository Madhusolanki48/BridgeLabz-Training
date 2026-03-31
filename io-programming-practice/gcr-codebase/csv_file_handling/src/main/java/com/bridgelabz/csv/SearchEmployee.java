package com.bridgelabz.csv;
import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {

        //read employees CSV
        BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/employees.csv"));

        String searchName = "John";
        String line;
        br.readLine(); 

        //search record
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + data[2]);
                System.out.println("Salary: " + data[3]);
            }
        }
        System.out.println("Employee does not exist!");
    }
}
