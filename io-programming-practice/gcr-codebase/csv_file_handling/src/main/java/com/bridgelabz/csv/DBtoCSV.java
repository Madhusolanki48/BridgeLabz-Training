package com.bridgelabz.csv;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBtoCSV {
    public static void main(String[] args) {

        // Output CSV file
        String outputFile = "src/main/resources/employee_report.csv";

        try (
            // Database connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/daniel2004",
                    "daniel",
                    "12345");

            Statement stmt = conn.createStatement();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // Fetch employee data
            ResultSet rs = stmt.executeQuery(
                    "SELECT id, name, department, salary FROM employees");

            // Write CSV header
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            //write records
            while (rs.next()) {
                bw.write(
                    rs.getInt("id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getDouble("salary")
                );
                bw.newLine();
            }

            System.out.println("CSV report generated: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
