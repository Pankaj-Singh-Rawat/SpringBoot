package com.example.Day5.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id) {
        super("Student not found with id: " + id);
    }
}
