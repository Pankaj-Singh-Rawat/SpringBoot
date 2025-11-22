package com.example.Day7.controller;

import com.example.Day7.dto.StudentRequestDTO;
import com.example.Day7.dto.StudentResponseDTO;
import com.example.Day7.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO dto){
        logger.info("POST /students -> Create student -> name {}, email {}", dto.getName(), dto.getEmail());
        StudentResponseDTO studentDTO = service.addStudent(dto);
        logger.info("POST /students -> student created with id {}", studentDTO.getId());
        return ResponseEntity.status(201).body(studentDTO);
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudent(){
        logger.info("Request Received -> Fetching all students");
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id){
        logger.info("GET /students/{} called", id);
        StudentResponseDTO dto = service.getStudentById(id);
        logger.info("Returning student with id {}", id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO dto){
        logger.info("PUT /students/{} -> update request recieved", id);
        StudentResponseDTO updated = service.updateStudent(id, dto);
        logger.info("PUT /students/{} -> Update successful ", id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        logger.info("Delete /students/{} -> request received", id);
        service.deleteStudent(id);
        logger.info("Delete /students/{} -> Deleted student successfully", id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
