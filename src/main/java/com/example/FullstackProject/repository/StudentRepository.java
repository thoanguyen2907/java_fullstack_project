package com.example.FullstackProject.repository;

import com.example.FullstackProject.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    @Query(value = "select * from student where student.email like :email", nativeQuery = true)
    Optional<Student> findByStudentCustom(@Param("email") String email);
}
