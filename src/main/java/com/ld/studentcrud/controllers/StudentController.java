package com.ld.studentcrud.controllers;

import com.ld.studentcrud.assemblers.StudentAssembler;
import com.ld.studentcrud.domain.Student;
import com.ld.studentcrud.resources.StudentResource;
import com.ld.studentcrud.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(allowedHeaders = "*",
//        origins = "*",
//        maxAge = 3600,
//        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/students/")
public class StudentController implements BaseController<StudentResource, Student> {

    private StudentService studentService;
    private StudentAssembler studentAssembler;


    @Override
    @GetMapping("{id}")
    public StudentResource get(@PathVariable String id) {
        return studentAssembler.toResource(studentService.getStudentById(id));
    }

    @Override
    @PostMapping
    public StudentResource create(@Valid @RequestBody Student student) {
        return studentAssembler.toResource(studentService.saveStudent(student));
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {

    }



    @Override
    @GetMapping
    public Resources<Resource<StudentResource>> list() {
        return null;
    }

    @Override
    @PutMapping("{id}")
    public StudentResource update(@PathVariable String id, @RequestBody Student student) {
        return null;
    }
}
