package com.skd.dockerdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student_rest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "firstName",nullable = false)
    String fname;
    @Column(name = "lastName")
    String lname;
    @Column(name = "email", nullable = false)
    String email;

    public Student(String fname, String lname, String email) {
        this.fname=fname;
        this.lname=lname;
        this.email=email;
    }
}
