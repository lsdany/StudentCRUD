package com.ld.studentcrud.controllers;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface BaseController <T,U> {

    //@ApiOperation(value = "Create")
    @ResponseStatus(CREATED)
    T create(final U u);

    //@ApiOperation(value = "Delete")
    @ResponseStatus(OK)
    void delete(final String id);

    //@ApiOperation(value = "Get one")
    @ResponseStatus(OK)
    T get(String id);

    //@ApiOperation(value = "Get a list")
    @ResponseStatus(OK)
    Resources<Resource<T>> list();

    //@ApiOperation(value = "Update")
    @ResponseStatus(OK)
    T update(final String id, final U u);

}
