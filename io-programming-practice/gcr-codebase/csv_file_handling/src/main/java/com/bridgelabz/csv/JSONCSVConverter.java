package com.bridgelabz.csv;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONCSVConverter {
    public static void main(String[] args) throws Exception {
        //file paths
        String jsonFile = "src/main/resources/student.json";
        String csvFile  = "src/main/resources/student.csv";

        //JSON -> CSV
        String content = new String(Files.readAllBytes(Paths.get(jsonFile)));
        JSONArray arr = new JSONArray(content);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            bw.write("ID,Name,Age\n");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                bw.write(
                    obj.getInt("id") + "," +
                    obj.getString("name") + "," +
                    obj.getInt("age") + "\n"
                );
            }
        }
        // CSV -> JSON
        JSONArray newArr = new JSONArray();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("id", Integer.parseInt(data[0]));
                obj.put("name", data[1]);
                obj.put("age", Integer.parseInt(data[2]));
                newArr.put(obj);
            }
        }

        //print JSON output
        System.out.println(newArr.toString(2));
    }
}
