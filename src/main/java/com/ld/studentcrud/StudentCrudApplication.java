package com.ld.studentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudApplication.class, args);
    }

}
