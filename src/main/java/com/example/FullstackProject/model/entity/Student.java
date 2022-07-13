package com.example.FullstackProject.model.entity;

import com.example.FullstackProject.model.base.BaseEntity;
import com.example.FullstackProject.model.base.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student extends BaseEntity {

    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
