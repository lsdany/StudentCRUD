package com.ld.studentcrud.services;

import com.ld.studentcrud.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudentById(String id);

    void deleteStudent(String id);

    Student updateStudent(Student student);

    Student saveStudent(Student student);
}
