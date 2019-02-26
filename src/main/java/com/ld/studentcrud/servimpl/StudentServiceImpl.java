package com.ld.studentcrud.servimpl;

import com.ld.studentcrud.domain.Student;
import com.ld.studentcrud.respository.StudentRepository;
import com.ld.studentcrud.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();
        studentRepository.findAll()
                .iterator()
                .forEachRemaining(students::add);
        log.info(students.toString());
        return students;
    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public void deleteStudent(String id) {
         studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
