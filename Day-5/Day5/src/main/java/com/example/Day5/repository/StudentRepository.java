package com.example.Day5.repository;

import com.example.Day5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    /*
    This gives you READY-MADE CRUD methods, like:
    save()
    findAll()
    findById()
    deleteById()
     */
}
