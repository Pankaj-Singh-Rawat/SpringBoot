package com.example.day2.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Pankaj",
                        "qoolphoenix@gmail.com",
                        21,
                        LocalDate.of(2003, Month.NOVEMBER, 29)
                )
        );
    }
}
