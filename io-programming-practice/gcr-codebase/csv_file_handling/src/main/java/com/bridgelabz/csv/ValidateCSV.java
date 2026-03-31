package com.bridgelabz.csv;
import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {

        //cSV containing Email and Phone
        String filePath = "src/main/resources/users.csv";

        //email and phone regex
        Pattern emailPattern =
                Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
        Pattern phonePattern =
                Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); //skip header
            System.out.println("Invalid rows:");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = data[2]; // Email column
                String phone = data[3]; // Phone column

                // Validate email and phone
                if (!emailPattern.matcher(email).matches() ||
                    !phonePattern.matcher(phone).matches()) {

                    System.out.println(line + " --> Invalid email or phone");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
