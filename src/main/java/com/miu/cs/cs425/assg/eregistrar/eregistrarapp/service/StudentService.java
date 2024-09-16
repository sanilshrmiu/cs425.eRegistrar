package com.miu.cs.cs425.assg.eregistrar.eregistrarapp.service;

import com.miu.cs.cs425.assg.eregistrar.eregistrarapp.model.Student;
import com.miu.cs.cs425.assg.eregistrar.eregistrarapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String keyword) {
        return studentRepository.findByFirstNameContainingIgnoreCase(keyword);
    }
}

