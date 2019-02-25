package com.ld.studentcrud.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;

}
