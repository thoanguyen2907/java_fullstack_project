package com.example.FullstackProject.model.entity;

import com.example.FullstackProject.model.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product  extends BaseEntity {
    private String name;

}
