package com.example.Day7.service;

import com.example.Day7.dto.StudentRequestDTO;
import com.example.Day7.dto.StudentResponseDTO;
import com.example.Day7.entity.Student;
import com.example.Day7.exception.AlreadyExistsException;
import com.example.Day7.exception.ResourceNotFoundException;
import com.example.Day7.exception.StudentNotFoundException;
import com.example.Day7.repository.StudentRepository;
import io.micrometer.observation.GlobalObservationConvention;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        logger.info("Attempting to create student with email {}", dto.getEmail());

        repo.findByEmail(dto.getEmail()).ifPresent(existing -> {
            logger.error("Student creation failed, student already exists with email {}", dto.getEmail());
            throw new AlreadyExistsException("Student Already Exists: " + dto.getEmail());
        });

        Student student = mapToEntity(dto);
        Student saved = repo.save(student);

        logger.info("Student created Successfully with id {}", saved.getId());

        return mapToResponseDTO(saved);
    }

    public List<StudentResponseDTO> getAllStudents(){

        logger.info("Fetching all students from DataBase.");

        List<StudentResponseDTO> students = repo.findAll().stream().map(this::mapToResponseDTO).toList();

        logger.info("Total students fetched {}", students.size());
        return students;
    }

    public StudentResponseDTO getStudentById(Long id){
        logger.info("Fetching student by id {}", id);

        Student student = repo.findById(id).orElseThrow(() -> {
            logger.error("Student not found with id {}", id);
            return new ResourceNotFoundException("Student Not Found with id: " + id);
        });
        logger.info("Student fetched successfully with id {}", id);
        return mapToResponseDTO(student);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto){
        logger.info("Attempting to update student with id {}", id);

        return repo.findById(id).map(student -> {
            student.setName((dto.getName()));
            student.setAge(dto.getAge());
            student.setEmail(dto.getEmail());

            Student updated = repo.save(student);

            logger.info("Student updated successfully with id -> {}", id);

            return mapToResponseDTO(updated);

        }).orElseThrow(() -> {
            logger.error("Update failed. Student not found with id {}", id);
            return new StudentNotFoundException(id);
        });
    }

    public void deleteStudent(Long id){
        logger.info("Attempting to delete student with id {}", id);

        if(!repo.existsById(id)){
            logger.info("Student does not exist for id {}", id);
            throw new StudentNotFoundException(id);
        }

        logger.info("student deleted successfully with id {}", id);
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
