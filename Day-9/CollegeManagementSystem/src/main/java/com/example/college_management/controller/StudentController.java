package com.example.college_management.controller;

import com.example.college_management.entity.Student;
import com.example.college_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // read all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // read student by ID
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Integer id) {

        return studentService.getStudentById(id);
    }

    // create student
    @PostMapping
    public Student createStudent(
            @RequestBody Student student) {

        return studentService.createStudent(student);
    }

    // update student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    // delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Integer id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }
}
