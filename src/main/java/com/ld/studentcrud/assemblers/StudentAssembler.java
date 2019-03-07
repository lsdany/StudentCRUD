package com.ld.studentcrud.assemblers;

import com.ld.studentcrud.controllers.StudentController;
import com.ld.studentcrud.domain.Student;
import com.ld.studentcrud.resources.StudentResource;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler  extends ResourceAssemblerSupport<Student, StudentResource> {


    public StudentAssembler(){
        super(StudentController.class, StudentResource.class);
    }

    @Override
    public StudentResource toResource(Student student) {
        final StudentResource resource = createResourceWithId(student.getId(), student);
        BeanUtils.copyProperties(student, resource);
        resource.setIdStudent(student.getId());
        return resource;
    }
}
