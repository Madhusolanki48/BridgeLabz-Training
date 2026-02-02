package com.bridgelabz.csv;
import java.io.*;
import java.util.Base64;

public class CSVEncryptDecrypt {
    public static void main(String[] args) throws IOException {
        // Input and output file paths
        String inputFile = "src/main/resources/employees.csv";
        String encryptedFile = "src/main/resources/employees_enc.csv";

        // Encrypt Salary column
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(encryptedFile))) {

            bw.write(br.readLine()); // write header
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Encrypt salary (4th column)
                data[3] = Base64.getEncoder()
                                .encodeToString(data[3].getBytes());

                bw.write(String.join(",", data));
                bw.newLine();
            }
        }

        //decrypt salary while reading
        try (BufferedReader br = new BufferedReader(new FileReader(encryptedFile))) {

            System.out.println(br.readLine()); // print header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                //decrypt salary
                data[3] = new String(
                        Base64.getDecoder().decode(data[3]));

                System.out.println(String.join(",", data));
            }
        }
    }
}
