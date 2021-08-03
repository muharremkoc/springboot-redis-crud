package com.crud.springbootcrudwithredis.payload.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Setter
public class UserUpdateRequest {

    @Size(max = 50)
    String name;


    @Size(max = 50)
    int age;
}
