package com.ld.studentcrud.controllers;

import com.ld.studentcrud.domain.Student;
import com.ld.studentcrud.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(allowedHeaders = "*",
//        origins = "*",
//        maxAge = 3600,
//        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/students/")
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }

    @CrossOrigin
    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @CrossOrigin
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return  studentService.updateStudent(student);
    }
}
