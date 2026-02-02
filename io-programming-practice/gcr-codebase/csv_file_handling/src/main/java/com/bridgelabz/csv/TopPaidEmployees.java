package com.bridgelabz.csv;
import java.io.*;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) throws Exception {

        List<String[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/employees.csv"));

        br.readLine(); 
        String line;

        //store records
        while ((line = br.readLine()) != null) {
            list.add(line.split(","));
        }

        //sort by salary descending
        list.sort((a, b) ->
                Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

        //print top 5
        for (int i = 0; i < 5; i++) {
            System.out.println(String.join(",", list.get(i)));
        }
    }
}
