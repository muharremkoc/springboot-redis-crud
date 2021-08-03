package com.crud.springbootcrudwithredis.payload.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor

public class UserCreateRequest {


    @NotNull(message = "Please enter id")
    int id;

    @NotBlank
    @Size(max = 50)
    String name;

    @NotBlank
    @Size(max = 50)
    int age;
}
