package com.ld.studentcrud.respository;

import com.ld.studentcrud.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
