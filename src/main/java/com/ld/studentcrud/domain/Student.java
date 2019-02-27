package com.ld.studentcrud.domain;

import com.ld.studentcrud.audit.DataAudit;
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
public class Student extends DataAudit {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;

}
