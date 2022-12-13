package com.skd.dockerdemo.controller;

import com.skd.dockerdemo.entity.Student;
import com.skd.dockerdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/hello/{name}")
    public String welcome(@PathVariable("name") String user){
        return "Hello "+user;
    }

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        Student s = studentService.saveStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.add("id", String.valueOf(s.getId()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {
        Student s = studentService.getStudentById(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student oldStudent = studentService.getStudentById(id);
        oldStudent.setFname(student.getFname());
        oldStudent.setLname(student.getLname());
        oldStudent.setEmail(student.getEmail());
        studentService.saveStudent(oldStudent);
        return new ResponseEntity<>(oldStudent, HttpStatus.OK);
    }
}
