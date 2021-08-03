package com.crud.springbootcrudwithredis.repository;

import com.crud.springbootcrudwithredis.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
