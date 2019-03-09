package com.ld.studentcrud.respository;

import com.ld.studentcrud.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String userName);

}
