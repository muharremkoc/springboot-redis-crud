package com.crud.springbootcrudwithredis.controller;

import com.crud.springbootcrudwithredis.model.User;
import com.crud.springbootcrudwithredis.payload.request.UserCreateRequest;
import com.crud.springbootcrudwithredis.payload.request.UserUpdateRequest;

import com.crud.springbootcrudwithredis.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/versions/1")
public class UserController {

 @Autowired
 UserService userService;

 @GetMapping("/users")
 public List<User> getUsers() {
  return userService.getUsers();
 }

 @GetMapping("/user/{id}")
 public Optional<User> getUser(@PathVariable int id) {
  return userService.getUser(id);
 }

 @PutMapping("/user/{id}")
 public Optional<User> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable int id) {
  return userService.updateUser(userUpdateRequest, id);
 }

 @DeleteMapping(value = "/user/{id}", produces = "application/json; charset=utf-8")
 public void deleteUser(@PathVariable("id") int id) {
  userService.deleteUser(id);
 }

 @PostMapping("/user")
 @Operation(summary = "Create New User")
 @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "User inserted",
                 content = {@Content(mediaType = "application/json",
                         schema = @Schema(implementation = User.class))}),
         @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                 content = @Content),
         @ApiResponse(responseCode = "404", description = "User NotFound",
                 content = @Content),
         @ApiResponse(responseCode = "500", description = "Internal Server Error")})
 @ResponseStatus(HttpStatus.CREATED)
 public User addUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
  return userService.addUser(userCreateRequest);

 }
}

