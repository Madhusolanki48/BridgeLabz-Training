package com.bridgelabz.csv;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//student class
class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age;
    }
}

public class CSVtoObjects {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                students.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //print all students
        students.forEach(System.out::println);
    }
}
