package com.example.FullstackProject.api;

import com.example.FullstackProject.model.entity.Student;
import com.example.FullstackProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/upload-file")
    public void uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("student") Student student) throws IOException {
        System.out.println( file);
        System.out.println(student);
        studentService.uploadImage(file, student);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student studentDetail) {
        studentService.updateStudent(studentDetail);
    }
}
