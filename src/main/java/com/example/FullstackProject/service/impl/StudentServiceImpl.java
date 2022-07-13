package com.example.FullstackProject.service.impl;

import com.example.FullstackProject.model.entity.Student;
import com.example.FullstackProject.repository.StudentRepository;
import com.example.FullstackProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentID) {
        studentRepository.deleteById(studentID);
    }

    @Override
    public void updateStudent(Student studentDetail) {
        Student student = studentRepository.findById(studentDetail.getId()).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentDetail.getId() + " does not exist"
        ));

        if (studentDetail.getName() != null && studentDetail.getName().length() > 0 && !Objects.equals(student.getName(), studentDetail.getName())) {
            student.setName(studentDetail.getName());
        }
        if (studentDetail.getEmail() != null && studentDetail.getEmail().length() > 0 && !Objects.equals(student.getEmail(), studentDetail.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentDetail.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(studentDetail.getEmail());
        }
        if (studentDetail.getGender() != null && !Objects.equals(student.getGender(), studentDetail.getGender())) {
            student.setGender(studentDetail.getGender());
        }
    }
}
