package com.crud.springbootcrudwithredis.service;

import com.crud.springbootcrudwithredis.exception.UserAlreadyExistsException;
import com.crud.springbootcrudwithredis.exception.UserNotFoundException;
import com.crud.springbootcrudwithredis.model.User;
import com.crud.springbootcrudwithredis.payload.request.UserCreateRequest;
import com.crud.springbootcrudwithredis.payload.request.UserUpdateRequest;
import com.crud.springbootcrudwithredis.payload.response.UserDeleteResponse;
import com.crud.springbootcrudwithredis.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper;
    @Override
    public List<User> getUsers() {
        Iterable<User> result = userRepository.findAll();
        List<User> employeesList = new ArrayList<User>();
        result.forEach(employeesList::add);
        return employeesList;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> emp = userRepository.findById(id);
        return emp;
    }

    @Override
    public Optional<User> updateUser(UserUpdateRequest userUpdateRequest, int id) {
        Optional<User> optionalEmp = userRepository.findById(id);
        if (optionalEmp.isPresent()) {
            User emp = optionalEmp.get();
            emp.setName(userUpdateRequest.getName());
            emp.setAge(userUpdateRequest.getAge());
            userRepository.save(emp);
        }
        return optionalEmp;

    }

    @Override
    public UserDeleteResponse deleteUser(int id) {

        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(user);

        return new UserDeleteResponse(id+" User deleted");
    }

    @Override
    public User addUser(UserCreateRequest userCreateRequest) {

        User emp = new User(userCreateRequest.getId(), userCreateRequest.getName(), userCreateRequest.getAge());
        userRepository.save(emp);
        return emp;
    }
        /*
          Optional<User> optionalUser=userRepository.findById(userCreateRequest.getId());

        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }


        User user=modelMapper.map(userCreateRequest,User.class);

        return  userRepository.save(user);
    }
         */

}
