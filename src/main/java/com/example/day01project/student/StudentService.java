package com.example.day01project.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student){
        Optional<Student> studentbyemail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentbyemail.isPresent()){
            throw new IllegalStateException("Email is already exists.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with id  "+id+"  Does not exists.");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, String name,String email){
        studentRepository.
    }

}
