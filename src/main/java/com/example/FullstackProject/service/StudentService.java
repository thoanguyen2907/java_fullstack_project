package com.example.FullstackProject.service;

import com.example.FullstackProject.model.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(Long studentID);

    void updateStudent(Student studentDetail);

    void uploadImage(MultipartFile file, Student student) throws IOException;
}
