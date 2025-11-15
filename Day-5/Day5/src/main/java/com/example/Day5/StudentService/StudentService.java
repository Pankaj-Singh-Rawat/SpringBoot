package com.example.Day5.StudentService;

import com.example.Day5.entity.Student;
import com.example.Day5.exception.StudentNotFoundException;
import com.example.Day5.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student student){
        return repo.save(student);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student getStudentById(Long id){
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student updateStudent(Long id, Student updatedData){
        return repo.findById(id).map(
                student -> {
                    student.setName(updatedData.getName());
                    student.setAge(updatedData.getAge());
                    student.setEmail(updatedData.getEmail());
                    return repo.save(student);
                }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(Long id){
        if(!repo.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
