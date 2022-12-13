package com.skd.dockerdemo.service;

import com.skd.dockerdemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student saveStudent(Student s);
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void delete(int id);
}
