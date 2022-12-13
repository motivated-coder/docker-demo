package com.skd.dockerdemo.service;

import com.skd.dockerdemo.entity.Student;
import com.skd.dockerdemo.exception.StudentNotFoundException;
import com.skd.dockerdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student s){
        return studentRepository.save(s);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student doen't exist with ID" + id));
    }

    @Override
    public void delete(int id) {
        Student s = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student doesn't exist with ID "+id));
        studentRepository.delete(s);
    }
}
