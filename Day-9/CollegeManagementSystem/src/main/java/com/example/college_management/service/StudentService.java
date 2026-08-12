package com.example.college_management.service;

import com.example.college_management.entity.Student;
import com.example.college_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // get student by ID
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    // create student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // update student
    public Student updateStudent(Integer id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setGender(student.getGender());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setCity(student.getCity());
        existingStudent.setState(student.getState());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setAdmissionYear(student.getAdmissionYear());

        return studentRepository.save(existingStudent);
    }

    // delete student
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
