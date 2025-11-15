package com.example.Day5.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<Map<String, String>> handleNotFound(StudentNotFoundException ex){
            Map<String, String> response = new HashMap<>();
            response.put("Error", ex.getMessage());
            return ResponseEntity.status(404).body(response);
        }
}
