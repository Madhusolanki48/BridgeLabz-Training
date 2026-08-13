package com.example.college_management.controller;

import com.example.college_management.entity.Faculty;
import com.example.college_management.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // read all faculty
    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    // read faculty by ID
    @GetMapping("/{id}")
    public Faculty getFacultyById(
            @PathVariable Integer id) {

        return facultyService.getFacultyById(id);
    }

    // create faculty
    @PostMapping
    public Faculty createFaculty(
            @RequestBody Faculty faculty) {

        return facultyService.createFaculty(faculty);
    }

    // update faculty
    @PutMapping("/{id}")
    public Faculty updateFaculty(
            @PathVariable Integer id,
            @RequestBody Faculty faculty) {

        return facultyService.updateFaculty(id, faculty);
    }

    // delete faculty
    @DeleteMapping("/{id}")
    public String deleteFaculty(
            @PathVariable Integer id) {

        facultyService.deleteFaculty(id);

        return "Faculty deleted successfully";
    }

    // highest salary in each department
    @GetMapping("/highest-paid-by-department")
    public List<Faculty> getHighestPaidByDepartment() {
        return facultyService.getHighestPaidByDepartment();
    }

    // salary greater than avg salary of the department
    @GetMapping("/above-department-average")
    public List<Faculty> getAboveDepartmentAverage() {
        return facultyService.getAboveDepartmentAverage();
    }
}
