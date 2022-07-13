package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(Long studentID);

    void updateStudent(Student studentDetail);
}
