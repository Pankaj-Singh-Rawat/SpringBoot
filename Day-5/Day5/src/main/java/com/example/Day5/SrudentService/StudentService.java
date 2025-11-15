package com.example.Day5.SrudentService;

import com.example.Day5.entity.Student;
import com.example.Day5.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedData){
        return repo.findById(id).map(
                student -> {
                    student.setName(updatedData.getName());
                    student.setAge(updatedData.getAge());
                    student.setEmail(updatedData.getEmail());
                    return repo.save(student);
                }).orElse(null);
    }

    public boolean deleteStudent(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
