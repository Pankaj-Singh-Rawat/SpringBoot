package com.example.Day6.service;

import com.example.Day6.dto.StudentRequestDTO;
import com.example.Day6.dto.StudentResponseDTO;
import com.example.Day6.entity.Student;
import com.example.Day6.exception.StudentNotFoundException;
import com.example.Day6.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student student = mapToEntity(dto);
        Student saved = repo.save(student);
        return mapToResponseDTO(saved);
    }

    public List<StudentResponseDTO> getAllStudents(){
        return repo.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public StudentResponseDTO getStudentById(Long id){
        Student student = repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return mapToResponseDTO(student);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto){
        return repo.findById(id).map(student -> {
            student.setName((dto.getName()));
            student.setAge(dto.getAge());
            student.setEmail(dto.getEmail());

            Student updated = repo.save(student);

            return mapToResponseDTO(updated);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(Long id){
        if(!repo.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        repo.deleteById(id);
    }

    private Student mapToEntity(StudentRequestDTO dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        return  student;
    }

    private StudentResponseDTO mapToResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }
}
