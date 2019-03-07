package com.ld.studentcrud.resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;


@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentResource extends ResourceSupport {

    @JsonProperty("id")
    private String idStudent;
    private String name;
    private Integer age;
    private String email;

}
