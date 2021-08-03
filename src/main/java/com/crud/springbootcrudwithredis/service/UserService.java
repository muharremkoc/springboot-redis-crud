package com.crud.springbootcrudwithredis.service;

import com.crud.springbootcrudwithredis.model.User;
import com.crud.springbootcrudwithredis.payload.request.UserCreateRequest;
import com.crud.springbootcrudwithredis.payload.request.UserUpdateRequest;
import com.crud.springbootcrudwithredis.payload.response.UserDeleteResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(int id);
    User addUser(UserCreateRequest userCreateRequest);
    Optional<User> updateUser(UserUpdateRequest userUpdateRequest, int id);
    UserDeleteResponse deleteUser(int id);

}
