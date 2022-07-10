package com.example.FullstackProject.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    private final  StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        studentRepository.deleteById(studentID);
    }
    @Transactional
    public void updateStudent( Student studentDetail) {
        System.out.println("studentDetail print" + studentDetail);
       Student student =  studentRepository.findById(studentDetail.getId()).orElseThrow(() -> new IllegalStateException(
               "student with id " + studentDetail.getId() + " does not exist"
       ));

       if(studentDetail.getName() != null && studentDetail.getName().length() > 0 && !Objects.equals(student.getName(), studentDetail.getName())){
           System.out.println("update name");
           student.setName(studentDetail.getName());
           System.out.println(student);
       }
        if(studentDetail.getEmail() != null && studentDetail.getEmail().length() > 0 && !Objects.equals(student.getEmail(), studentDetail.getEmail())){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentDetail.getEmail());
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }       
            student.setEmail(studentDetail.getEmail());
        }
        if(studentDetail.getGender() != null  && !Objects.equals(student.getGender(), studentDetail.getGender())){
            student.setGender(studentDetail.getGender());
        }
    }


}
