package com.example.Day5.controller;

import com.example.Day5.SrudentService.StudentService;
import com.example.Day5.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getAllStudents();
    }
}
