package com.example.Day7.service;

import com.example.Day7.dto.StudentRequestDTO;
import com.example.Day7.dto.StudentResponseDTO;
import com.example.Day7.entity.Student;
import com.example.Day7.exception.AlreadyExistsException;
import com.example.Day7.exception.ResourceNotFoundException;
import com.example.Day7.exception.StudentNotFoundException;
import com.example.Day7.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        repo.findByEmail(dto.getEmail()).ifPresent(existing -> {
            throw new AlreadyExistsException("Student Already Exists: " + dto.getEmail());
        });

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
        Student student = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Not Found with id: " + id));
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
