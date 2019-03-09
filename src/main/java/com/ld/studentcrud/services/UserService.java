package com.ld.studentcrud.services;

import com.ld.studentcrud.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(String username);

    User findById(int id);

    User save(User user);

}
